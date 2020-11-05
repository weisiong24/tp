# User Guide

## Introduction

WhereGotTime is an application for the student to check their timetable and compare them against their peers for a common timeslot to be able so that they can schedule a study time together

## Quick Start

1. Ensure you have Java 11 or above installed in your Computer.
1. Down the latest version of  WhereGotTime.jar from [here](https://github.com/AY2021S1-CS2113-T13-3/tp/releases/tag/2.0).
1. Copy the jar file into an empty folder you want to use as the home folder for your WhereGotTime.
1. Open a command window in that folder
1. Run the command java -jar {filename}.jar e.g., java -jar Duke.jar (i.e., run the command in the same folder as the jar file)
1. Type the command in the command box and press Enter to execute it. e.g. typing bye and pressing Enter will close the app.<br/>
Some example commands you can try:
    1. login /John Snow /123123: login as John Snow
    1. add /CS2113 Lec /mon /1600-1800 /lt23: Adds an event named CS2113 Lecture for current logged in the student (John Snow) to Time Table
    1. edit /mon /1 /1300-1400 : Edits an event named CS2113 on Fri for current logged in (John Snow) in the TimeTable
    1. list /all: list of all the classes that John Snow has in a new line, enumerated.
    1. find /CS2113: finds all the classes that John Snow has containing "CS2113"
    1. delete /mon /1 : Deletes the 1st class shown in the current list.
    1. clear /mon: Deletes all classes in the current list for John Snow for his Monday timetable

## Features 
* Login user
* Add timetable
* Edit timetable
* List timetable
* Compare timetable
* Find class
* Delete timetable
* Clear timetable
* Exit program

### Login user: `login`
Creates a new User with inputted username and password (if first time user).
Logs the existing user back into the app. (existing user)

Format: `login /username /password(6-digit)`

Example of usage: 

`login /John /123456`

Expected Output:

![](images/Userlogin_EO.PNG)<br/>

### Adding a timetable: `add`
Adds a new timetable to the list of timetable arraylist.

Format: `add /event name /day /timeStart-timeEnd /Location`
  
Example of usage: 

`add /CS2040C Tut /mon /0800-1000 /COM1-2`

`add /CG2028 Tut /Thu /1200-1300 /E4-4-1`

Expected Output:

![](images/expectedoutput.PNG)<br/>

### Editing a timetable : `edit`
Edits an existing timetable with a new timing.

Format: `edit /day /index /(timeStart-timeEnd)`

Note: You may get the `index` by listing the full timetables using `list /all`

Example of usage:

`edit /mon /1 /1100-1200`

`edit /thu /1 /1300-1500`

Expected Output:

![](images/Edit_EO.PNG)<br/>
### Listing a timetable: `list`
Lists all the classes on a particular day or on all days

Format: `list /day`

Example of usage:

`list /mon`

`list /all`

Expected Output:

![](images/list_EO.PNG)<br/>

![](images/list_all_EO.PNG)<br/>

### Comparing timetables: `compare`
Compares current User's timetable to Target user's timetable and returns a range of common available timeslots.

Format: `compare /TargetUser's name /day`
  
Example of usage: 

`compare /Alex /Mon`

`compare /Tammy /Mon`

### Finding a class: `find`
Lists all the classes based on the keyword entered by user

Format: `find /keyword`

Example of usage:

`find /CG2028`

`find /Tut`

Expected output:

![](images/Find_EO.PNG)<br/>

### Deleting a class: `delete`
Deletes a class as specified by the user 

Format: `delete /day /index`

Example of usage:

`delete /thu /1`

Expected Output:

![](images/Delete_EO.PNG)<br/>

### Clearing timetable: `clear`
Clears all the classes on the day specified by the user

Format: `clear /day`

Example of usage:

`clear /mon`

Expected Output:

![](images/clear_EO.PNG)<br/>

### Exiting the program: `bye`
Exits the Program<br/>

Format: `bye`

Expected output:

![](images/Exit_EO.PNG)<br/>

## Command Summary
* Login user `login /username /password`
* Add timetable `add /event name /day /timeStart-timeEnd /Location`
* Edit timetable `edit /day /index /timeStart-timeEnd`
* List timetable `list /day`
* Compare timetable `compare /target username /day`
* Find class `find /keyword`
* Delete timetable `delete /day /index`
* Clear timetable `clear /day`
* Exit program `bye`
