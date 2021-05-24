package com.cinema;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
	private static final Object StudentID = null;
	private JdbcTemplate jdbcTemplate;
    // JdbcTemplate setter
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Saving a new User
    public void saveUser(User user)
    {
        String sql = "insert into students values(?,?,?)";
        System.out.println("dao called");
        jdbcTemplate.update(sql, new Object[]
        { user.getName(), user.getEmail(), user.getPassword()});
    }

    // Getting a particular Employee
    public Customer getCustomerById(String email)
    {
        String sql = "select * from customer where email=?";
        Customer customer = (Customer) jdbcTemplate.queryForObject(sql, new Object[]
        { email }, new RowMapper<Customer>()
        {
            @Override
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException 
            {
            	Customer customer = new Customer();
            	customer.setName(rs.getString(1));
            	customer.setPassword(rs.getString(3));
            	customer.setEmail(rs.getString(2));
                return customer;
            }
        });
        return customer;
    }

    // Getting all the Employees
    public List<Customer> getAllCustomers()
    {
        String sql = "select * from customer";

        List<Customer> customerList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Customer>>()
        {
            @Override
            public List<Customer> extractData(ResultSet rs) throws SQLException, DataAccessException
            {
                List<Customer> list = new ArrayList<Customer>();
                while (rs.next())
                {
                	Customer customer = new Customer();
                	customer.setName(rs.getString(1));
                	customer.setEmail(rs.getString(2));
                	customer.setPassword(rs.getString(3));
                    list.add(customer);
                }
                return list;
            }
        });
        return customerList;
    }

 // Getting all the Employees
    public List<Student> getAllStudents()
    {
        String sql = "select * from students";

        List<Student> studentList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Student>>()
        {
            @Override
            public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException
            {
                List<Student> list = new ArrayList<Student>();
                while (rs.next())
                {
                	Student student = new Student();
                	student.setName(rs.getString(1));
                	student.setGender(rs.getString(2));
                	student.setDateOfBirth(rs.getString(3));
                	student.setMobileNo(rs.getString(4));
                    list.add(student);
                }
                return list;
            }
        });
        return studentList;
    }
    
 // Getting a particular Student
    public Student getStudentById(int id)
    {
        String sql = "select * from students where StudentID=?";
        Student student = (Student) jdbcTemplate.queryForObject(sql, new Object[]
        { StudentID }, new RowMapper<Student>()
        {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException 
            {
            	Student student = new Student();
            	student.setName(rs.getString(1));
            	student.setFatherName(rs.getString(2));
            	student.setRollNo(rs.getString(3));
            	student.setGender(rs.getString(4));
            	student.setDateOfBirth(rs.getString(5));
            	student.setAge(rs.getString(6));
            	student.setMobileNo(rs.getString(7));
            	student.setClassName(rs.getString(8));
            	student.setFee(rs.getString(9));
            	student.setstudyGroup(rs.getString(7));
                return student;
            }
        });
        return student;
    }
    
    // Updating a particular Employee
    public void updateCustomer(Customer customer)
    {
        String sql = "update customer set name =?, email=?,password=? where email=?";
        jdbcTemplate.update(sql, new Object[]
        { customer.getName(), customer.getEmail(), customer.getPassword(), customer.getEmail()}); 
    }

    // Deletion of a particular Employee
    public void deleteCustomer(String email)
    {
        String sql = "delete from customer where email=?";
        jdbcTemplate.update(sql, new Object[]
        { email });
    }
    @Override
	public void insertBollywoodMovies(BollywoodMovies bollywoodMovie) {
    	MovieFactory movieFactory = new MovieFactory();
		 //get an object of Circle and call its draw method.
		 Movies movie = movieFactory.storeMovie("Bollywood");
		 movie.addMovie(bollywoodMovie.getTitle(), bollywoodMovie.getDescription(), bollywoodMovie.getStartingDate(), bollywoodMovie.getEndingDate(), bollywoodMovie.getTime());
		
		String sql = "insert into movies values(?,?,?,?,?,?)";
        System.out.println("dao called");
        jdbcTemplate.update(sql, new Object[]
        { "bollywood", bollywoodMovie.getTitle(), bollywoodMovie.getDescription(), bollywoodMovie.getStartingDate(), bollywoodMovie.getEndingDate(), bollywoodMovie.getTime()});
	}
	@Override
	public void insertHollywoodMovies(HollywoodMovies hollywoodMovie) {
		MovieFactory movieFactory = new MovieFactory();
		 //get an object of Circle and call its draw method.
		 Movies movie = movieFactory.storeMovie("Hollywood");
		 movie.addMovie(hollywoodMovie.getTitle(), hollywoodMovie.getDescription(), hollywoodMovie.getStartingDate(), hollywoodMovie.getEndingDate(), hollywoodMovie.getTime());
		String sql = "insert into movies values(?,?,?,?,?,?)";
        System.out.println("dao called");
        jdbcTemplate.update(sql, new Object[]
        { "hollywood", hollywoodMovie.getTitle(), hollywoodMovie.getDescription(), hollywoodMovie.getStartingDate(), hollywoodMovie.getEndingDate(), hollywoodMovie.getTime()});
	}

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
