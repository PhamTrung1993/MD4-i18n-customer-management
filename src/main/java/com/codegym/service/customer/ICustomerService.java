package com.codegym.service.customer;

import com.codegym.model.Customer;
import com.codegym.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ICustomerService extends IGeneralService<Customer> {
    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);
}
