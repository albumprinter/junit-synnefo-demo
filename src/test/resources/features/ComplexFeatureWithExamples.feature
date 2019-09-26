@regression
Feature: Check a few contributors

  Background:
    Given The CorrelationTracking Github contributors page is open

  Scenario Outline: Ensure that contributors are present
    Then There is <contributor> in the contributors list

    Examples:
      | contributor |
      | kolbasik    |
      | derwasp     |
      | gmariano    |