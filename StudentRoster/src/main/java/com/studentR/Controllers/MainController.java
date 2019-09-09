package com.studentR.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.studentR.models.Address;
import com.studentR.models.Person;
import com.studentR.services.AddressService;
import com.studentR.services.PersonService;


@Controller
public class MainController {
	private final PersonService personService;
	private final AddressService addressService;
	public MainController(PersonService personService, AddressService addressService) {
		this.personService = personService;
		this.addressService = addressService;
	}

	@RequestMapping("/")
	public String index() {
		return "redirect:/person/new";
	}

	//render person creation form
	@RequestMapping("/person/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "index.jsp";
	}
	
	//create a Person
	@RequestMapping(value = "/create/person", method = RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else {

			personService.createPerson(person);
			return "redirect:/person/new";
		}
	}
	
	//render address creation form
	@RequestMapping("/addresses/new")
	public String newAddress(@ModelAttribute("address")Address address, Model model) {
		List<Person> listPerson = personService.findAll();
		model.addAttribute("persons", listPerson);
		return "address.jsp";
	}
	
	//create address
	@RequestMapping(value="/addresses/create", method=RequestMethod.POST)
	public String createAddress(@Valid @ModelAttribute("address")Address address, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/addresseSs/new";
		}else {
			addressService.createAddress(address);
			return "redirect:/";
		}
		
	}
	//render user profile
	@RequestMapping("/person/{id}")
	public String showProfile(@PathVariable("id")Long id, Model model) {
		Person findPerson = personService.findPerson(id);
		if (findPerson == null) {
			return "redirect:/";
		}else {
			model.addAttribute("person", findPerson);
			return "result.jsp";
		}
		
	}
	
	
	
}