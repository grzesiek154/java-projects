package com.company.my.poc.functionalInterace;

import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
    Customer maria = new Customer("Maria", "9999");
    greetCustomer(maria);
    greetCustomerConsumer.accept(maria);

    }

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName + " with phone number " + customer.customerPhoneNumber);
    }
    static Consumer<Customer> greetCustomerConsumer = customer
            -> System.out.println("Hello " + customer.customerName + " with phone number " + customer.customerPhoneNumber);


    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
