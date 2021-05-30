package com.cinema;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController{
	@Autowired
	private CustomerDAO customerDAO;
    @RequestMapping(value = "/home",method={ RequestMethod.GET, RequestMethod.POST })
    public String saveCustomer(@ModelAttribute("customer") Customer customer,Model model)
    {
    	try
        {
    		if(customer.getEmail().equals("admin@gmail.com") && customer.getPassword().equals("admin")) {
    			List<Student> studentList = customerDAO.getAllStudents();
        		List<Teacher> teacherList = customerDAO.getAllTeachers();
            	Total total=new Total(studentList.size(), teacherList.size());
            	model.addAttribute("Tteacher", Total.getTotalTeachers());
            	model.addAttribute("Tstudent", Total.getTotalStudents());
    		}
    		else
    		{
    			return "redirect:/login";
    		}	
        }
        catch(NullPointerException e)
        {
        	return "redirect:/login";
        }
		return null;
    	
    }
    String studentId=null;
    String studentEmail=null;
    @RequestMapping(value = "/studentDashboard",method={ RequestMethod.GET, RequestMethod.POST })
    public String studentDashboard(@ModelAttribute("customer") Customer customer,Model model)
    {
    	try
        {
        		if(customer.getEmail()==null) {			
        			Student student=customerDAO.loginAsStudent(studentEmail);
        			studentId=student.getStudentId();
        			System.out.println("NNN"+student.getEmail());
        			System.out.println("NNN"+studentEmail);
        			studentEmail=student.getEmail();
        			System.out.println("sttd id"+student.getStudentId());
        			model.addAttribute("id", student.getStudentId());
        			model.addAttribute("name", student.getName());
        			model.addAttribute("fName", student.getFatherName());
        			model.addAttribute("rollNo", student.getRollNo());
        			model.addAttribute("gender", student.getGender());
        			model.addAttribute("dateOfBirth", student.getDateOfBirth());
        			model.addAttribute("age", student.getAge());
        			model.addAttribute("mobileNo", student.getMobileNo());
        			model.addAttribute("jamat", student.getClassName());
        			model.addAttribute("fee", student.getFee());
        			model.addAttribute("Tteacher", Total.getTotalTeachers());
        			model.addAttribute("Tstudent", Total.getTotalStudents());
        			return "studentDashboard";
        		}
        		else {
        			Student student=customerDAO.loginAsStudent(customer.getEmail());
        			studentId=student.getStudentId();
        			System.out.println("NNjN"+student.getEmail());
        			System.out.println("NNjN"+studentEmail);
        			studentEmail=student.getEmail();
        			System.out.println("sttd id"+student.getStudentId());
        			model.addAttribute("id", student.getStudentId());
        			model.addAttribute("name", student.getName());
        			model.addAttribute("fName", student.getFatherName());
        			model.addAttribute("rollNo", student.getRollNo());
        			model.addAttribute("gender", student.getGender());
        			model.addAttribute("dateOfBirth", student.getDateOfBirth());
        			model.addAttribute("age", student.getAge());
        			model.addAttribute("mobileNo", student.getMobileNo());
        			model.addAttribute("jamat", student.getClassName());
        			model.addAttribute("fee", student.getFee());
        			model.addAttribute("Tteacher", Total.getTotalTeachers());
        			model.addAttribute("Tstudent", Total.getTotalStudents());
        			return "studentDashboard";
        		}
        }
        catch(NullPointerException e)
        {
        	return "redirect:/login";
        }
    	
    }
    String teacherId=null;
    String email=null;
    @RequestMapping(value = "/teacherDashboard",method={ RequestMethod.GET, RequestMethod.POST })
    public String teacherDashboard(@ModelAttribute("customer") Customer customer,Model model)
    {
    	try
        {
    		if(customer.getEmail()==null) {	
    			Teacher teacher=customerDAO.loginAsTeacher(email);
    			teacherId=teacher.getTeacherId();
    			email=teacher.getEmail();
    			model.addAttribute("name", teacher.getName());
    			model.addAttribute("email", teacher.getEmail());
    			model.addAttribute("number", teacher.getNumber());
    			model.addAttribute("attendance", teacher.getAttendance());
    			model.addAttribute("salary", teacher.getSalary());
    			model.addAttribute("subject", teacher.getSubject());
    			model.addAttribute("className", teacher.getClassName());
    			return "teacherDashboard";
    		}
    		else {
    			Teacher teacher=customerDAO.loginAsTeacher(customer.getEmail());
    			teacherId=teacher.getTeacherId();
    			email=teacher.getEmail();
    			model.addAttribute("name", teacher.getName());
    			model.addAttribute("email", teacher.getEmail());
    			model.addAttribute("number", teacher.getNumber());
    			model.addAttribute("attendance", teacher.getAttendance());
    			model.addAttribute("salary", teacher.getSalary());
    			model.addAttribute("subject", teacher.getSubject());
    			model.addAttribute("className", teacher.getClassName());
    			return "teacherDashboard";
    		}
        }
        catch(NullPointerException e)
        {
        	return "redirect:/login";
        }
    }
@RequestMapping(value = "/addBollywoodMovies",method={ RequestMethod.GET, RequestMethod.POST })
public String manageBollywoodFilms(@ModelAttribute("movies") BollywoodMovies bollywoodMovie,Model model)
{
	model.addAttribute("movies", bollywoodMovie);
	AdminUI object = AdminUI.getInstance();
	object.setBttnAddNewFilm("<a href=\"/CinemaProject/addHollywoodMovies\">Add Hollywood Movies</a><a href=\"/CinemaProject/addBollywoodMovies\">Add Bollywood Movies</a>");
	object.setBookingLink("<a href=\"/bookings\">Manage Bookings</a>");
	model.addAttribute("admin", object);
	model.addAttribute("addBollywoodMovies", bollywoodMovie);
	if(bollywoodMovie.getTitle()!=null) {
			customerDAO.insertBollywoodMovies(bollywoodMovie);
		}
	return "addBollywoodMovies";
}
   
    @RequestMapping(value = "/viewMovies",method={ RequestMethod.GET, RequestMethod.POST })
	public String addMovie(@ModelAttribute("customer") Customer customer,Model model) {
//		AdminUI object = AdminUI.getInstance();
//    	object.setBttnAddNewFilm("<div  class=\"getStartedBtn\"><a href=\"/CinemaProject/manageFilms\" onClick=\"j\">Add New Film</a></div>");
//		object.setBookingLink("<a href=\"/bookings\">Manage Bookings</a>");
		System.out.println("inside admin");
		customerDAO.saveCustomer(customer);
		return "viewMovies";
	}
    @RequestMapping(value = "/edit/{id}")
    public ModelAndView editCustomer(@ModelAttribute("customer") Customer customer,@PathVariable("email") String email)
    {
        ModelAndView model = new ModelAndView("registration");
        customer = customerDAO.getCustomerById(email);
        List<Customer> customerList = customerDAO.getAllCustomers();
        model.addObject("customer",customer);
        model.addObject("customerList",customerList);
        return model;
    }
    
    @RequestMapping(value = "/delete/{id}")
    public ModelAndView deleteCustomer(@ModelAttribute("customer") Customer customer,@PathVariable("name") String name)
    {
    	customerDAO.deleteCustomer(name);
        return new ModelAndView("redirect:/registration");
    }

    @RequestMapping(value = "/registration")
    public ModelAndView listEmployees(@ModelAttribute("user") User user)
    {
        ModelAndView model = new ModelAndView("registration");
        List<User> userList = customerDAO.getAllUsers();
        System.out.println(userList);
        model.addObject("userList", userList);
        return model;
    }
    @RequestMapping(value = "/login")
    public ModelAndView login(@ModelAttribute("user") User user)
    {
        ModelAndView model = new ModelAndView("login");
        return model;
    }
    @RequestMapping(value = "/addHollywoodMovies",method={ RequestMethod.GET, RequestMethod.POST })
    public String manageHollywoodFilms(@ModelAttribute("movies") HollywoodMovies hollywoodMovie,Model model)
    {
    	model.addAttribute("movies", hollywoodMovie);
    	System.out.println(hollywoodMovie.getDescription());
    	AdminUI object = AdminUI.getInstance();
    	object.setBttnAddNewFilm("<a href=\"/CinemaProject/addHollywoodMovies\">Add Hollywood Movies</a><a href=\"/CinemaProject/addBollywoodMovies\">Add Bollywood Movies</a>");
    	object.setBookingLink("<a href=\"/bookings\">Manage Bookings</a>");
    	model.addAttribute("admin", object);
    	model.addAttribute("addHollywoodMovies", hollywoodMovie);
    	if(hollywoodMovie.getTitle()!=null) {
    		customerDAO.insertHollywoodMovies(hollywoodMovie);
    	}
    	
    	return "addHollywoodMovies";
    }
   
    @RequestMapping(value = "/teacherDetail",method={ RequestMethod.POST })
    public String saveSalary(@ModelAttribute("salary") Teacher teacher,Model model)
{
    	customerDAO.savePriceAdminAccount(0,"get");

    	model.addAttribute("Tteacher", Total.getTotalTeachers());
    	model.addAttribute("Tstudent", Total.getTotalStudents());
    	teacher.setMessage("Initialize");
    	teacher.setTeacherId("900");
    	teacher.setName("Asma");
    	teacher.setNumber("8948393990");
    	teacher.setEmail("asma@gmail.com");
    	teacher.setAttendance("100%");
    	teacher.setSalary("12000");
    	teacher.setSubject("Science");
    	CheckAttendanceThread t1=new CheckAttendanceThread(teacher);
    	GiveSalaryThread t2=new GiveSalaryThread(teacher);
        t1.start();
        t2.start();
//      wait for threads to end
        try {
         t1.join();
         t2.join();
           
        } catch ( Exception e) {
           System.out.println("Interrupted");
        }
        System.out.println("Less Balance in Account BB");
        System.out.println(teacher.getMessage());
        if(teacher.getMessage().equals("Less Balance in Account")) { 
        	System.out.println("Less Balance in Account CC");
     	   AddPriceInAccount t3=new AddPriceInAccount(Integer.parseInt(teacher.getSalary())+10000);
     	   t3.start();  
     	   try {
              t3.join();
              System.out.println("Silary"+teacher.getSalary());
              customerDAO.savePriceAdminAccount(Integer.parseInt(teacher.getSalary())+10000,"add");
              System.out.println("Less Balance in Account F");
     	   }
     	   catch ( Exception e) {
     		   System.out.println("Interruptedd");
     	   }
        }
        System.out.println("Less Balance in Account C");
        System.out.println(teacher.getMessage());
        System.out.println("Opospo");
        System.out.println("Less Balance in Account C"+Account.price);
        System.out.println("Less in Account C"+Integer.parseInt(teacher.getSalary()));
        customerDAO.savePriceAdminAccount(Integer.parseInt(teacher.getSalary()),"give Salary");
    	return "teacherHome";
    }
    @RequestMapping(value = "/fee")
    public ModelAndView inputFee(@ModelAttribute("fee") Fee fee)
    {
        ModelAndView model = new ModelAndView("fee");
        return model;
    }
    @RequestMapping(value = "/fee",method={ RequestMethod.POST })
    public String inputFee(@ModelAttribute("fee") Fee fee,Model model)
    {			
    	System.out.println("fee"+fee.getFee());
            	customerDAO.submitFee(fee.getFee());	
            	return "fee";
    }
    @RequestMapping(value = "/studentHome")
    public ModelAndView studentHome(@ModelAttribute("student") Student student)
    {
        ModelAndView model = new ModelAndView("studentHome");
        List<Student> studentList = customerDAO.getAllStudents();
        System.out.println(studentList);
        model.addObject("student", studentList);
        model.addObject("Tteacher", Total.getTotalTeachers());
        model.addObject("Tstudent", Total.getTotalStudents());
        return model;
    }
    @RequestMapping(value = "/teacherHome")
    public ModelAndView teacherHome(@ModelAttribute("teacher") Teacher teacher)
    {
        ModelAndView model = new ModelAndView("teacherHome");
        List<Teacher> teacherList = customerDAO.getAllTeachers();
        System.out.println("Teahcerss");
        model.addObject("Tteacher", Total.getTotalTeachers());
        model.addObject("Tstudent", Total.getTotalStudents());
        System.out.println("Teahcer List"+teacherList);
        model.addObject("teacher", teacherList);
        return model;
    }
    
    //For particular class
    @RequestMapping(value = "/classes/{className}", method = RequestMethod.GET)
    public ModelAndView classDetail(@ModelAttribute("className") Student student,@PathVariable("className") String className)
    {
    	ModelAndView model = new ModelAndView("particularClassInfo");
        System.out.println(className);
        List<Student> studentList = customerDAO.getStudentByClass(className);
        model.addObject("student", studentList);
        List<Teacher> teacherList = customerDAO.getTeacherByClass(className);
        model.addObject("teacher", teacherList);
        model.addObject("Tteacher", Total.getTotalTeachers());
        model.addObject("Tstudent", Total.getTotalStudents());
        return model;
    }
    
    @RequestMapping(value = "/studentDetail/{studentId}", method = RequestMethod.GET)
    public ModelAndView studentDetail(@ModelAttribute("submitFee") Student student,@PathVariable("studentId") String studentId)
    {
        ModelAndView model = new ModelAndView("studentDetail");
        Student studentList = customerDAO.getStudentById(studentId);
        System.out.println("particular student"+studentList);
        System.out.println("sttd id"+studentList.getStudentId());
        model.addObject("id", studentList.getStudentId());
        model.addObject("name", studentList.getName());
        model.addObject("fName", studentList.getFatherName());
        model.addObject("rollNo", studentList.getRollNo());
        model.addObject("gender", studentList.getGender());
        model.addObject("dateOfBirth", studentList.getDateOfBirth());
        model.addObject("age", studentList.getAge());
        model.addObject("mobileNo", studentList.getMobileNo());
        model.addObject("jamat", studentList.getClassName());
        model.addObject("fee", studentList.getFee());
        model.addObject("studyGroup", studentList.getStudyGroup());
        model.addObject("Tteacher", Total.getTotalTeachers());
        model.addObject("Tstudent", Total.getTotalStudents());
//        customerDAO.saveFee("2", "3444");
        return model;
    }

    @RequestMapping(value = "/teacherDetail/{teacherId}", method = RequestMethod.GET)
    public ModelAndView teacherDetail(@ModelAttribute("teacher") Teacher teacher,@PathVariable("teacherId") String teacherId)
    {
        ModelAndView model = new ModelAndView("teacherDetail");
        Teacher teacherList = customerDAO.getTeacherById(teacherId);
        model.addObject("name", teacherList.getName());
        model.addObject("email", teacherList.getEmail());
        model.addObject("number", teacherList.getNumber());
        model.addObject("attendance", teacherList.getAttendance());
        model.addObject("salary", teacherList.getSalary());
        model.addObject("subject", teacherList.getSubject());
        model.addObject("className", teacherList.getClassName());
        model.addObject("Tteacher", Total.getTotalTeachers());
        model.addObject("Tstudent", Total.getTotalStudents());
        return model;
    }
    @RequestMapping(value = "/inputTeacherDetail")
    public ModelAndView inputTeacherDetail(@ModelAttribute("teacher") Teacher teacher)
    {
        ModelAndView model = new ModelAndView("inputTeacherDetail");
        model.addObject("Tteacher", Total.getTotalTeachers());
        model.addObject("Tstudent", Total.getTotalStudents());
        return model;
    }
    @RequestMapping(value = "/inputTeacherDetail",method={ RequestMethod.POST })
    public String inputTeacherDetail(@ModelAttribute("teacher") Teacher teacher,Model model)
    {	
            	customerDAO.addTeacher(teacher);	
            	return "inputTeacherDetail";
    }
    @RequestMapping(value = "/inputStudentDetail")
    public ModelAndView inputStudentDetail(@ModelAttribute("student") Student student)
    {
        ModelAndView model = new ModelAndView("inputStudentDetail");
        model.addObject("Tteacher", Total.getTotalTeachers());
        model.addObject("Tstudent", Total.getTotalStudents());
        return model;
    }
    @RequestMapping(value = "/inputStudentDetail",method={ RequestMethod.POST })
    public String inputStudentDetail(@ModelAttribute("student") Student student,Model model)
    {	
    	System.out.println("ss"+student.getAge());
            	customerDAO.addStudent(student);	
            	return "inputStudentDetail";
    }

    @RequestMapping(value = "/about")
    public ModelAndView about()
    {
        ModelAndView model = new ModelAndView("about");

        return model;
    }
    @RequestMapping(value = "/classes")
    public ModelAndView classes()
    {
        ModelAndView model = new ModelAndView("classes");
        model.addObject("Tteacher", Total.getTotalTeachers());
        model.addObject("Tstudent", Total.getTotalStudents());
        return model;
    }
    @RequestMapping(value = "/teacherAttendance")
    public ModelAndView teacherAttendance()
    {
        ModelAndView model = new ModelAndView("teacherAttendance");
        Teacher teacher = customerDAO.getTeacherAttendance(teacherId);
        model.addObject("attendance", teacher.getAttendance());
        return model;
    }

}
