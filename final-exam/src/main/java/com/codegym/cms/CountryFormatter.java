package com.codegym.cms;

import com.codegym.cms.model.Country;
import com.codegym.cms.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
@Component
public class CountryFormatter implements Formatter<Country> {
    private CountryService countryService;
    @Autowired
    public CountryFormatter(CountryService countryService){
        this.countryService = countryService;
    }
    @Override
    public Country parse(String text, Locale locale) throws ParseException {
        return countryService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Country object, Locale locale) {
        return "[" + object.getId() + "," + object.getName() + "]";
    }
}
