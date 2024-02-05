package utils;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import enums.Status;
import tester.TaskManager;

public class TaskManagerValidations {
	public static TaskManager validTaskId(int id, Map<Integer, TaskManager> hm) throws TaskManagerExceptions {
		if (id == 0 || !hm.containsKey(id)) {
			throw new TaskManagerExceptions("Invalid key");
		}
		return hm.get(id);
	}

	public static Status validStatus(String status) throws IllegalArgumentException {
		return Status.valueOf(status.toUpperCase());
	}

	private static LocalDate validDate(String date, Map<Integer, TaskManager> hm)
			throws TaskManagerExceptions, DateTimeException {
		LocalDate newDate = LocalDate.parse(date);
		if (newDate.isBefore(LocalDate.now()))
			throw new TaskManagerExceptions("Invalid Date");
		return newDate;
	}

	public static TaskManager valdidateAllInput(int taskId,String taskName, String taskDiscription, String taskDate,
			String taskStatus, Boolean active, Map<Integer, TaskManager> hm)
			throws TaskManagerExceptions, DateTimeException, IllegalArgumentException {
		LocalDate newDate = validDate(taskDate, hm);
		Status newStatus = validStatus(taskStatus);

		return new TaskManager(taskId,taskName, taskDiscription, newDate, newStatus, active);
	}
}
