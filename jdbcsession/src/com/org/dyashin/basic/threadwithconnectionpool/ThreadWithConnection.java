package com.org.dyashin.basic.threadwithconnectionpool;

import java.sql.Connection;
import java.sql.SQLException;

public class ThreadWithConnection extends Thread {
	public static void main(String[] args) {
		ConnectionPool con = new ConnectionPool();

		Thread t1 = new Thread(() -> {
			try {
				Connection co = con.getConnection();
				Thread.sleep(3000);
				con.returnConnection(co);
			} catch (SQLException | InterruptedException e) {
				e.printStackTrace();
			}

		});
		Thread t2 = new Thread(() -> {
			try {
				Connection co = con.getConnection();
				Thread.sleep(2000);
				
				
			} catch (SQLException | InterruptedException e) {
				e.printStackTrace();
			}

		});
		Thread t3 = new Thread(() -> {
			try {
				Connection co = con.getConnection();
				Thread.sleep(3000);
				
				
			} catch (SQLException | InterruptedException e) {
				e.printStackTrace();
			}

		});
		t1.start();
		t2.start();
		t3.start();

	}

}
