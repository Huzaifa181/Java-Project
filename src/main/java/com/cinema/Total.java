package com.cinema;

public final class Total {
	static int students;
	static int teachers;
	public Total(int stu, int tea) {
		Total.students=stu;
		Total.teachers=tea;
	}
	public static int getTotalStudents()
    {
        return students;
    }
   
    public static int getTotalTeachers()
    {
        return teachers;
    }
}
