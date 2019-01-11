package brli;

import static org.testng.Assert.fail;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DrawNowThirdPartyMedicare extends Data {

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
	public void addpatientdntpmedicare() throws Exception {
		driver.get(baseUrl);
		driver.switchTo().frame(0);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtUsername")));
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtPassword")));
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		WebDriverWait wait3 = new WebDriverWait(driver, 10);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtLocation")));
		driver.findElement(By.id("txtLocation")).sendKeys("J3333");
		WebDriverWait wait4 = new WebDriverWait(driver, 10);
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnLogin")));
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		WebDriverWait wait5 = new WebDriverWait(driver, 10);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.name("searchvalue")));
		driver.findElement(By.name("searchvalue")).sendKeys("Medicare");
		WebDriverWait wait6 = new WebDriverWait(driver, 10);
		wait6.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnQuickSearchGo")));
		driver.findElement(By.id("btnQuickSearchGo")).click();
		WebDriverWait wait7 = new WebDriverWait(driver, 10);
		wait7.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Medicare, Medicare")));
		driver.findElement(By.linkText("Medicare, Medicare")).click();
		WebDriverWait wait8 = new WebDriverWait(driver, 10);
		wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Create New Order')]")));
		driver.findElement(By.xpath("//span[contains(text(), 'Create New Order')]")).click();
		WebDriverWait wait9 = new WebDriverWait(driver, 10);
		wait9.until(ExpectedConditions.visibilityOfElementLocated(By.name("BillType")));
		Select dropdown2 = new Select(driver.findElement(By.name("BillType")));
		dropdown2.selectByValue("I");
		WebDriverWait wait10 = new WebDriverWait(driver, 10);
		wait10.until(ExpectedConditions.visibilityOfElementLocated(By.id("OrderingProviderId")));
		Select dropdown3 = new Select(driver.findElement(By.id("OrderingProviderId")));
		dropdown3.selectByValue("409492");
		Thread.sleep(1000);
		WebDriverWait wait12 = new WebDriverWait(driver, 10);
		wait12.until(ExpectedConditions.visibilityOfElementLocated(By.id("Fasting")));
		driver.findElement(By.id("Fasting")).click();
		WebDriverWait wait13 = new WebDriverWait(driver, 10);
		wait13.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNext")));
		driver.findElement(By.id("btnNext")).click();
		WebDriverWait wait14 = new WebDriverWait(driver, 10);
		wait14.until(ExpectedConditions.visibilityOfElementLocated(By.id("QuickTestTextbox")));
		Thread.sleep(2000);
		driver.findElement(By.id("QuickTestTextbox")).clear();
		driver.findElement(By.id("QuickTestTextbox")).sendKeys("0088");
		Thread.sleep(10000);
		driver.findElement(By.id("QuickTestTextbox")).sendKeys(Keys.DOWN, Keys.RETURN);
		Thread.sleep(2000);
		WebDriverWait wait16 = new WebDriverWait(driver, 10);
		wait16.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Next >')]")));
		driver.findElement(By.xpath("//span[contains(text(), 'Next >')]")).click();
		WebDriverWait wait17 = new WebDriverWait(driver, 20);
		wait17.until(ExpectedConditions.visibilityOfElementLocated(By.id("QuickDxTextbox")));
		driver.findElement(By.id("QuickDxTextbox")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("QuickDxTextbox")).sendKeys("F21");
		Thread.sleep(1000);
		driver.findElement(By.id("QuickDxTextbox")).sendKeys(Keys.DOWN, Keys.RETURN);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(), 'Next >')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(), 'Next >')]")).click();
		Thread.sleep(2000);

		String parentWindowHandler = driver.getWindowHandle(); 
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); 
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler); 
		Thread.sleep(2000);

		
		driver.findElement(By.xpath("//span[contains(text(), 'Print ABN')]")).click();
		Thread.sleep(2000);
		List<WebElement> oCheckBox = driver.findElements(By.name("signed"));

		int iSize = oCheckBox.size();

		for (int j = 0; j < iSize; j++) {

			String sValue = ((WebElement) oCheckBox.get(j)).getAttribute("value");

			if (sValue.equalsIgnoreCase("1")) {

				((WebElement) oCheckBox.get(j)).click();

				Thread.sleep(2000);

				List<WebElement> oCheckBox2 = driver.findElements(By.name("option"));

				int kSize = oCheckBox2.size();

				for (int k = 0; k < kSize; k++) {

					String kValue = ((WebElement) oCheckBox2.get(k)).getAttribute("value");

					if (kValue.equalsIgnoreCase("1")) {

						((WebElement) oCheckBox2.get(k)).click();

						break;

					}
				}

				Thread.sleep(2000);

				driver.findElement(By.id("proceedBtn")).click();
				Thread.sleep(2000);

				driver.switchTo().window(parentWindowHandler); 

				driver.findElement(By.name("SubmitComplete")).click();
				Thread.sleep(2000);
				driver.switchTo().frame("RequisitionFrame");
				Thread.sleep(2000);
				WebDriverWait wait19 = new WebDriverWait(driver, 10);
				wait19.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'J3333,')]")));
				String orderNo = driver.findElement(By.xpath("//div[contains(text(), 'J3333,')]")).getText();
				System.out.println(orderNo);

				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				Date date = new Date();
				String date1 = dateFormat.format(date);
				FileInputStream fis = new FileInputStream("C:\\Users\\mpatel113326\\BioPortal\\Orders.xls");
				HSSFWorkbook workbook = new HSSFWorkbook(fis);
				HSSFSheet sheet = workbook.getSheet("Sheet1");
				int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
				Row row = sheet.getRow(0);
				Row newRow = sheet.createRow(rowCount + 1);
				for (int i = 0; i < row.getLastCellNum(); i++) {
					Cell cell = newRow.createCell(i);
					cell.setCellValue("DrawNowThirdPartyMedicare" + ": " + orderNo + ": " + date1);
				}
				fis.close();
				FileOutputStream fos = new FileOutputStream("C:\\Users\\mpatel113326\\BioPortal\\Orders.xls");
				workbook.write(fos);
				fos.close();
			}
		}
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