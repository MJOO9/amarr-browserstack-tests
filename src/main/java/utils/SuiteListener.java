package utils;

import java.io.File;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.browserstack.SeleniumTest;






public class SuiteListener implements ITestListener , IAnnotationTransformer {


	  @Override
	    public void onTestFailure(ITestResult result) {
	        String fileName = System.getProperty("user.dir") + File.separator + ("target") + File.separator + result.getMethod().getMethodName();
	        // ITestListener.super.onTestFailure(result);
	        File f = ((TakesScreenshot) SeleniumTest.driver).getScreenshotAs(OutputType.FILE);
	        try {
	            FileUtils.copyFile(f, new File(fileName + ".png"));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyser.class);
    }



}