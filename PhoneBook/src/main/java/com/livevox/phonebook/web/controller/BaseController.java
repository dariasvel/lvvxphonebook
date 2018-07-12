package com.livevox.phonebook.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Base controller for home page (index.jsp)
 *
 */
@Controller
public class BaseController {
	private static final String INDEX = "index";

	/**
	 * @return index page name
	 */
	@GetMapping(value="/")
    public String homepage(){
        return INDEX;
    }
}
