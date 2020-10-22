# Developer Guide

## Design & implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}
login function<br/> 

Add Function<br/>

Edit Function<br/>

Delete Function<br/>

Clear Function<br/>

Display Function<br/>

Compare Function<br/>

## Product scope
### Target user profile

Our Application, WheregotTime is developed for University students.

### Value proposition
It was developed to solve the inconvenience students face when accessing timetables and lecture venues and
also to keep track of their timetable.
It is also developed to assist in finding common available time slots for students to study with their peers

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|login to my own timetable|be sure that it is my own timetable that is shown there|
|v1.0|new user|add events into my timetable for the day|refer to the timetable to remind me of the event|
|v1.0|new user|edit events that I have entered into my timetable for the day|easily change the details as I need it|
|v1.0|new user|delete events in my timetable for the day|remove an event in the timetable that I do not wish to keep|
|v1.0|new user|clear my timetable for the day|so that I can remove all the entries I have entered wrongly|
|v1.0|new user|compare my timetable with my friends|schedule a common time for revision together|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list| example only

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

login Alex /123123<br/>
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
login Tammy /321321<br/>
add /CS2113 Lec /mon /1200-1300 /LT21<br/>
add /CS2040C Tut /mon /0800-1000 /COM1-2<br/>
add /CG2028 Tut /Thu /0900-1100 /E4-4-1<br/>
compare /Alex /mon<br/>
list /mon<br/>
edit /mon /2 /1000-1200<br/>
compare /Alex /mon<br/>
login Alex /123123<br/>
delete /mon /2<br/>
clear /fri<br/>
bye<br/>
