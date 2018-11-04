package boot.project.wintercoding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import boot.project.wintercoding.constant.TodoConstant;
import boot.project.wintercoding.entity.Todo;
import boot.project.wintercoding.service.TodoService;

@Controller
public class TodoController {
	@Autowired
	private TodoService todoService;
	
	@GetMapping("/")
	public String root() {
		return TodoConstant.REDIRECT_LIST_DEADLINE_URL.getValue();
	}
	
	@GetMapping("add")
	public String add() {
		return TodoConstant.FORM_JSP.getValue();
	}
	
	@PostMapping("add")
	public String add(Todo todo) {
		todoService.save(todo);
		return TodoConstant.REDIRECT_ROOT_URL.getValue();
	}
	
	@GetMapping("list/deadline")
	public String listByDeadline(Model model) {
		model.addAttribute(TodoConstant.MODEL_LIST_NAME.getValue(), todoService.getAllOrderByDeadline());
		return TodoConstant.LIST_JSP.getValue();
	}
	
	@GetMapping("list/priority")
	public String listByPriority(Model model) {
		model.addAttribute(TodoConstant.MODEL_LIST_NAME.getValue(), todoService.getAllOrderByPriority());
		return TodoConstant.LIST_JSP.getValue();
	}
	
	@GetMapping("set/{id}")
	public String set(Model model, @PathVariable("id") int id) {
		model.addAttribute(TodoConstant.MODEL_TODO_NAME.getValue(), todoService.getById(id));
		return TodoConstant.FORM_JSP.getValue();
	}
	
	@PostMapping("set/{id}")
	public String set(Todo todo, @PathVariable("id") int id) {
		todo.setId(id);
		todoService.save(todo);
		return TodoConstant.REDIRECT_ROOT_URL.getValue();
	}
	
	@PostMapping("remove")
	@ResponseBody
	public void remove(int id) {
		todoService.removeById(id);
	}
}
