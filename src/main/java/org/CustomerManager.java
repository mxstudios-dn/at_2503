package org;

import module.Address;
import module.Customer;
import utils.CSVHelper;
import utils.XMLHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class CustomerManager {

    private List<Customer> customers;
    private  List<Address> addresses;

    public CustomerManager(String xmlPath, String csvPath){
        customers = XMLHelper.loadCustomer(xmlPath);
        addresses = CSVHelper.loadAddresses(csvPath);

        assignRandomCustomer();
    }

    public void assignRandomCustomer(){
        Random r = new Random();
        for ( Customer c: customers){
            Address randomAddress = addresses.get(r.nextInt(addresses.size()));
            c.setAddress(randomAddress);
        }

    }

    public void printAllCustomer(){
        System.out.println("==Customer given random address==");
        for (Customer c: customers){
            System.out.println(c);
        }
    }
}
