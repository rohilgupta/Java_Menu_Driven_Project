package utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import tester.Publication;

public class PublicationsUtils {

	public static List<Publication> populate()
	{
		List<Publication> pubList = new ArrayList<>();
		pubList.add(new Publication("Book",101,"SunRise", 100,LocalDate.parse("2022-10-12"),7));
		pubList.add(new Publication("Book",102,"RiseKing", 150,LocalDate.parse("2022-11-10"),5));
		pubList.add(new Publication("Book",103,"Arjun", 300,LocalDate.parse("2021-10-12"),4));
		pubList.add(new Publication("Book",104,"Bhaubali", 50,LocalDate.parse("2022-05-12"),8));
		pubList.add(new Publication("Book",105,"Jailer", 120,LocalDate.parse("2022-04-22"),7));
		pubList.add(new Publication("Book",106,"Jawan", 80,LocalDate.parse("2017-10-12"),2));
		pubList.add(new Publication("Tape",107,"Galaxy", 100,LocalDate.parse("2017-11-22"),3));
		pubList.add(new Publication("Tape",108,"Interseller", 150,LocalDate.parse("2022-10-12"),4));
		pubList.add(new Publication("Tape",109,"Dark", 140,LocalDate.parse("2021-09-12"),8));
		pubList.add(new Publication("Tape",110,"MoneyHiest", 250,LocalDate.parse("2019-10-12"),7));
		pubList.add(new Publication("Tape",111,"Zebra", 280,LocalDate.parse("2020-12-12"),9));
		pubList.add(new Publication("Tape",112,"Despacito", 400,LocalDate.parse("2022-04-12"),6));
		
		return pubList;
	}
}
