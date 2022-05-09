package com.javaex.ex04;

public class Ex01 {
	public static void main(String[] args) {
		Thread th01 = new Thread(new DigitImpl());
		Thread th02 = new Thread(new DigitImpl('A', 'Z'));
		Thread th03 = new Thread(new DigitImpl('a', 'z'));
		
		th01.start();
		th02.start();
		th03.start();
	}
}
