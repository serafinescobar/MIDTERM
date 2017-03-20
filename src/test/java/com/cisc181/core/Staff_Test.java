package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cisc181.core.Staff;
import com.cisc181.eNums.eTitle;

public class Staff_Test
{

	@BeforeClass
	public static void setup()
	{
		Staff Leti = new Staff(eTitle.MRS, 50000.00);
		Staff Adam = new Staff(eTitle.MR, 55000.00);
		Staff Trevor = new Staff(eTitle.MR, 60000.00);
		Staff Alondra = new Staff(eTitle.MR, 65000.00);
		Staff Serafin = new Staff(eTitle.MR, 75000.00);
		
		ArrayList<Staff> staffListT = new ArrayList<Staff>();
		staffListT.add(Leti);
		staffListT.add(Adam);
		staffListT.add(Trevor);
		staffListT.add(Alondra);
		staffListT.add(Serafin);
		
		double totalSalary = 0;
		double ExpAvgSalary = (50000 + 55000 + 60000 + 65000 + 75000)/5;
		for(Staff i : staffListT)
		{
			totalSalary += i.getSalary();
		}
		double AvgSalary = totalSalary / 5;	
		
		assertEquals(ExpAvgSalary, AvgSalary, 0.01);
		
	}


	@Test (expected = PersonException.class)
	public void PersonExceptionTest1() throws PersonException {
		Staff Ryan = new Staff (eTitle.MR, "1(302)2944293");
	}
	

	@Test (expected = PersonException.class)
	public void PersonExpceptionTest2() throws PersonException {
		Staff Stanley = new Staff (eTitle.MR);
		Stanley.setDOB(new Date(12,7,3));
}

}
