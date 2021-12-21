package swep.haushaltsplaner;

public class Task {
	
	private String taskLabel;
	private String taskDescription;
		
	Task(String taskLabel, String taskDescription){
		this.taskLabel = taskLabel;
		this.taskDescription = taskDescription;
	}
	
	public String getTaskLabel() {
		return taskLabel;
	}
	
	public String getTaskDescription() {
		return taskDescription;
	}
	
}
