# Developer Guide

## 1. Table of content
**1. Setting Up**\
**2. Design**

## 2. Design

### 2.1 Architecture
The **Architecture Diagram** below shows a high-level design of WhereGotTime. The design is based 
on multi-tier architecture where the processing, UI, logic and data management are separated. The upper
tiers make use of services provided by lower tiers.

![](team/OverallArchi.png)<br/>


## 3. Design & implementation

### Add Function

#### System Architecture of the Add Function<br/>

![](team/Architect-digram.PNG)

The Architecture Diagram given above explains the high-level design of the add command.<br/>

Below we will discuss a quick overview of each component.

* UI: The User Interface of the app<br/>
* Add Command: The main logic command of the add function<br/>
* Timetable: The arraylist where events that are added are stored accordingly<br/>

#### Design of the Add Function<br/>

UML Class Diagram of the Add function:
![](team/uml.PNG)<br/>

1) The Add function gets the inputs from the User and places it to the event class so that 
it can parser to string.<br/>
2)  It will then pass the event data onto UI class to display and inform user of the event added 
to the timetable.<br/>
3) Next,the add function will pass all the parameters (event name,day,time
and location) to the timetable class into its arraylist divided by the day of the week<br/>

#### Sequence Design of Add Function<br/>
![](team/seqdiagram.jpg)<br/>

#### Improvements to be made to Version 2.0<br/>
* To ensure that the users do not enter duplicate event that has the same timing or in between the time 
that is entered. 
* A verification check is added to the add command of the version 2.0 of WhereGotTime.

E.g.
* add /CS2113 Lec /Mon /1200-1400 /LT21<br/>
* add /CS2113 Lec /Mon /1300-1400 /LT22<br/>
* add /CS2040C Tut /Mon /1300-1500 /LT32<br/>

The above would result in the first line being add,
while the other two will result in the app giving an error message
prompting the user to re-enter again.<br/>

### Edit Function<br/>
#### Class Diagram <br/>
![](team/ClassDiagram_EditCommand.png)<br/>

### Delete Function<br/>

### Clear Function<br/>

### Display Function<br/>

### Compare Function<br/>
#### System Architecture of the Compare Function<br/>
![](team/CompareCommand_ClassDiagram.jpg) <br/>
The System Architecture given above explains the high-level design of the <b>COMPARE</b> command.<br/>

Listed below are some features we will be highlighting:<br/>

* Ui: The User Interface of the app<br/>
* CompareCommand: The main logic command of the <b>COMPARE</b> function<br/>
* Timetable: The arraylist where events that are added are stored accordingly<br/>
* User: User(s) of the program<br/>
* UserList: An arraylist of User<br/>

#### Design of the Compare Function<br/>
![](team/CompareCommand_UML_Diagram.jpg)<br/>

1) The <b>COMPARE</b> function gets the inputs from the User and retrieves the User's / Target User's<br/>
timetables based on a specific day. It will then compare the timetables and return an arraylist
of common timeslots.<br/>
2)  It will then pass the arraylist onto Ui class to display the range of common <br/>
timeslots the User and Target User have on a specific day of the week.<br/>


#### Sequence Design of Compare Function<br/>
![](team/CompareCommand_SequenceDesign.jpg) <br/>

#### Improvements to be made to Version 2.0<br/>
* Display a range of timings instead of individual hours<br/>
* Remove edge cases<br/>

E.g.<br/>
* compare /Alex /Mon<br/>
* compare /Tammy /Mon<br/>

These cases above would no longer output "0000HR, 0100HR" etc but
instead "0000HR - 1000HR"

### Login Function
#### System Architecture of the Login Function<br/>
![](team/LogInCommand_Architecture_Diagram_v001.png)
* UI: The User Interface of the app<br/>
* LogInCommand: The main logic command of the Login function<br/>
* Parser: The main logic that takes input data and builds the command.
* User: The Class where username, password, etc are stored
* UserList: The Class that creates an ArrayList where the User objects will be stored

#### Class Diagram
![](team/LogInCommand_Class_Diagram_v002.png)
1.) The LogInCommand checks the UserList to check if the inputted user already exists.
<br/>
2.) In the case that the User is a first time user, the LogInCommand will create a new User object then add it into 
the UserList. 

#### Sequence Diagram
![](team/LogInCommand_Sequence_v002.png)

1.) When the user inputs a Login Command, a LogInCommand Object is created with the input member Username and Password.
<br/>
2.) The Login Command is then executed by sending the users UserList, ui Ui and the User nowUser to the method where 
it search the users to check if the input Username already exists with the correct password.
<br/>
3.) If the User already exists, it will return the User back to the method as currentUser. Otherwise, it will create a
User with the input Username and Password.
<br/>

#### Improvements to be made to Version 2.0<br/>
* In order to protect the User's privacy, the User's Passwords have been encrypted on the save file. 
* A Cryptography Class with encipherPassword and decipherPassword has been implemented as part of the version 2.0 of 
WhereGotTime.

## Product scope
### Target user profile

Our Application, WhereGotTime is developed for University students.

### Value proposition
It was developed to solve the inconvenience students face when accessing timetables and lecture venues and
to keep track of their timetable.
It is also developed to assist in finding common available time slots for students to study with their peers.

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|login to my own timetable|be sure that it is my own timetable that is shown there|
|v1.0|new user|add events into my timetable for the day|refer to the timetable to remind me of the event|
|v1.0|new user|edit events that I have entered into my timetable for the day|easily change the details as I need it|
|v1.0|new user|delete events in my timetable for the day|remove an event in the timetable that I do not wish to keep|
|v1.0|new user|clear my timetable for the day|so that I can remove all the entries I have entered wrongly|
|v1.0|new user|compare my timetable with my friends|schedule a common time for revision together|
|v2.0|user|have my password encrypted|only I can access my own timetables|
|v2.0|user|be assured that my inputs are correctly added|my input are correctly convey into the timetable|
|v2.0|user|access my saved timetables|I do not have to manually enter the timetables again|

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
