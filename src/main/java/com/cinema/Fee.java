package com.cinema;

public class Fee{
	private static final long serialVersionUID = -1280037900360314186L;
    private String fee;
    private String studentId;
    
    public Fee()
    {
        super();
    }
    public Fee(String studentId,String fee)
    {
        super();
        this.studentId=studentId;
        this.fee=fee;
    }
    public String getStudentId()
    {
        return studentId;
    }
    public void setStudentId(String studentId)
    {
        this.studentId = studentId;
    }
    public String getFee()
    {
        return fee;
    }
    public void setFee(String fee)
    {
        this.fee = fee;
    }
    synchronized void checkAttendance() {
    	System.out.println("checkAttendance");
    }
    synchronized void submitFee() {
    	System.out.println("submitFee");
    }
}

class Thread1 extends Thread{
	Fee fee=new Fee();
	Thread1(Fee f){
		this.fee=f;
	}
	public void run() {
		fee.checkAttendance();
		System.out.println("Thread1");
	}
}

class Thread2 extends Thread{
	Fee fee=new Fee();
	Thread2(Fee f){
		this.fee=f;
	}
	public void run() {
		fee.submitFee();
		System.out.println("Thread2");
	}
}