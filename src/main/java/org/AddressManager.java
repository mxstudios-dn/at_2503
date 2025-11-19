package org;

import module.Address;
import utils.CSVHelper;

import java.util.ArrayList;
import java.util.List;

public class AddressManager {
    private final List<Address> data;

    public AddressManager(String filePath){
        this.data = CSVHelper.loadAddresses(filePath);
    }

    public  void  printAll(){
        System.out.println("==All Addresses");
        for (Address a: data){
            System.out.println(a);
        }
    }

    public void printIndex(int index){
        System.out.println("\n=== Address at index " + index + " ===");
        if (index >= 0 && index < data.size()) {
            System.out.println(data.get(index));
        } else {
            System.out.println("Index out of range!");
        }
    }

    public List<Address> getAll(){
        return data;
    }


}
