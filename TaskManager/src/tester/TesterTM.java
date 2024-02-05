package tester;

import java.security.KeyStore.Entry;
import java.time.LocalDate;
import java.util.*;
import java.util.Map;
import java.util.Scanner;

import enums.Status;
import utils.PopulateMap;
import utils.TMComparator;
import utils.TaskManagerValidations;
import utils.TaskManagerValidations.*;
import static tester.TaskManager.*;

public class TesterTM {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			Map<Integer, TaskManager> map = new HashMap<>();

			while (exit != true) {
				try {
					System.out.println("Task Manager Menu");
					System.out.println(
							"1. Add New Task\n2. Delete The Task\n3. Update Task Status\n4. Display All Pending Tasks\n5. Display All Pending Tasks of Today\n6. Display All Task Based On Date\n7. Display All Tasks\n8. Populate The Task Manager\n0. Exit");

					System.out.println("Choose Your Option");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Status \n1. PENDING\n2. IN_PROGRESS\n3. COMPLETED");
						System.out.println(
								"Enter Details In Following Order TaskName,TaskDiscription,Date(yyyy-mm-dd),Status");
						int counter = 1;
						TaskManager tm = TaskManagerValidations.valdidateAllInput(counter++, sc.next(), sc.next(),
								sc.next(), sc.next(), true, map);
						map.put(tm.getTaskId(), tm);
						break;
					case 2:
						System.out.println("Enter Task Id which You Want Delete ");
						int key1 = sc.nextInt();
						if (map.containsKey(key1)) {
//							System.out.println(key1);
							for (TaskManager i : map.values()) {
								if (i.getTaskId() == key1) {
									i.setActive(false);
								}
							}
						} else {
							System.out.println("Invalid Task Id");
						}
						break;
					case 3:
						System.out.println("Enter Task Id of which You Want Update Status ");
						key1 = sc.nextInt();
						System.out.println("Status \n1. PENDING\n2. IN_PROGRESS\n3. COMPLETED");
						if (map.containsKey(key1)) {
//                            System.out.println(key1);
							for (TaskManager i : map.values()) {
								if (i.getTaskId() == key1) {
									System.out.println("Update Status from above given Stataus values");
									i.setTaskStatus(TaskManagerValidations.validStatus(sc.next()));
								}
							}

						} else {
							System.out.println("Invalid Task Id");
						}
						break;
					case 4:

						for (Map.Entry<Integer, TaskManager> i : map.entrySet()) {
							if (i.getValue().getTaskStatus().equals(Status.PENDING)) {
								System.out.println(i.getValue());
							}
							continue;
						}

						break;
					case 5:
						List<TaskManager> list = new ArrayList<>();
						for (Map.Entry<Integer, TaskManager> i : map.entrySet()) {
							if (i.getValue().getTaskStatus().equals(Status.PENDING)) {
								if (i.getValue().getTaskDate().equals(LocalDate.now())) {
									System.out.println(i.getValue());
									list.add(i.getValue());
								}
							}
//							continue;
						}
						if (list == null) {
							System.out.println("No Pending Task For Today");
						}
						break;
					case 6:
						List<TaskManager> list2 = new ArrayList<>();
						for (Map.Entry<Integer, TaskManager> i : map.entrySet()) {
							list2.add(i.getValue());
						}
						TMComparator comp = new TMComparator();
						Collections.sort(list2, comp);
						for(TaskManager i : list2)
						{
							System.out.println(i);
						}
						break;
					case 7:
						if (map == null) {
							System.out.println("No Value Enter");
							return;
						}
//						for(Map.Entry<Integer,TaskManager>i:map.entrySet())
//						{
//							System.out.println(i.getKey()+i.getValue());
//						}
						Collection<TaskManager> col = map.values();
						for (TaskManager i : col) {
							System.out.println(i);
						}
						break;
					case 8:
						map = PopulateMap.populate();
						break;
					case 0:
						break;
					}
				} catch (Exception err) {
					System.out.println(err);
					err.printStackTrace();
					sc.nextLine();
			}

			}

		}

	}


}
