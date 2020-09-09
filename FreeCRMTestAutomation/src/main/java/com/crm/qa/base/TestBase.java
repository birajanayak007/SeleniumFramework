package com.crm.qa.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;
    public  static Actions action;
    public  JavascriptExecutor javascriptExecutor;

    public TestBase()
    {
        System.out.println("Test Base Constructor");
        try {
            prop = new Properties();
            String path=System.getProperty("user.dir")+"/src/main/java/com/crm/qa/config/config.properties";
            FileInputStream file = new FileInputStream(path);
            prop.load(file);
        }
       catch (Exception e)
       {
            e.printStackTrace();
        }
    }


    public void  initializeBrowserAndURL()
    {

    String browser = prop.getProperty("browser");
    if (browser.equalsIgnoreCase("chrome")){
    WebDriverManager.chromedriver().setup();

    ChromeOptions options=new ChromeOptions();
    options.addArguments("--incognito");
    options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

    DesiredCapabilities capabilities=new DesiredCapabilities();
    capabilities.setCapability(ChromeOptions.CAPABILITY,options);

    options.merge(capabilities);

    driver=new ChromeDriver(options);

} else if (browser.equalsIgnoreCase("firefox"))
{
    WebDriverManager.firefoxdriver().setup();
    driver=new FirefoxDriver();
}

        driver.manage().window().maximize();

        javascriptExecutor=(JavascriptExecutor)driver;

        //ngWebDriver=new NgWebDriver((JavascriptExecutor) driver);

        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        driver.manage().deleteAllCookies();

        driver.get(prop.getProperty("url"));

        //ngWebDriver.waitForAngularRequestsToFinish();

        action=new Actions(driver);

     }
    }


