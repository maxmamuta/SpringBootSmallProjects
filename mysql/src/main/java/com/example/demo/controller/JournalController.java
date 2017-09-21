package com.example.demo.controller;

import com.example.demo.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by maxmamuta on 9/16/17.
 */
@RestController
public class JournalController {

    private static final String VIEW_INDEX = "index";
    private static final String VIEW_LOGIN = "login";

    @Autowired
    JournalRepository repo;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName(VIEW_INDEX);
        modelAndView.addObject("journal", repo.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName(VIEW_LOGIN);
        return modelAndView;
    }
}
