package boot.project.wintercoding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import boot.project.wintercoding.service.TestService;

@Controller
public class TestController {
	@Autowired
	private TestService testService;
	
	@RequestMapping("/test")
	public String test() {
		System.out.println("test controller");
		return "test";
	}
	
	@RequestMapping("test2")
	public String test2(Model model) {
		model.addAttribute("list", testService.getAll());
		return "test2";
	}
}
