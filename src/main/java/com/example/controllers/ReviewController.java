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
 /* Controller class that handles the CRUD operations
-------------------------------------------------- */
 public class ReviewController {

     @Autowired
     private ReviewRepository repository;


    /* Shows the list of reviews on the site from the repository
-------------------------------------------------- */
     @RequestMapping(value="", method=RequestMethod.GET)
     public String listReviews(Model model) {
         model.addAttribute("reviews", repository.findAll());
         return "reviews/list";
     }

    /* Uses the ID selected to delete the Review from the repository
-------------------------------------------------- */
     @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
     public ModelAndView delete(@PathVariable long id) {
         repository.delete(id);
         return new ModelAndView("redirect:/reviews");
     }

    /* Direct to new.html to create a new review
-------------------------------------------------- */
     @RequestMapping(value="/new", method = RequestMethod.GET)
     public String newProject() {
         return "reviews/new";
     }

    /* Saves the Review created in the repository
-------------------------------------------------- */
     @RequestMapping(value = "/create", method = RequestMethod.POST)
     public ModelAndView create(@RequestParam("message") String comment) {
         repository.save(new Review(comment));
         return new ModelAndView("redirect:/reviews");
     }

    /* Uses the Review selected to update by updating the message and saving it in the repository
-------------------------------------------------- */
     @RequestMapping(value = "/update", method = RequestMethod.POST)
     public ModelAndView update(@RequestParam("review_id") long id,
                                @RequestParam("message") String message) {
         Review review = repository.findOne(id);
         review.setReview(message);
         repository.save(review);
         return new ModelAndView("redirect:/reviews");
     }

    /* Edit the Review by finding the selected review in the repository via the ID and displaying it on th edit.html page
-------------------------------------------------- */
     @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
     public String edit(@PathVariable long id,
                        Model model) {
         Review review = repository.findOne(id);
         model.addAttribute("review", review);
         return "reviews/edit";
     }


 }
