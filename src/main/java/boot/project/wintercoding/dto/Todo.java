package boot.project.wintercoding.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Todo {
	private static String DEADLINE_PATTERN = "yyyy-MM-dd";
	private static String EMPTY_STRING = "";
	private int id;
	private String title;
	private String content;
	private LocalDate deadline;
	private String complete;
	private int priority;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDate getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		if(deadline.equals(Todo.EMPTY_STRING)) {
			this.deadline = null;
		}else {
			this.deadline = LocalDate.parse(deadline, DateTimeFormatter.ofPattern(Todo.DEADLINE_PATTERN));
		}
	}
	public String getComplete() {
		return complete;
	}
	public void setComplete(String complete) {
		this.complete = complete;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
}
