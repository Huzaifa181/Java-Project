package com.cinema;
import java.util.List;

public interface SchoolDAO {
	public void saveUser(User user);
	public void addStudent(Student student);
	public void addTeacher(Teacher teacher);
	public Teacher getTeacherAttendance(String id);
	public Student loginAsStudent(String email);
	public Teacher loginAsTeacher(String email);
	public void submitFee(String price);
    public Student getStudentById(String studentId);
    public List<Student> getStudentByClass(String className);
    public List<Teacher> getTeacherByClass(String className);
    public Teacher getTeacherById(String teacherId);
    public void savePriceAdminAccount(int price, String add);
    public List<Student> getAllStudents();
    public List<Teacher> getAllTeachers();
}
