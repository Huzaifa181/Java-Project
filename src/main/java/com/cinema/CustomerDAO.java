package com.cinema;
import java.util.List;

public interface CustomerDAO {
	public void saveCustomer(Customer customer);
    public Customer getCustomerById(String email);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(String email);
    public List<Customer> getAllCustomers();
	void insertHollywoodMovies(HollywoodMovies hollywoodMovie);
	void insertBollywoodMovies(BollywoodMovies bollywoodMovie);
    
}
