/**
 * @author praveen
 * 
 */
package com.ethicalprogrammers.mis.controller;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ethicalprogrammers.mis.model.User;
import com.ethicalprogrammers.mis.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "customerLogin.do", method = RequestMethod.POST)
	public ModelAndView doCustomerLogin(@ModelAttribute("obj") User obj,
			BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (!result.hasErrors()) {
			User userStatus = userService.checkUser(obj);
			if (null != userStatus
					&& "customer".equalsIgnoreCase(userStatus.getUserType())) {
				mav.setViewName("searchScreen");
			} else {
				// incorrect password; ask for reset
				mav.setViewName("customerLogin");
				mav.addObject("errMsg", "Incorrect User Name / Password");
			}
		} else {
			// entered data is invalid
		}
		return mav;
	}

	@RequestMapping(value = "adminLogin.do", method = RequestMethod.POST)
	public ModelAndView doAdminLogin(@ModelAttribute("obj") User obj,
			BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (!result.hasErrors()) {
			User userStatus = userService.checkUser(obj);
			if (null != userStatus
					&& "admin".equalsIgnoreCase(userStatus.getUserType())) {
				mav.setViewName("infoScreen");
			} else {
				// incorrect password; ask for reset
				mav.setViewName("adminLogin");
				mav.addObject("errMsg", "Incorrect User Name / Password");
			}
		} else {
			// entered data is invalid
		}
		return mav;
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(@ModelAttribute("obj") User obj,
			BindingResult result) {
		ModelAndView mav = new ModelAndView();

		// incorrect password; ask for reset
		mav.setViewName("home");

		return mav;
	}


	@RequestMapping(value = "signup.do", method = RequestMethod.POST)
	public ModelAndView doSignup(@ModelAttribute("obj") User obj,
			BindingResult result) throws JAXBException {
		ModelAndView mav = new ModelAndView();
		if (!result.hasErrors()) {
			boolean signUpSuccess = userService.createUser(obj);
			if (signUpSuccess) {
				mav.setViewName("customerLogin");
				mav.addObject("successMsg",
						"User created successfully please enter the credentials to login.");
			} else {
				mav.setViewName("customerLogin");
				mav.addObject("errMsg",
						"User already exists with this information.");
			}
		} else {

		}

		return mav;
	}
}
