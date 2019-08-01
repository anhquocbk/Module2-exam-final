package com.codegym.cms.controller;

import com.codegym.cms.model.City;
import com.codegym.cms.model.Country;
import com.codegym.cms.service.CityService;
import com.codegym.cms.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CityController {

       @Autowired
       private CityService cityService;
       @Autowired
       private CountryService countryService;

        @ModelAttribute("countries")
        public Iterable<Country> country(){
            return countryService.findAll();
        }
        @GetMapping("/cites")
        public ModelAndView listCity(){
            Iterable<City> cities = cityService.findAll();
            ModelAndView modelAndView = new ModelAndView("/city/list");
            modelAndView.addObject("cities", cities);
            return modelAndView;
        }
        @GetMapping("/create-city")
        public ModelAndView showCreate(){
            ModelAndView modelAndView = new ModelAndView("/city/create");
            modelAndView.addObject("city",new City());
            return modelAndView;
        }

        @PostMapping("/create-city")
        public ModelAndView saveCity(@ModelAttribute("city") City city){
            cityService.save(city);

            ModelAndView modelAndView = new ModelAndView("/city/create");
            modelAndView.addObject("blog", new City());
            modelAndView.addObject("message", "City created ");
            return modelAndView;
        }
        @GetMapping("/edit-city/{id}")
        public ModelAndView showEdit(@PathVariable Long id){
            City city = cityService.findById(id);
            if (city != null){
                ModelAndView modelAndView = new ModelAndView("/city/edit");
                modelAndView.addObject("city", city);
                return modelAndView;
            } else {
                ModelAndView modelAndView = new ModelAndView("/error.404");
                return modelAndView;
            }
        }
        @PostMapping("/edit-city")
        public ModelAndView updateCity(@ModelAttribute("city") City city){
            cityService.save(city);

            ModelAndView modelAndView = new ModelAndView("/city/edit");
            modelAndView.addObject("city", city);
            modelAndView.addObject("message", "City updated successfully");
            return modelAndView;
        }
        @GetMapping("/delete-city/{id}")
        public ModelAndView showDelete(@PathVariable Long id){
            City city = cityService.findById(id);
            if (city != null){
                ModelAndView modelAndView = new ModelAndView("/city/delete");
                modelAndView.addObject("city",city);
                return modelAndView;
            } else {
                ModelAndView modelAndView = new ModelAndView("/error.404");
                return modelAndView;
            }
        }
        @PostMapping("/delete-city")
        public String deleteCity(@ModelAttribute("city") City city){
            cityService.remove(city.getId());
            return "redirect:cities";
        }
    }

