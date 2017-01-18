package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Luke Frost on 23/12/2016.
 */
@Controller
@RequestMapping("/posts")
public class PostController {

    @RequestMapping(value="", method= RequestMethod.GET)
    public String listReviews(Model model) {
        
        return "posts/list";
    }
}
