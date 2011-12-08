/**
 * Copyright (c) 2007 Regents of the University of California (Regents). Created
 * by TELS, Graduate School of Education, University of California at Berkeley.
 *
 * This software is distributed under the GNU Lesser General Public License, v2.
 *
 * Permission is hereby granted, without written agreement and without license
 * or royalty fees, to use, copy, modify, and distribute this software and its
 * documentation for any purpose, provided that the above copyright notice and
 * the following two paragraphs appear in all copies of this software.
 *
 * REGENTS SPECIFICALLY DISCLAIMS ANY WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE. THE SOFTWAREAND ACCOMPANYING DOCUMENTATION, IF ANY, PROVIDED
 * HEREUNDER IS PROVIDED "AS IS". REGENTS HAS NO OBLIGATION TO PROVIDE
 * MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS, OR MODIFICATIONS.
 *
 * IN NO EVENT SHALL REGENTS BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT,
 * SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES, INCLUDING LOST PROFITS,
 * ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
 * REGENTS HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.telscenter.sail.webapp.presentation.web.controllers.admin;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.sail.webapp.domain.User;
import net.sf.sail.webapp.service.UserService;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.telscenter.sail.webapp.domain.admin.StudentFields;
import org.telscenter.sail.webapp.domain.authentication.Gender;
import org.telscenter.sail.webapp.domain.impl.LookupParameters;

/**
 * @author patrick lawler
 *
 */
public class LookupStudentController extends SimpleFormController {

	private final static String VIEW = "admin/manageusers";
		
	private UserService userService;

	@Override
	protected Map<String, Object> referenceData(HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("fields", StudentFields.values());
		return model;
	}

	/**
     * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse, java.lang.Object,
     *      org.springframework.validation.BindException)
     */
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors){
		LookupParameters params = (LookupParameters) command;
		Object term = new Object();
		
		if(params.getLookupField().equals("GENDER")){
			term = Gender.valueOf(params.getLookupData().toUpperCase());
		} else if(params.getLookupCriteria().equals("like")){
			term = "%" + params.getLookupData() + "%";
		} else {
			term = params.getLookupData();
		}

		// if searching for ID, make the term object in a Long.
		if ("ID".equals(params.getLookupField())) {
			term = Long.parseLong(params.getLookupData());
		}

		List<User> users = this.userService.retrieveByField(params.getLookupField()
				.toLowerCase(),	params.getLookupCriteria(), term,
				"studentUserDetails");
		
		ModelAndView modelAndView = new ModelAndView(VIEW);
		// put the usernames in an array
		List<String> usernames = new ArrayList<String>();
		for (User user : users) {
			usernames.add(user.getUserDetails().getUsername());
		}
		
		if(users.size() < 1){
			modelAndView.addObject("message", "No users given search criteria found.");
		} else {
			modelAndView.addObject("students", usernames);
		}
		
		return modelAndView;
	}

	
	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
