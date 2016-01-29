/*
Omar Portillo 

Java code to print out 
the calender of any year


*/
import java.util. *;
public class Cal
{
	public static void main(String[] args)
	{	
		Scanner kb = new Scanner(System.in);
		int days = 0;
		System.out.print("Enter in any year: ");
		int year = kb.nextInt();
		JulianDate JD = new JulianDate(); 
		int date = JD.toJulian(year,1,1); 
		int dayOfWeek = (date+1)%7; // 0 means Sunday, 1 means Monday, etc. 
		
 	
		
		for(int month = 1; month <=12; month++)
		{
			
			String monthString="";
			switch (month){
			case 1: monthString = "January"; days = 31;

				break;
			case 2 : monthString = "February"; 
				if(year%100 == 0)
					if(year%400 ==0)
					{
						days = 29;
					}else days = 28;
					
					if (year%4 == 0)
					days = 29;
					else days = 28;
				
				break;
			case 3: monthString   = "March"; days = 31;
				break;
			case 4 : monthString  = "April"; days = 30;
				break;
			case 5 : monthString  = "May"; days = 31;
				break;
			case 6 : monthString  = "June"; days = 30;
				break;
			case 7 : monthString  = "July"; days = 31;
				break;
			case 8:  monthString  = "August"; days = 31;
				break;
			case 9 : monthString  = "September"; days = 30;
				break;
			case 10 : monthString = "October"; days = 31;
				break;
			case 11 : monthString = "Novemeber"; days = 30;
				break;
			case 12 : monthString = "Decemeber"; days = 31;
				break;
			}
			System.out.printf("%" + (monthString.length()/2 + 11) + "s\n", monthString);
			System.out.println();
			System.out.println(" S  M Tu  W Th  F  S");
			if(dayOfWeek > 0)
			{
			System.out.printf("%" + (dayOfWeek *3) + "c", ' ');
			
			}
			
			int d = 1;
			while (d <= days)
			{
				System.out.printf("%3d", d);
				d++;
				dayOfWeek++;
				if(dayOfWeek == 7)
				{
				 dayOfWeek = 0;
				 System.out.println();
				}
			}
			System.out.println();
		}
	
	}
}