package utils;
import java.util.Comparator;
import java.util.List;

import tester.TaskManager;

public class TMComparator implements Comparator<TaskManager> {

	@Override
	public int compare(TaskManager o1, TaskManager o2) {
		int value = (o1.getTaskDate()).compareTo(o2.getTaskDate());
		
		return value;
	}

	

}
