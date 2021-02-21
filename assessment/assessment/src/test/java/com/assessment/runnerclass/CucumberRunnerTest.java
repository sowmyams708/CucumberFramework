package com.assessment.runnerclass;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

@RunWith(Cucumber.class)
//@RunWith(ExtendedCucumber.class)

@CucumberOptions(plugin = { "io.qameta.allure.cucumberjvm.AllureCucumberJvm" }, features = {
		"src/test/java/featurefiles/composemail.feature" }, glue = { "com.assessment.stepdefinition",
				"com.assessment.common"}, monochrome = true)
//@ExtendedCucumberOptions(jsonReport="target/cucumber.json",retryCount = 1)
public class CucumberRunnerTest {

	/**
	 * @BeforeClass public static void before() { System.out.println("Inside Junit
	 *              Before class"); }
	 * 
	 * @AfterClass public static void after() { System.out.println("Inside Junit
	 *             after class"); }
	 **/

}
