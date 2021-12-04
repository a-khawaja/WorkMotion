package com.Flink.stepdefs;


import com.Flink.utilities.GetConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.Assert;

import java.awt.*;

public class Task_StepDefs {

    @And("user clicks on {string}")
    public void userClicksOn(String button) throws Throwable {

        if (button.equalsIgnoreCase("Add Employee")) {
            Hooks_UI.container.homePage.clickAddEmployee();
        } else if (button.equalsIgnoreCase("Get Started")) {
            Hooks_UI.container.homePage.clickGetStartedButton();
        } else if (button.equalsIgnoreCase("Continue")) {
            Hooks_UI.container.addEmployeePage.clickContinueButton();
        } else if (button.equalsIgnoreCase("Calculate")) {
            Hooks_UI.container.addEmployeePage.clickCalculateButton();
        } else if (button.equalsIgnoreCase("Confirmation")) {
            Hooks_UI.container.addEmployeePage.clickConfirmationButton();
        } else if (button.equalsIgnoreCase("Finish")) {
            Hooks_UI.container.addEmployeePage.clickFinishButton();
        } else if (button.equalsIgnoreCase("Action Items")) {
            Hooks_UI.container.actionItemsPage.clickActionItems();
        } else if (button.equalsIgnoreCase("Mark as Done")) {
            Hooks_UI.container.actionItemsPage.clickDone();
        }
    }

    @Then("user is landed to the {string} page")
    public void userIsLandedToThePage(String arg0) throws InterruptedException {
        if (arg0.equalsIgnoreCase("Country")) {
            Assert.assertEquals("Select a country", Hooks_UI.container.homePage.verifyPage(arg0));
        } else if (arg0.equalsIgnoreCase("Add Employee")) {
            Assert.assertEquals("Sunscreens", Hooks_UI.container.homePage.verifyPage(arg0));
        } else if (arg0.equalsIgnoreCase("Contract Clause")) {
            Assert.assertEquals("Contract Clauses", Hooks_UI.container.homePage.verifyPage("Contract Clause"));
        } else if (arg0.equalsIgnoreCase("Salary Calculator")) {
            Assert.assertEquals("Salary Calculator", Hooks_UI.container.homePage.verifyPage("Salary Calculator"));
        } else if (arg0.equalsIgnoreCase("Invite Employee")) {
            Assert.assertEquals("Now it is time to invite your employee.", Hooks_UI.container.homePage.verifyPage("Invite Employee"));
        } else if (arg0.equalsIgnoreCase("Summary Review")) {
            Assert.assertEquals("Summary of employment agreement", Hooks_UI.container.homePage.verifyPage("Summary Review"));
        }
    }


    @And("user enters {string} and {string}")
    public void userEntersAnd(String arg0, String arg1) throws InterruptedException {
        if (arg0.equalsIgnoreCase("FirstName") && arg1.equalsIgnoreCase("LastName")) {
            Hooks_UI.container.addEmployeePage.enterNameDetails(Hooks_UI.data.get("FirstName"), Hooks_UI.data.get("LastName"));
        } else if (arg0.equalsIgnoreCase("Job Title") && arg1.equalsIgnoreCase("Job Description")) {
            Hooks_UI.container.addEmployeePage.enterJobDetails(Hooks_UI.data.get("Job Title"), Hooks_UI.data.get("Job Description"));
        } else if (arg0.equalsIgnoreCase("Cost Center") || arg1.equalsIgnoreCase("Name of Signatory")) {
            Hooks_UI.container.addEmployeePage.enterCostCenter(Hooks_UI.data.get("Cost Center"));
            Hooks_UI.container.addEmployeePage.enterSignatoryName(Hooks_UI.data.get("Name of Signatory"));
        } else if (arg0.equalsIgnoreCase("Title of Signatory") && arg1.equalsIgnoreCase("Email of Direct Manager")) {
            Hooks_UI.container.addEmployeePage.enterSignatoryTitle(Hooks_UI.data.get("Title of Signatory"));
            Hooks_UI.container.addEmployeePage.enterEmailManager(Hooks_UI.data.get("Email of Direct Manager"));
        } else if (arg0.equalsIgnoreCase("Contract Start Date") && arg1.equalsIgnoreCase("Contract End Date")) {
            Hooks_UI.container.addEmployeePage.selectStartDate(Hooks_UI.data.get("Start Date"));
            Hooks_UI.container.addEmployeePage.selectEndDate(Hooks_UI.data.get("End Date"));
        } else if (arg0.equalsIgnoreCase("Paid Time Off") && arg1.equalsIgnoreCase("Probation Period")) {
            Hooks_UI.container.addEmployeePage.enterPaidTimeOff(Hooks_UI.data.get("PaidTimeOff"));
            Hooks_UI.container.addEmployeePage.enterProbationTime(Hooks_UI.data.get("Probation"));
        } else if (arg0.equalsIgnoreCase("Termination Notice Period") || arg1.equalsIgnoreCase("Anything else field")) {
            Hooks_UI.container.addEmployeePage.enterTerminationTime(Hooks_UI.data.get("TerminationNotice"));
            Hooks_UI.container.addEmployeePage.enterAnythingElseSection(Hooks_UI.data.get("OptionalData"));
        }
    }

