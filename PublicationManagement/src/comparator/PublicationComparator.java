package comparator;

import java.util.Comparator;

import tester.Publication;

public class PublicationComparator implements Comparator<Publication> {

	public int compare(Publication o1,Publication o2)
	{
		int val = o1.getDate().compareTo(o2.getDate());
		if(val == -1)
		{
			return 1;
		}
		else if(val == 1)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
}
