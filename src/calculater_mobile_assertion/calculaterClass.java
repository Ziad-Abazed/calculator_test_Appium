package calculater_mobile_assertion;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class calculaterClass extends Parameters {
	
	SoftAssert myAssertion=new SoftAssert();

	DesiredCapabilities caps = new DesiredCapabilities();
	AndroidDriver driver;
	
	
	 @BeforeTest
	    public void TheSetUp() throws MalformedURLException {
	    	
	    	// we will use them always 
	        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "PixelZiad");
	        
	
	        
	        File CalculatorApp = new File("src/myApplications/calculator.apk");
			caps.setCapability(MobileCapabilityType.APP, CalculatorApp.getAbsolutePath());
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	    }
	 
	 
		@Test(description ="Addition")
		
		public void testAddition() throws MalformedURLException {
			//driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	
			   driver.findElement(By.id("com.google.android.calculator:id/digit_8")).click(); 
		        driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
		        driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click(); 
		        String realReasult=driver.findElement(By.id("com.google.android.calculator:id/result_preview")).getText();
		        
		        myAssertion.assertEquals(Expected_Result_add,realReasult);
				myAssertion.assertAll();
				driver.findElement(By.id("com.google.android.calculator:id/clr")).click();

	
		}
		
        @Test(description ="Multiplication")
		
		public void testMultiplication() throws MalformedURLException {
			
	
        	   driver.findElement(By.id("com.google.android.calculator:id/digit_8")).click(); 
   	        driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
   	        driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click(); 
   	        String realReasult=driver.findElement(By.id("com.google.android.calculator:id/result_preview")).getText();
   	        
   	        myAssertion.assertEquals(Expected_Result_multi,realReasult);
   			myAssertion.assertAll();	
			driver.findElement(By.id("com.google.android.calculator:id/clr")).click();

	
		}
        @Test(description ="Division")

        public void testDivision() throws MalformedURLException {
	       // driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

	        driver.findElement(By.id("com.google.android.calculator:id/digit_8")).click(); 
	        driver.findElement(By.id("com.google.android.calculator:id/op_div")).click();
	        driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click(); 
	        String realReasult=driver.findElement(By.id("com.google.android.calculator:id/result_preview")).getText();
	        
	        myAssertion.assertEquals(Expected_Result_Div,realReasult);
			myAssertion.assertAll();
			driver.findElement(By.id("com.google.android.calculator:id/clr")).click();

	

         }
        @Test(description ="Subtraction")

        public void testSubtraction() throws MalformedURLException {
	      //driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);


	        driver.findElement(By.id("com.google.android.calculator:id/digit_8")).click(); 
	        driver.findElement(By.id("com.google.android.calculator:id/op_sub")).click();
	        driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click(); 
	        String realReasult=driver.findElement(By.id("com.google.android.calculator:id/result_preview")).getText();
	        
	        myAssertion.assertEquals(Expected_Result_sub,realReasult);
			myAssertion.assertAll();
			
			driver.findElement(By.id("com.google.android.calculator:id/clr")).click();

        }
        

    	@AfterTest
    	public void PostTesting() {
    	}


}
