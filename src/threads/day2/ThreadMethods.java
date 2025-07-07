package threads.day2;
public class ThreadMethods extends Thread {
	
	public ThreadMethods (String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName()+ " is Running");
			Thread.yield();
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	

	}
	
	public static void main(String[] args) {
		
		ThreadMethods t1 = new ThreadMethods("ThreadOne");
		ThreadMethods t2 = new ThreadMethods("ThreadTwo");
		t1.start();
		try {
			t1.join();//-->
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		
		
	}

}
