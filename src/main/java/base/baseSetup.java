package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class baseSetup {
    public static WebDriver driver;
    public WebDriver setup(){

       // WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver","/Users/eshan/Documents/chromedriver");
        driver = new ChromeDriver();
        return driver;

    }
    public void tearDown(){
        driver.quit();
    }
}
