package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class test extends TestBase
{
//    public static void main (String args[])
//    {
//        MySQLDatabase.getInstance().make_Connection();
//
//        try {
//            ResultSet rs= MySQLDatabase.getInstance().excecute_Query("SELECT * FROM emp WHERE emp_id=1");
//            System.out.println(rs.getString(0));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        MySQLDatabase.getInstance().close_Connection();
//    }

    public static void main (String args[])
    {





        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        WebDriverWait wait=new WebDriverWait(driver,25);

        driver.get("https://flight.yatra.com/");


        wait.until(ExpectedConditions.elementToBeClickable(By.id("BE_flight_flsearch_btn"))).click();

        //  try{Thread.sleep(6000);}catch (Exception e){}
        List<WebElement> parentContainer=null;

        try {
            parentContainer = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=\"flight-det table full-width clearfix\"]")));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        Map<String,String> map=new HashMap<String, String>();

        for (WebElement e:parentContainer)
        {
            String flightNumber=e.findElement(By.xpath("p[@class=\"normal fs-11 font-lightestgrey no-wrap fl-no\"]/span")).getText().trim();

            String flightPrice = e.findElement(By.xpath("p/i/..")).getText().trim();

            map.put(flightNumber,flightPrice);
        }


        for (Map.Entry k:map.entrySet())
        {
            System.out.println(k.getKey()+" "+k.getValue());
        }

    }

}
