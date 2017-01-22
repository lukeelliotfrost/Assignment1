package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Luke Frost on 23/12/2016.
 */
 @Entity
 /* Defines the Reviews on the site and their features i.e. ID and Message
-------------------------------------------------- */
 public class Review {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private long id;
     private String review;

     public Review(){
     }

     public Review(String message){
         this.review = message;
     }

     public long getId() {
         return id;
     }

     public String getReview() {
         return review;
     }

     public void setReview(String message) {
         this.review = message;
     }
 }
