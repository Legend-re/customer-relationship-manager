package com.example.customerrelationshipmanager.service;

import com.example.customerrelationshipmanager.exceptions.CustomerException;
import com.example.customerrelationshipmanager.model.Customers;
import com.example.customerrelationshipmanager.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customers> getCustomersList() {
        log.info("About getting Customers List");
        return customerRepository.findAll();
    }

    @Override
    @Transactional
    public Customers addCustomer(Customers customer) throws CustomerException {
        log.info("About adding new Customer to List {}", customer);
        Customers customers = customerRepository.findByEmail(customer.getEmail()).orElse(null);
        if (customers != null) {
            log.error("Customer with Email {} Already Exist", customer.getEmail());
            throw new CustomerException("Email already exists");
        }
        Customers few = Customers.builder()
                .firstName(customer.getFirstName())
                .lastName(customers.getLastName())
                .email(customer.getEmail())
                .build();
        customerRepository.save(few);
        return few;
       /* return customerRepository.save(Customers.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .build());*/
    }

   @Override
   @Transactional
    public Customers updateCustomer(Long id, Customers customer) throws CustomerException {
        log.info("About updating existing Customer in List {}", customer);
        Customers customers = customerRepository.findByEmail(customer.getEmail()).orElse(null);
        if (customers == null) {
            log.error("Customer with name {} is null", customer.getFirstName());
            throw new CustomerException("Customer not Found");
        }
        customer.setFirstName(customer.getFirstName());
        customer.setLastName(customer.getLastName());
        customer.setEmail(customer.getEmail());
        return customerRepository.save(customers);
    }

    @Override
    @Transactional
    public void deleteCustomer(Long id) throws CustomerException{
        log.info("About Deleting Customer by id {}", id);
        Customers customer = customerRepository.findById(id).orElse(null);
        if(customer==null){
            log.error("Customer with id {} is null", id);
            throw new CustomerException("Customer not Found");
        }
        customerRepository.delete(customer);
    }
}
