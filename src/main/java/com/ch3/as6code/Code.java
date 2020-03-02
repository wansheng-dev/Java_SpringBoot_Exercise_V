package com.ch3.as6code;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Code {
	
	@RequestMapping("/")
	public String index() {
		return "indexCode.jsp";
	}
	
	@RequestMapping(value="/try", method=RequestMethod.POST)
	public String tryCode(@RequestParam(value="code") String code) {
		if (code.equals("bushido")) {
			return "redirect:/code";
		}
		return "redirect:/createError";
	}
	
	@RequestMapping("/code")
	public String code() {
		return "code.jsp";
	}
	
	@RequestMapping("/createError")
	public String flashMessage(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("error", "Try harder");
		return "redirect:/";
	}
}
