package com.actitime.qa.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"F:\\Lecs\\4th Year\\IS4102 - Advanced SQA\\Assignments\\SQA_Assignment_02\\Section 3\\src\\main\\java\\com\\actitime\\qa\\feature\\Login.feature", "F:\\Lecs\\4th Year\\IS4102 - Advanced SQA\\Assignments\\SQA_Assignment_02\\Section 3\\src\\main\\java\\com\\actitime\\qa\\feature\\NewUser.feature"},
		glue={"com/actitime/qa/stepdefinitions"}
		,monochrome = true,
		strict=true,
		dryRun=false
)

public class TestRunner {




}