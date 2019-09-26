@regression
Feature: Feature that fails

  @regression
  Scenario: Fail to verify mungobungo as a synnefo contributor
    When The Synnefo Github contributors page is open
    Then There is mungobungo in the contributors list