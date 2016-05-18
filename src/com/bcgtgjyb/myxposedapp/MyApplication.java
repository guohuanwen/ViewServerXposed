package com.bcgtgjyb.myxposedapp;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application{

	private static Context mContext;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		mContext = getApplicationContext();
	}
	
	
	public static Context getContext (){
		return mContext;
	}
	

}
