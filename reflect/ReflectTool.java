package com.caidongrong.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTool {
	ReflectObject mObject;
	String reflectObjectVariableName = "color";
	String reflectObjectMethodName = "mixColor";
	public ReflectTool(ReflectObject mObject) {
		this.mObject = mObject;
	}

	//using reflect to get private variable
	public Integer getReflectObjectColor() {
		try {
			Field mField = mObject.getClass().getDeclaredField(reflectObjectVariableName);
			//Inorder to access private variable, you need to set accessible to true
			mField.setAccessible(true);
			//setter usage
			//mField.set(mObject, 222);
			return mField.getInt(mObject);
		} catch (Exception e) {
		}
		return null;
	}
	
	public String getReflectObjectMethod() {
		try {
			Method method = mObject.getClass().getDeclaredMethod(reflectObjectMethodName, Integer.class, Double.class);
			//set true to have the right to access private method
			method.setAccessible(true);
			//it's important to konw the return object's type
			String invorkReult = (String) method.invoke(mObject, 123,456.0);
			return invorkReult;
		} catch (Exception e) {
		}
		return null;
	}
	
}
