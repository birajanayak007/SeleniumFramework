package com.crm.qa.testcases;


import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginPageTest extends TestBase
{

    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setup()
    {
        System.out.println("Before Method call");
        initializeBrowserAndURL();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)

    public void loginPageTitleTest()
    {
        String title = loginPage.validateLoginPageTitle();
    }
@Test(priority = 2)

public void crmLogoImageTest()
{
    boolean flag = loginPage.validateCRMImage();
    Assert.assertTrue(true);
}
@Test(priority = 3)

public void loginTest()
{
    homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

}
    @AfterMethod
    public void tearDown()
    {
        //driver.quit();
    }

}
