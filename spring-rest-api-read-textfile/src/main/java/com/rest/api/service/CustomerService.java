package com.rest.api.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.rest.api.model.Customer;
import com.rest.api.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	String path="src/main/resources/sample-data.txt";
	String line="";
	
//	@Scheduled(cron= " 0/15 * * * * * " )  //cron(sec, min, hour, day(month), month, day(week) )
	@Scheduled(cron=" 0 0 1 * * ? ")  //executes daily at 1AM
	public void getCustomerData() {
		try {
			BufferedReader br=new BufferedReader(new FileReader(path));
			try {
				line=br.readLine();
				while((line=br.readLine())!= null) {
					String[] values=line.split("\\|");
					Customer customer=new Customer();
					customer.setName(values[0]);
					customer.setEmail(values[1]);
					customer.setMobile(values[2]);
					customer.setGender(values[3]);
					customer.setAddress(values[4]);
					customer.setCity(values[5]);
					customerRepository.save(customer);
				}
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
}
