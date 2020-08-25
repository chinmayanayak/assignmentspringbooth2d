package com.marsassignment.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import com.marsassignment.StartApplication;
import com.marsassignment.dto.PersonDTO;
import com.marsassignment.exception.PersonNotFoundException;
import com.marsassignment.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
	
	private static final Logger log = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonRepository personRepository;

    // Find all person
    @GetMapping("/person")
    List<PersonDTO> findAllPerson() {
    	log.info("Inside get all person details endpoint");
        return personRepository.findAll();
    }
    
    // Count number of  person
    @GetMapping("/countperson")
    Long countNoOfPerson() {
    	log.info("Inside count total number of person endpoint");
        return personRepository.count();
    }
    

    // Add a person
    @PostMapping("/person")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    PersonDTO newPerson(@RequestBody PersonDTO newPersonDTO) {
    	log.info("Create new person endpoint");
        return personRepository.save(newPersonDTO);
    }

    // Find a person with given id
    @GetMapping("/person/{id}")
    PersonDTO findOne(@PathVariable Long id) {
    	log.info("Get the detail of person with particular id::");
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    // Update a person with given id
    @PutMapping("/person/{id}")
    Optional<Object> updatePerson(@RequestBody PersonDTO newPersonDTO, @PathVariable Long id) {
    	
    	log.info("Update a  person endpoint::::");
    	if(personRepository.existsById(id)) {
	        return personRepository.findById(id)
	                .map(x -> {
	                    x.setFirstName(newPersonDTO.getFirstName());
	                    x.setLastName(newPersonDTO.getLastName());
	                    return personRepository.save(x);
	                    
	                });
    	}
    	else {
                throw new PersonNotFoundException(id);
        
    	}
    }


    @DeleteMapping("/person/{id}")
    void deleteBook(@PathVariable Long id) {
    	log.info("Delete a new person endpoint");
        personRepository.deleteById(id);
    }

}
