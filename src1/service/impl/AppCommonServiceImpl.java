package service.impl;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import service.AppCommonService;

public class AppCommonServiceImpl implements AppCommonService{

	public AppiumDriver appLogin(AppiumDriver driver, String userName, String userPassWord) {
		// TODO Auto-generated method stub
		
		  //wait for 60s
//	      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      //点击进入登录页面
	      new WebDriverWait(driver,120).until(ExpectedConditions.elementToBeClickable(By.name("我的"))).click();
	      new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(By.name("请点击登录/注册"))).click();
	      
	      //输入用户名和密码
	      new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.id("login_username"))).sendKeys(userName);
	      driver.findElementById("login_password").sendKeys(userPassWord);
	      
	      driver.findElementByName("立即登录").click();
	      
	      new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.id("mine_user_name")));
				
		  return driver;
	}

	public AppiumDriver appLogout(AppiumDriver driver) {
		// TODO Auto-generated method stub
		//点击设置按钮
		new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(By.id("mine_setting_img"))).click();
		//退出登录
		driver.findElement(By.name("退出登录")).click();		
		new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(By.id("button1"))).click();
		
		return driver;
	}

	public AppiumDriver commentSubmit(AppiumDriver driver, String comment) {
		// TODO Auto-generated method stub
		
		//星级评定
		new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(By.id("star_1"))).click();
		driver.findElement(By.id("star_2")).click();
		driver.findElement(By.id("star_3")).click();
		//评论内容
		driver.findElement(By.id("zong_ti_ping_jia")).sendKeys(comment);
		driver.findElement(By.id("submit")).click();	

		return driver;
	}

	public AppiumDriver swipeToDown(AppiumDriver driver) {
		// TODO Auto-generated method stub
		
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width/2,height*3/4, width/2,height/4, 1000);//向下滑动，间隔1s        
	
		return driver;
	}

	public AppiumDriver alipay(AppiumDriver driver) throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(5000);	
		int x =driver.manage().window().getSize().width;
		int y =driver.manage().window().getSize().height;
	
		io.appium.java_client.TouchAction touchAction  =new io.appium.java_client.TouchAction(driver);
		touchAction.press(x/2, y-90).release().perform();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(By.name("付款"))).click();
		
		return driver;
	}
	


}
