package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test
{

	static ArrayList<Course> courseList = new ArrayList<Course>();
	static ArrayList<Semester> semesterList = new ArrayList<Semester>();
	static ArrayList<Section> sectionList = new ArrayList<Section>();

	static Course CPEG202 = new Course(UUID.randomUUID(), "Intro to DIGITAL SYSTEMS", 3);
	static Course CISC181 = new Course(UUID.randomUUID(), "Intro to COMPUTER SCIENCE", 4);
	static Course MATH241 = new Course(UUID.randomUUID(), "ANALYTIC GEOMETRY & CALCULUS A", 4);

	static Semester Fall = new Semester(UUID.randomUUID(), new Date(116, 9, 1), new Date(116, 12, 15));
	static Semester Spring = new Semester(UUID.randomUUID(), new Date(117, 2, 6), new Date(117, 5, 30));

	static Section CPEG2020 = new Section(CPEG202.getCourseID(), Fall.getSemesterID(), UUID.randomUUID(), 117);
	static Section CPEG2021 = new Section(CPEG202.getCourseID(), Spring.getSemesterID(), UUID.randomUUID(), 205);
	static Section CISC1810 = new Section(CISC181.getCourseID(), Fall.getSemesterID(), UUID.randomUUID(), 323);
	static Section CISC1811 = new Section(CISC181.getCourseID(), Spring.getSemesterID(), UUID.randomUUID(), 323);
	static Section MATH2410 = new Section(MATH241.getCourseID(), Fall.getSemesterID(), UUID.randomUUID(), 141);
	static Section MATH2411 = new Section(MATH241.getCourseID(), Spring.getSemesterID(), UUID.randomUUID(), 288);

	@BeforeClass
	public static void setup()
	{
		courseList.add(CPEG202);
		courseList.add(CISC181);
		courseList.add(MATH241);

		semesterList.add(Fall);
		semesterList.add(Spring);

		sectionList.add(CPEG2020);
		sectionList.add(CPEG2021);
		sectionList.add(CISC1810);
		sectionList.add(CISC1811);
		sectionList.add(MATH2410);
		sectionList.add(MATH2411);
	}

	@Test
	public void test() throws PersonException
	{
		Student Larry = new Student(eMajor.BUSINESS);
		Student Rodger = new Student(eMajor.PHYSICS);
		Student Bill = new Student(eMajor.CHEM);
		Student Richard = new Student(eMajor.COMPSI);
		Student Matt = new Student(eMajor.NURSING);
		Student Drew = new Student(eMajor.PHYSICS);
		Student Andy = new Student(eMajor.COMPSI);
		Student Jack = new Student(eMajor.PHYSICS);
		Student Tom = new Student(eMajor.BUSINESS);
		Student Steve = new Student(eMajor.NURSING);

		ArrayList<Student> students = new ArrayList<Student>();

		students.add(Larry);
		students.add(Rodger);
		students.add(Bill);
		students.add(Richard);
		students.add(Matt);
		students.add(Drew);
		students.add(Andy);
		students.add(Jack);
		students.add(Tom);
		students.add(Steve);

		ArrayList<Enrollment> enrolled = new ArrayList<Enrollment>();
		for (Section i : sectionList)
		{
			for (Student j : students)
			{
				enrolled.add(new Enrollment(i.getSectionID(), j.getStudentID()));
			}
		}

		for (Enrollment e : enrolled)
		{
			if (e.getStudentID() == Larry.getStudentID())
			{
				e.setGrade(4.0);
			} 
			else if (e.getStudentID() == Rodger.getStudentID())
			{
				e.setGrade(3.9);
			} 
			else if (e.getStudentID() == Bill.getStudentID())
			{
				e.setGrade(3.8);
			} 
			else if (e.getStudentID() == Richard.getStudentID())
			{
				e.setGrade(3.7);
			} 
			else if (e.getStudentID() == Matt.getStudentID())
			{
				e.setGrade(3.6);
			}
			else if (e.getStudentID() == Drew.getStudentID())
			{
				e.setGrade(3.5);
			}
			else if (e.getStudentID() == Andy.getStudentID())
			{
				e.setGrade(3.4);
			}
			else if (e.getStudentID() == Jack.getStudentID())
			{
				e.setGrade(3.3);
			} 
			else if (e.getStudentID() == Tom.getStudentID())
			{
				e.setGrade(3.2);
			} 
			else if (e.getStudentID() == Steve.getStudentID())
			{
				e.setGrade(3.1);
			}
		}

		int TotalCred = 0;
		for (Section section : sectionList)
		{
			if (section.getCourseID() == CPEG202.getCourseID())
			{
				TotalCred += CPEG202.getGradePoints();
			} 
			else if (section.getCourseID() == CISC181.getCourseID())
			{
				TotalCred += CISC181.getGradePoints();
			}
			else
			{
				TotalCred += MATH241.getGradePoints();
			}
		}

		// Average GPA Testing
		double LarryGPA = 0;
		for (Enrollment e : enrolled)
		{
			if (e.getStudentID() == Larry.getStudentID())
			{
				if (e.getSectionID() == CPEG2020.getSectionID() || e.getSectionID() == CPEG2021.getSectionID())
				{
					LarryGPA += CPEG202.getGradePoints() * e.getGrade();
				} 
				else if (e.getSectionID() == CISC1810.getSectionID() || e.getSectionID() == CISC1811.getSectionID())
				{
					LarryGPA += CISC181.getGradePoints() * e.getGrade();
				} 
				else
				{
					LarryGPA += MATH241.getGradePoints() * e.getGrade();
				}
			}
		}
		LarryGPA /= TotalCred;
		assertEquals(LarryGPA, 4, 0.1);

		double RodgerGPA = 0;
		for (Enrollment e : enrolled)
		{
			if (e.getStudentID() == Rodger.getStudentID())
			{
				if (e.getSectionID() == CPEG2020.getSectionID() || e.getSectionID() == CPEG2021.getSectionID())
				{
					RodgerGPA += CPEG202.getGradePoints() * e.getGrade();
				} 
				else if (e.getSectionID() == CISC1810.getSectionID() || e.getSectionID() == CISC1811.getSectionID())
				{
					RodgerGPA += CISC181.getGradePoints() * e.getGrade();
				} 
				else
				{
					RodgerGPA += MATH241.getGradePoints() * e.getGrade();
				}
			}
		}
		RodgerGPA /= TotalCred;
		assertEquals(RodgerGPA, 3.9, 0.);

		double BillGPa = 0;
		for (Enrollment e : enrolled)
		{
			if (e.getStudentID() == Bill.getStudentID())
			{
				if (e.getSectionID() == CPEG2020.getSectionID() || e.getSectionID() == CPEG2021.getSectionID())
				{
					BillGPa += CPEG202.getGradePoints() * e.getGrade();
				} 
				else if (e.getSectionID() == CISC1810.getSectionID() || e.getSectionID() == CISC1811.getSectionID())
				{
					BillGPa += CISC181.getGradePoints() * e.getGrade();
				} 
				else
				{
					BillGPa += MATH241.getGradePoints() * e.getGrade();
				}
			}
		}
		BillGPa /= TotalCred;
		assertEquals(BillGPa, 3.8, 0.1);

		double RichardGPA = 0;
		for (Enrollment e : enrolled)
		{
			if (e.getStudentID() == Richard.getStudentID())
			{
				if (e.getSectionID() == CPEG2020.getSectionID() || e.getSectionID() == CPEG2021.getSectionID())
				{
					RichardGPA += CPEG202.getGradePoints() * e.getGrade();
				} 
				else if (e.getSectionID() == CISC1810.getSectionID() || e.getSectionID() == CISC1811.getSectionID())
				{
					RichardGPA += CISC181.getGradePoints() * e.getGrade();
				} 
				else
				{
					RichardGPA += MATH241.getGradePoints() * e.getGrade();
				}
			}
		}
		RichardGPA /= TotalCred;
		assertEquals(RichardGPA, 3.7, 0.1);

		double MattGPA = 0;
		for (Enrollment e : enrolled)
		{
			if (e.getStudentID() == Matt.getStudentID())
			{
				if (e.getSectionID() == CPEG2020.getSectionID() || e.getSectionID() == CPEG2021.getSectionID())
				{
					MattGPA += CPEG202.getGradePoints() * e.getGrade();
				} 
				else if (e.getSectionID() == CISC1810.getSectionID() || e.getSectionID() == CISC1811.getSectionID())
				{
					MattGPA += CISC181.getGradePoints() * e.getGrade();
				} 
				else
				{
					MattGPA += MATH241.getGradePoints() * e.getGrade();
				}
			}
		}
		MattGPA /= TotalCred;
		assertEquals(MattGPA, 3.6, 0.1);

		double DrewGPA = 0;
		for (Enrollment e : enrolled)
		{
			if (e.getStudentID() == Drew.getStudentID())
			{
				if (e.getSectionID() == CPEG2020.getSectionID() || e.getSectionID() == CPEG2021.getSectionID())
				{
					DrewGPA += CPEG202.getGradePoints() * e.getGrade();
				} 
				else if (e.getSectionID() == CISC1810.getSectionID() || e.getSectionID() == CISC1811.getSectionID())
				{
					DrewGPA += CISC181.getGradePoints() * e.getGrade();
				} 
				else
				{
					DrewGPA += MATH241.getGradePoints() * e.getGrade();
				}
			}
		}
		DrewGPA /= TotalCred;
		assertEquals(DrewGPA, 3.5, 0.1);

		double AndyGPA = 0;
		for (Enrollment e : enrolled)
		{
			if (e.getStudentID() == Andy.getStudentID())
			{
				if (e.getSectionID() == CPEG2020.getSectionID() || e.getSectionID() == CPEG2021.getSectionID())
				{
					AndyGPA += CPEG202.getGradePoints() * e.getGrade();
				} 
				else if (e.getSectionID() == CISC1810.getSectionID() || e.getSectionID() == CISC1811.getSectionID())
				{
					AndyGPA += CISC181.getGradePoints() * e.getGrade();
				} 
				else
				{
					AndyGPA += MATH241.getGradePoints() * e.getGrade();
				}
			}
		}
		AndyGPA /= TotalCred;
		assertEquals(AndyGPA, 3.4, 0.1);

		double JackGPA = 0;
		for (Enrollment e : enrolled)
		{
			if (e.getStudentID() == Jack.getStudentID())
			{
				if (e.getSectionID() == CPEG2020.getSectionID() || e.getSectionID() == CPEG2021.getSectionID())
				{
					JackGPA += CPEG202.getGradePoints() * e.getGrade();
				} 
				else if (e.getSectionID() == CISC1810.getSectionID() || e.getSectionID() == CISC1811.getSectionID())
				{
					JackGPA += CISC181.getGradePoints() * e.getGrade();
				} 
				else{
					JackGPA += MATH241.getGradePoints() * e.getGrade();
				}
				{

				}
			}
			JackGPA /= TotalCred;
			assertEquals(JackGPA, 3.3, 0.1);

			double TomGPA = 0;
			for (Enrollment e1 : enrolled)
			{
				if (e1.getStudentID() == Jack.getStudentID())
				{
					if (e1.getSectionID() == CPEG2020.getSectionID() || e1.getSectionID() == CPEG2021.getSectionID())
					{
						TomGPA += CPEG202.getGradePoints() * e1.getGrade();
					} 
					else if (e1.getSectionID() == CISC1810.getSectionID() || e1.getSectionID() == CISC1811.getSectionID())
					{
						TomGPA += CISC181.getGradePoints() * e1.getGrade();
					} 
					else{
						TomGPA += MATH241.getGradePoints() * e1.getGrade();
					}
					{

					}
				}
				TomGPA /= TotalCred;
				assertEquals(TomGPA, 3.2, 0.1);

				double SteveGPA = 0;
				for (Enrollment e0 : enrolled)
				{
					if (e0.getStudentID() == Steve.getStudentID())
					{
						if (e0.getSectionID() == CPEG2020.getSectionID() || e0.getSectionID() == CPEG2021.getSectionID())
						{
							SteveGPA += CPEG202.getGradePoints() * e0.getGrade();
						} 
						else if (e0.getSectionID() == CISC1810.getSectionID() || e0.getSectionID() == CISC1811.getSectionID())
						{
							SteveGPA += CISC181.getGradePoints() * e0.getGrade();
						} 
						else{
							SteveGPA += MATH241.getGradePoints() * e0.getGrade();
						}
						{

						}
					}
					SteveGPA /= TotalCred;
					assertEquals(SteveGPA, 3.2, 0.1);



					// CourseAverage Testing
					double CPEGAvg = 0;
					double CISCAvg = 0;
					double MATHAvg = 0;
					for (Enrollment e3 : enrolled)
					{
						if (e3.getSectionID() == CPEG2020.getSectionID() || e3.getSectionID() == CPEG2020.getSectionID())
						{
							CPEGAvg += e3.getGrade();
						} 
						else if (e3.getSectionID() == CISC1810.getSectionID() || e3.getSectionID() == CISC1810.getSectionID())
						{
							CISCAvg += e3.getGrade();
						} 
						else
						{
							MATHAvg += e3.getGrade();
						}
					}
					CPEGAvg /= (enrolled.size() / 3);
					CISCAvg /= (enrolled.size() / 3);
					MATHAvg /= (enrolled.size() / 3);

					assertEquals(CPEGAvg, 3.55, 0.01);
					assertEquals(CISCAvg, 3.55, 0.01);
					assertEquals(MATHAvg, 3.55, 0.01);

					//MajorChange
					Student Lesley = new Student(eMajor.NURSING);
					assertTrue(Lesley.getMajor() == eMajor.NURSING);
					Lesley.setMajor(eMajor.CHEM);
				}
			}
		}
	}
}