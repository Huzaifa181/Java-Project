package com.cinema;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.lang.*;
@Repository
public class SchoolDAOImpl implements SchoolDAO{
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
 // Saving a Fee
    public void saveFee(Fee fee)
    {
    	System.out.println(fee.getStudentId()+fee.getFee());
        String sql = "insert into fee values(?,?)";
        System.out.println("dao called");
        jdbcTemplate.update(sql, new Object[]
         { fee.getFee(),fee.getStudentId()});
    }
  
 // Getting all the Students
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
                	student.setStudentId(rs.getString(1));
                	student.setName(rs.getString(2));
                	student.setGender(rs.getString(3));
                	student.setDateOfBirth(rs.getString(6));
                	student.setMobileNo(rs.getString(8));
                	student.setEmail(rs.getString(12));
                    list.add(student);
                }
                return list;
            }
        });
        return studentList;
    }
    
    // Getting all the Teacher
    public List<Teacher> getAllTeachers()
    {
        String sql = "select * from teacher";

        List<Teacher> teacherList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Teacher>>()
        {
            @Override
            public List<Teacher> extractData(ResultSet rs) throws SQLException, DataAccessException
            {
                List<Teacher> list = new ArrayList<Teacher>();
                while (rs.next())
                {
                	Teacher teacher = new Teacher();
                	teacher.setTeacherId(rs.getString(1));
                	teacher.setName(rs.getString(2));
                	teacher.setNumber(rs.getString(3));
                	teacher.setEmail(rs.getString(4));
                	teacher.setAttendance(rs.getString(5));
                	teacher.setSalary(rs.getString(6));
                	teacher.setSubject(rs.getString(7));
                    list.add(teacher);
                }
                return list;
            }
        });
        return teacherList;
    }
 // Getting a particular Student
    public Student getStudentById(String StudentID)
    {
        String sql = "select * from students where StudentID=?";
        Student student = (Student) jdbcTemplate.queryForObject(sql, new Object[]
        { StudentID }, new RowMapper<Student>()
        {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException 
            {
            	System.out.println("rs"+rs);
            	Student student = new Student();
            	student.setStudentId(rs.getString(1));
            	student.setName(rs.getString(2));
            	student.setFatherName(rs.getString(3));
            	student.setRollNo(rs.getString(4));
            	student.setGender(rs.getString(5));
            	student.setDateOfBirth(rs.getString(6));
            	student.setAge(rs.getString(7));
            	student.setMobileNo(rs.getString(8));
            	student.setClassName(rs.getString(9));
            	student.setFee(rs.getString(10));
            	student.setstudyGroup(rs.getString(11));
                return student;
            }
        });
        return student;
    }

 // Getting all Teacher by ClassName
    public List<Teacher> getTeacherByClass(String className)
    {
        String sql = "select * from teacher where Class=?";

        List<Teacher> teacherList = jdbcTemplate.query(sql,new Object[]
                { className }, new ResultSetExtractor<List<Teacher>>()
        {
            @Override
            public List<Teacher> extractData(ResultSet rs) throws SQLException, DataAccessException
            {
                List<Teacher> list = new ArrayList<Teacher>();
                while (rs.next())
                {
                	Teacher teacher = new Teacher();
                	teacher.setTeacherId(rs.getString(1));
                	teacher.setName(rs.getString(2));
                	teacher.setNumber(rs.getString(3));
                	teacher.setEmail(rs.getString(4));
                	teacher.setAttendance(rs.getString(5));
                	teacher.setSalary(rs.getString(6));
                	teacher.setSubject(rs.getString(7));
                	teacher.setClassName(rs.getString(8));
                    list.add(teacher);
                }
                return list;
            }
        });
        return teacherList;
    }
    
 // Getting all the Students
    public List<Student> getStudentByClass(String className)
    {
        String sql = "select * from students where Class=?";

        List<Student> studentList = jdbcTemplate.query(sql,new Object[]
                { className }, new ResultSetExtractor<List<Student>>()
        {
            @Override
            public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException
            {
                List<Student> list = new ArrayList<Student>();
                while (rs.next())
                {
                	Student student = new Student();
                	student.setStudentId(rs.getString(1));
                	student.setName(rs.getString(2));
                	student.setFatherName(rs.getString(3));
                	student.setRollNo(rs.getString(4));
                	student.setGender(rs.getString(5));
                	student.setDateOfBirth(rs.getString(6));
                	student.setAge(rs.getString(7));
                	student.setMobileNo(rs.getString(8));
                	student.setClassName(rs.getString(9));
                	student.setFee(rs.getString(10));
                	student.setstudyGroup(rs.getString(11));
                    list.add(student);
                }
                return list;
            }
        });
        return studentList;
    }
    // Getting a particular teacher
    public Teacher getTeacherById(String TeacherID)
    {
        String sql = "select * from teacher where Id=?";
        Teacher teacher = (Teacher) jdbcTemplate.queryForObject(sql, new Object[]
        { TeacherID }, new RowMapper<Teacher>()
        {
            @Override
            public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException 
            {
            	System.out.println("rs"+rs);
            	Teacher teacher = new Teacher();
            	teacher.setTeacherId(rs.getString(1));
            	teacher.setName(rs.getString(2));
            	teacher.setNumber(rs.getString(3));
            	teacher.setEmail(rs.getString(4));
            	teacher.setAttendance(rs.getString(5));
            	teacher.setSalary(rs.getString(6));
            	teacher.setSubject(rs.getString(7));
            	teacher.setClassName(rs.getString(8));
                return teacher;
            }
        });
        return teacher;
    }

 // Updating a price of Admin Account
    public void savePriceAdminAccount(int price, String mssg)
    {
    	if(mssg=="get") {  
    		String sql1 = "select * from account where Id=?";
            String price1 = (String) jdbcTemplate.queryForObject(sql1, new Object[]
            { 1 }, new RowMapper<String>()
            {
                @Override
                public String mapRow(ResultSet rs, int rowNum) throws SQLException 
                {
                	System.out.println("rs"+rs);
                	Account a1=new Account(Integer.parseInt(rs.getString(2)));
                    return rs.getString(2);
                }
            });
    	}
    	else {
    		System.out.println("Model"+price);
        	String sql1 = "select * from account where Id=?";
            String price1 = (String) jdbcTemplate.queryForObject(sql1, new Object[]
            { 1 }, new RowMapper<String>()
            {
                @Override
                public String mapRow(ResultSet rs, int rowNum) throws SQLException 
                {
                	System.out.println("rs"+rs.getString(1));
                    return rs.getString(2);
                }
            });
            if(mssg=="add") {
            	System.out.println("kksk"+(price+Integer.parseInt(price1)));
            	String sql = "update account set Price =? where Id=?";
            	jdbcTemplate.update(sql, new Object[]
            			{price+Integer.parseInt(price1),1});
            	Account a1=new Account(price+Integer.parseInt(price1));
            }
            else {
            	System.out.println("Final"+Account.price);
            	System.out.println("Price1"+Integer.parseInt(price1));
            	String sql = "update account set Price =? where Id=?";
            	jdbcTemplate.update(sql, new Object[]
            			{Integer.parseInt(price1)-price,1});
            }
    	}
    	
    }



	@Override
	public Student loginAsStudent(String email) {
		try {
			
			String sql = "select * from students where Email=?";
	        Student student = (Student) jdbcTemplate.queryForObject(sql, new Object[]
	        { email }, new RowMapper<Student>()
	        {
	            @Override
	            public Student mapRow(ResultSet rs, int rowNum) throws SQLException 
	            {
	            	System.out.println("rs"+rs);
	            	Student student = new Student();
	            	student.setStudentId(rs.getString(1));
                	student.setName(rs.getString(2));
                	student.setFatherName(rs.getString(3));
                	student.setRollNo(rs.getString(4));
                	student.setGender(rs.getString(5));
                	student.setDateOfBirth(rs.getString(6));
                	student.setAge(rs.getString(7));
                	student.setMobileNo(rs.getString(8));
                	student.setClassName(rs.getString(9));
                	student.setFee(rs.getString(10));
                	student.setstudyGroup(rs.getString(11));
                	student.setEmail(rs.getString(12));
	                return student;
	            }
	        });
	        return student;	
		}
	        catch(EmptyResultDataAccessException e)
	        {
				return null;	
	        }
	}
	@Override
	public Teacher loginAsTeacher(String email) {
			try {
				String sql = "select * from teacher where Email=?";
				
				Teacher teacher = (Teacher) jdbcTemplate.queryForObject(sql, new Object[]
						{ email }, new RowMapper<Teacher>()
				{
					@Override
					public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException 
					{
						System.out.println("rs"+rs);
						Teacher teacher = new Teacher();
						teacher.setTeacherId(rs.getString(1));
						teacher.setName(rs.getString(2));
						teacher.setNumber(rs.getString(3));
						teacher.setEmail(rs.getString(4));
						teacher.setAttendance(rs.getString(5));
						teacher.setSalary(rs.getString(6));
						teacher.setSubject(rs.getString(7));
						teacher.setClassName(rs.getString(8));
						return teacher;
					}
				});
				return teacher;	
			}
			catch(EmptyResultDataAccessException e)
	        {
				return null;	
	        }
	}

	@Override
	public Teacher getTeacherAttendance(String id) {
		String sql = "select * from teacher where Id=?";
		Teacher teacher = (Teacher) jdbcTemplate.queryForObject(sql, new Object[]
        {id}, new RowMapper<Teacher>()
        {
            @Override
            public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException 
            {
            	System.out.println("rs"+rs);
            	Teacher teacher = new Teacher();
            	teacher.setTeacherId(rs.getString(1));
				teacher.setName(rs.getString(2));
				teacher.setNumber(rs.getString(3));
				teacher.setEmail(rs.getString(4));
				teacher.setAttendance(rs.getString(5));
				teacher.setSalary(rs.getString(6));
				teacher.setSubject(rs.getString(7));
				teacher.setClassName(rs.getString(8));
                return teacher;
            }
        });
        return teacher;
	}

	@Override
	public void addStudent(Student student) {
		System.out.println("opdop"+student.getName());
		String sql = "insert into students values(?,?,?,?,?,?,?,?,?,?,?,?)";
        System.out.println("dao called");
        jdbcTemplate.update(sql, new Object[]
        {Math.random()*1000000, student.getName(), student.getFatherName(), student.getRollNo(),student.getGender(),student.getDateOfBirth(),student.getAge(),student.getMobileNo(),student.getClassName(),student.getFee(),student.getStudyGroup(),student.getEmail()});
	}
	@Override
	public void addTeacher(Teacher teacher) {
		String sql = "insert into teacher values(?,?,?,?,?,?,?,?)";
        System.out.println("dao called");
        jdbcTemplate.update(sql, new Object[]
        {Math.random()*1000000, teacher.getName(),teacher.getNumber(), teacher.getEmail(), teacher.getAttendance(),teacher.getSalary(),teacher.getSubject(),teacher.getClassName()});
	}

	@Override
	public void submitFee(String price) {
		System.out.println("Price"+price);
		String sql1 = "select * from account where Id=?";
        String price1 = (String) jdbcTemplate.queryForObject(sql1, new Object[]
        { 1 }, new RowMapper<String>()
        {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException 
            {
            	System.out.println("rs"+rs);
            	Account a1=new Account(Integer.parseInt(rs.getString(2)));
                return rs.getString(2);
            }
        });
        String sql = "update account set Price =? where Id=?";
    	jdbcTemplate.update(sql, new Object[]
    			{Integer.parseInt(price)+Integer.parseInt(price1),1});
	}
}
