package com.assessment.common;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;

public class BaseSelenium {
	protected WebDriver driver;

	protected enum LOCATOR_TYPE {
		ID, NAME, LINK, XPATH, JSSCRIPT, PARTIALLINK, CSS
	};
	public static void initializeVariable() throws Exception {
		String workingDir = System.getProperty("user.dir");
		System.out.println(workingDir);

		try {
			if (!Constants.is_initialized_variable) {
				Constants.prop.load(new FileInputStream(new File(workingDir + "/Automation.properties")));
				Constants.base_url = Constants.prop.getProperty("BaseURL");
				Constants.browser = Constants.prop.getProperty("Browser");
				Constants.firefox_driver_path = workingDir + "/" + Constants.prop.getProperty("FirefoxDriverPath");
				Constants.chrome_driver_path = workingDir + "/" + Constants.prop.getProperty("ChromeDriverPath");
				Constants.ie_driver_path = Constants.prop.getProperty("IEDriverPath");
				Constants.explicit_wait_time = Integer.parseInt(Constants.prop.getProperty("Explicit_wait_time"));
				Constants.implicit_wait_time = Integer.parseInt(Constants.prop.getProperty("Implicit_wait_time"));
				Constants.page_load_time = Integer.parseInt(Constants.prop.getProperty("Max_page_load_time"));
				
				System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
				System.setProperty("webdriver.gecko.driver", Constants.firefox_driver_path);
				System.setProperty("webdriver.chrome.driver", Constants.chrome_driver_path);
				Constants.is_initialized_variable = true;
			}
		} catch (Exception e) {
			System.out.println("Error during initialization of Variables, Hence Quittting");
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void OpenBrowser() throws Exception {
		try {
//			proxy = getProxyServer();
//			Proxy seleniumProxy = getSeleniumProxy(proxy);
			if (Constants.browser.toLowerCase().equals("firefox")) {
				FirefoxOptions options = new FirefoxOptions();
//				options.setCapability(CapabilityType.PROXY, seleniumProxy);
				driver = new FirefoxDriver(options);
			} else if (Constants.browser.toLowerCase().equals("chrome")) {
				ChromeOptions options = new ChromeOptions();
// 				options.setCapability(CapabilityType.PROXY, seleniumProxy);
				options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				options.setCapability(ChromeOptions.CAPABILITY, true);
				options.addArguments("--ignore-certificate-errors");
				options.addArguments("--enable-automation");
				options.addArguments("--window-size=1920x1080");
				options.addArguments("--start-maximized");
// 				options.addArguments("--headless");
				options.addArguments("--disable-gpu");
				options.addArguments("--disable-infobars");
				// options.addArguments("--remote-debugging-port=9222");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-setuid-sandbox");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--dns-prefetch-disable");
				options.addArguments("--disable-infobars");
				options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

				options.setCapability("silent", true);
				driver = new ChromeDriver(options);
				// driver=new ChromeDriver();

			}

			else {
				throw new Exception("Browser not supported");
			}

			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(Constants.base_url);
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	public void type(String Locator, String LocatorType, String Value)
			throws Exception {
		switch (LOCATOR_TYPE.valueOf(LocatorType)) {
		case ID:
			driver.findElement(By.id(Locator)).sendKeys(Value);
			break;

		case NAME:
			driver.findElement(By.name(Locator)).sendKeys(Value);
			break;

		case XPATH:
			driver.findElement(By.xpath(Locator)).sendKeys(Value);
			break;

		case CSS:
			driver.findElement(By.cssSelector(Locator))
					.sendKeys(Value);
			break;

		default:
			throw new Exception(
					"Invalid Locator Type/Locator Type may not be supported");
		}
	}
	
	
	public void click(String Locator, String LocatorType) throws Exception {
		//scrollIntoViewAndClick(Locator, LocatorType);
		switch (LOCATOR_TYPE.valueOf(LocatorType)) {
		case ID:
			driver.findElement(By.id(Locator)).click();
			break;

		case NAME:
			driver.findElement(By.name(Locator)).click();
			break;

		case XPATH:
			driver.findElement(By.xpath(Locator)).click();
			break;

		case CSS:
			driver.findElement(By.cssSelector(Locator)).click();
			break;

		case PARTIALLINK:
			driver.findElement(By.partialLinkText(Locator)).click();
			break;

		case LINK:
			driver.findElement(By.linkText(Locator)).click();
			break;
			

		default:
			throw new Exception(
					"Invalid Locator Type/Locator Type may not be supported");
		}
}
	
	public List<WebElement> getWebElements (String Locator, String LocatorType) throws Exception {
		//List<String> SearchOutPut=new ArrayList<String>();	
		List<WebElement> WebObjects;
			switch (LOCATOR_TYPE.valueOf(LocatorType)) {
			case ID:
				WebObjects=driver.findElements(By.id(Locator));
				break;

			case NAME:
				WebObjects=driver.findElements(By.name(Locator));
				break;

			case XPATH:
				WebObjects=driver.findElements(By.xpath(Locator));
				break;

			case CSS:
				WebObjects=driver.findElements(By.cssSelector(Locator));
				break;

			case PARTIALLINK:
				WebObjects=driver.findElements(By.partialLinkText(Locator));
				break;

			case LINK:
				WebObjects=driver.findElements(By.linkText(Locator));
				break;
				
			default:
				throw new Exception(
						"Invalid Locator Type/Locator Type may not be supported");
			}
			return WebObjects;
		}
	
	public void mouseOver(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public boolean checkElementExist(String Locator, String LocatorType)
			throws Exception {
		boolean ElementExists = false;
		switch (LOCATOR_TYPE.valueOf(LocatorType)) {
		case ID:
			ElementExists = driver.findElements(By.id(Locator)).size() != 0;
			break;

		case NAME:
			ElementExists = driver.findElements(By.name(Locator))
					.size() != 0;
			break;

		case XPATH:
			ElementExists = driver.findElements(By.xpath(Locator))
					.size() != 0;
			break;

		case CSS:
			ElementExists = driver.findElements(
					By.cssSelector(Locator)).size() != 0;
			break;
		default:
			throw new Exception(
					"Invalid Locator Type/Locator Type may not be supported");
		}
	return ElementExists;	
}
	
	public void switchToIFrame(String type,String frame,WebElement obj) throws Exception
	{
		if(type.equals("id")||type.equals("name"))
		{
			driver.switchTo().frame(frame);
		}
		else if(type.equals("webelement"))
		{
			driver.switchTo().frame(obj);
		}
		else
		{
			throw new Exception("Invalid frame type");
		}
	}
	
	public void switchToParentFrame() throws Exception
	{
	  driver.switchTo().parentFrame();	
	}
	
	public WebElement getWebElement(String Locator, String LocatorType) throws Exception {
		WebElement element;
		switch (LOCATOR_TYPE.valueOf(LocatorType)) {
		case ID:
			return driver.findElement(By.id(Locator));

		case NAME:
			return driver.findElement(By.name(Locator));

		case XPATH:
			return driver.findElement(By.xpath(Locator));

		case CSS:
			return driver.findElement(By.cssSelector(Locator));
			

		case PARTIALLINK:
			return driver.findElement(By.partialLinkText(Locator));

		case LINK:
			return driver.findElement(By.linkText(Locator));
			
		default:
			throw new Exception(
					"Invalid Locator Type/Locator Type may not be supported");
		}
	}
}
