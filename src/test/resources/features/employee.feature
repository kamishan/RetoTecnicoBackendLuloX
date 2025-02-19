Feature: Employee API operations

  Scenario: Retrieve all employees
    Given I send a GET request to retrieve all employees
    When the response status code should be 200
    Then the response should contain a non-empty list of employees

  Scenario: Create a new employee
    Given I send a POST request to create a new employee with name "John Doe", salary "50000", and age "30"
    When the response status code should be 200
    Then the response body should contain the created employee details

  Scenario: Retrieve a single employee
    Given I send a GET request to retrieve employee with id "1"
    When the response status code should be 200
    Then the response body should contain the employee details for id "1"

  Scenario: Delete an employee
    Given I send a DELETE request to delete employee with id "2"
    When the response status code should be 200
    Then the response should indicate successful deletion