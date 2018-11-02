package boot.project.wintercoding.controller;

public enum TodoConstant {
	REDIRECT_ROOT_URL("redirect:/"), REDIRECT_LIST_DEADLINE_URL("redirect:/list/deadline"),
	LIST_JSP("list"), FORM_JSP("form"),
	MODEL_LIST_NAME("todo_list"), MODEL_TODO_NAME("todo");
	
	private final String value;
	
	private TodoConstant(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
