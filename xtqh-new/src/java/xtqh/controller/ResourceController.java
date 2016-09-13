package xtqh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import xtqh.business.ResourceService;
import xtqh.business.bean.BResource;

@Controller
@RequestMapping("/resourceManager/resource")
public class ResourceController {

	@Autowired
	private ResourceService resourceService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String fetchResourceList(HttpServletRequest request, HttpServletResponse response, Model model,
			ModelAndView modelAndView) {

		List<BResource> resourceList = resourceService.getResourceList();

		return "ProcessInstanceList";
	}
}
