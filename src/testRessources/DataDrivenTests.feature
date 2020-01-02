Feature: Data Driven Tests
This feature covers different examples of data driven testing in Cucumber

Scenario: Wenn ich einen Stich erstellen will
Given Vereinsverwaltung läuft
When Ich wähle neuen Stich erstellen
Then öffnet sich ein Fenster
And der Stich wird sequenzweise erfasst