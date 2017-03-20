package com.cisc181.core;

import java.util.UUID;

public class Enrollment
{
	private UUID StudentID;
	private UUID SectionID;
	private UUID EnrollmentID;
	private double Grade;

	private Enrollment()
	{

	}
	Enrollment(UUID StudentID, UUID SectionID)
	{
		this.SectionID = SectionID;
		this.StudentID = StudentID;
		this.EnrollmentID = UUID.randomUUID();
	}
	
	public UUID getStudentID()
	{
		return StudentID;
	}
	public void setStudentID(UUID studentID)
	{
		StudentID = studentID;
	}
	public UUID getSectionID()
	{
		return SectionID;
	}
	public void setSectionID(UUID sectionID) 
	{
		SectionID = sectionID;
	}
	public double getGrade() 
	{
		return Grade;
	}
	public void setGrade(double grade) 
	{
		Grade = grade;
	}
	
	
	

}
