/*
package com.example.customerrelationshipmanager.service;


import com.example.customerrelationshipmanager.model.Customers;
import com.example.customerrelationshipmanager.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StartUp implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        Customers ajia = customerRepository.findById(1L).orElse(null);
        if(ajia == null){
            customerRepository.save(Customers.builder()
                    .firstName("Mubarak")
                    .lastName("Ajia")
                    .email("ajiamubarak@gmail.com")
                    .build());
            log.info("ID Created");
        }
        else {
            log.info("ID already Exist");
        }
        Customers bello = customerRepository.findById(2L).orElse(null);
        if(bello == null){
            customerRepository.save(Customers.builder()
                    .firstName("Quadri")
                    .lastName("Bello")
                    .email("belloquadri@gmail.com")
                    .build());
            log.info("ID Created");
        }
        else {
            log.info("ID already Exist");
        }
    }
}
*/
