package utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;

public class driverfactory {
     public static WebDriver driver;
     
    public static WebDriver Open(String browertype) {
        //As of now i have made this work for only chrome, we can place other browsers as well by using If conditions or datatables         
        browertype.contains("Chrome");
        System.setProperty("webdriver.chrome.driver", "C:\\mywork\\chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("***************After Test**********");
        if (driver != null) {
            driver.quit();
        }
    }

}
