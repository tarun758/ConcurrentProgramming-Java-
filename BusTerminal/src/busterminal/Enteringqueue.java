package busterminal;

import java.util.Date;

public class Enteringqueue extends ticket{
	static int Q = 0;
	public Enteringqueue(enterence people) {
		super(people);
		
	}
	
	public String getName() {
		
		return super.getName();
	}




	public Date getInTime() {
	
		return super.getInTime();
	}



	public void run() {

			go();
		
		
	}


	private void go(){
		
		
		if(Q == 0) {
			try {
				Thread.sleep(1000);
				
				people.addingtoqueue1(this);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			
			Q++;
			
		}
		else if(Q == 1) {
			try {
				Thread.sleep(1000);
				
				people.addingtoqueue2(this);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			

			Q++;
			
		}
		else{
			try {
				Thread.sleep(1000);
			
				people.addingtoqueue3(this);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			
			Q = 0;
		}
		
		
		
	}
	
}
