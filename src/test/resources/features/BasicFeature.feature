Feature: Check synnefo contributors 1

  @regression
  Scenario: Verify that derwasp is a contributor to Synnefo
    When The Synnefo Github contributors page is open
    Then There is derwasp in the contributors list


  @ignore
  Scenario: Verify again that derwasp is a contributor to Synnefo
    When The Synnefo Github contributors page is open
    Then There is derwasp in the contributors list
