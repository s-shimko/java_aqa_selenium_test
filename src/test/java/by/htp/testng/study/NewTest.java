package by.htp.testng.study;

import static by.htp.testng.study.XpathVariables.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class NewTest {

	private static final String DRIVER_FIREFOX = "webdriver.gecko.driver";
	private static final String DRIVER_FIREFOX_PATH = "D:\\Projects\\install\\geckodriver.exe";
	private WebDriver driver;
	private WebDriverWait wait;

	@BeforeClass
	public void BeforeClass() {
		System.out.println("BeforeClass");
		System.setProperty(DRIVER_FIREFOX, DRIVER_FIREFOX_PATH);
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
	}

	@BeforeMethod
	public void BeforeMethod() {
		System.out.println("BeforeMethod");
	}

	@BeforeSuite
	public void BeforeSuite() {
		System.out.println("BeforeSuite");
	}

	@Test(enabled = false)
	public void test1() {
		
		
		System.out.println("Find Java");
		driver.get("http://www.google.com");
		WebElement el = driver.findElement(By.xpath(GOOGLE_INPUT_SEARCH));
		el.sendKeys("Java");
		driver.findElement(By.xpath(GOOGLE_BUTTON_SEARCH)).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String title = driver.getTitle();
		assertTrue(title.contains("Java"));

	}

	@Test(enabled = false)
	public void test2() {
		System.out.println("Read tut.by header and count p");
		driver.get("http://www.tut.by");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement header = driver.findElement(By.xpath(TUTBY_HEADER));
		driver.findElement(By.xpath(TUTBY_MAIN_NEWS)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> elements = driver.findElements(By.xpath(TUTBY_PARAGRAPHS));
		System.out.println(elements.size());
	}

	@Test(enabled = false)
	public void test4() {
		System.out.println("It academy menu test");
		driver.get("https://www.it-academy.by/");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement trudoustroystvo = driver.findElement(By.xpath(ITAC_TRUDOUSTROYSTVO));
		Actions act = new Actions(driver);
		act.moveToElement(trudoustroystvo).perform();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<WebElement> menu = driver.findElements(By.xpath(ITAC_TRUDOUSTROYSTVO_MENU));
		for (WebElement menu_el : menu) {
			System.out.println(menu_el.getText());
		}

		WebElement obuchenie = driver.findElement(By.xpath(ITAC_OBUCHENIYE));
		Actions act2 = new Actions(driver);
		act2.moveToElement(obuchenie).perform();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<WebElement> menu2 = driver.findElements(By.xpath(ITAC_OBUCHENIYE_MENU));
		WebElement menu_marketing = null;
		for (WebElement menu_el : menu2) {
			if (menu_el.getText().equals("Маркетинг и продажи")) {
				menu_marketing = menu_el;
			}
		}

		menu_marketing.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Test(enabled = false)
	public void Test5() {
		System.out.println("Quizful personal info");
		driver.get("http://www.quizful.net");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(QUIZFUL_PAGETITLE)));

		driver.findElement(By.xpath(QUIZFUL_LOGIN_LINK)).click();

		WebElement login = driver.findElement(By.xpath(QUIZFUL_INPUT_LOGIN));
		WebElement password = driver.findElement(By.xpath(QUIZFUL_INPUT_PASSWORD));
		WebElement submit_button = driver.findElement(By.xpath(QUIZFUL_SUBMIT_BUTTON));

		login.sendKeys("s_shimko");
		password.sendKeys("brahman222");
		submit_button.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(QUIZFUL_LOGIN_MARK)));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(QUIZFUL_PROFILE_BUTTON)));
		WebElement profile = driver.findElement(By.xpath(QUIZFUL_PROFILE_BUTTON));
		profile.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(QUIZFUL_EDIT_BUTTON)));
		WebElement button_edit = driver.findElement(By.xpath(QUIZFUL_EDIT_BUTTON));
		button_edit.click();

		WebElement menu_personal = driver.findElement(By.xpath(QUIZFUL_MENU_PERSONAL));
		WebElement input_name = driver.findElement(By.xpath(QUIZFUL_INPUT_NAME));
		WebElement input_surname = driver.findElement(By.xpath(QUIZFUL_INPUT_SURNAME));
		WebElement input_birthdate = driver.findElement(By.xpath(QUIZFUL_INPUT_BIRTHYEAR));
		WebElement input_site = driver.findElement(By.xpath(QUIZFUL_INPUT_SITE));
		String image_path = "D:\\Projects\\javaaqa\\info\\image.jpg";
		WebElement input_avatar = driver.findElement(By.xpath(QUIZFUL_INPUT_AVATAR));
		WebElement input_company = driver.findElement(By.xpath(QUIZFUL_INPUT_COMPANY));
		WebElement textarea_about = driver.findElement(By.xpath(QUIZFUL_TEXTAREA_ABOUT));
		WebElement button_save_personal_data = driver.findElement(By.xpath(QUIZFUL_BUTTON_SAVE_PERSONAL_DATA));

		input_avatar.sendKeys(image_path);
		menu_personal.click();
		input_name.sendKeys("sergey");
		input_surname.sendKeys("shimko");
		input_birthdate.sendKeys("1333");
		input_site.sendKeys("www.tut.by");
		input_company.sendKeys("asdf");
		textarea_about.sendKeys("about");
		button_save_personal_data.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement button_edit2 = driver.findElement(By.xpath(QUIZFUL_EDIT_BUTTON));
		button_edit2.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement menu_notifications = driver.findElement(By.xpath(QUIZFUL_MENU_NOTIFICATIONS));
		WebElement checkbox_notifications_enabled = driver.findElement(By.xpath(QUIZFUL_CHECKBOX_NOTIFICATIONS_ENABLED));
		WebElement checkbox_delivery_enabled = driver.findElement(By.xpath(QUIZFUL_CHECKBOX_DELIVERY_ENABLED));
		WebElement button_save_notifications = driver.findElement(By.xpath(QUIZFUL_BUTTON_SAVE_NOTIFICATIONS));

		menu_notifications.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		checkbox_notifications_enabled.sendKeys(Keys.SPACE);
		checkbox_delivery_enabled.sendKeys(Keys.SPACE);
		button_save_notifications.click();

		WebElement button_edit3 = driver.findElement(By.xpath(QUIZFUL_EDIT_BUTTON));
		button_edit3.click();

		WebElement menu_privacy = driver.findElement(By.xpath(QUIZFUL_MENU_PRIVACY));
		WebElement radiobutton_justme = driver.findElement(By.xpath(QUIZFUL_RADIOBUTTON_JUSTME));
		WebElement button_save_privacy = driver.findElement(By.xpath(QUIZFUL_BUTTON_SAVE_PRIVACY));

		menu_privacy.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		radiobutton_justme.click();
		button_save_privacy.click();
	}
	
	@Test(enabled = true)
	public void Test6() {
		System.out.println("Registration Quizful");
		driver.get("http://www.quizful.net");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(QUIZFUL_PAGETITLE)));
		
		WebElement reg_button = driver.findElement(By.xpath(QUIZFUL_BUTTON_REGISTRATION));
		reg_button.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(QUIZFUL_INPUT_REGISTRATION_LOGIN)));
		
		WebElement login = driver.findElement(By.xpath(QUIZFUL_INPUT_REGISTRATION_LOGIN));
		WebElement pass = driver.findElement(By.xpath(QUIZFUL_INPUT_REGISTRATION_PASSWORD));
		WebElement repass = driver.findElement(By.xpath(QUIZFUL_INPUT_REGISTRATION_REPASSWORD));
		WebElement email = driver.findElement(By.xpath(QUIZFUL_INPUT_REGISTRATION_EMAIL));
		WebElement input_captcha = driver.findElement(By.xpath(QUIZFUL_INPUT_REGISTRATION_CAPTCHA));
		WebElement button_ok = driver.findElement(By.xpath(QUIZFUL_BUTTON_REGISTRATION_OK));
		
		login.sendKeys("testasdf");
		pass.sendKeys("testasdf");
		repass.sendKeys("testasdf");
		email.sendKeys("testasdf");
		
		input_captcha.sendKeys("some_captcha");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		button_ok.click();	
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(QUIZFUL_MESSAGE_REGISTRATION_ERROR)));
		WebElement error = driver.findElement(By.xpath(QUIZFUL_MESSAGE_REGISTRATION_ERROR));
		
		String error_text = error.getText();
		assertEquals(error_text, "Некорректный e-mail\nНеправильное число");
		
	}

	@AfterClass
	public void AfterClass() {
		System.out.println("AfterClass");
		driver.close();
	}

	@AfterMethod
	public void AfterMethod() {
		System.out.println("AfterMethod");
	}

	@AfterSuite
	public void AfterSuite() {
		System.out.println("AfterSuite");
	}

	@AfterTest
	public void AfterTest() {
		System.out.println("AfterTest");
	}

}
