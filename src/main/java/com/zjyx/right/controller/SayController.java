package com.zjyx.right.controller;

import java.io.File;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.baidu.aip.speech.AipSpeech;

@Controller
public class SayController {
	// 设置APPID/AK/SK，注册百度语音识别API即可获取
	public static final String APP_ID = "15189200";
    public static final String API_KEY = "tvk35Q3DdctsUyEPqLfkamM8";
    public static final String SECRET_KEY = "nZU2WxeO2Csx08vyAIDHBcXaosLXhSsf";

    /**
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/sayhello")
    @ResponseBody
    public Object sayhello(HttpServletRequest request) {
    	MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
    	MultipartHttpServletRequest multipartRequest = resolver.resolveMultipart(request);
        MultipartFile file = multipartRequest.getFile("file");
        try {
            byte[] pcmBytes = mp3Convertpcm(file.getInputStream());
            JSONObject resultJson = speechBdApi(pcmBytes);
            System.out.println(resultJson.toString());
            System.out.println(resultJson.toString());
            if (null != resultJson && resultJson.getInt("err_no") == 0) {
                return resultJson.getJSONArray("result").get(0).toString().split("，")[0];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
    static int i = 0 ;
    @RequestMapping(value = "/sayhello1",method=RequestMethod.POST)
    @ResponseBody
    public String sayhello(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
    	MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
    	MultipartHttpServletRequest multipartRequest = resolver.resolveMultipart(request);
        MultipartFile file1 = multipartRequest.getFile("file");
        try {
        	String fileName = file.getOriginalFilename();
        	File files = new File("/Users/cott.wen/Desktop/ww"+ (i++) +".mp3");
        	file.transferTo(files);
        	
        	
        	
            byte[] pcmBytes = mp3Convertpcm(file.getInputStream());
            JSONObject resultJson = speechBdApi(pcmBytes);
            System.out.println(resultJson.toString());
            System.out.println(resultJson.toString());
            if (null != resultJson && resultJson.getInt("err_no") == 0) {
                return resultJson.getJSONArray("result").get(0).toString().split("，")[0];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "接口出现异常";
    }

    /**
     * @Description MP3转换pcm
     */
    public byte[] mp3Convertpcm(InputStream mp3Stream) throws Exception {
        // 原MP3文件转AudioInputStream
        AudioInputStream mp3audioStream = AudioSystem.getAudioInputStream(mp3Stream);
        // 将AudioInputStream MP3文件 转换为PCM AudioInputStream
        AudioInputStream pcmaudioStream = AudioSystem.getAudioInputStream(AudioFormat.Encoding.PCM_SIGNED,
                mp3audioStream);
        byte[] pcmBytes = IOUtils.toByteArray(pcmaudioStream);
        pcmaudioStream.close();
        mp3audioStream.close();
        return pcmBytes;
    }

    /**
     * @Description 调用百度语音识别API
     */
    public static JSONObject speechBdApi(byte[] pcmBytes) {
        // 初始化一个AipSpeech
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        // 调用接口
        JSONObject res = client.asr(pcmBytes, "pcm", 16000, null);
        return res;
    }
}
