
package comparator;

import java.util.Comparator;

import tester.Publication;

public class PublicationRateComparator implements Comparator<Publication> {

	@Override
	public int compare(Publication o1, Publication o2) {
		Integer obj1 =o1.getRate();
		Integer obj2 = o2.getRate();
		int val = obj1.compareTo(obj2);
		return val;
	}

}
