package com.example.customerrelationshipmanager.repositories;

import com.example.customerrelationshipmanager.model.Customers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository test;

    @Test
    void shouldFindByEmail() {
        String email = "legendre@gmail.com";
        assertThat(test.findByEmail(email)).isPresent();
    }

    @BeforeEach
    void findByEmail(){
        test.save(Customers.builder()
                        .firstName("mubarak")
                        .lastName("ajia")
                        .email("legendre@gmail.com")
                .build());
    }
}