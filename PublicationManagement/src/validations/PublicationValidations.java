package validations;

import java.time.LocalDate;
import java.util.List;

import tester.Publication;

public class PublicationValidations {
   public static int checkDupId(int id,List<Publication>pub)throws PublicationExceptions
   {
	   Publication nId = new Publication(id);
	   if(pub.contains(nId))
	   {
		   throw new PublicationExceptions("Duplicate Id");
	   }
	   return id;
   }
   public static String checkDupTitle(String title,List<Publication>pub)throws PublicationExceptions
   {
//	   Publication nTitle = new Publication(title);
	   if(pub.contains(title))
	   {
		   throw new PublicationExceptions("Duplicate Title");
	   }
	   return title;
   }
   public static int checkRating(int rate)throws PublicationExceptions
   {
	   if(rate > 1 && rate <= 10)
	   {
		   return rate;
	   }
	   throw new PublicationExceptions("Invalid Rating");
   }
   public static Publication validateAllInput(String type,int id, String title, double price, String date, int rate,List<Publication>pub) throws PublicationExceptions
   {
	   int nId = checkDupId(id ,pub);
	   String nTitle = checkDupTitle(title, pub);
	   LocalDate nDate = LocalDate.parse(date);
	   int nRate = checkRating(rate);
	   return new Publication(type,nId, nTitle, price, nDate, rate);
   }
}
