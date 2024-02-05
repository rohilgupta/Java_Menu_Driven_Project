package comparators;

import java.util.Comparator;

import tester.Pen;

public class PenComparator implements Comparator<Pen> {

	@Override
	public int compare(Pen o1, Pen o2) {
		int value = o1.getBrand().compareTo(o2.getBrand());
		if(value == 0)
		{
			return o1.getColor().compareTo(o2.getColor());
		}
		return value;
	}

}
