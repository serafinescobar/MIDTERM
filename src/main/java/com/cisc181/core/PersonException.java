package com.cisc181.core;

public class PersonException extends Exception
{
	private Person x;
	public PersonException(Person x)
	{
		this.x = x;
	}
	public Person getx()
	{
		return x;
	}
}
