package com.example.controllers;

import com.example.domain.Review;
import com.example.domain.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
        return new ModelAndView("redirect:/reviews");
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String newReview(){
        return "reviews/new";
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam("message") String comment){
        repository.save(new Review(comment));
        return new ModelAndView("redirect:/reviews");
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam("post_id") long id, @RequestParam("message") String message){
        Review review = repository.findOne(id);
        review.setReview(message);
        repository.save(review);
        return new ModelAndView("redirect:/reviews");
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable long id, Model model){
        Review review = repository.findOne(id);
        model.addAttribute("review", review);
        return "reviews/edit";
    }



}
