package com.marsassignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marsassignment.dto.PersonDTO;
import com.marsassignment.repository.AddressRepository;
import com.marsassignment.repository.PersonRepository;

@SpringBootApplication
public class StartApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

    @Autowired
    private PersonRepository personRepository;
    
    @Autowired
    private AddressRepository addressRepository;

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

   @Override
    public void run(String... args) {

        log.info("StartApplication...");
        
        personRepository.deleteAllInBatch();
        addressRepository.deleteAllInBatch();

        

    }

}