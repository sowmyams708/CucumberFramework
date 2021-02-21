package com.assessment.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Applib extends BaseSelenium {

	public void launchBrowser() throws Exception {
		try {
			OpenBrowser();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void closeBrowser() {
		driver.close();
	}
	public void logintoaccount() {
		try {
			String email = "#identifierId";
			String next = "#identifierNext > div > button > div.VfPpkd-RLmnJb";
			String pwd = "#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input";
			String nextpwd = "#passwordNext > div > button";
			String settings = "#gbwa > div > a > svg";
			String mailele = "#yDmH0d > c-wiz > div > div > c-wiz > div > div > ul.LVal7b.u4RcUd > li> a";
			String mailurl = "https://mail.google.com/mail/u/0/#inbox";
			
			type(email,"CSS","email12@test.com");
			Thread.sleep(1000);
			click(next,"CSS");
			Thread.sleep(3000);
			type(pwd,"CSS","pwd");
			Thread.sleep(1000);
			click(nextpwd,"CSS");
			Thread.sleep(3000);
			driver.get("https://mail.google.com/mail/u/0/#inbox");
			Thread.sleep(5000);


		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void fetchcontentandselect(String value, String ObjectArray) throws Exception {
		try {
			Thread.sleep(1000);
			boolean flag = false;
			List<WebElement> element = getWebElements(ObjectArray, "CSS");
			for (int i = 0; i < element.size(); i++) {
				if (element.get(i).getAttribute("href").contains(value)) {
					flag = true;
					Thread.sleep(1000);
					mouseOver(element.get(i));
					Thread.sleep(1000);
					element.get(i).click();
					break;
				}
			}
			if (!flag)
				throw new Exception(" not found in ");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void clickoncomposemmail() throws Exception
	{
		try
		{
			String compmail = "[gh='cm']";
			if(checkElementExist(compmail,"CSS"))
			{
				System.out.println("Compose mail button is visible");
			}
			driver.get("https://mail.google.com/mail/u/0/#inbox");
			click(compmail,"CSS");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void addaddress() throws Exception
	{
		try
		{
			String to = "#\\:r8";
			String toadd= ".//textarea[contains(@aria-label, 'To')]";
			String cc = "#\\:nx";
			String ccadd = "#\\:r9";
			String bcc = "#\\:ny";
			String bccadd = "#\\:ra";
			String iframename = "#oauth2relay766960332";


			click(toadd,"XPATH");
			type(toadd,"XPATH","abcde@gmail.com");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void addsubjectandbody(String sub) throws Exception
	{
		try
		{
			Thread.sleep(2000);
			String subject = "subjectbox";
			String body = "(.//*[@aria-label='Message Body'])[2]";

			click(subject,"NAME");
			type(subject,"NAME",sub);
			Thread.sleep(2000);
			click(body,"XPATH");
			type(body,"XPATH","randomtext");
			Thread.sleep(2000);

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void clickonsend() throws Exception
	{
		try
		{
			String send = "//div[contains(@data-tooltip,\"Send\")]";

			click(send,"XPATH");
			
			Thread.sleep(30000);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void attachfiles(String type) throws Exception
	{
		try
		{
			String workingDir = System.getProperty("user.dir");
			String attachment = "//input[@name='attach']";
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("document.getElementsByName('attach')[0].setAttribute('type', 'file');");
			driver.findElement(By.xpath(attachment)).clear();
			driver.findElement(By.xpath(attachment)).sendKeys(workingDir+"/github11.png");
			Thread.sleep(30000);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
