package busterminal;

import java.util.LinkedList;
import java.util.List;



public class enterence {
	
	
	String name;
	

	int fayel = 5;

	int capacity = 35;

    protected int capacityr = 10;

    protected int capacityOfC = 3;
 
    protected int sit = 0;
   
   
 
    
  
    List<people> noPeople;

    List<ticket> ll;

    List<Enteringqueue> queue1;

    List<Enteringqueue> queue2;

    List<Enteringqueue> queue3;

    LinkedList<ticketforQueue> ll2;

    LinkedList<ticket>waiting;
    

    public enterence(String name)
    {
    	

       
    	noPeople = new LinkedList<people>();
    	ll = new LinkedList<ticket>();
    	queue1 = new LinkedList<Enteringqueue>();
    	queue2 = new LinkedList<Enteringqueue>();
    	queue3 = new LinkedList<Enteringqueue>();
    	waiting = new LinkedList<ticket>();
    	ll2 = new LinkedList<ticketforQueue>();
    	this.name = name;
    }
  

	public void takeTicket() {
    
    	people p;
    	Enteringqueue en;
        synchronized (noPeople)
        {
 
            while(noPeople.size()==0)
            {
                System.out.println("Currently the terminal is empty");
                try
                {
                	noPeople.wait();
                }
                catch(InterruptedException iex)
                {
                    iex.printStackTrace();
                }
            }
        
            
            p = (people)((LinkedList<?>)noPeople).poll();
            System.out.println(p.getName() + " is entering into the terminal ");
            
            
        }
        long duration=0;
       
        
        try
        {    
            
            
            duration = (long)(Math.random()*1000);
            Thread.sleep(2000);
          
            
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        
        synchronized (queue1)
        {
 
            while(queue1.size()==10)
            {
                System.out.println("Currently  the line is full");
                try
                {
                	queue1.wait();
                }
                catch(InterruptedException iex)
                {
                    iex.printStackTrace();
                }
            }
        
            
            en = (Enteringqueue)((LinkedList<?>)queue1).poll();
            System.out.println(p.getName() + "Students are alowed to enter");
            
            
        }
        
    }
	

    
	public void enteredIn(people people) {
		
		
		
		
		ticket t;
        synchronized (noPeople)
        {
            if(noPeople.size() == capacity)
            {
            	
            	System.out.println("The terminal is full " +people.getName()+" must wait");
                System.out.println("Hold Please");
                return ;
            }
            System.out.println(people.getName()+ " are entering into the temrianl from " + this.name);
            ((LinkedList<people>)noPeople).offer(people);
   
        
            if(noPeople.size() == 1)
                noPeople.notify();
            
           
        }
    }
	
	

    public void addingQueue(ticket ticket){
    	
    	 
    	
        synchronized(ll) {
          	
        	
          	while (ll.size() == capacityOfC) {
          		
          		try {
					ll.wait();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
          		
          	}
          }
        
   
     if(this.name == "East Entrance") {
    	 ((LinkedList<ticket>)ll).offer(ticket);
    	 System.out.println(ticket.getName() + " collecting Ticket ");
     }
     
     else {
    	 
    	 ((LinkedList<ticket>)ll).offer(ticket);
    	 ((LinkedList<ticket>)ll).offer(ticket);
    	 System.out.println( ticket.getName() + " collecting Ticket ");
    	 
    
     }
          
          
          
          
          if(ll.size() >= 1) {
        	  ticket t;
        	  t = (ticket)((LinkedList<?>)ll).poll();
        	  System.out.println(ticket.getName() + " Has took the ticket ");
          }
 
          
      }

    public void removingFromQueue(ticketforQueue t){
    	
   
        synchronized (ll2)
        {
        	
        	
            while(ll2.size() ==6)
            {
                System.out.println(" waiting for the bus ");
                try
                {
                	ll2.wait();
                	Thread.sleep(4000);
                }
                catch(InterruptedException iex)
                {
                    iex.printStackTrace();
                }
            }
            
            if(this.name == "East Entrance") {
            	
            	try {
					Thread.sleep(2000);
					((LinkedList<ticketforQueue>)ll2).offer(t);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
            }
            else {
            	
            	try {
					Thread.sleep(2000);
					((LinkedList<ticketforQueue>)ll2).offer(t);	
	            	((LinkedList<ticketforQueue>)ll2).offer(t);
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}
            }
           
        	if(ll2.size() == 0) {
        		
        		try
                {
        			System.out.println(" New Bus is arriving now ");
                    Thread.sleep(2000);
                }
                catch(InterruptedException iex)
                {
                    iex.printStackTrace();
                }
        		
        		
        	}
            
        	 try {
  				Thread.sleep(2000);
  				System.out.println(t.getName() + " is in the bus now " );
  	          
  			} catch (InterruptedException e) {
  				
  				e.printStackTrace();
  			}
        	
           		
            
            
           
   		 	if(ll2.size() ==6) {
   		 	 try {
 				Thread.sleep(2000);
 				System.out.println(t.getName() + "  is on bus" );
 	           	System.out.println(" people are in the bus "+ ll2.size());
 			} catch (InterruptedException e) {
 				
 				e.printStackTrace();
 			}
             
   		 	for(int i=0;i<6;i++) {
   		 		
   		 		t = (ticketforQueue)((LinkedList<?>) ll2).poll();
   		 	   
   		 			
   		 		
   		 	}
   		 	
   		    System.out.println(" Bus has been departured ");
   		 	
   		 try
         {
             Thread.sleep(2000);
         }
         catch(InterruptedException iex)
         {
             iex.printStackTrace();
         }
   		 	
   		 	
   		 	}
   		 	
   		 	
   		
        }
        
       
        
        
    }
   


public void addingtoqueue1(Enteringqueue enteringqueue){
    	
        synchronized(queue1) {

          	while (queue1.size() == capacityr) {
          		
          		try {
          			System.out.print("Currently no place in queue 1");
          			System.out.print("Please wait");
          			queue1.wait();
          			
          			addingtoqueue2(enteringqueue);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
          		
          	}
          }
        
        
     if(this.name == "East Entrance") {
    	 ((LinkedList<Enteringqueue>)queue1).offer(enteringqueue);
    	 System.out.println(enteringqueue.getName() + " Going to queue 1 " );
    	 
    	 
     }
     else {
    	 
    	 ((LinkedList<Enteringqueue>)queue1).offer(enteringqueue);
    	 ((LinkedList<Enteringqueue>)queue1).offer(enteringqueue);
    	 System.out.println(enteringqueue.getName() + " Going to Queue  2 ");
    	 
    
     }
          
          System.out.println("Number of students "+ queue1.size());
   
          enteringqueue = (Enteringqueue)((LinkedList<?>) queue1).poll();
          
      
          try {
			Thread.sleep(2000);
			System.out.println(enteringqueue.getName() + " is checking by ticket officer");
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		}
          if(queue1.size() ==10) {
                  queue1.notify();
          }
  
          
      }
    
public void addingtoqueue2(Enteringqueue enteringqueue){
	
    synchronized(queue2) {

      	while (queue2.size() == capacityr) {
      		
      		try {
      			queue2.wait();
      			addingtoqueue3(enteringqueue);
      			
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
      		
      	}
      }
    
    
 if(this.name == "East Entrance") {
	 ((LinkedList<Enteringqueue>)queue2).offer(enteringqueue);
	 System.out.println(enteringqueue.getName() + " Going to queue 2 ");
 }
 else {
	 
	 ((LinkedList<Enteringqueue>)queue2).offer(enteringqueue);
	 ((LinkedList<Enteringqueue>)queue2).offer(enteringqueue);
	 System.out.println(enteringqueue.getName() + " Going to Queue  3 ");
	 

 }

      System.out.println("Number of students "+ queue2.size());
      enteringqueue = (Enteringqueue)((LinkedList<?>) queue2).poll();
   
      try {
		Thread.sleep(2000);
		System.out.println(enteringqueue.getName() + " is checking by ticket checker");
	} catch (InterruptedException e) {
	
		e.printStackTrace();
	}
      
      
  }
public void addingtoqueue3(Enteringqueue enteringqueue){
	
    synchronized(queue3) {
    
      	while (queue3.size() == capacityr) {
      		
      		try {
      			queue3.wait();
      			waitingarea(enteringqueue);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
      		
      	}
      }
    
    
 if(this.name == "East Entrance") {
	 ((LinkedList<Enteringqueue>)queue3).offer(enteringqueue);
	 System.out.println(enteringqueue.getName() + " Going to queue 3 ");
 }
 else {
	 
	 ((LinkedList<Enteringqueue>)queue3).offer(enteringqueue);
	 ((LinkedList<Enteringqueue>)queue3).offer(enteringqueue);
	 System.out.println( enteringqueue.getName() + " Going to Queue 1 ");
	 

 }
      
      System.out.println("Number of students "+ queue3.size());
    
      enteringqueue = (Enteringqueue)((LinkedList<?>) queue3).poll();

      try {
		Thread.sleep(2000);
		System.out.println(enteringqueue.getName() + " is checking by ticket checker ");
	} catch (InterruptedException e) {
	
		e.printStackTrace();
	}
      
  }

public void waitingarea(ticket ticket){
	
    synchronized(waiting) {
      	
      	while (waiting.size() == fayel) {
      		
      		try {
				noPeople.wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
      		
      	}
      }
    
    
 if(this.name == "East Entrance") {
	 ((LinkedList<ticket>)waiting).offer(ticket);
	 System.out.println(ticket.getName() + " Entering to station ");
 }
 else {
	 
	 ((LinkedList<ticket>)waiting).offer(ticket);
	 ((LinkedList<ticket>)waiting).offer(ticket);
	 System.out.println(ticket.getName() + " Entering to station ");
	 

 }
      
      System.out.println(" people are in waiting area "+ waiting.size());

      ticket = (ticket)((LinkedList<?>)waiting).poll();
      
      if(waiting.size()==5){	
			try {
				noPeople.wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}	
     		
     	}
      
  }


}
 
		
	
	

