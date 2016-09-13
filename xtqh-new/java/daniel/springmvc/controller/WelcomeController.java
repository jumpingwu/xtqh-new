package daniel.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import xtqh.execution.model.ProcessInstance;
import xtqh.execution.service.ProcessInstanceService;

@Controller
public class WelcomeController {
	
	@Autowired
	ProcessInstanceService processInstanceService;
	
	@RequestMapping("/")
	public String showWelcomePage() {
		return "redirect:/ProcessInstances/List";
	}
}
