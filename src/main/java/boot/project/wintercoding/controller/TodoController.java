package boot.project.wintercoding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import boot.project.wintercoding.dto.Todo;
import boot.project.wintercoding.service.TodoService;

@Controller
public class TodoController {
	@Autowired
	private TodoService todoService;
	
	@RequestMapping("/")
	public String root() {
		return TodoConstant.REDIRECT_LIST_DEADLINE_URL.getValue();
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String add() {
		return TodoConstant.FORM_JSP.getValue();
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(Todo todo) {
		todoService.add(todo);
		return TodoConstant.REDIRECT_ROOT_URL.getValue();
	}
	
	@RequestMapping(value="list/deadline", method=RequestMethod.GET)
	public String listByDeadline(Model model) {
		model.addAttribute(TodoConstant.MODEL_LIST_NAME.getValue(), todoService.getAllOrderByDeadline());
		return TodoConstant.LIST_JSP.getValue();
	}
	
	@RequestMapping(value="list/priority", method=RequestMethod.GET)
	public String listByPriority(Model model) {
		model.addAttribute(TodoConstant.MODEL_LIST_NAME.getValue(), todoService.getAllOrderByPriority());
		return TodoConstant.LIST_JSP.getValue();
	}
	
	@RequestMapping(value="set/{id}", method=RequestMethod.GET)
	public String set(Model model, @PathVariable("id") int id) {
		model.addAttribute(TodoConstant.MODEL_TODO_NAME.getValue(), todoService.getById(id));
		return TodoConstant.FORM_JSP.getValue();
	}
	
	@RequestMapping(value="set/{id}", method=RequestMethod.POST)
	public String set(Todo todo, @PathVariable("id") int id) {
		todo.setId(id);
		todoService.setById(todo);
		return TodoConstant.REDIRECT_ROOT_URL.getValue();
	}
	
	@RequestMapping(value="remove", method=RequestMethod.POST)
	@ResponseBody
	public void remove(int id) {
		todoService.removeById(id);
	}
}
