package com.abc.singletondp.conn;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;


public class DBThreadEnumUT extends TestCase{

	   private static DBConnection dbThread = null;
	   public DBThreadEnumUT(String name) {
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
		    	  DBConnection s = DBConnection.getInstance();
		         synchronized(DBThreadSampleUT.class) {
		            if(dbThread == null)
		               dbThread = s;    
		         }
		         Assert.assertEquals(true, s == dbThread);
		      }
		   }
}
