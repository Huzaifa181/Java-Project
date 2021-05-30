package com.cinema;

public class Teacher{
	private static final long serialVersionUID = -1280037900360314186L;
	private String teacherId;
	private String name;
    private String number;
    private String email;
    private String attendance;
    private String salary;
    private String subject;
    private String message;
    private String className;
    public Teacher()
    {
        super();
    }
    public Teacher(String teacherId,String message,String className,String name,  String number,  String email,  String attendance,String salary,String subject)
    {
        super();
        this.teacherId=teacherId;
        this.name=name;
        this.number=number;
        this.email=email;
        this.attendance=attendance;
        this.salary=salary;
        this.message=message;
        this.subject=subject;
        this.className=className;
    }
    public String getTeacherId()
    {
        return teacherId;
    }
    public void setTeacherId(String teacherId)
    {
        this.teacherId = teacherId;
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
    public String getMessage()
    {
        return message;
    }
    public void setMessage(String message)
    {
        this.message = message;
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
    public String getClassName()
    {
        return className;
    }
    public void setClassName(String className)
    {
        this.className = className;
    }
    synchronized void checkAttendance() {
    	System.out.println("checkAttendance");
    	if(!this.attendance.equals("100%")) {
    		String[] arr = this.attendance.split("%", 0);
    		int leftAttendnce= 100-Integer.parseInt(arr[0]);
    		Integer salary=Integer.parseInt(this.salary)-((Integer.parseInt(this.salary)*leftAttendnce)/100);
    		System.out.println("checkAttendance"+salary);
    		this.salary=salary.toString();
    	}
    }
    synchronized void giveSalary() {
    	System.out.println("submitFee");
    	System.out.println(this.salary+"ui");
    	System.out.println(Account.price+"Accc");
    	if(Account.price<Integer.parseInt(this.salary)) {
    		this.setMessage("Less Balance in Account");
    		System.out.println("Less Balance in Account"+salary);
    		try {
    			System.out.println("uiiii");
//    			wait();
    		}
    		catch(Exception e) {}
    		System.out.println("checkAttendanceio"+salary);
    	}
    	System.out.println("Account.setPrice"+salary);
//    	Account.setPrice(Account.price-Integer.parseInt(this.salary));
    }
    synchronized void addPrice(int price) {
    	System.out.println("addPrice"+salary);
//    	notifyAll();
    }
    @Override
    public String toString()
    {
        return "Teacher [name=" + name + ", number=" + number + ", email=" + email +  "]";
    }
}

class CheckAttendanceThread extends Thread{
	Teacher t1=new Teacher();
	CheckAttendanceThread(Teacher t){
		this.t1=t;
	}
	public void run() {
		synchronized (t1) {	
		t1.checkAttendance();
		System.out.println("CheckAttendanceThread");
		}
	}
}

class GiveSalaryThread extends Thread{
	Teacher t1=new Teacher();
	GiveSalaryThread(Teacher t){
		this.t1=t;
	}
	public void run() {
		synchronized (t1) {	
			t1.giveSalary();
			System.out.println("GiveSalaryThread");
		}
	}
}
class AddPriceInAccount extends Thread{
	Teacher t1=new Teacher();
	int price;
	AddPriceInAccount(int price){
		this.price=price;
	}
	public void run() {
		synchronized (t1) {	
		t1.addPrice(this.price);
		System.out.println("AddPriceThread");
		}
	}
}