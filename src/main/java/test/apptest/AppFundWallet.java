package test.apptest;
import java.io.IOException;
import java.sql.DriverAction;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.glass.events.KeyEvent;
import com.thoughtworks.selenium.webdriven.commands.Click;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import javafx.scene.input.KeyCode;
import common.frame.test.BaseTest;
import service.AppCommonService;
import service.InitialService;

public class AppFundWallet extends BaseTest{
	@Autowired
	private InitialService Initial;
	@Autowired
	private AppCommonService appCommonService;

	private AppiumDriver driver;
private AndroidDriver mobDriver;
	private WebDriver webDriver;

	@BeforeClass
	public void beforeClass() throws Exception {	
		Runtime.getRuntime().exec("cmd.exe /c start appium");
		Thread.sleep(5000);
	}

	
	
	
	@AfterClass
	public void afterClass() throws Exception {	

		Runtime.getRuntime().exec("cmd.exe /C start wmic process where name='node.exe' call terminate");
		Thread.sleep(5000);
	}
	
	
	@Test(enabled = true, dataProvider = "testData",description="我的钱包提现")
	public void Wallet(Map<String, String> datadriven)throws Exception {
		
	//	logger("APP "+datadriven.get("version")+"---提现流程开始--");
		//启动企业app并且登录
	//	logger.info("启动并登陆投资者app");
		driver = Initial.appiumAndroidFundSetUp(driver, datadriven.get("fundApkName"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//测试自动搜索定位
	   new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.name("发现"))).click();
	   new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.name("一融活动"))).click();
	   new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.name("自动化活动"))).click();
	   new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.name("报名 Link"))).click();
	 MobileElement aa=  (MobileElement) driver.findElementByClassName("android.widget.EditText");
	 aa.click();
	 
System.out.println("adfsdfsdfsdfsd"+driver.getPageSource());
	   new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.name("公司"))).click();
	   MobileElement mobileElement=(MobileElement) driver.findElementByAccessibilityId("请输入名称");	
mobileElement.click();

	}

	public void PayButton(){
		int x =driver.manage().window().getSize().width;
		int y =driver.manage().window().getSize().height;
		TouchAction  touchAction =new TouchAction(driver);
		touchAction.press(x/2, y-20).release().perform();
	}
//，参数请输入搜索id和你想要搜索的名字
	public void AutoSwipeAndSearchById(String id,String name) {
		try {
			List<WebElement> elements=driver.findElementsById(id);
			
			for (WebElement webElement : elements) {
			
			if(webElement.getText().equals(name)){
				webElement.click();
				break;
		     	}
			else {
				
			
				do {
					
					int width=driver.manage().window().getSize().width;
					int  height=driver.manage().window().getSize().height;
					driver.swipe(width/2,height*3/4, width/2,height*1/2, 1000);
					
					List<WebElement> elements1=driver.findElementsById(id);
					elements=elements1;

					for(WebElement webElement2 : elements) {
						if(webElement2.getText().equals(name)){
							webElement2.click();
							break;
							}
						}
					}
			
			  while (!elements.contains(name));
				}
			
			}
		} catch (Exception e) {
		//	logger.info("ok");
			e.getMessage();
		} 
			
		


	}

	@DataProvider(name = "testData")
	public Iterator<Object[]> data1test() throws IOException {
		return ExcelProviderByEnv(this, "testData");

	}
	}