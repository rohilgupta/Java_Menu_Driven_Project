package utils;

import java.time.LocalDate;
import java.util.*;

import enums.Status;
import tester.TaskManager;

public class PopulateMap {
	public static Map<Integer, TaskManager> populate() {

		Map<Integer,TaskManager> tasks = new HashMap<>();
		tasks.put(101, new TaskManager(101, "Drinking Water", "2 ltr Of Water",LocalDate.parse("2024-10-25"),Status.COMPLETED, true));
		tasks.put(102, new TaskManager(102, "DSA", "2 code",LocalDate.parse("2023-11-28"),Status.PENDING, true));
		tasks.put(103, new TaskManager(103, "Picnic", "Family Picnic",LocalDate.parse("2024-01-25"),Status.PENDING, true));
		tasks.put(104, new TaskManager(104, "Movie", "Jhon Wick 5",LocalDate.parse("2025-10-25"),Status.PENDING, true));
		tasks.put(105, new TaskManager(105, "Ganga Darshan", "Hariduar",LocalDate.parse("2024-11-11"),Status.PENDING, true));
		tasks.put(106, new TaskManager(106, "USA", "MS in CSE",LocalDate.parse("2030-10-01"),Status.PENDING, true));
		tasks.put(107, new TaskManager(107, "Core Java", "Complete Core Java",LocalDate.parse("2023-11-25"),Status.IN_PROGRESS, true));
		tasks.put(108, new TaskManager(108, "WPT", "Complete the WPT",LocalDate.parse("2023-12-15"),Status.IN_PROGRESS, true));
		tasks.put(109, new TaskManager(109, "Aptitude", "Practice",LocalDate.parse("2024-01-25"),Status.IN_PROGRESS, true));
		tasks.put(110, new TaskManager(110, "Runnig", "2km in morning",LocalDate.parse("2024-11-15"),Status.COMPLETED, true));

		return tasks;

	}
}
