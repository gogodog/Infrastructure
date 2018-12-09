package com.zjyx.right.service.impl;

import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.zjyx.right.plugin.es.ESTransportClient;
import com.zjyx.right.service.IEsService;

@Service
public class EsServiceImpl implements IEsService{

	@Autowired
	ESTransportClient transportClient;
	
	@Override
	public <T> String save(T t,String index,String type) {
		if(t == null){
			return null;
		}
		TransportClient client=transportClient.getClient();
		IndexRequestBuilder indexRequestBuilder =client.prepareIndex(index, type);
		String param = JSON.toJSONString(t);
		System.out.println(param);
		IndexResponse response = indexRequestBuilder.setSource(param).execute().actionGet();
		return response.getId();
	}

}
