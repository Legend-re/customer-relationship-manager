package com.example.customerrelationshipmanager.service;

import com.example.customerrelationshipmanager.exceptions.CustomerException;
import com.example.customerrelationshipmanager.model.Customers;
import com.example.customerrelationshipmanager.model.dto.CustomersDTO;


import java.util.List;

public interface CustomerService {

    List<Customers> getCustomersList();

    Customers addCustomer(Customers customer) throws CustomerException;

    Customers updateCustomer(Long id, Customers customers) throws CustomerException;

    void deleteCustomer(Long id) throws CustomerException;
}
