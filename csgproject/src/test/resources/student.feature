#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Mrs Masuku student attendance app
	Scenario: client makes call to GET api/class
	Given: the client calls GET api/class
	When: the client receives status code of 200
	Then: verity the data
	
	  Examples: 
      | Class name  | Grade | Date       | Time  | Student Name |
      | Economics   |     5 | 2021/07/05 | 09:00 | Tinashe      |
      | Mathematics |     7 | 2021/07/05 | 11:00 | Tanaka       |
