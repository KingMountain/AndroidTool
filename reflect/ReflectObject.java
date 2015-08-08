package com.caidongrong.reflect;

public class ReflectObject {
	//private method and variable
	private int color = 225;
	private String mixColor(Integer mColor,Double mSecondColor) {
		return "After mix: "+ this.color + mColor + mSecondColor;
	}
}
