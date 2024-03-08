package sample;

import org.testng.annotations.Test;

public class Sample 
{
	@Test(groups="Smoke")
	public void test1()
	{
		System.out.println("I am Test1");
	}
	
	@Test(groups="Regression")
	public void test2()
	{
		System.out.println("I am Test2");
	}
	
	@Test(groups="Smoke")
	public void test3()
	{
		System.out.println("I am Test3");
	}	
}
