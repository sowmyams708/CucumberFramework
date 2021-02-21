package com.assessment.stepdefinition;

import org.testng.Assert;

import com.assessment.common.Applib;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Composemail {
	Applib app;

	public Composemail(Applib app) {
		this.app = app;
	}

	@Given("^user logs into gmail account$")
	public void user_navigates_to_gmail_website() {
		try {
			app.launchBrowser();
			app.logintoaccount();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Then("^click on compose mail$")
	public void click_on_compose_mail() {
		try {
			System.out.println("fgfghfg");
			app.clickoncomposemmail();
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@And("^Verify To,CC,BCC CTA$")
	public void verify_ctas() {
		try {
			System.out.println("fgfghfg");
			app.addaddress();
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@And("^Add Subject as \"([^\"]*)\" and add body of the mail$")
	public void add_subject(String sub) {
		try {
			System.out.println("fgfghfg");
			app.addsubjectandbody(sub);
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@And("^Attach the files$")
	public void attachthefiles() {
		try {
			System.out.println("fgfghfg");
			app.attachfiles("img");
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	@And("^Click on send$")
	public void click_on_send() {
		try {
			System.out.println("fgfghfg");
			app.clickonsend();
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
}
