package com.userregistration.appexecution;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import com.userregistration.boundarycases.TestBoundary;
import com.userregistration.exceptioncases.TestException;
import com.userregistration.functionalcases.TestFunctional;



public class TestCaseExecutor {
	@Test
	public void test() {
		//fail("Not yet implemented");
		JUnitCore junit = new JUnitCore();
		junit.addListener(new TextListener(System.out));
		Result result = junit.run(TestFunctional.class);
		try {
			resultFunctionalReport(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = junit.run(TestException.class);
		try {
			resultExceptionConditionReport(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = junit.run(TestBoundary.class);

		try {
			resultBoundaryConditionReport(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@SuppressWarnings("deprecation")
	public static void resultFunctionalReport(Result result) throws IOException {
	    System.out.println("Finished... Result: Failures: " +
	      result.getFailureCount() + ". Ignored: " +
	      result.getIgnoreCount() + ". Tests run: " +
	      result.getRunCount() + ". Time: " +
	      result.getRunTime() + "ms." );
	    String res = "";
	    res += "Total="+result.getRunCount()+"\nFailed="+result.getFailureCount()+"\nIgnore="+result.getIgnoreCount()+"\nExecTime="+result.getRunTime();
	    FileUtils.writeStringToFile(new File("output.txt"), res);
	}
	@SuppressWarnings("deprecation")
	public static void resultExceptionConditionReport(Result result) throws IOException {
	    System.out.println("Finished... Result: Failures: " +
	      result.getFailureCount() + ". Ignored: " +
	      result.getIgnoreCount() + ". Tests run: " +
	      result.getRunCount() + ". Time: " +
	      result.getRunTime() + "ms." );
	    String res = "";
	    res += "Total="+result.getRunCount()+"\nFailed="+result.getFailureCount()+"\nIgnore="+result.getIgnoreCount()+"\nExecTime="+result.getRunTime();
	    FileUtils.writeStringToFile(new File("output_exception.txt"), res);
	}
	@SuppressWarnings("deprecation")
	public static void resultBoundaryConditionReport(Result result) throws IOException {
	    System.out.println("Finished... Result: Failures: " +
	      result.getFailureCount() + ". Ignored: " +
	      result.getIgnoreCount() + ". Tests run: " +
	      result.getRunCount() + ". Time: " +
	      result.getRunTime() + "ms." );
	    String res = "";
	    res += "Total="+result.getRunCount()+"\nFailed="+result.getFailureCount()+"\nIgnore="+result.getIgnoreCount()+"\nExecTime="+result.getRunTime();
	    FileUtils.writeStringToFile(new File("output_boundary.txt"), res);
	}

}
