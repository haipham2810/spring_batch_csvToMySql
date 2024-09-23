package com.bean_notation.springbatch_haipham2.repository;

import com.bean_notation.springbatch_haipham2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
