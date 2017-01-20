package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Luke Frost on 23/12/2016.
 */
 @Entity
 public class Review {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private long id;
     private String message;

     public Review(){
     }

     public Review(String message){
         this.message = message;
     }

     public long getId() {
         return id;
     }

     public String getMessage() {
         return message;
     }

     public void setMessage(String message) {
         this.message = message;
     }
 }
