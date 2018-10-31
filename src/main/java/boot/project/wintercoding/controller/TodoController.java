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
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String add() {
		return "form";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(Todo todo) {
		todoService.add(todo);
		return "form";
	}
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("todo_list", todoService.getAll());
		return "list";
	}
	
	@RequestMapping(value="set/{id}", method=RequestMethod.GET)
	public String set(Model model, @PathVariable("id") int id) {
		model.addAttribute("todo", todoService.getById(id));
		return "form";
	}
	
	@RequestMapping(value="set/{id}", method=RequestMethod.POST)
	public String set(Todo todo) {
		todoService.setById(todo);
		return "redirect:/list";
	}
	
	@RequestMapping(value="remove", method=RequestMethod.POST)
	@ResponseBody
	public void remove(int id) {
		todoService.removeById(id);
	}
}
