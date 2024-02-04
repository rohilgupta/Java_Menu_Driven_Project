package tester;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import comparator.PublicationComparator;
import comparator.PublicationRateComparator;
import utils.PublicationsUtils;
import validations.PublicationValidations;

public class PublicationTester {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner (System.in))
		{
			List<Publication> pubList = new ArrayList<>();
			boolean exit = false;
			while(!exit)
			{
				System.out.println("1. Add Book\n2.Add Tape\n3. Sort All Publication By PublishDate\n4. List Top 5 Publication By Rating\n5. Remove All Publications 5 Years Old\n6. Display Data\n7. Populate Data\n0. Exit");
				try {
					switch(sc.nextInt())
					{
					case 1:
						System.out.println("Enter Details of Book => Id,Title,Price,Date('yyyy-mm-dd'),Rating");
						Publication book = PublicationValidations.validateAllInput("Book",sc.nextInt(), sc.next(), sc.nextDouble(), sc.next(), sc.nextInt(), pubList);
						pubList.add(book);
						break;
					case 2:
						System.out.println("Enter Details of Book => Id,Title,Price,Date('yyyy-mm-dd'),Rating");
						Publication tape = PublicationValidations.validateAllInput("Tape",sc.nextInt(), sc.next(), sc.nextDouble(), sc.next(), sc.nextInt(), pubList);
						pubList.add(tape);
						break;
					case 3:
						PublicationComparator comp = new PublicationComparator();
						Collections.sort(pubList,comp);
						break;
					case 4:
						PublicationRateComparator comp1 = new PublicationRateComparator();	
						Collections.sort(pubList,comp1);
						Iterator<Publication> itr = pubList.listIterator();
						int counter = 0;
						while(itr.hasNext())
						{
						  if(counter<5)
						  {
							  System.out.println(itr);
						  }
						  else
						  {
							  break;
						  }
						  counter++;	
						}
						break;
					case 5:
						Iterator<Publication> itr2 = pubList.listIterator();
						LocalDate date = LocalDate.now();
						while(itr2.hasNext())
						{
						  Publication nDate = itr2.next();
						  Period per = Period.between((nDate).getDate(),date);
						  long month = per.toTotalMonths();
						 if(month>60)
						 {
							 itr2.remove(); 
						 }
						}
						break;
					case 6:
						for(Publication p : pubList)
						{
							System.out.println(p);
						}
						break;
					case 7:
						pubList = PublicationsUtils.populate();
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
					sc.nextLine();

				}
			    
			}
		}

	}

}
