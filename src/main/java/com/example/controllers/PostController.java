package com.example.controllers;

import com.example.domain.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ReviewRepository repository;

    @RequestMapping(value="", method= RequestMethod.GET)
    public String listReviews(Model model) {
        model.addAttribute("reviews", repository.findAll());
        return "posts/list";
    }
}
