package busterminal;

import java.util.Date;

public class ticketforQueue extends ticket {

	public ticketforQueue(enterence people) {
		super(people);
		
	}
	



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
		
		people.removingFromQueue(this);
		
		
	}
	
	
	
}

