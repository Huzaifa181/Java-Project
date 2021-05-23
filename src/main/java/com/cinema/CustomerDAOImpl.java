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
	private JdbcTemplate jdbcTemplate;
    // JdbcTemplate setter
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Saving a new Employee
    public void saveCustomer(Customer customer)
    {
        String sql = "insert into customer values(?,?,?)";
        System.out.println("dao called");
        jdbcTemplate.update(sql, new Object[]
        { customer.getName(), customer.getEmail(), customer.getPassword()});
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

}
