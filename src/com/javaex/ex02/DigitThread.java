package com.javaex.ex02;

public class DigitThread extends Thread {
	private int start;
	private int end;
	char ch;
	
	public DigitThread() {
		start = 0;
		end = 10;
	}
	public DigitThread(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
		for(int i=start; i<=end; i++) {
			ch = (char)i;
			System.out.println(ch);
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
