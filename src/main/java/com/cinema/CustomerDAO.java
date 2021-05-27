package com.cinema;
import java.util.List;

public interface CustomerDAO {
	public void saveCustomer(Customer customer);
	public void saveUser(User user);
	public void saveFee(Fee fee);
    public Customer getCustomerById(String email);
    public Student getStudentById(String studentId);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(String email);
    public List<Customer> getAllCustomers();
    public List<User> getAllUsers();
    public List<Student> getAllStudents();
	void insertHollywoodMovies(HollywoodMovies hollywoodMovie);
	void insertBollywoodMovies(BollywoodMovies bollywoodMovie);
}
