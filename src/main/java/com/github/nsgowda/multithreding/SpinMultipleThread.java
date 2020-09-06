package com.github.nsgowda.multithreding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SpinMultipleThread {

	public static void main(String[] args) {
		ExecutorService executor1 = Executors.newFixedThreadPool(10);
		try {
			for (int i = 0; i < 10; i++) {
				executor1.execute(() -> {
					String threadName = Thread.currentThread().getName();
					System.out.println("Hello " + threadName);
				});

			}
		} finally {
			executor1.shutdown();
		}
		ExecutorService executor2 = Executors.newFixedThreadPool(10);
		try {
			for (int i = 0; i < 10; i++) {
				executor2.execute(new MyRunnable());
			}
		} finally {
			executor1.shutdown();
		}

	}

}

class MyRunnable implements Runnable {

	/**
	 * When an object implementing interface <code>Runnable</code> is used
	 * to create a thread, starting the thread causes the object's
	 * <code>run</code> method to be called in that separately executing
	 * thread.
	 * <p>
	 * The general contract of the method <code>run</code> is that it may
	 * take any action whatsoever.
	 *
	 * @see Thread#run()
	 */
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println("Hello2 " + threadName);
	}
}
