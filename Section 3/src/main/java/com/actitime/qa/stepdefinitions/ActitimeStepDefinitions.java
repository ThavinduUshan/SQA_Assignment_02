package com.actitime.qa.stepdefinitions;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.UsersPage;
import com.actitime.qa.util.TestUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ActitimeStepDefinitions extends TestBase {
	
	
	LoginPage loginPage;
	HomePage homePage;

	UsersPage newUserPage;
	String sheetName = "Users";
	TestUtil testUtil;

	
	@Given("^User in the Actitime Loging Page$")
	public void user_in_the_Actitime_Loging_Page() throws Throwable {

		initialization();
		loginPage = new LoginPage();
	}

	@When("^User Enter the User Name as  \"([^\"]*)\"$")
	public void user_Enter_the_User_Name_as(String userName) throws Throwable {
		loginPage.enterUserName(userName);
	}

	@Then("^User Enter the Password as  \"([^\"]*)\"$")
	public void user_Enter_the_Password_as(String password) throws Throwable {
		loginPage.enterPassword(password);
	}

	@Then("^User click in Loging button$")
	public void user_click_in_Loging_button() throws Throwable {
		homePage =loginPage.clickSubmitButton();
	}

	@Then("^User should be able to successfuly loging to Actitime$")
	public void user_should_be_able_to_successfuly_loging_to_Actitime() throws Throwable {

		homePage.validateActiTimeLogo();
		driver.quit();

	}

	@Given("^User logs into the system as admin with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_logs_into_the_system_as_admin_with_username_and_password(String username, String password) throws Throwable {
		initialization();
		loginPage = new LoginPage();
		loginPage.loging(username, password);
	}

	@When("^User navigates to the Users page and Click New User button$")
	public void user_navigates_to_the_new_user_creation_page() throws Throwable {
		homePage = new HomePage();
		newUserPage = homePage.clickOnUsersLink();
		newUserPage.clickAddUserButton();
	}

	@When("^User fills in the First Name as \"([^\"]*)\"$")
	public void user_fills_in_the_first_name(String firstName) throws Throwable {
		newUserPage.enterFirstName(firstName);
	}

	@When("^User fills in the Last Name as \"([^\"]*)\"$")
	public void user_fills_in_the_last_name(String lastName) throws Throwable {
		newUserPage.enterLastName(lastName);
	}

	@When("^User fills in the Email as \"([^\"]*)\"$")
	public void user_fills_in_the_email(String email) throws Throwable {
		newUserPage.enterEmail(email);
	}

	@When("^User clicks on the Save button$")
	public void user_clicks_on_the_save_button() throws Throwable {
		newUserPage.clickSaveButton();
	}

	@Then("^User should see a confirmation message with email \"([^\"]*)\"$")
	public void user_should_see_a_confirmation_message_with_email(String email) throws Throwable {
		newUserPage.confirmingEmail(email);
		driver.quit();
	}

}
