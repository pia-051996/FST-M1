@activity5
Feature: data driven with Examples

Scenario Outline: Testing with data from Scenario
Given the user is on the login page
When the user enters "<Usernames>" and '<Passwords>"
And clicks the submit button
Then get the confirnation text and verify message as "<Message>"

Examples:
| Usernames | Passwords   | message              |
| admin     | Password    | Welcome Back, Admin! |
| admin     | Password123 | Invalid credentials|