# Developer Guide

## Design & implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}
login function
Add Function
Edit Function
Delete Function
Clear Function
Display Function
Compare Function

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
|v1.0|new user|add events into my timetable for the day|refer to the timetable to remind me of the event|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

login Alex /123<br/>
add /CS2113 Lec /mon /1200-1300 /LT21<br/>
add /CS3243 Lec /mon /1400-1500 /LT22<br/>
add /CS2040C Tut /mon /0800-1000 /COM1-2<br/>
add /CG2028 Tut /Thu /0900-1100 /E4-4-1<br/>
add /CG2023 Lec /Fri /1700-1800 /E7-3-10<br/>
list /all<br/>
list /mon<br/>
edit /mon /3 /1300-1400<br/>
edit /fri /1 /0900-1100<br/>
list /all<br/>
list /mon<br/>
login Tammy /321<br/>
add /CS2113 Lec /mon /1200-1300 /LT21<br/>
add /CS2040C Tut /mon /0800-1000 /COM1-2<br/>
add /CG2028 Tut /Thu /0900-1100 /E4-4-1<br/>
compare /Alex /mon<br/>
list /mon<br/>
edit /mon /2 /1000-1200<br/>
compare /Alex /mon<br/>
login Alex /123<br/>
delete /mon /2<br/>
clear /fri<br/>
bye<br/>
