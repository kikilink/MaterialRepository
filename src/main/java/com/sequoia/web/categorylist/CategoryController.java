package com.sequoia.web.categorylist;

import com.sequoia.service.ICategorylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("categorylist")
public class CategoryController {

	@Autowired
	private ICategorylistService categorylistService;

	@RequestMapping(value = "all", method = RequestMethod.GET)
	public String getCategoryList(ModelMap model) {

		model.addAttribute("categories",
				categorylistService.getAllCategorylist());

		return "categorylist/AllCategorylist";
	}

	@RequestMapping(value = "page", method = RequestMethod.POST)
	@ResponseBody
	public String getPageCategoryList(@RequestBody String parameters) {
		System.out.println(parameters);
		return "";
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String addCategory(@RequestBody String parameters) {
		System.out.println(parameters);
		return "";
	}
}
