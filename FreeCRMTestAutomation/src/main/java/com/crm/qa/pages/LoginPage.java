package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //page factory OR:
    @FindBy(name= "username")
    WebElement username;
    @FindBy(name="password")
    WebElement password;
@FindBy(xpath = "//input[@type='submit']")
WebElement loginBtn;

@FindBy(xpath="//button[contains(text(),'Sign Up']")
    WebElement signUpBtn;
@FindBy(xpath="//img[contains(@class,'img-responsive')]")
    WebElement crmLogo;

//initialize the page objects
public LoginPage()
{
    PageFactory.initElements(driver,this);
}

public String validateLoginPageTitle()
{
    return driver.getTitle();
}
public boolean validateCRMImage()
{
    return crmLogo.isDisplayed();
}
public HomePage login(String crmusername, String crmpassword)
{
    username.sendKeys(crmusername);
    password.sendKeys(crmpassword);
    loginBtn.click();

    return new HomePage();
}

}
