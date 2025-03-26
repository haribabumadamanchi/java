package projectsjava;

import java.util.Scanner;

interface messagesystem{
	
	public void textverification();
	public void gmailverification();
}


class Messages implements messagesystem{
	
	@Override
	public void textverification() {
		
		System.out.println("textverification is completed");
	}
	
	@Override
	public void gmailverification() {
		System.out.println("gmailverification is completed");
	}
}



class peoplelogin{
	
	Scanner scanner = new Scanner (System.in);
	String username;
	String password;
	
	public void userlogin() {
		
		String username="hari";
		String password="hari@2003";
		
		System.out.println("create your username");
		String uname=scanner.nextLine();
		username=uname;
		
		System.out.println("enter your password");
		String newpassword=scanner.nextLine();
		//scanner.nextLine();
		System.out.println("enter password once again");
		String repassword=scanner.nextLine();
		
		if(newpassword==repassword) {
			password=repassword;
		}
		else {
			System.out.println("your password is wrong plese enter correct password");
		}
	}
	
	
	
	public void loginVerification() {
		
		System.out.println("username");
		String userid=scanner.nextLine();
		
		System.out.println("password");
		String passwords=scanner.nextLine();
		
		if(userid==username && password==passwords) {
			System.out.println("you are suceesfully login");
			
		}
		else {
			System.out.println("User details are incorrect plese login once");
			loginVerification();
			System.out.println("User details are incorrect plese login next time");
		}
		
		
	}
	
	
}


class Register{
	Scanner scanner = new Scanner (System.in);
	
	Verification  vf=new Verification ();
	
	
	peoplelogin ulogin=new peoplelogin();
	
	public void registerDetails() {
		String Nuser="NEWUSER";
		System.out.println("Enter NEWUSER if you are register/new user ");
		String name=scanner.nextLine();
		if(Nuser.equals(name)) {
			ulogin.userlogin();
			vf.verification();
			
			
			System.out.println("you are sucessfully registered then login ");
			loginDetails();
		}
		
		else {
			System.out.println("you are enter wrong details plese enter you are correct details");
		}
	}
	
	
	public void loginDetails() {
		String Nlogin="login";
		
		System.out.println("Enter LOGIN if you are login");
		String loginname=scanner.nextLine();
		
		if(Nlogin.equals(loginname)) {
			
			ulogin.loginVerification();
			
		}

	}
	
	
}


class Verification {
	
	Scanner scanner = new Scanner (System.in);
	
	public void verification() {
		messagesystem msg = new Messages();
		System.out.println("enter 1 for verification for texttype");
		System.out.println("enter 2 for verification for gmailtype");
		
		System.out.println("enter the number which type of verification you want");
		int number=scanner.nextInt();
		
		if(number==1) {
			msg.textverification();
			System.out.println("verification is sucessfully completed");
		}
		else if(number==2) {
			msg.gmailverification();
			System.out.println("verification is sucessfully completed");
		}
		
	}
	
	
}


public class Userlogin {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		Register reg=new Register();
		
		System.out.println("Enter REGISTER if you are register/new user ");
		System.out.println("Enter LOGIN if you are login");
		
		String rname="REGISTER";
		String lname="LOGIN";
		
		String name=scanner.nextLine();
		if(name.equals(rname)) {
			
			reg.registerDetails();
		}
		else if(name.equals(lname)) {
			reg.loginDetails();
		}
		
		
		scanner.close();
	}

}
