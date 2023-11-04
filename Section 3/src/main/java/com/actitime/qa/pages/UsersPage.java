package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
public class UsersPage extends TestBase  {
    @FindBy(xpath = "//div[contains(@class,'withPlusIcon')]")
    @CacheLookup
    WebElement addUserBtn;

    @FindBy(xpath = "//div[@id='createUserPanel_accountInformationSection']/descendant::input[@name='firstName']")
    WebElement webFirstName;

    @FindBy(xpath = "//div[@id='createUserPanel_accountInformationSection']/descendant::input[@name='lastName']")
    WebElement webLastName;

    @FindBy(xpath = "//div[@id='createUserPanel_accountInformationSection']/descendant::input[@name='email']")
    WebElement webEmail;

    @FindBy(xpath = "//div[contains(@class,'submitBtn')]")
    WebElement addBtn;

    @FindBy(xpath = "//div[@class='createUserPanel_accountCreatedContainer']/child::div[@class='invitationInfo']")
    WebElement webConfirm;

    Logger log = Logger.getLogger(UsersPage.class);

    public UsersPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickAddUserButton() {

        addUserBtn.click();
        log.info("New User Button Clicked");
    }

    public void enterFirstName(String firstName) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(webFirstName));
        webFirstName.sendKeys(firstName);
        log.info("First Name entered as " + firstName);
    }

    public void enterLastName(String lastName) {
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        webLastName.sendKeys(lastName);
        log.info("Last Name entered as " + lastName);
    }

    public void enterEmail(String email) {
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        webEmail.sendKeys(email);
        log.info("Email entered as " + email);
    }

    public void clickSaveButton() {
        addBtn.click();
    }

    public void confirmingEmail(String email) {
        String confirmation = webConfirm.getText();
        if (confirmation.contains(email))
        {
            log.info("User successfully created");
        }
    }

}
