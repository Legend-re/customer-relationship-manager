package com.example.customerrelationshipmanager.service;

import com.example.customerrelationshipmanager.exceptions.CustomerException;
import com.example.customerrelationshipmanager.model.Customers;
import com.example.customerrelationshipmanager.repositories.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;
    private CustomerServiceImpl underTest;


    @BeforeEach
    void setUp() {
        underTest = new CustomerServiceImpl(customerRepository);
    }


    @Test
    void shouldGetCustomersList() {
        //when
        underTest.getCustomersList();
        //then
        verify(customerRepository).findAll();
    }

    @Test
    void shouldAddNewCustomer() throws CustomerException {
        //given
        Customers customers = new Customers(
                1L,
                "mubarak",
                "ajia",
                "ajiamubarak@gmail.com");

        //when
        Customers dre = underTest.addCustomer(customers);

        //then
        ArgumentCaptor<Customers> customersArgumentCaptor
                = ArgumentCaptor.forClass(Customers.class);

        verify(customerRepository).save(customersArgumentCaptor.capture());

        Customers captureCustomers = customersArgumentCaptor.getValue();

        assertEquals(dre, customers);
    }

    @Test
    @Disabled
    void updateCustomer() {

    }

    @Test
    @Disabled
    void deleteCustomer() {
    }
}