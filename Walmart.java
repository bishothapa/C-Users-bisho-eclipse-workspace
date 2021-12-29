package launchBrowser;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Walmart {
     static WebDriver driver;
	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
	 
		driver.findElement(By.name("q")).sendKeys("walmart");
		
        List<WebElement> list=	driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='wM6W7d']/span"));
       
        System.out.println("total number of suggestion in search box:::====>" + list.size());
//        System.out.println(list.size());
        
        for(int i=0;i<list.size();i++) {
        	System.out.println(list.get(i).getText());
        	if(list.get(i).getText().contains("walmart fort worth")){
        	   list.get(i).click();
        		break;
        		
        	}
        }
        
   
	}
	

}
