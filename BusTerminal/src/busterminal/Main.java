package busterminal;

public class Main {

	public static void main(String[] args) {
		
		
			enterence people = new enterence("West Entrance");
			station s = new station(people);
			 pessengerentering pg = new pessengerentering(people);
			 Thread ts = new Thread(s);
			 Thread thpg = new Thread(pg);
			 thpg.start();
			 ts.start();
			 
		
		
			enterence people1 = new enterence("East Entrance");
			station s1 = new station(people1);
			pessengerentering pg1 = new pessengerentering(people1);
			Thread ts1 = new Thread(s1);
			Thread thpg1 = new Thread(pg1);
			thpg1.start();
			ts1.start();

        

	}

}
