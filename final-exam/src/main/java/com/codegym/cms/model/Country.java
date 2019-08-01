package com.codegym.cms.model;

import javax.persistence.*;
@Entity
@Table
public class Country {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String name;

        @OneToMany(targetEntity = City.class)
        private Iterable<City> cities;

        public Country(){};

        public Country(String name){
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Iterable<City> getCities() {
            return cities;
        }

        public void setCities(Iterable<City> cities) {
            this.cities =cities;
        }
    }

