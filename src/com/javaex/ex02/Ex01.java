package com.javaex.ex02;

public class Ex01 {
	public static void main(String[] args) {
		Thread th01 = new DigitThread('a', 'z');
		Thread th02 = new DigitThread('A', 'Z');
		Thread th03 = new DigitThread('0', '9');
		
		th01.start();
		th02.start();
		th03.start();
	}
}
