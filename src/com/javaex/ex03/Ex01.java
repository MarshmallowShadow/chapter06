package com.javaex.ex03;

public class Ex01 {
	public static void main(String[] args) {
		Runnable digit = new DigitImpl();
		
		Thread thread = new Thread(digit);
		thread.start();
	}
}
