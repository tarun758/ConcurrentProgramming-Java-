package busterminal;

import java.util.Date;
import java.util.concurrent.TimeUnit;




class pessengerentering implements Runnable{

	enterence people;
	protected int s =1;
    public boolean closingTime = false;
    
    public pessengerentering(enterence people)
    {
        this.people = people;
    }
 
    public void run()
    {
        while(!closingTime)
        {
        	
            people p = new people(people);
            p.setInTime(new Date());
            Thread tp = new Thread(p);
            p.setName("Student "+tp.getId());
            tp.start();
            
            
            try {
				Thread.sleep(2000);
				ticket t = new ticket(people);
	            t.setInTime(new Date());
	            Thread tpc = new Thread(t);
	            t.setName("Student "+ tp.getId());
	            tpc.start();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
            
            
            try {
				Thread.sleep(2000);
				Enteringqueue eq = new Enteringqueue(people);
	            eq.setInTime(new Date());
	            Thread teq = new Thread(eq);
	            eq.setName("Student"+ tp.getId());
	            teq.start();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
            
            try {
				Thread.sleep(2000);
				ticketforQueue tq = new  ticketforQueue(people);
	            tq.setInTime(new Date());
	            Thread tqc = new Thread(tq);
	            tq.setName("Student "+ tp.getId());
	            tqc.start();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
            
            
            
            
            
            
            
           
            
           
            
            try
            {
                TimeUnit.SECONDS.sleep((long)(Math.random()*10));
            }
            catch(InterruptedException iex)
            {
                iex.printStackTrace();
            }
        }
        if (closingTime) { 
            try 
            {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return;
        }
    }
    	
}
