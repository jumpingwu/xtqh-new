package xtqh.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import daniel.springmvc.execution.model.ProcessInstance;

@Controller
@RequestMapping("/resourceManager/resource")
public class ResourceController {

	@RequestMapping("/List")
	public String showProcessInstanceList(Model model) {
		return "ProcessInstanceList";
	}
}
