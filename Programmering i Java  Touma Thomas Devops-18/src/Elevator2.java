import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Elevator2 {
	static final int maxFloor= 10;
	static final int minFloor=0;
	 private int floor;
	private String name;
	Scanner scanner = new Scanner(System.in);
	
	
	
	public Elevator2()
	{
		//Default constructor
		setName();
		startUpp();;
	}
	
	public Elevator2(int floor, String name) {
		super();
		this.floor = floor;
		this.name = name;
	}
	
	public void setFloor(int f) {
		floor = f;
	}
	public int getFloor() {
		return this.floor;
	}
	public void setName() {
		
		System.out.println("Enter a name for the elevator");
		name =scanner.nextLine();
	}
	public String getName() {
		return this.name;
	}
	
	
	
	public void startUpp() {
	
		
		int x;
		while(true) {
			System.out.println("Enter a starting floor");
		     x = scanner.nextInt();
			if(x>Elevator2.maxFloor) {
				System.out.println("The highest floor is 10, you cant go higher than that");
				
				}
			else if (x<Elevator2.minFloor) {
				System.out.println("The lowest floor is 0, you cant go lower than that");
				
				}
		
		    else {
				System.out.println("Welcome to the elevator: " + getName() + "\nYou have succesfully choosen starting floor for the elevator");
				floor = x;
				break;
				}
}
	}


	int goUpp(int floorUpp) {
		if(floorUpp!=getFloor() && floorUpp<=maxFloor && getFloor()>=minFloor && getFloor()<=maxFloor) {
			for (int i = floor; i < floorUpp; i++) {
				System.out.println("pling... at floor " + (i+1));
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//floor++;
				setFloor(i+1);
				
			}
		}
		else if(floorUpp == getFloor()) {
			System.out.println("You are allready at floor " + getFloor());
		}
		
		if(floorUpp<getFloor()) {
			System.out.println("You cant travel upp from floor " + getFloor() + " to floor " + floorUpp);
		}
		
		if(floorUpp>maxFloor) {
			System.out.println("This building highest floor is 10, you cant travel further upp than that");
		}
		
		System.out.println("***************************************************\n" + "Current floor: " + getFloor());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getFloor();
		
	}
	
	
	int goDown(int floorDown) {
		
		if(floorDown!=getFloor() && floorDown>=minFloor && getFloor()>=minFloor && getFloor()<=maxFloor) {
			for (int i = getFloor(); i > floorDown; i--) {
				System.out.println("pling... at floor " + (i-1));
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				setFloor(i-1);
			
			} 	
		}
		else if(floorDown == getFloor()) {
			System.out.println("You are allready at floor " + getFloor());
		}
		
		if(floorDown>getFloor()) {
			System.out.println("You cant travel down from floor " + getFloor() + " to floor " + floorDown);
		}
		
		if(floorDown<minFloor) {
			System.out.println("This buildings lowest floor is 0, you cant travel further down than that");
		}
		
	System.out.println( "***************************************************\n" + "Current floor: " + getFloor());
	try {
		TimeUnit.SECONDS.sleep(1);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return getFloor();
	}
	
	public void Switchmeny() {
		int operator = 0;
		do {
			System.out.println("**************************************************\n" + "To travel down press 1 and follow the instructions \n" +"**************************************************\n" +
					 "To travel upp press 2 and follow the instructions\n" +"************************************************* \n" +
					 "To exit the simulator press 0 \n" + "*************************************************");
				try {
					operator= scanner.nextInt();
					if (operator<0 || operator>2) {
						   System.out.println("Not a valid number.");
						}
					
				}
				catch (InputMismatchException e) {
				   System.out.println("Must enter an integer!");
					scanner.next();   // discard the bad input
				}	
			} while (operator<0 || operator>2);
			System.out.println("You entered " + operator);
			 int interator = operator;
			
			
		switch(interator) {
		case 1 :
			System.out.println("Which floor do you wish to travel down to ? enter a floor number between 0-10");
			int down = scanner.nextInt();
			goDown(down);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Switchmeny();
		case 2 :
			System.out.println("Which floor do you wish to travel up to ? enter a floor number between 0-10");
			int upp = scanner.nextInt();
	    	goUpp(upp);
	    	try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	Switchmeny();
	    	
		case 0 :
			System.out.println("Thank you for using this elevator simulator, stay safe!");
			scanner.close();
			break;
		default :
			System.out.println("I never said that you could enter anything else than what i described, try again");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Switchmeny();
		}
		
	}
  //end
}
