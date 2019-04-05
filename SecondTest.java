package second;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
									//turn on VPN before starting the test!!! 
public class SecondTest {
	
	private WebDriver driver;
	
	@BeforeClass // Runs this method before the first test method in the current class is invoked
	public void setUp() {
		// Create a new instance of the Chrome driver
		System.setProperty("webdriver.chrome.driver","C:\\SeleniumDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		
	}
	
	@Test // Marking this method as part of the test
	public void gotoPage() {
		
			//Step 1
		// Go to the StagingWeb home page
		driver.get("https://staging-web.naip.de/");
		driver.findElement(By.xpath("//a[@href='/Account/NewPassword']")).click();
		
			//Step 2
		driver.findElement(By.className("standardButton")).click();
		// Get text from header of the NewPassword page
		String header = driver.findElement(By.id("FirstName-error")).getText();
		// Verify that header equals "Feld 'Vorname' muss ausgefullt sein"
		Assert.assertEquals(header, "Feld 'Vorname' muss ausgefullt sein");
		// Get text from header1 of the NewPassword page
		String header1 = driver.findElement(By.id("LastName-error")).getText();
		// Verify that header1 equals "Feld 'Nachname' muss ausgefullt sein"
		Assert.assertEquals(header1, "Feld 'Nachname' muss ausgefullt sein");
		// Get text from header2 of the NewPassword page
		String header2 = driver.findElement(By.id("Institution-error")).getText();
		// Verify that header2 equals "Feld 'Einrichtung / Praxis / Klinik' muss ausgefullt sein"
		Assert.assertEquals(header2, "Feld 'Einrichtung / Praxis / Klinik' muss ausgefullt sein");
		// Send text "Mihas" from UserName
		
			//Step 3
		driver.findElement(By.id("FirstName")).sendKeys("Mihas");
		
			//Step 4
		// Click button "Neues Passwort anfordern"
		driver.findElement(By.className("standardButton")).click();
		// Get text from header1 of the NewPassword page
		String header3 = driver.findElement(By.id("LastName-error")).getText();
		// Verify that header3 equals "Feld 'Nachname' muss ausgefullt sein"
		Assert.assertEquals(header3, "Feld 'Nachname' muss ausgefullt sein");
		// Get text from header4 of the NewPassword page
		String header4 = driver.findElement(By.id("Institution-error")).getText();
		// Verify that header4 equals "Feld 'Einrichtung / Praxis / Klinik' muss ausgefullt sein"
		Assert.assertEquals(header4, "Feld 'Einrichtung / Praxis / Klinik' muss ausgefullt sein");
		
			//Step 5
		driver.findElement(By.id("LastName")).sendKeys("Ivanov");
				
			//Step 6	
		// Click button "Neues Passwort anfordern"
		driver.findElement(By.className("standardButton")).click();
		// Get text from header5 of the NewPassword page
		String header5 = driver.findElement(By.id("Institution-error")).getText();
		// Verify that header5 equals "Feld 'Einrichtung / Praxis / Klinik' muss ausgefullt sein"
		Assert.assertEquals(header5, "Feld 'Einrichtung / Praxis / Klinik' muss ausgefullt sein");
		
			//Step 7
		driver.findElement(By.id("Institution")).sendKeys("Pinsk City Hospital");
		
			//Step 8	
		// Click button "Neues Passwort anfordern"
		driver.findElement(By.className("standardButton")).click();
		// Get text from header6 of the NewPassword page
		String header6 = driver.findElement(By.className("field-validation-error")).getText();
		// Verify that header6 equals "Sicherheitsfrage muss korrekt beantwortet werden."
		Assert.assertEquals(header6, "Sicherheitsfrage muss korrekt beantwortet werden.");
				
		
		
		
	}
	
	@AfterClass // Runs this method after all the test methods in the current class have been run
	public void tearDown() {
		// Close all browser windows and safely end the session
		driver.quit();
	}

}