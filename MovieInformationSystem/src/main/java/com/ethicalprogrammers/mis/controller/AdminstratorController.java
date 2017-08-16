/**
 * @author praveen
 * 
 */

package com.ethicalprogrammers.mis.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ethicalprogrammers.mis.model.Movie;
import com.ethicalprogrammers.mis.service.AdministratorService;

@Controller
public class AdminstratorController {

	@Autowired
	AdministratorService administratorService;

	@RequestMapping(value = "/insertDetails.do", method = RequestMethod.POST)
	public ModelAndView insertMovieDetails(@ModelAttribute("obj") Movie obj,
			BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (!result.hasErrors() && obj.getGenre() != null) {
			boolean addStatus = administratorService.addMovie(obj);
			if(addStatus){
				mav.setViewName("infoScreen");
				mav.addObject("successMsg", "Movie information created successfully");
			} else {
				mav.setViewName("infoScreen");
				mav.addObject("errMsg", "Movie Already present in the database.");
			}
		} else {
			mav.setViewName("infoScreen");
			mav.addObject("errMsg", "Genre  is not selected please select genre.");
		}
		return mav;
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

}
