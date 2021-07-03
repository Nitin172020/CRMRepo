package com.crm.testcases;

import org.testng.annotations.Test;

public class TestNGGroupDemo {

	@Test(groups= {"Sanity"})
	public void test1()
	{
	
		System.out.println("This is Test case 1");
	}

	@Test(groups= {"Sanity","Smoke"})
	public void test2()
	{
	
		System.out.println("This is Test case 2");
	}
	
	@Test(groups= {"Regression"})
	public void test3()
	{
	
		System.out.println("This is Test case 3");
	}
	
	@Test(groups= {"Smoke","Regression"})
	public void test4()
	{
	
		System.out.println("This is Test case 4");
	}
	
	@Test(groups= {"Regression","Sanity"})
	public void test5()
	{
	
		System.out.println("This is Test case 5");
	}
	
	@Test(groups= {"Sanity", "Smoke"})
	public void test6()
	{
	
		System.out.println("This is Test case 6");
	}


	
	
}
