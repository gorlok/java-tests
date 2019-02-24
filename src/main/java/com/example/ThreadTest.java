package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreadTest {
	
	public static void main(String[] args) {
		var t = new Task();
		t.start();
		
		while (true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("press <ENTER> to interrupt the thread");
			try {
				br.readLine();
			} catch (IOException e) {}
			System.out.println("main - interrupting thread");
			t.interrupt();
		}
		
	}

}

class Task extends Thread {
	@Override
	public void run() {
		while (true) {
			System.out.println("do stuff...");
			
			
			long time = System.currentTimeMillis();
			
			while ((System.currentTimeMillis() - time) < 1000 * 10) {
			}
			System.out.println("DONE. Going to sleep now.");

			try {
				Thread.sleep(1000 * 60); // 1 min
			} catch (InterruptedException e) {
				System.out.println("thread interrupted");
			}
		}
	}
}
