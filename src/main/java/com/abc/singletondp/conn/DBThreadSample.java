package com.abc.singletondp.conn;

public class DBThreadSample {

	private static DBThreadSample threadSample = null;
	private static boolean firstThread = true;
	private DBThreadSample() {
		
	}
	
	public static DBThreadSample getInstance() {
		runActivity();
		threadSample = new DBThreadSample();
		System.out.println("Created object "+threadSample);
		return threadSample;
	}
	
	private static void runActivity() {
		if(firstThread) {
			firstThread = false;
			System.out.println("Sleeping....");
			try {
				Thread.currentThread().sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
