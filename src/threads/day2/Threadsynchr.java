package threads.day2;

public class Threadsynchr extends Thread {
	
	Display d;
	String name;
	
	public Threadsynchr(Display d, String name) {
		this.d = d;
		this.name = name;
	}
	
	@Override
	public void run() {
		d.duStuff(name);
	}
	
	public static void main(String[] args) {
		
		Display d1 = new Display();
		//duStuff method is synchronized so after t1 execution completes then only t2 will proceed
		Threadsynchr  t1 = new Threadsynchr(d1,"hema");
		Threadsynchr t2 = new Threadsynchr(d1, "nisha");
		/*
		 *  daemon threads is a background service threads that provide support to user threads. 
		*/
		t1.setDaemon(true); // daemon has to be set before starting a thread
		t1.start();
//		t1.setDaemon(true); --> this leads to  IllegalThreadStateException
		
		System.out.println(t1.isDaemon());
		t2.start();
		
	}
	



}
