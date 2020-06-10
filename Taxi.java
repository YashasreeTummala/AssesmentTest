package logic;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Taxi
{
	public void select() throws Exception
	{
		//Provide the details of type of taxi & Kms travelled.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Choose Type of Car: \n1.Mini \n2.Sedan \n3.SUV \n");
		int choice = Integer.parseInt(reader.readLine());

		System.out.println("Enter the Distance travelled: \n");
		int distance = Integer.parseInt(reader.readLine());

		String type = "";
		try 
		{
			switch(choice)
			{
				case 1: type = "Mini";
						calculate(choice, type, distance);
						break;
				case 2: type = "Sedan";
						calculate(choice, type, distance);
						break;
				case 3: type = "SUV";
						calculate(choice, type, distance);
						break;
				default: System.out.println("\nChoose among 1|2|3");
						select();
			}
		}
		catch(Exception e)
		{
			System.out.println("\nPlease enter only Digits.. Choose among 1|2|3\n");
			select();
		}
	}
	
	public void calculate(int choice, String type, int distance) throws Exception, IOException
	{
		int finalCost = 0;
		//Mini Taxi
		if(choice == 1 && distance <75)
		{
			if(distance > 3)
			{
				int tempDistance = distance -3;
				finalCost = 50;				
				finalCost += tempDistance *10;   
				System.out.println("Final Price for " +type+" to be paid is: " + finalCost + "\n");
				select();
			}
		}
		
		if(choice == 1 && distance > 75)
		{
			finalCost = distance * 8;
			System.out.println("Final Price for " +type+" to be paid is: " + finalCost + "\n");
			select();
		}
		
		//Sedan
		if(choice == 2 && distance <100)
		{
			if(distance > 5)
			{
				int tempDistance = distance -5;
				finalCost = 80;
				finalCost += tempDistance *12;
				System.out.println("Final Price for " +type+" to be paid is: " + finalCost + "\n");
				select();
			}
		}
		
		if (choice ==2 && distance > 100)
		{
			finalCost = distance * 10;
			System.out.println("Final Price for " +type+" to be paid is: " + finalCost + "\n");
			select();
		}
		
		//SUV
		if(choice == 3 && distance <100)
		{
			if(distance < 5) 
				System.out.println("Final Price for " +type+" to be paid is: " + finalCost*distance + "\n");
			else if(distance > 5)
			{
				int tempDistance = distance -5;
				finalCost = 100;
				finalCost += tempDistance *15;
				System.out.println("Final Price for " +type+" to be paid is: " + finalCost + "\n");
				select();
			}
		}
		
		if (choice == 3 && distance >100)
		{
			System.out.println("\nSorry Not Available\n");
			select();
		}
	}
}

public class Taxi
{	
	public static void main(String[] args) throws Exception
	{
		//Anonymous object call to select() of Taxi class to calculate the fare
		new TaxiFare().select();
	}
}


