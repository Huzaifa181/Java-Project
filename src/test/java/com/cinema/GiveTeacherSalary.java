package com.cinema;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GiveTeacherSalary {
	@Test
	void test() {
		Teacher teacher=new Teacher("2","add","II","Huzaifa","03352163311","huzai","100%","90000","Science");
		teacher.checkAttendance();
		CheckAttendanceThread t1=new CheckAttendanceThread(teacher);
    	GiveSalaryThread t2=new GiveSalaryThread(teacher);
    	int depositedAmount=10000;
        t1.start();
        t2.start();
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
              System.out.println(
  "Add Price in Account if Less Balance in Account than Teacher Salary"
              +(teacher.getSalary()+10000+depositedAmount));
     	   }
     	   catch ( Exception e) {
     		   System.out.println("Interruptedd");
     	   }
        }
        System.out.println(
       "Deduct Teacher Salary From Admin Account"+
        (depositedAmount-Integer.parseInt(teacher.getSalary())));
	}

}
