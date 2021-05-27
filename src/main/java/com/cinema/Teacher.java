package com.cinema;

public class Teacher{
	private static final long serialVersionUID = -1280037900360314186L;
    private String name;
    private String number;
    private String email;
    private String attendance;
    private String salary;
    private String subject;
    public Teacher()
    {
        super();
    }
    public Teacher(String name,  String number,  String email,  String attendance,String salary,String subject)
    {
        super();
        this.name=name;
        this.number=number;
        this.email=email;
        this.attendance=attendance;
        this.salary=salary;
        this.subject=subject;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getNumber()
    {
        return number;
    }
    public void setNumber(String number)
    {
        this.number = number;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getAttendance()
    {
        return attendance;
    }
    public void setAttendance(String attendance)
    {
        this.attendance = attendance;
    }
    public String getSubject()
    {
        return subject;
    }
    public void setSubject(String subject)
    {
        this.subject = subject;
    }
    public String getSalary()
    {
        return salary;
    }
    public void setSalary(String salary)
    {
        this.salary = salary;
    }
    synchronized void checkAttendance() {
    	System.out.println("checkAttendance");
    	if(!this.attendance.equals("100%")) {
    		String[] arr = this.attendance.split("%", 0);
    		int leftAttendnce= 100-Integer.parseInt(arr[0]);
    		Integer salary=Integer.parseInt(this.salary)-((Integer.parseInt(this.salary)*leftAttendnce)/100);
    		System.out.println(salary);
    		this.salary=salary.toString();
    	}
    }
    synchronized void giveSalary() {
    	System.out.println("submitFee");
    }
}

class CheckAttendanceThread extends Thread{
	Teacher t1=new Teacher();
	CheckAttendanceThread(Teacher t){
		this.t1=t;
	}
	public void run() {
		t1.checkAttendance();
		System.out.println("CheckAttendanceThread");
	}
}

class GiveSalaryThread extends Thread{
	Teacher t1=new Teacher();
	GiveSalaryThread(Teacher t){
		this.t1=t;
	}
	public void run() {
		t1.giveSalary();
		System.out.println("GiveSalaryThread");
	}
}