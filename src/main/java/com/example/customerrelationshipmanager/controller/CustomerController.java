package com.example.customerrelationshipmanager.controller;

import com.example.customerrelationshipmanager.exceptions.CustomerException;
import com.example.customerrelationshipmanager.model.Customers;
import com.example.customerrelationshipmanager.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/customers/list")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping()
    public ResponseEntity<List<Customers>> getCustomersList(){
        try{
            log.info("Incoming Request to get Customers List ");
            return new ResponseEntity<>(customerService.getCustomersList(), HttpStatus.OK);
        }catch (HttpServerErrorException exception){
            log.error("Error getting List {}", exception.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<Customers> addCustomer(@RequestBody Customers customer){
        try{
            log.info("Incoming Request to add new Customer ");
            return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
        }catch (HttpServerErrorException | CustomerException exception){
            log.error("Error adding new Customer, {}", exception.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Customers> updateCustomer(@PathVariable(value ="id")Long id, @RequestBody Customers customers){
        try{
            log.info("Incoming Request to edit existing Customer {}", id);
            return new ResponseEntity<>(customerService.updateCustomer(id,customers), HttpStatus.OK);
        }catch (HttpServerErrorException | CustomerException exception){
            log.error("Error Updating existing Customer {}, {}", id, exception.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customers> deleteCustomer(@PathVariable(value = "id")Long id){
        try{
            log.info("Incoming Request to delete Customer {} ", id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (HttpServerErrorException exception){
            log.error("Error deleting Customer {}, {}", id, exception.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
