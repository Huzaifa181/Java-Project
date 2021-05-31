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
public class SchoolController{
	@Autowired
	private SchoolDAO schoolDAO;
	String adminEmail=null;
	String adminPassword=null;
    @RequestMapping(value = "/home",method={ RequestMethod.GET, RequestMethod.POST })
    public String saveCustomer(@ModelAttribute("customer") User user,Model model)
    {
    	try
        {
    		List<Student> studentList = schoolDAO.getAllStudents();
			List<Teacher> teacherList = schoolDAO.getAllTeachers();
			System.out.println("Teacher List"+teacherList.size());
			Total total=new Total(studentList.size(), teacherList.size());
    		System.out.println("AdminEmail"+adminEmail);
    		System.out.println("User"+user);
    		System.out.println("Student List Size"+studentList.size());
    		if(user.getEmail()!=null) {	
    			System.out.println("UserBock");
    			if(user.getEmail().equals("admin@gmail.com") && user.getPassword().equals("admin")) {
    				adminEmail=user.getEmail();
    				adminPassword=user.getPassword();
    				model.addAttribute("Tteacher", Total.getTotalTeachers());
    				model.addAttribute("Tstudent", Total.getTotalStudents());
    			}
    		}
    		else {			
    			if(adminEmail.equals("admin@gmail.com") && adminPassword.equals("admin")) {
    				model.addAttribute("Tteacher", Total.getTotalTeachers());
    				model.addAttribute("Tstudent", Total.getTotalStudents());
    			}
    			else
    			{
    				System.out.println("Else block");
    				return "redirect:/login";
    			}	
    		}
        }
        catch(NullPointerException e)
        {
        	System.out.println("Catch block");
        	return "redirect:/login";
        }
		return "home";
    	
    }
    String studentId=null;
    String studentEmail=null;
    @RequestMapping(value = "/studentDashboard",method={ RequestMethod.GET, RequestMethod.POST })
    public String studentDashboard(@ModelAttribute("user") User user,Model model)
    {
    	try
        {
        		if(user.getEmail()==null) {			
        			Student student=schoolDAO.loginAsStudent(studentEmail);
        			studentId=student.getStudentId();
        			studentEmail=student.getEmail();
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
        			model.addAttribute("studyGroup", student.getStudyGroup());
        			model.addAttribute("Tteacher", Total.getTotalTeachers());
        			model.addAttribute("Tstudent", Total.getTotalStudents());
        			return "studentDashboard";
        		}
        		else {
        			Student student=schoolDAO.loginAsStudent(user.getEmail());
        			studentId=student.getStudentId();
        			studentEmail=student.getEmail();
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
        			model.addAttribute("studyGroup", student.getStudyGroup());
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
    public String teacherDashboard(@ModelAttribute("user") User user,Model model)
    {
    	try
        {
    		if(user.getEmail()==null) {	
    			Teacher teacher=schoolDAO.loginAsTeacher(email);
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
    			Teacher teacher=schoolDAO.loginAsTeacher(user.getEmail());
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
    @RequestMapping(value = "/login")
    public ModelAndView login(@ModelAttribute("user") User user)
    {
        ModelAndView model = new ModelAndView("login");
        return model;
    }
  
    @RequestMapping(value = "/teacherDetail",method={ RequestMethod.POST })
    public String saveSalary(@ModelAttribute("salary") Teacher teacher,Model model)
{
    	schoolDAO.savePriceAdminAccount(0,"get");

    	model.addAttribute("Tteacher", Total.getTotalTeachers());
    	model.addAttribute("Tstudent", Total.getTotalStudents());
    	teacher.setMessage("Initialize");
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
        if(teacher.getMessage().equals("Less Balance in Account")) { 
     	   AddPriceInAccount t3=new AddPriceInAccount(Integer.parseInt(teacher.getSalary())+10000);
     	   t3.start();  
     	   try {
              t3.join();
              schoolDAO.savePriceAdminAccount(Integer.parseInt(teacher.getSalary())+10000,"add");     	   }
     	   catch ( Exception e) {
     		   System.out.println("Interruptedd");
     	   }
        }
        schoolDAO.savePriceAdminAccount(Integer.parseInt(teacher.getSalary()),"give Salary");
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
    	schoolDAO.submitFee(fee.getFee());	
            	return "fee";
    }
    @RequestMapping(value = "/studentHome")
    public ModelAndView studentHome(@ModelAttribute("student") Student student)
    {
        ModelAndView model = new ModelAndView("studentHome");
        List<Student> studentList = schoolDAO.getAllStudents();
        model.addObject("student", studentList);
        model.addObject("Tteacher", Total.getTotalTeachers());
        model.addObject("Tstudent", Total.getTotalStudents());
        return model;
    }
    @RequestMapping(value = "/teacherHome")
    public ModelAndView teacherHome(@ModelAttribute("teacher") Teacher teacher)
    {
        ModelAndView model = new ModelAndView("teacherHome");
        List<Teacher> teacherList = schoolDAO.getAllTeachers();
        model.addObject("Tteacher", Total.getTotalTeachers());
        model.addObject("Tstudent", Total.getTotalStudents());
        model.addObject("teacher", teacherList);
        return model;
    }
    
    //For particular class
    @RequestMapping(value = "/classes/{className}", method = RequestMethod.GET)
    public ModelAndView classDetail(@ModelAttribute("className") Student student,@PathVariable("className") String className)
    {
    	ModelAndView model = new ModelAndView("particularClassInfo");
        List<Student> studentList = schoolDAO.getStudentByClass(className);
        model.addObject("student", studentList);
        List<Teacher> teacherList = schoolDAO.getTeacherByClass(className);
        model.addObject("teacher", teacherList);
        model.addObject("Tteacher", Total.getTotalTeachers());
        model.addObject("Tstudent", Total.getTotalStudents());
        return model;
    }
    
    @RequestMapping(value = "/studentDetail/{studentId}", method = RequestMethod.GET)
    public ModelAndView studentDetail(@ModelAttribute("submitFee") Student student,@PathVariable("studentId") String studentId)
    {
        ModelAndView model = new ModelAndView("studentDetail");
        Student studentList = schoolDAO.getStudentById(studentId);
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
        return model;
    }

    @RequestMapping(value = "/teacherDetail/{teacherId}", method = RequestMethod.GET)
    public ModelAndView teacherDetail(@ModelAttribute("teacher") Teacher teacher,@PathVariable("teacherId") String teacherId)
    {
        ModelAndView model = new ModelAndView("teacherDetail");
        Teacher teacherList = schoolDAO.getTeacherById(teacherId);
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
    			schoolDAO.addTeacher(teacher);	
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
    			schoolDAO.addStudent(student);	
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
        Teacher teacher = schoolDAO.getTeacherAttendance(teacherId);
        model.addObject("attendance", teacher.getAttendance());
        return model;
    }

}
