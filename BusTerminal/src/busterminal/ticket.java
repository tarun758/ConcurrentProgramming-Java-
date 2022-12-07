package busterminal;

import java.util.Date;

public class ticket extends people {
	static int counter = 0;
	public ticket(enterence people) {
		super(people);
		
	}
	


	@Override
	public String getName() {
	
		return super.getName();
	}



	@Override
	public Date getInTime() {
		
		return super.getInTime();
	}



	public void run() {

			go();
		
		
	}


	private void go(){
	   
		if(counter == 0) {
			try {
				Thread.sleep(3000);
				System.out.println("Students taking ticket through Ticket machine 1");
				
				people.addingQueue(this);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			
			counter++;
			
		}
		else if(counter == 1) {
			try {
				Thread.sleep(3000);
				
				System.out.println("Students taking ticket through Ticket booth 1");
				people.addingQueue(this);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			

			counter++;
			
		}
		else{
			try {
				Thread.sleep(3000);
				System.out.println("Students taking ticket through Ticket booth 2");
				people.addingQueue(this);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			
			counter = 0;
		}
		
		
		
	}
	
	
	
}
