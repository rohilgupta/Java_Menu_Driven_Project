package utils;

import java.time.LocalDate;
//import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import enums.*;
import tester.Pen;
import validations.PensException;
public class PensUtils {

	public static Pen findPen(int id,List<Pen>Pens)throws PensException 
	{
		Pen newId = new Pen(id);
		int index = Pens.indexOf(newId);
		if(index == -1)
		{
			throw new PensException("You Have Entered Invalid PenID ");
		}
		else
		{
			return Pens.get(index) ;
		}
		
	}
	public static List<Pen> populate()
	{
		List<Pen> pens = new ArrayList<>();
		pens.add(new Pen(103,PenEnum.CLASSMATE,PenColor.BLACK,LocalDate.parse("2022-12-01"),50));
		pens.add(new Pen(101,PenEnum.PARKER,PenColor.RED,LocalDate.parse("2020-12-01"),50));
		pens.add(new Pen(105,PenEnum.PARKER,PenColor.BLUE,LocalDate.parse("2020-11-01"),50));
		pens.add(new Pen(108,PenEnum.REYNOLD,PenColor.BLACK,LocalDate.parse("2022-10-30"),50));
		pens.add(new Pen(102,PenEnum.NATRAJ,PenColor.BLUE,LocalDate.parse("2021-12-01"),100));
		pens.add(new Pen(106,PenEnum.NATRAJ,PenColor.GREEN,LocalDate.parse("2021-12-01"),50));
		pens.add(new Pen(104,PenEnum.REYNOLD,PenColor.GREEN,LocalDate.parse("2022-10-01"),50));
		pens.add(new Pen(107,PenEnum.CLASSMATE,PenColor.RED,LocalDate.parse("2019-12-01"),50));
		return pens;
	}
}
