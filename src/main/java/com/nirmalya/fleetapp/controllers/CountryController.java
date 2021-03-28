package com.nirmalya.fleetapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nirmalya.fleetapp.models.Country;
import com.nirmalya.fleetapp.services.CountryService;

@Controller
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping("/country")
	public String getCountries() {
		return "country";
	}

	// Get All Countrys
	@GetMapping("/countries")
	public String findAll(Model model) {
		model.addAttribute("countries", countryService.findAll());
		return "country";
	}

	@RequestMapping(value = "/countries/findById", method = RequestMethod.GET)
	@ResponseBody
	public Optional<Country> findById(Integer id) {
		return countryService.findById(id);
	}

	// Add Country
	@PostMapping(value = "/countries/addNewCountry")
	public String addNew(Country country) {
		countryService.save(country);
		return "redirect:/countries";
	}

	@RequestMapping(value = "/countries/updateCountry", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Country country) {
		countryService.save(country);
		return "redirect:/countries";
	}

	@RequestMapping(value = "/countries/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		countryService.delete(id);
		return "redirect:/countries";
	}
}
