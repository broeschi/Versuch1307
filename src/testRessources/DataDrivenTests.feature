Feature: Data Driven Tests
This feature covers different examples of data driven testing in Cucumber

Scenario: Wenn ich einen Stich erstellen will
Given Vereinsverwaltung l�uft
When Ich w�hle neuen Stich erstellen
Then �ffnet sich ein Fenster
And der Stich wird sequenzweise erfasst