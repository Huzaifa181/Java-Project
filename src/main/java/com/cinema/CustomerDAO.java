package com.cinema;
import java.util.List;

public interface CustomerDAO {
	public void saveCustomer(Customer customer);
	public void saveUser(User user);
	public void addStudent(Student student);
	public void addTeacher(Teacher teacher);
	public Teacher getTeacherAttendance(String id);
	public Student loginAsStudent(String email);
	public Teacher loginAsTeacher(String email);
	public void submitFee(String price);
    public Customer getCustomerById(String email);
    public Student getStudentById(String studentId);
    public List<Student> getStudentByClass(String className);
    public List<Teacher> getTeacherByClass(String className);
    public Teacher getTeacherById(String teacherId);
    public void savePriceAdminAccount(int price, String add);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(String email);
    public List<Customer> getAllCustomers();
    public List<User> getAllUsers();
    public List<Student> getAllStudents();
    public List<Teacher> getAllTeachers();
	void insertHollywoodMovies(HollywoodMovies hollywoodMovie);
	void insertBollywoodMovies(BollywoodMovies bollywoodMovie);
}
