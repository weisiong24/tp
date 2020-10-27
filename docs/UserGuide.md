# User Guide

## Introduction

WhereGotTime is an application for the student to check their timetable and compare them against their peers for a common timeslot to be able so that they can schedule a study time together

## Quick Start

1. Ensure you have Java 11 or above installed in your Computer.
1. Down the latest version of  WhereGotTime.jar from [here](https://github.com/AY2021S1-CS2113-T13-3/tp/releases/tag/v1.0).
1. Copy the jar file into an empty folder you want to use as the home folder for your WhereGotTime.
1. Open a command window in that folder
1. Run the command java -jar {filename}.jar e.g., java -jar Duke.jar (i.e., run the command in the same folder as the jar file)
1. Type the command in the command box and press Enter to execute it. e.g. typing <strong>exit</strong> and pressing Enter will close the app.<br/>
Some example commands you can try:
    1.login John Snow 123123: login as John Snow
    1. add /CS2113 Lec /fri /1600-1800 /lt23: Adds an event named CS2113 Lecture for current logged in the student (John Snow) to Time Table
    1. edit /mon /3 /1300-1400 : Edits an event named CS2113 on Fri for current logged in student (John Snow) in the TimeTable
    1. list /all: list of all the classes that John Snow has in a new line, enumerated.
    1. delete 2 : Deletes the 2nd class shown in the current list.
    1. clear /day: Deletes all classes in the current list for John Snow

## Features 
* login user
* login timetable
* Add timetable
* Edit timetable
* Compare timetable
* delete timetable
* clear timetable
* exit program

### Adding a timetable: `add`
Adds a new timetable to the list of timetable arraylist.

Format: `add /event name /day /timeStart-timeEnd /Location`
  
Example of usage: 

`add /CS2040C Tut /mon /0800-1000 /COM1-2`

`add /CG2028 Tut /Thu /0900-1100 /E4-4-1`

### Exiting the program: `bye`
Exits the Program<br/>

Format: `bye`



## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add timetable `add /event name /day /timeStart-timeEnd /Location`
* Edit timetable `edit /mon /3 /1300-1400`
* Exit program `bye`