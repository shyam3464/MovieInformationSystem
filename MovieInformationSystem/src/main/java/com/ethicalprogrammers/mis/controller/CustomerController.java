/**
 * @author praveen
 */
package com.ethicalprogrammers.mis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ethicalprogrammers.mis.model.Movie;
import com.ethicalprogrammers.mis.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/searchDetails.do", method = RequestMethod.POST)
	
	public ModelAndView seacrhMovieDetails(@ModelAttribute("obj") Movie obj,
			BindingResult result) {
		
		ModelAndView mav = new ModelAndView("searchDisplay");
		List<Movie> movieList =  new ArrayList<Movie>();
		
		if (!result.hasErrors()) {
			
			movieList = customerService.searchMovie(obj);
						
			if(movieList.size() > 0){
				
//				mav.setViewName("searchScreen");
				mav.addObject("movieList", movieList);	
				mav.addObject("errMsg", "");
				
			} else {
				mav.setViewName("searchScreen");
				mav.addObject("errMsg", "No movies found with this data.");
			}
		} else {
			// entered data is invalid
		}
		
		return mav;
	}
	
	/*@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }*/
}
