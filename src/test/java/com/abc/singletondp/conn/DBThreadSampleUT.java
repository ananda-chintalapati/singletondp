package com.abc.singletondp.conn;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;

public class DBThreadSampleUT extends TestCase {

   private static DBThreadSample dbThread = null;
   public DBThreadSampleUT(String name) {
      super(name);
   }
   public void setUp() {
      dbThread = null;
   }
   
	@Test
	public void testUnique() throws InterruptedException {
	     Thread threadOne = new Thread(new SingletonTestRunnable()),
	             threadTwo = new Thread(new SingletonTestRunnable());
	      threadOne.start();
	      threadTwo.start();
	      threadOne.join();
	      threadTwo.join();
	}
	
	 private static class SingletonTestRunnable implements Runnable {
	      public void run() {
	    	  DBThreadSample s = DBThreadSample.getInstance();
	         synchronized(DBThreadSampleUT.class) {
	            if(dbThread == null)
	               dbThread = s;    
	         }
	         Assert.assertEquals(true, s == dbThread);
	      }
	   }
}
