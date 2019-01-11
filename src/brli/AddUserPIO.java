package brli;

import static org.testng.Assert.fail;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddUserPIO extends Data{

	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\mpatel113326\\BioPortal\\Driver\\geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
		driver = new FirefoxDriver();
		baseUrl = url;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void adduserpio() throws Exception {
		driver.get(baseUrl);
		driver.switchTo().frame(0);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtUsername")));
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtPassword")));
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		WebDriverWait wait3 = new WebDriverWait(driver, 20);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtLocation")));
		driver.findElement(By.id("txtLocation")).sendKeys("J3333");
		WebDriverWait wait4 = new WebDriverWait(driver, 20);
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnLogin")));
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.id("Admin"));
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(element).build().perform();
		Thread.sleep(2000);
		
		
		String parentHandle = driver.getWindowHandle(); 
		driver.findElement(By.linkText("Admin Practice")).click();
		Thread.sleep(2000);

		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle);
		}

		Thread.sleep(2000);
		driver.findElement(By.linkText("Add")).click();
		Thread.sleep(2000);
		Select dropdown = new Select(driver.findElement(By.name("userLevel")));
		Thread.sleep(2000);
		dropdown.selectByValue("P");
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("bioref123");
		Thread.sleep(2000);
		driver.findElement(By.name("passwordcfm")).sendKeys("bioref123");
		Thread.sleep(2000);
		String fname = generatefname();
		driver.findElement(By.name("firstName")).sendKeys(fname);
		Thread.sleep(2000);
		String lname = generatelname();
		driver.findElement(By.name("lastName")).sendKeys(lname);
		Thread.sleep(2000);
		driver.findElement(By.id("addUserButton")).click();
		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath("//b[contains(.,'New User Added')]"));
		String text=ele.getText();
		if (text.contains("New User Added")){
		System.out.println("Expected text is obtained");
		}else{
		System.out.println("Expected text is not obtained");
		}
		 
		String user = driver.findElement(By.xpath("//table[@style='margin: 0px auto;border-spacing: 5px;font-family : Arial;font-size:12px;']/tbody/tr[1]/td[2]")).getText();
		System.out.println(user);
		
		
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		String date1= dateFormat.format(date);
		FileInputStream fis = new FileInputStream("C:\\Users\\mpatel113326\\BioPortal\\Orders.xls");
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		HSSFSheet sheet = workbook.getSheet("Sheet2");
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		Row row = sheet.getRow(0);
		Row newRow = sheet.createRow(rowCount+1);
		for (int i = 0; i< row.getLastCellNum(); i++) {
			 Cell cell = newRow.createCell(i);
			 cell.setCellValue("Patient ID Only"+": " + user + ": "+date1);
		}
		fis.close();
		FileOutputStream fos = new FileOutputStream("C:\\Users\\mpatel113326\\BioPortal\\Orders.xls");
		workbook.write(fos);
		fos.close();
		driver.switchTo().window(parentHandle);
	}		

	@AfterClass(alwaysRun = true)
	public void teardown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}