@OptionalFields

Feature: OptionalFields
  Description: This feature is to test employee addition in workmotion

  Background:
    Given user login to the system successfully

  Scenario: Verify_EmployeeAdditionWithOUTOptionalFields
    And  user clicks on "Add Employee"
    Then user is landed to the "Country" page
    When user enters "Country name"
    And  user clicks on "Get Started"
    And user sees the "Contract Details" Page
    And  user enters "FirstName" and "LastName"
    And  user answers the Radio Button "Eligible" and "Executive" questions
    And  user enters "Job Title" and "Job Description"
    And  user enters "Business Assignment Context"
    And  user answers the Radio Button "ContractType" and "Part Time" questions
    And  user enters "Working hours"
    And  user enters "Contract Start Date" and "Contract End Date"
    And  user enters "" and "Name of Signatory"
    And  user enters "Title of Signatory" and "Email of Direct Manager"
    When user clicks on "Continue"
    Then user is landed to the "Contract Clause" page
    When user enters "Paid Time Off" and "Probation Period"
    And user enters "Termination Notice Period" and ""
    When user clicks on "Continue"
    Then user is landed to the "Salary Calculator" page
    And  user enters "Base Salary"
    When user clicks on "Continue"
    Then user is landed to the "Invite Employee" page
    And user enters "Email Address"
    When user clicks on "Continue"
    Then user is landed to the "Summary Review" page
    And user clicks on "Confirmation"
    And user clicks on "Finish"
    Then user sees the "success" window

  Scenario: Verify_EmployeeAdditionInActionItems
    And user clicks on "Action Items"
    When user filters for pending action items
    Then user sees the new Employee onboarding entry
    When user clicks on "Mark as Done"
    Then user sees the entry as done