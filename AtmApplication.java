package projectsjava;




import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

class pininvalidexception extends Exception{
	
}


class ATM{
	private int pin=1234;
	int secretpin;
	long cardnumber;
	int cvv;
	int userbalance;
	
	Scanner scan=new Scanner(System.in);
	public void takeinput() {
		System.out.println("enter the pin number");
		secretpin=scan.nextInt();
	}
	
	
	
	
	int withdrawlamount; 
	int balance=0;
	
	public void pinvalidation() throws pininvalidexception {
		if (pin == secretpin) {
			
			System.out.println("enter your balance amount");
			userbalance=scan.nextInt();
			balance=userbalance;
			
			System.out.println("enter your withdrawl amount");
		    withdrawlamount=scan.nextInt();
			balance -= withdrawlamount;
			
			System.out.println("collect the cash");
			
			System.out.println("your available balance is : "+balance);
			toPrintBalance();
		}
		
		else {
			System.out.println("invalid pin");
			pininvalidexception piv=new pininvalidexception();
			throw piv;
		}
		
	}
	
	
	//checkbalance method is here
	
	
	
	void checkbalance()  throws pininvalidexception{
		if (pin == secretpin) {
			
			System.out.println("enter your balance amount");
			 userbalance=scan.nextInt();
			balance=userbalance;
			
			System.out.println("your balnace is : "+balance);
			toPrintBalance();
		}
		
		else {
			System.out.println("invalid pin");
			pininvalidexception piv=new pininvalidexception();
			throw piv;
		}
		
	}
	
	
	//to create atm pin
	
	public void tosetpin() throws pininvalidexception {
		try {
			
			
			Scanner scan=new Scanner(System.in);
			int newpin=0;
			int count=0;
			int cardcount=0;
			int newpincount=0;
			int funcount=0;
			                            
			 
			
					System.out.println("enter the card number");
					 cardnumber=scan.nextLong();
					
					
					                                     //atm card 12 digits validation condition here
					
					while(cardnumber>0) {
						
						cardnumber/=10;
						cardcount++;
						
					}
					
					if(cardcount==12) {
						
						                              //atm cvv number validation here here we check user enter correct 3 digit pin or not
						
						System.out.println("enter the cvv number");
						
						                                // here we check the pin is four digits or not
						 cvv=scan.nextInt();
						
						
						while(cvv>0) {
							cvv/=10;
							count++;
						}

						
						if(count==3) {
							System.out.println("to set your pin pin must be fout digits");
							int setpin=scan.nextInt();
							System.out.println("once again enter the pin ");
							int repin=scan.nextInt();
							newpin=setpin;
							while(newpin>0) {
								
								newpin/=10;
								newpincount++;
							}
							
							if(newpincount==4 && repin==setpin) {
								System.out.println("you pin is " +repin);
								
								
							}
							
							else {
								System.out.println("plese enter the correct pin, pin must be fout digits only and pin number must contain only four digits only");
								tosetpin();
								
							}
						}
						
						else {
							System.out.println("plese enter correct cvv and cvv must be four digits");
							
							tosetpin();
						}
						
						
					}
					
					else {
						System.out.println("plese enter the valid card number");
						System.out.println("card number only have 12 digits enter correct details");
						tosetpin();
					
						
					}
			
			
		} catch (Exception e) {
			
			
			System.out.println("invalid details");
			pininvalidexception ivd=new pininvalidexception();
			throw ivd;
		}
				
		
	}
	
	
	
	
	
	
	
	public void toPrintBalance(){
		
		 LocalDate currentDate = LocalDate.now();
	        System.out.println("Current Date: " + currentDate);
	        
	        
	        LocalTime currentTime = LocalTime.now();
	        System.out.println("Current Time: " + currentTime);
		
		System.out.println("A.C= 17500XXXXXXX" );
		System.out.println(" Card number : 123X XXXX XXXX");
		System.out.println(" CVV number : 7XX");
		
		System.out.println("Initial balance :"+ userbalance);
		System.out.println("withdraw amount :"+ withdrawlamount);
		System.out.println("Avail.Balnace :"+balance);
		
	}
	
	
	
	
	
}



class Checkbalance{
	
	ATM atm=new ATM();
	
	void checkbalance() {
		try {
			atm.takeinput();
			atm.checkbalance();
		} catch (Exception e) {
			try {
				atm.takeinput();
				atm.checkbalance();
			} catch (Exception e1) {
				try {
					atm.takeinput();
					atm.checkbalance();
				} catch (Exception e2) {
					System.out.println("your card is blocked conteact your bank");
					
				}
			}
		}
	}
	
}




class Bank{
	
	ATM atm=new ATM();
	void permission()  {
	
		try {
		atm.takeinput();
		atm.pinvalidation();
		} 
		catch (Exception e) {
			try {
				atm.takeinput();
				atm.pinvalidation();
				} 
				catch (Exception e1) {
					try {
						atm.takeinput();
						atm.pinvalidation();
						} 
						catch (Exception e3) {
						   System.out.println("your card is blocked plese contact bank");
						   e3.printStackTrace();
						   
						}
				}
		}
		
		
	}

	
}


class Createpin{
	
	
	void changepin() {
		ATM atm=new ATM();
		try {
			atm.tosetpin();
		} catch (Exception e) {
			System.out.println("invalid details plese check once this is the last chance");
			try {
				atm.tosetpin();
			} catch (Exception e1) {
				System.out.println("invalid details plese check the details plese contact the your near bank");
			}
		}
	}
}



public class AtmApplication {

	public static void main(String[] args) {
        Bank bank = new Bank();
        Checkbalance checkbalance = new Checkbalance();
        Createpin createpin = new Createpin();
        
        try {
            Scanner scan = new Scanner(System.in);
            
            System.out.println("Press 1 for amount withdrawal");
            System.out.println("Press 2 for balance enquiry");
            System.out.println("Press 3 for creating a new pin");
            int i = scan.nextInt();
            
            switch (i) {
                case 1:
                    bank.permission();
                            
                    break;
                case 2:
                    checkbalance.checkbalance();
                    break;
                case 3:
                    createpin.changepin();
                    break;
                default:
                    System.out.println("Invalid option! Please choose a valid option.");
                    
                
            }
        } catch (Exception e) {
            System.out.println("Please choose the option using numbers only.");
            System.out.println(e.getMessage());
        }
    }

	
}
