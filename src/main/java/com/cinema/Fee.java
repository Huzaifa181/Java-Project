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
}