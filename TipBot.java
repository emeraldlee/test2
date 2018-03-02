	//Emerald Lee
	//Assignment 1

import java.text.NumberFormat;
import java.util.Scanner;

	public class TipBot {

		public static void main(String[] args) {
			double subtotal = 0;
			String stateAbb = null;
			double tax = 0;
			int rating = 0;
			double Tip = 0;
			double total = 0;
			
			//imported to get the total output to be in a currency format//
			NumberFormat formatter = NumberFormat.getCurrencyInstance();
			
			Scanner kb=new Scanner(System.in);
			
			System.out.print("Hi I am a Tip Bot! ");
			System.out.println("What was your subtotal?");
				subtotal = kb.nextDouble(); 
			System.out.println("What is the two letter state abbreviation of where you are?");
				stateAbb = kb.next(); 
				//If the user input was an invalid state abbreviation, the bot will run until a valid state is inputted//
				while(TipBot.getTax(stateAbb.toUpperCase())==1)
				{
					System.out.println("That was not a valid state abbreviation. Please enter another one: ");
					stateAbb = kb.next();
				}
				tax = subtotal*TipBot.getTax(stateAbb.toUpperCase()); //Gets the tax value and prevents issue with case sensitivity by using the toUpperCase() method
			
			System.out.println("Please rate your waiter/waitress on a scale of 1 to 10. \nWith 1 being the worst, 5 being average, and 10 being amazing (30% tip): ");
				rating = kb.nextInt(); 
				
			
			//Prints out the tax, tip, and overall total//
			System.out.println("The tax is " + formatter.format(tax));
			Tip = TipBot.getTip(rating)*subtotal;
			System.out.println("The tip is " + TipBot.getTip(rating)*100 +"%"); 
			total = tax + subtotal + Tip;
			System.out.println("Your overall total is " + formatter.format(total));
		}
		
		public static double getTip(int b)
		{
			double tip = 0;
			for(int i=0;i<10;i++)
			{
				if(b==1)
					tip=0;
				else if(b==2)
					tip=.05;
				else if(b==3)
					tip=.08;
				else if(b==4)
					tip=.1;
				else if(b==5)
					tip=.15;
				else if(b==6)
					tip=.2;
				else if(b==7)
					tip=.23;
				else if(b==8)
					tip=.25;
				else if(b==9)
					tip=.28;
				else tip=.3;
			}
			return (tip);
		}
		
		//Method getTax takes the user's input of where they are, and uses that to get the respective state tax value
		public static double getTax(String a)
		{
			double stateTax = 0;
			for(int i=0;i<50;i++)
			{
				if(a.equals("AL")) 
					stateTax = .0891;
				else if(a.equals("AK"))
					stateTax = .0176;
				else if(a.equals("AZ"))
					stateTax = .0817;
				else if(a.equals("AR"))
					stateTax = .0926;
				else if(a.equals("CA"))
					stateTax = .0844;
				else if(a.equals("CO"))
					stateTax = .0744;
				else if(a.equals("CT"))
					stateTax = .0625;
				else if(a.equals("DE"))
					stateTax = 0;
				else if(a.equals("FL"))
					stateTax = .0665;
				else if(a.equals("GA"))
					stateTax = .0696;
				else if(a.equals("HI"))
					stateTax = .0435;
				else if(a.equals("ID"))
					stateTax = .0601;
				else if(a.equals("IL"))
					stateTax = .0819;
				else if(a.equals("IN"))
					stateTax = .07;
				else if(a.equals("IA"))
					stateTax = .0678;
				else if(a.equals("KS"))
					stateTax = .082;
				else if(a.equals("KY"))
					stateTax = .06;
				else if(a.equals("LA"))
					stateTax = .0891;
				else if(a.equals("ME"))
					stateTax = .055;
				else if(a.equals("MD"))
					stateTax = .06;
				else if(a.equals("MA"))
					stateTax = .0625;
				else if(a.equals("MI"))
					stateTax = .06;
				else if(a.equals("MN"))
					stateTax = .0721;
				else if(a.equals("MS"))
					stateTax = .0707;
				else if(a.equals("MO"))
					stateTax = .0781;
				else if(a.equals("MT"))
					stateTax = 0;
				else if(a.equals("NE"))
					stateTax = .068;
				else if(a.equals("NV"))
					stateTax = .0794;
				else if(a.equals("NH"))
					stateTax = 0;
				else if(a.equals("NJ"))
					stateTax = .0697;
				else if(a.equals("NM"))
					stateTax = .0735;
				else if(a.equals("NY"))
					stateTax = .0848;
				else if(a.equals("NC"))
					stateTax = .069;
				else if(a.equals("ND"))
					stateTax = .0656;
				else if(a.equals("OH"))
					stateTax = .071;
				else if(a.equals("OK"))
					stateTax = .0877;
				else if(a.equals("OR"))
					stateTax = 0;
				else if(a.equals("PA"))
					stateTax = .0634;
				else if(a.equals("RI"))
					stateTax = .07;
				else if(a.equals("SC"))
					stateTax = .0713;
				else if(a.equals("SD"))
					stateTax = .0583;
				else if(a.equals("TN"))
					stateTax = .0945;
				else if(a.equals("TX"))
					stateTax = .0805;
				else if(a.equals("UT"))
					stateTax = .0668;
				else if(a.equals("VT"))
					stateTax = .0614;
				else if(a.equals("VA"))
					stateTax = .0563;
				else if(a.equals("WA"))
					stateTax = .0889;
				else if(a.equals("WV"))
					stateTax = .0607;
				else if(a.equals("WI"))
					stateTax = .0543;
				else if(a.equals("WY"))
					stateTax = .0547;		
				else stateTax = 1;
			}
			return stateTax;
		}
	}
