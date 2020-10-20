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
login Alex /123<\b>
add /CS2113 Lec /mon /1200-1300 /LT21<\b>
add /CS3243 Lec /mon /1400-1500 /LT22<\b>
add /CS2040C Tut /mon /0800-1000 /COM1-2<\b>
add /CG2028 Tut /Thu /0900-1100 /E4-4-1<\b>
add /CG2023 Lec /Fri /1700-1800 /E7-3-10<\b>
list /all<\b>
list /mon<\b>
edit /mon /3 /1300-1400<\b>
edit /fri /1 /0900-1100<\b>
list /all<\b>
list /mon<\b>
login Tammy /321<\b>
add /CS2113 Lec /mon /1200-1300 /LT21<\b>
add /CS2040C Tut /mon /0800-1000 /COM1-2<\b>
add /CG2028 Tut /Thu /0900-1100 /E4-4-1<\b>
compare /Alex /mon<\b>
list /mon<\b>
edit /mon /2 /1000-1200<\b>
compare /Alex /mon<\b>
login Alex /123<\b>
delete /mon /2<\b>
clear /fri<\b>
bye<\b>
