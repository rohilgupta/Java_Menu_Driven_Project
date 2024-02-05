package tester;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

import comparators.PenComparator;
import utils.PensUtils;
import validations.PenValidationRule;
import validations.PensException;
public class PenShopTester {
public static void main(String[]args)
{
	try(Scanner sc = new Scanner(System.in))
	{
		List<Pen> penList = new ArrayList<>();
		boolean exit = false;
		int counter = 100;
		
		while(exit!=true)
		{
			try {
				
				LocalDate newDate = LocalDate.now();
				System.out.println("1.To ADD PEN\n2.TO Display All Pen\n3.Remove Which Are Not Sold From 1.5 year\n4.Set Discount of 20% on All Pen Which Are Not Sold For 1 year\n5.Search Pen by PenId\n6.Sort PenList by PenId\n7.Populate The PenShop\n8 Sort PenList by Brand and Color0. To Exit\nChoose Your Option:\n");
				switch(sc.nextInt())
				{
				case 1:
					System.out.println("Enter PenId ,Brand,Color,Buying Date 'yyyy-mm-dd' ,Price");
					Pen penValidated = PenValidationRule.validateAllInput(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.nextDouble(),penList);
					penList.add(penValidated);
//				counter++;
					break;
				case 2:
					for(Pen i:penList)
					{
						if(i != null)
						{
							System.out.println(i);
						}
						else
						{
							throw new PensException("No pen Added");
						}
					}					
					break;
				case 3:
//					System.out.println("Today Is "+newDate);
					Iterator<Pen> itr = penList.iterator();
					while(itr.hasNext())
					{
						Pen date = itr.next();
						Period per = Period.between((date).getDate(), newDate);
						long  month = per.toTotalMonths();
						if(month > 18)
						{
							itr.remove();
						}
					}
					//					for(Pen i:penList)
//					{
//					 if(i.getDate().isBefore(newDate))
//					  {
////						 Integer Id = i.getId();
////						 Pen pens = i.getId();
//						 int key = i.getId();
//						  boolean removed = penList.remove(i);
//						 if(removed==false)
//						{
//							throw new PensException("Invalid Pens");
//						}
//						 else {
//							 System.out.println("PenId -> "+ key +" Removed");
//						 }
//					  }
//					}
					break;
				case 4:
					newDate = LocalDate.now();
					System.out.println("Today Is "+newDate);
					for(Pen i:penList)
					{
						Period P = Period.between(i.getDate(), newDate);
						long month = P.toTotalMonths();
						if(month>12)
						{
							System.out.println("PenID -> "+i.getId()+" Discounted");
							i.setDiscountPrice(i.getPrice()-0.2*(i.getPrice()));
						}
					}
					break;
				case 5:
					System.out.println("Enter PenId");
					Pen newPen = PensUtils.findPen(sc.nextInt(), penList);
					System.out.println(newPen);
					break;
				case 6:
					System.out.println("Sorted By PenId");
				    Collections.sort(penList);
				    for(Pen i:penList)
					System.out.println(i);
					break;
				case 7:
					penList = PensUtils.populate();
					System.out.println("Populated Done");
					break;
				case 8:
					PenComparator comp = new PenComparator();
					Collections.sort(penList,comp);
					break;
				case 0:
					exit = true;
					System.out.println("Thank You");
					break;
				}
			}
			catch(Exception err)
			{
				System.out.println(err);
//				err.printStackTrace();
			}
	   }
	}//sc.close();
	finally{System.out.println("Program Ends");};
}
}

