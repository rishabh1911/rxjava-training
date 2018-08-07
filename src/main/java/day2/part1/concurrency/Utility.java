package day2.part1.concurrency;

import java.util.concurrent.ThreadLocalRandom;

public class Utility {
	
	public static Integer longRunningComputation(Integer x) {
		// TODO Auto-generated method stub
		System.out.print(Thread.currentThread().getName()+" "+x);
		sleep(ThreadLocalRandom.current().nextInt(100));
		return x;
		
	}

	public static void sleep(int nextInt) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(nextInt);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void printx(int nextInt){
		System.out.println(Thread.currentThread().getName()+ " "+ nextInt);
	}

}
