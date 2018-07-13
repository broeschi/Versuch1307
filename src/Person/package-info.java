/**
 * 
 */
/**
 * Die Teilnehmenden des OP und FS sind Personen mit Adressen.
 * In diesem Umfeld wird noch die AHV-Nummer, der militärische Grad sowie die militärische Einteilung benötigt.
 * Personen müssen gesucht, ihre Adresse geändert und Resultate erfasst werden können
 * 
 * Als Subklasse der Personen wird die Klasse Resultate erstellt. Diese enthält wiederum die Subklassen FS und OP.
 * In der Klasse Resultate wird berechnet, ob ein Teilnehmer die Schiesspflicht erfüllt hat und ob der Schütze die Limite erreicht hat, um ausgezeichnet zu werden.
 * Für die Berchnung wird das Package Stammdaten benötigt. Dort sind die erfolderlichen Limiten abgebildet.
 * 
 * @author Rudolf Broger
 *
 */
package Person;