package org.id.billingservice.dao;

import org.id.billingservice.entities.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillingRepository extends JpaRepository<Billing, Long> {
    List<Billing> findByCustomerId(Long customerId);
}
