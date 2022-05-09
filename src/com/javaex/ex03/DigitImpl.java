package com.javaex.ex03;

public class DigitImpl implements Runnable {
	@Override
	public void run() {
		for(int i=0; i<9; i++) {
			System.out.println(i);
		}
	}
}
