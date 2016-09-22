package xtqh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import xtqh.base.BaseController;
import xtqh.base.paginate.Pagination;
import xtqh.business.BResourceService;
import xtqh.business.bean.BResource;
import xtqh.business.exception.BusinessException;
import xtqh.controller.exception.PortalException;

@Controller
@RequestMapping("/resourceController")
public class ResourceController extends BaseController {

	@Autowired
	private BResourceService bResourceService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView fetchResourceList(HttpServletRequest request, HttpServletResponse response, Model model,
			ModelAndView modelAndView) throws PortalException {

		try {
			this.getParameterFromRequest("key");

			List<BResource> resourceList = bResourceService.getResourceList();
			

		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.handleException(e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.handleException(e);
		}
		modelAndView.setViewName("forward:/pages/resource/resourceList.jsp");

		return modelAndView;
	}

	@RequestMapping("/resourceList")
	@ResponseBody
	public Pagination<BResource> lparListContr(HttpServletRequest request, HttpServletResponse response, Model model,
			ModelAndView modelAndView) {
		Pagination<BResource> pagination = null;
		String key = this.getParameterFromRequest("key");

		return pagination;
	}
}
