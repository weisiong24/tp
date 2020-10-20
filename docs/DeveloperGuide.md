# Developer Guide

## Design & implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}


## Product scope
### Target user profile

Our Application, WheregotTime targets University students.

### Value proposition
It was developed to solve the inconvenience student face when accessing timetables and lecture venues and
to keep track of their timetable.
It is also developed to assist in finding common available time slots to study with peers

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
login Alex /123
add /CS2113 Lec /mon /1200-1300 /LT21
add /CS3243 Lec /mon /1400-1500 /LT22
add /CS2040C Tut /mon /0800-1000 /COM1-2
add /CG2028 Tut /Thu /0900-1100 /E4-4-1
add /CG2023 Lec /Fri /1700-1800 /E7-3-10
list /all
list /mon
edit /mon /3 /1300-1400
edit /fri /1 /0900-1100
list /all
list /mon
login Tammy /321
add /CS2113 Lec /mon /1200-1300 /LT21
add /CS2040C Tut /mon /0800-1000 /COM1-2
add /CG2028 Tut /Thu /0900-1100 /E4-4-1
compare /Alex /mon
list /mon
edit /mon /2 /1000-1200
compare /Alex /mon
login Alex /123
delete /mon /2
clear /fri
bye
