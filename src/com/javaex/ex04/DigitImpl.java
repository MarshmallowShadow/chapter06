package com.javaex.ex04;

public class DigitImpl implements Runnable {
	private char start;
	private char end;
	
	public DigitImpl() {
		start = '0';
		end = '9';
	}
	public DigitImpl(char start, char end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
		for(char i=start; i<=end; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
