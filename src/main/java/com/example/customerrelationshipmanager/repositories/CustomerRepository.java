package com.example.customerrelationshipmanager.repositories;

import com.example.customerrelationshipmanager.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long> {

    Optional<Customers> findByEmail(String email);
}
