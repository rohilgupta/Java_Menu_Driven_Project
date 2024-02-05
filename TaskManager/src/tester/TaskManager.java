package tester;

import java.time.LocalDate;

import enums.Status;

public class TaskManager {

	private int taskId =1;
	private String taskName;
	private String taskDiscription;
	private LocalDate taskDate;
	private Status taskStatus;
	private Boolean active;

	public TaskManager(int taskId, String taskName, String taskDiscription, LocalDate taskDate, Status taskStatus,
			Boolean active) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDiscription = taskDiscription;
		this.taskDate = taskDate;
		this.taskStatus = taskStatus;
		this.active = active;
	}

	public  int getTaskId() {
		return taskId;
	}

	public LocalDate getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(LocalDate taskDate) {
		this.taskDate = taskDate;
	}

	public Status getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(Status taskStatus) {
		this.taskStatus = taskStatus;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Task [Task Id = "+taskId+", Name=" + taskName + ", Discription=" + taskDiscription + ", Date=" + taskDate
				+ ", Status=" + taskStatus + ", active=" + active + "]";
	}
	public int hashCode​()
	{
		return this.taskId;
	}
	
    
}
