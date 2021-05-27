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
   System.out.println(customer.getEmail());
   System.out.println(customer.getEmail().equalsIgnoreCase("huzaifa@gmail.com"));
    	if(customer.getEmail().equals("huzaifa@gmail.com")) {
    		AdminUI object = AdminUI.getInstance();
    		object.setBttnAddNewFilm("");
    		object.setBookingLink("<a href=\"/bookings\">Manage Bookings</a>");
    		System.out.println("inside admin");
    		model.addAttribute("home", customer);
    		model.addAttribute("admin", object);
            System.out.println("inside catch");
            customerDAO.saveCustomer(customer);
            return "home";
    	}
    	else {
    	model.addAttribute("home", customer);
    	AdminUI object = AdminUI.getInstance();
		object.setBookingLink("<a href=\"/bookings\">View Bookings</a>");
		object.setBttnAddNewFilm("<a>Manage Bookins</a>");
		model.addAttribute("admin", object);
    	System.out.println("inside customer");
            System.out.println("inside catch");
            customerDAO.saveCustomer(customer);
        return "home";
    }
    }
    
//    @RequestMapping("/addHollywoodMovies")
//    public String addHollywoodMovies(@ModelAttribute("movies") HollywoodMovies hollywoodMovies)
//    {
//    	return "addHollywoodMovies";
//    }

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
    @RequestMapping(value = "/studentDetail",method={  RequestMethod.POST })
    
    public String saveFee(@ModelAttribute("submitfee") Fee fee,Model model)
    {
    	model.addAttribute("submitfee", fee);
    	System.out.println("Fee"+fee.getFee());
    	fee.setFee("80000");
    	fee.setStudentId("2");
    	Thread1 t1=new Thread1(fee);
        Thread2 t2=new Thread2(fee);
        t1.start();
        t2.start();
    	customerDAO.saveFee(fee);
    	model.addAttribute("studentHome", fee);
    	return "studentDetail";
    }
    @RequestMapping(value = "/fee")
    public ModelAndView fee(@ModelAttribute("fee") Fee fee)
    {
        ModelAndView model = new ModelAndView("fee");
        return model;
    }
    @RequestMapping(value = "/studentHome")
    public ModelAndView studentHome(@ModelAttribute("student") Student student)
    {
        ModelAndView model = new ModelAndView("studentHome");
        List<Student> studentList = customerDAO.getAllStudents();
        System.out.println(studentList);
        model.addObject("student", studentList);
        return model;
    }
    
    @RequestMapping(value = "/studentDetail/{studentId}", method = RequestMethod.GET)
    public ModelAndView studentDetail(@ModelAttribute("submitFee") Student student,@PathVariable("studentId") String studentId)
    {
        ModelAndView model = new ModelAndView("studentDetail");
        Student studentList = customerDAO.getStudentById(studentId);
        System.out.println("particular student"+studentList);
        System.out.println("class"+studentList.getClassName());
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
//        customerDAO.saveFee("2", "3444");
        return model;
    }
    @RequestMapping(value = "/inputStudentDetail")
    public ModelAndView inputStudentDetail(@ModelAttribute("customer") Customer customer)
    {
        ModelAndView model = new ModelAndView("inputStudentDetail");
        return model;
    }
    @RequestMapping(value = "/inputTeacherDetail")
    public ModelAndView inputTeacherDetail(@ModelAttribute("customer") Customer customer)
    {
        ModelAndView model = new ModelAndView("inputTeacherDetail");
        return model;
    }
}
