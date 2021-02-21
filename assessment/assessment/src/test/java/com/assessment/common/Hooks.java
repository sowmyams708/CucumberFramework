package com.assessment.common;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import com.assessment.common.Applib;

public class Hooks {

	public Applib Shutdownhook;

	public Hooks(Applib app) {
		this.Shutdownhook = app;
	}

	@Before
	public void beforeLaunch(Scenario scenario) throws Exception {
		if (!Constants.is_initialized) {
			System.out.println("hooks");
			BaseSelenium.initializeVariable();
			// Shutdownhook.createnewUser(Constants.global_email,
			// Constants.global_phonenumber,
			// Constants.global_password,Constants.global_country_code);
			// Shutdownhook.closeBrowser();
		}
		System.out.println("-----------------------Scenario Name=" + scenario.getName() + " Started-----------------");
	}

	@After
	public void afterExecution(Scenario scenario) throws Exception {
		System.out.println("------------------------Scenario Name=" + scenario.getName() + " Ended Status="
				+ scenario.getStatus() + " --------------------");
		
		Shutdownhook.closeBrowser();


	}

}
