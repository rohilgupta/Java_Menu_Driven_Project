package validations;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import enums.PenColor;
import enums.PenEnum;
import tester.Pen;



public class PenValidationRule {

	public static int checkDup(int id,List<Pen> pensList)throws PensException
	{
		Pen newId = new Pen(id);
		if(pensList.contains(newId))
			throw new PensException ("Duplicate Pen Id");
		return id;
	}
	public static PenEnum checkBrand(String brand) throws IllegalArgumentException
	{
		return PenEnum.valueOf(brand.toUpperCase());
	}
	public static PenColor checkColor(String color) throws IllegalArgumentException
	{
		return PenColor.valueOf(color.toUpperCase());
	}
	public static LocalDate checkDate(String date)throws PensException,DateTimeParseException
	{
		LocalDate newDate = LocalDate.parse(date);
		LocalDate fixedDate = LocalDate.of(2020,01,01);
		if(newDate.isBefore(fixedDate))
			throw new PensException("Invalid Manufaturing Date");
		return newDate;
	}
	public static Pen validateAllInput(int id, String brand, String color, String date, double price,List<Pen> pens)
			throws PensException, IllegalArgumentException, DateTimeParseException
	{
		checkDup(id,pens);
		PenEnum brands= checkBrand(brand);
		PenColor colors = checkColor(color);
		LocalDate dates = checkDate(date);
		return new Pen(id, brands, colors, dates, price);
	}
}
