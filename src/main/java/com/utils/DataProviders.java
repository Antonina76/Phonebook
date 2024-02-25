package com.utils;

import com.phonebook.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> addNewContactFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact1.csv")));
        String line =  reader.readLine();
        while (line !=null) {
            String[] split = line.split(",");
            list.add(new Object[]{new Contact().setName(split[0]).setLastName(split[1]).setPhone(split[2]).setEmail(split[3]).setAdress(split[4]).setDeskription(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> addNewContact(){
        List<Object[]>list=new ArrayList<>();
        list.add(new Object[]{"Markus1","Gross","1234567891","mark@xp.com","Arnheim","goalkeeper"});
        list.add(new Object[]{"Markus2","Gross","1234567895","mark@xp.com","Arnheim","goalkeeper"});
        list.add(new Object[]{"Markus3","Gross","1234567896","mark@xp.com","Arnheim","goalkeeper"});
        return list.iterator();
    }
}