    @Then("user sees the {string} window")
    public void userSeesTheWindow(String arg0) throws InterruptedException {
        if (arg0.equalsIgnoreCase("Total Monthly Payment")) {
            Assert.assertEquals("TOTAL MONTHLY PAYMENT", Hooks_UI.container.addEmployeePage.getTOTALCostHeader(arg0));
            Assert.assertNotEquals("", Hooks_UI.container.addEmployeePage.getTOTALCost());
        } else if (arg0.equalsIgnoreCase("success")) {
            Assert.assertEquals("Congratulations, Onboarding has started!", Hooks_UI.container.addEmployeePage.getSuccessMessage());
        }
    }

    @Given("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() throws Exception {
        String url = GetConfig.getProperties("baseURL");
        Hooks_UI.container.homePage.enterURL(url);
        Assert.assertTrue(Hooks_UI.container.homePage.login(Hooks_UI.data.get("Username"), Hooks_UI.data.get("Password")));
    }

    @When("user enters {string}")
    public void userEnters(String arg0) throws InterruptedException {
        if (arg0.equalsIgnoreCase("Country name")) {
            Hooks_UI.container.homePage.enterCountry(Hooks_UI.data.get("CountryName"));
        } else if (arg0.equalsIgnoreCase("Business Assignment Context")) {
            Hooks_UI.container.addEmployeePage.enterBusinessAssignment(Hooks_UI.data.get("Business Assignment Context"));
        } else if (arg0.equalsIgnoreCase("Working hours")) {
            Hooks_UI.container.addEmployeePage.enterWorkingHours(Hooks_UI.data.get("Working hours"));
        } else if (arg0.equalsIgnoreCase("Base Salary")) {
            Hooks_UI.container.addEmployeePage.enterBaseSalary(Hooks_UI.data.get("Salary"));
        } else if (arg0.equalsIgnoreCase("Sign up bonus")) {
            Hooks_UI.container.addEmployeePage.enterBonus(Hooks_UI.data.get("Bonus"));
        } else if (arg0.equalsIgnoreCase("Email Address")) {
            Hooks_UI.container.addEmployeePage.enterEmail(Hooks_UI.data.get("Email"));
        }
    }

    @And("user sees the {string} Page")
    public void userSeesThePage(String arg0) throws InterruptedException {
        Assert.assertEquals("Contract Details", Hooks_UI.container.homePage.verifyPage("Contract Details"));
    }

    @And("user answers the Radio Button {string} and {string} questions")
    public void userAnswersTheRadioButtonAndQuestions(String arg0, String arg1) throws InterruptedException {
        if (arg0.equalsIgnoreCase("Eligible") && arg1.equalsIgnoreCase("Executive")) {
            Hooks_UI.container.addEmployeePage.clickRadioButtons(arg0, Hooks_UI.data.get("EligibilityYesOrNo"));
            Hooks_UI.container.addEmployeePage.clickRadioButtons(arg1, Hooks_UI.data.get("ExecutiveYesOrNo"));
        } else if (arg0.equalsIgnoreCase("ContractType")) {
            Hooks_UI.container.addEmployeePage.clickRadioButtons(arg0, Hooks_UI.data.get("FullOrPart"));
        } else if (arg0.equalsIgnoreCase("Reimburse") && arg1.equalsIgnoreCase("Work from home")) {
            Hooks_UI.container.addEmployeePage.clickRadioButtons(arg0, Hooks_UI.data.get("Reimbursement"));
            Hooks_UI.container.addEmployeePage.clickRadioButtons(arg1, Hooks_UI.data.get("Work from home"));
        } else if (arg0.equalsIgnoreCase("Bonus")) {
            Hooks_UI.container.addEmployeePage.clickRadioButtons(arg0, Hooks_UI.data.get("BonusYesorNo"));
        }
    }

    @And("user {string} the {string}")
    public void userThe(String arg0, String arg1) throws ConfigurationException, AWTException {
        if (arg0.equalsIgnoreCase("uploads")) {
            Hooks_UI.container.addEmployeePage.uploadFile();
        } else if (arg0.equalsIgnoreCase("Downloads")) {
            Hooks_UI.container.addEmployeePage.downloadAgreement();
        }
    }

    @When("user filters for pending action items")
    public void userFiltersForPendingActionItems() throws InterruptedException {
        Hooks_UI.container.actionItemsPage.clickDropDown();
        Hooks_UI.container.actionItemsPage.selectFromDropDown("Pending");
        Assert.assertTrue(Hooks_UI.container.actionItemsPage.verifyIncompleteActionList());
    }

    @Then("user sees the new Employee onboarding entry")
    public void userSeesTheNewEmployeeOnboardingEntry() {
        Assert.assertTrue(Hooks_UI.container.actionItemsPage.getEmployeeName(Hooks_UI.data.get("FirstName")));
    }

    @Then("user sees the entry as done")
    public void userSeesTheEntryAsDone() throws InterruptedException {
        Hooks_UI.container.actionItemsPage.clickDropDown();
        Hooks_UI.container.actionItemsPage.selectFromDropDown("Done");
        Assert.assertTrue(Hooks_UI.container.actionItemsPage.getEmployeeName(Hooks_UI.data.get("FirstName")));
    }
}
