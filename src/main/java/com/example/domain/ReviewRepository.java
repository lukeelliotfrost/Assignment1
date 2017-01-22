package com.example.domain;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Luke Frost on 23/12/2016.
 */
/* Handles the database data that is retrived from the website using the CRUD operations
-------------------------------------------------- */
 public interface ReviewRepository extends CrudRepository<Review, Long> {
 }
