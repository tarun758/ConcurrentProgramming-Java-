package busterminal;

import java.util.Date;

public class people implements Runnable {
	String name;
    Date inTime;
    enterence people;
 
   
    public people(enterence people)
    {
        this.people = people;
    }
 
    public String getName() {
        return name;
    }
 
    public Date getInTime() {
        return inTime;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }
 
    public void run()
    {
        enterIn();
        
    }
    private synchronized void  enterIn()
    {
    	
        people.enteredIn(this);
    }
}
