package com.cinema;

public class Student {
	private static final long serialVersionUID = -1280037900360314186L;
    private String name;
    private String studentId;
    private String fatherName;
    private String rollNo;
    private String gender;
    private String dateOfBirth;
    private String age;
    private String mobileNo;
    private String className;
    private String fee;
    private String studyGroup;
    public Student()
    {
        super();
    }
    public Student(String studentId,String name,String fatherName,String rollNo,String gender,String dateOfBirth, String age,  String mobileNo,  String className,  String fee,  String studyGroup)
    {
        super();
        this.studentId=studentId;
        this.name = name;
        this.name = fatherName;
        this.rollNo	= rollNo;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.mobileNo = mobileNo;
        this.className = className;
        this.fee = fee;
        this.studyGroup= studyGroup;
    }
    public String getStudentId()
    {
        return studentId;
    }
    public void setStudentId(String studentId)
    {
        this.studentId = studentId;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getFatherName()
    {
        return fatherName;
    }
    public void setFatherName(String fatherName)
    {
        this.fatherName = fatherName;
    }
    public String getRollNo()
    {
        return rollNo;
    }
    public void setRollNo(String rollNo)
    {
        this.rollNo = rollNo;
    }
    public String getGender()
    {
        return gender;
    }
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    public String getDateOfBirth()
    {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }
    public String getAge()
    {
        return age;
    }
    public void setAge(String age)
    {
        this.age = age;
    }
    public String getMobileNo()
    {
        return mobileNo;
    }
    public void setMobileNo(String mobileNo)
    {
        this.mobileNo = mobileNo;
    }
    public String getClassName()
    {
        return className;
    }
    public void setClassName(String className)
    {
        this.className = className;
    }
    public String getFee()
    {
        return fee;
    }
    public void setFee(String fee)
    {
        this.fee = fee;
    }
    public String getStudyGroup()
    {
        return studyGroup;
    }
    public void setstudyGroup(String studyGroup)
    {
        this.studyGroup = studyGroup;
    }

    @Override
    public String toString()
    {
        return "Student [name=" + name + ", gender=" + gender + ", date of birth=" + dateOfBirth + ", date of birth=" + dateOfBirth + "]";
    }
}
