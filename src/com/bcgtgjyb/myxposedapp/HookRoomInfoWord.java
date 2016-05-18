package com.bcgtgjyb.myxposedapp;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XC_MethodHook.MethodHookParam;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class HookRoomInfoWord implements IXposedHookLoadPackage{
private String TAG = HookRoomInfoWord.class.getName();
	
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {

    	if (!lpparam.packageName.equals("com.android.server.wm")){
    		return;
    	}
    	
    	findAndHookMethod("com.android.server.wm.WindowManagerService", lpparam.classLoader, "startViewServer", new XC_MethodHook() {
        	@Override
        	protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
        		XposedBridge.log(TAG+"=beforeHookedMethod");
            }
        	@Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
        		XposedBridge.log(TAG+"=afterHookedMethod");
        		param.setResult(true);
            }
        	
        });
    }
	

}
