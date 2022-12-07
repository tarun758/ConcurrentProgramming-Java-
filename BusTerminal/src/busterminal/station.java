package busterminal;


class station implements Runnable {

	enterence people;
    public boolean closingTime = false;

    public station(enterence people)
    {
        this.people = people;
    }
    public void run()
    {
        try
        {
            Thread.sleep(5000);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        while(!closingTime)
        {
            people.takeTicket();
            
        
      
        }
        if (closingTime) { try {
     			Thread.sleep(5000);
     		} catch (InterruptedException e) {
     
     			e.printStackTrace();
     		} return;}
    }
    public synchronized void setclosingTime()
    {
    closingTime = true;
    System.out.println("Gaurd number 1  : The gate is closing");
    }
    public synchronized void setclosingTime2()
    {
    closingTime = true;
    System.out.println("Guide number 2: The gate is closing!");
    }
    
}
