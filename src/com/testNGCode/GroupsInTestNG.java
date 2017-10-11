package com.testNGCode;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsInTestNG {

	@BeforeGroups({ "secondGroup", "firstGroup" })
	public void executeBeforeGroup() {
		System.out.println("executeBefore both Group");
	}

	@AfterGroups("firstGroup")
	public void executeAfterGroup() {
		System.out.println("executeAfter firstGroup");
	}

	@Test(groups = "firstGroup")
	public void method1() {
		System.out.println("method1");
	}

	@Test(groups = "firstGroup")
	public void method2() {
		System.out.println("method2");
	}

	@Test(groups = "secondGroup")
	public void method3() {
		System.out.println("method3");
	}

	@Test(groups = "secondGroup")
	public void method4() {
		System.out.println("method4");
	}

	@Test(dependsOnGroups = { "secondGroup", "firstGroup" })
	public void method5() {
		System.out.println("if both group passed then method5 test will execute");
	}
}
