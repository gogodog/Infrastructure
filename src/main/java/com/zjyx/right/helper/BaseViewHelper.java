package com.zjyx.right.helper;

import com.zjyx.right.model.controllerview.BaseView;

public class BaseViewHelper {
	public static BaseView getBaseView(boolean isError, String code, String msg, Object object){
		BaseView view = new BaseView();
		view.setError(isError);
		view.setErrorCode(code);
		view.setErrorMessage(msg);
		view.setObjects(object);
		return view;
	}
	public static BaseView getBaseView(boolean isError, String code, String msg){
		BaseView view = new BaseView();
		view.setError(isError);
		view.setErrorCode(code);
		view.setErrorMessage(msg);
		return view;
	}
	public static BaseView getSuccessBaseView(){
		BaseView view = new BaseView();
		return view;
	} 
}
