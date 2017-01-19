package com.example.controllers;

import com.example.domain.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Luke Frost on 23/12/2016.
 */
@Controller
@RequestMapping("/reviews")
public class PostController {

    @Autowired
    private ReviewRepository repository;

    @RequestMapping(value="", method= RequestMethod.GET)
    public String listReviews(Model model) {
        model.addAttribute("reviews", repository.findAll());
        return "reviews/list";
    }

    @RequestMapping(value="/{id}/delete", method=RequestMethod.GET)
    public ModelAndView delete(@PathVariable long id){
        repository.delete(id);
        return new ModelAndView("redirect:/posts");
    }

    




}
