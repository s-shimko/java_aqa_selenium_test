package by.htp.testng.study;

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
		WebElement el = driver.findElement(By.id("lst-ib"));
		el.sendKeys("Java");
		driver.findElement(By.name("btnK")).click();
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
		WebElement header = driver.findElement(By.cssSelector(".header"));
		driver.findElement(By.cssSelector(".b-mainnews__img")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> elements = driver.findElements(By.cssSelector("#article_body > p"));
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

		WebElement trudoustroystvo = driver.findElement(By.cssSelector("a[data-section='section-menu-50']"));
		Actions act = new Actions(driver);
		act.moveToElement(trudoustroystvo).perform();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<WebElement> menu = driver.findElements(By.cssSelector("section[data-section='section-menu-50'] li"));
		for (WebElement menu_el : menu) {
			System.out.println(menu_el.getText());
		}

		WebElement obuchenie = driver.findElement(By.cssSelector("a[data-section='section-menu-0']"));
		Actions act2 = new Actions(driver);
		act2.moveToElement(obuchenie).perform();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<WebElement> menu2 = driver.findElements(By.cssSelector("section[data-section='section-menu-0'] a"));
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("page-title")));

		driver.findElement(By.cssSelector("#user-panel a[href='/LoginAction.loginForm']")).click();

		WebElement login = driver.findElement(By.cssSelector("#login"));
		WebElement password = driver.findElement(By.cssSelector("input[name='loginForm.password']"));
		WebElement submit_button = driver.findElement(By.cssSelector("p.buttons .btn.btn-primary"));

		login.sendKeys("s_shimko");
		password.sendKeys("brahman222");
		submit_button.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/feed']")));

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("b > a[href='/user/s_shimko']")));
		WebElement profile = driver.findElement(By.cssSelector("b > a[href='/user/s_shimko']"));
		profile.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/ProfileAction.settings']")));
		WebElement button_edit = driver.findElement(By.cssSelector("a[href='/ProfileAction.settings']"));
		button_edit.click();

		WebElement menu_personal = driver.findElement(By.cssSelector("#profile-personal-form .title"));
		WebElement input_name = driver.findElement(By.name("personalForm.name"));
		WebElement input_surname = driver.findElement(By.name("personalForm.surname"));
		WebElement input_birthdate = driver.findElement(By.name("personalForm.birthyear"));
		WebElement input_site = driver.findElement(By.name("personalForm.site"));
		String image_path = "D:\\Projects\\javaaqa\\info\\image.jpg";
		WebElement input_avatar = driver.findElement(By.name("personalForm.avatar"));
		WebElement input_company = driver.findElement(By.name("personalForm.company"));
		WebElement textarea_about = driver.findElement(By.name("personalForm.about"));
		WebElement button_save_personal_data = driver.findElement(By.name("personalForm.save"));

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
		WebElement button_edit2 = driver.findElement(By.cssSelector("a[href='/ProfileAction.settings']"));
		button_edit2.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement menu_notifications = driver.findElement(By.cssSelector("#profile-notifications-form .title"));
		WebElement checkbox_notifications_enabled = driver
				.findElement(By.name("notificationsForm.notificationsEnabled"));
		WebElement checkbox_delivery_enabled = driver.findElement(By.name("notificationsForm.deliveryEnabled"));
		WebElement button_save_notifications = driver.findElement(By.name("notificationsForm.save"));

		menu_notifications.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		checkbox_notifications_enabled.sendKeys(Keys.SPACE);
		checkbox_delivery_enabled.sendKeys(Keys.SPACE);
		button_save_notifications.click();

		WebElement button_edit3 = driver.findElement(By.cssSelector("a[href='/ProfileAction.settings']"));
		button_edit3.click();

		WebElement menu_privacy = driver.findElement(By.cssSelector("#profile-privacy-form .title"));
		WebElement radiobutton_justme = driver.findElement(By.xpath(".//label[.='Только я']/input"));
		WebElement button_save_privacy = driver.findElement(By.name("privacyForm.save"));

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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("page-title")));
		
		WebElement reg_button = driver.findElement(By.cssSelector("a[href='/LoginAction.registration']"));
		reg_button.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("registrationForm.login")));
		
		WebElement login = driver.findElement(By.name("registrationForm.login"));
		WebElement pass = driver.findElement(By.name("registrationForm.password"));
		WebElement repass = driver.findElement(By.name("registrationForm.repassword"));
		WebElement email = driver.findElement(By.name("registrationForm.email"));
		WebElement input_captcha = driver.findElement(By.name("registrationForm.captcha"));
		WebElement button_ok = driver.findElement(By.name("ok"));
		
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
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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

// package by.htp.testng.study;
//
// import org.testng.annotations.Test;
// import org.testng.annotations.BeforeMethod;
// import org.testng.annotations.AfterMethod;
// import org.testng.annotations.BeforeClass;
// import org.testng.annotations.AfterClass;
// import org.testng.annotations.BeforeTest;
// import org.testng.annotations.AfterTest;
//
// public class NewTest {
// @Test
// public void f() {
// }
// @BeforeMethod
// public void beforeMethod() {
// }
//
// @AfterMethod
// public void afterMethod() {
// }
//
// @BeforeClass
// public void beforeClass() {
// }
//
// @AfterClass
// public void afterClass() {
// }
//
// @BeforeTest
// public void beforeTest() {
// }
//
// @AfterTest
// public void afterTest() {
// }
//
// }
