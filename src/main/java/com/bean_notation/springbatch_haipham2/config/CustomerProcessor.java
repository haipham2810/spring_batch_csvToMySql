package com.bean_notation.springbatch_haipham2.config;

import com.bean_notation.springbatch_haipham2.entity.Customer;
import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {
    @Override
    public Customer process(Customer customer)throws Exception{
        return customer;

        //Return customers who live in China to database
//        if(customer.getCountry().equals("China")) {
//            return customer;
//        }else{
//            return null;
//        }
    }
}
