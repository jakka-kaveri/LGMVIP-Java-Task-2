package com.searchapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SearchController {
	
	@RequestMapping("/home")
	public String home()
	{
		System.out.println("in home handler");
		return "search";
	}
	
	@RequestMapping("/search")
	public RedirectView search(@RequestParam("querybox") String query,Model model)
	{
		RedirectView redirectView = new RedirectView();
		if(query.isBlank())
		{
			redirectView.setUrl("blank");
			return redirectView;
		}
		
		String url="https://www.google.com/search?q="+query;
		redirectView.setUrl(url);
		return redirectView;
	}
	
	@RequestMapping("/blank")
	public String blank()
	{
		return "blank";
	}

}
