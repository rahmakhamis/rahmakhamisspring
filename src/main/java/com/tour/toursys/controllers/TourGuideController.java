package com.tour.toursys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tour.toursys.models.TourGuide;
import com.tour.toursys.repositories.TourGuideRepository;

@RestController
public class TourGuideController{
    @Autowired
    private TourGuideRepository repository;

    @GetMapping("/customer")
    public List<TourGuide> getAll(){
        return repository.findAll();
    }
