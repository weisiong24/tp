package seedu.storage;

import seedu.exception.DukeException;
import seedu.task.Event;
import seedu.user.Cryptography;
import seedu.user.User;
import seedu.user.UserList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//import seedu.duke.task.Deadline;

/**
 * Manages the loading and saving of data to or from a text file.
 */
public class Storage {
    //public String Message_Tick_Symbol = "\u2713";
    private static final String FP = "data/duke.txt";
    private static final String[] days = {"mon", "tue", "wed", "thu", "fri", "sat", "sun"};
    //public static final int MAX_SIZE = 100;

    /**
     * Creates a new file if it does not exist.
     *
     * @throws DukeException if an I/O error has occurred.
     */
    public Storage() throws DukeException {
        //this.FP = FP;
        initialise();
    }

    /**
     * Initialises a file by checking path validity.
     *
     * @throws DukeException if an I/O error has occurred.
     */
    private void initialise() throws DukeException {
        File storageFile = new File(FP);
        File storageFolder = new File(storageFile.getParent());
        if (storageFolder.exists() && storageFolder.isDirectory()) {
            //System.out.println("Data folder found! Finding duke.txt...");
        } else {
            //System.out.println("Data folder not found! Creating one...");
            if (!storageFolder.mkdir()) {
                //throw new DukeException("Attempt to create a data folder failed.");
            }
        }
        try {
            if (storageFile.createNewFile()) {
                //System.out.println("No existing duke.txt found! Creating one...");
            } else {
                //System.out.println("Existing duke.txt found. Loading previously saved task list...");
            }
        } catch (IOException e) {
            //throw new DukeException("Attempt to create duke.txt failed.");
        } finally {
            //System.out.println("Previous task list loaded successfully");
        }
    }

/*    *//**
     * Loads data from the text file to task arraylist.
     *
     * @throws DukeException if an I/O error has occurred.
     *//*
    public ArrayList<Task> load() throws DukeException {
        Scanner reader;
        try {
            reader = new Scanner(new File(FP));
        } catch (FileNotFoundException e) {
            throw new DukeException("Attempt to read duke.txt failed.");
        }
        ArrayList<Task> tasks = new ArrayList<>(MAX_SIZE);
        while (reader.hasNextLine()) {
            loadTask(reader, tasks);
        }
        return tasks;
    }*/
    

    /**
     * Parses the saved tasks according to specified format in order to be loaded.
     *
     * @param reader reads user's string input.
     * @param storageTasks the task arraylist.
     * @throws DukeException if an I/O error has occurred.
     *//*
    private void loadTask(Scanner reader, ArrayList<Task> storageTasks) throws DukeException {
        Task task;
        String[] parsedLines = reader.nextLine().split("\\|");
        for (int i = 0; i < parsedLines.length; i++) {
            parsedLines[i] = parsedLines[i].trim();
        }
        switch (parsedLines[0]) {
        case "D":
            task = new Deadline(parsedLines[2], parsedLines[3]);
            break;
        case "E":
            task = new Event(parsedLines[2], parsedLines[3]);
            break;
        default:
            throw new DukeException("Existing task list format is corrupted. Please check again.");
        }
        if (parsedLines[1].equals("\u2713")) {  //
            task.markAsDone();
        }
        storageTasks.add(task);
    }*/

    /**
     * Loads data from the text file to task arraylist.
     *
     * @throws DukeException if an I/O error has occurred.
     */
    public void load(UserList users) throws DukeException {
        Scanner reader;
        
        try {
            reader = new Scanner(new File(FP));
        } catch (FileNotFoundException e) {
            throw new DukeException("Attempt to read duke.txt failed.");
        }
        while (reader.hasNextLine()) {
            loadTask(reader, users);
        }
    }


    /**
     * Parses the saved tasks according to specified format in order to be loaded.
     *
     * @param reader reads user's string input.
     * @throws DukeException if an I/O error has occurred.
     */
    private void loadTask(Scanner reader, UserList users) throws DukeException {
        String firstLine = reader.nextLine();
        int totalUser = 0;
        if (firstLine.contains("Total user: ")) {
            totalUser = Integer.parseInt(firstLine.substring(12));
        } else {
            throw new DukeException("duke.txt formatting is incorrect.");
        }

        for (int i = 0; i < totalUser; i++) {
            String[] userCredentials = reader.nextLine().split("\\|");
            User newUser = new User(userCredentials[0].trim(), 
                    Cryptography.decipherPassword(userCredentials[1].trim()));
            users.addUser((newUser));

            for (String day : days) {
                reader.nextLine();
                String line = reader.nextLine();

                if (line.isEmpty()) {
                    continue;
                }

                String[] timetables = line.split("\\|");
                for (String s : timetables) {
                    String[] lessons = s.split("/");
                    String description = lessons[1].trim();
                    String location = lessons[2].trim();
                    String timeRange = lessons[3].trim();
                    String[] times = timeRange.split("-");
                    Event lessonEvent = new Event(description, location, times[0].trim(), times[1].trim());
                    ArrayList<Event> timetable = users.getUser(i + 1).getTimetable().getTimetable(day);
                    timetable.add(lessonEvent);
                }
            }
        }
    }

    /**
     * Writes data to the text file.
     *
     * @tasks Arraylist of task.
     * @throws DukeException if an I/O error has occurred.
     *//*
    public void write(TaskList taskList) throws DukeException {
        ArrayList<Task> tasks = taskList.getTaskList();
        try {
            FileWriter fw = new FileWriter(new File(FP));
            writeTask(fw, tasks);
            fw.close();
        } catch (IOException e) {
            throw new DukeException("Attempt to write to duke.txt failed.");
        }
    }*/

    /**
     * Writes data to the text file.
     * #@tasks Arraylist of task.
     * @throws DukeException if an I/O error has occurred.
     */
    public void write(UserList users) throws DukeException {
        //ArrayList<Task> tasks = taskList.getTaskList();
        try {
            FileWriter fw = new FileWriter(new File(FP));
            writeTask(fw, users);
            fw.close();
        } catch (IOException e) {
            throw new DukeException("Attempt to write to duke.txt failed.");
        }
    }

/*    *//**
     * Writes specific task details to the text file in given format.
     *
     * @param fw FileWriter object.
     * @tasks Arraylist of task.
     * @throws IOException if an I/O error has occurred.
     *//*
    private void writeTask(FileWriter fw, ArrayList<Task> tasks) throws IOException, DukeException {
        for (Task t : tasks) {
            fw.write(t.getTaskType() + " | " + t.getStatusIcon() + " | " + t.getDescription());
            if (t.getTaskType().equals("D")) {
                fw.write(" | " + ((Deadline) t).getBy());
            } else if (t.getTaskType().equals("E")) {
                fw.write(" | " + ((Event) t).getAt());
            }
            fw.append("\n");
        }
    }*/

    /**
     * Writes specific task details to the text file in given format.
     *
     * @param fw FileWriter object.
     * @throws IOException if an I/O error has occurred.
     *//*
    private void writeTask(FileWriter fw, UserList users) throws IOException, DukeException {
        for (User k : users.getUserList()) {
            ArrayList<ArrayList<Event>> allTimeTable = k.combineAllTimetable();
            fw.write(k.getName() + " | " + k.getPassWord());
            fw.append("\n");
            for (int i = 0; i < 7; i++) {
                fw.write(days[i]);
                fw.append("\n");
                fw.write(allTimeTable.get(i).toString());
                fw.append("\n");

            }
            fw.write("###");
            fw.append("\n");
        }
    }*/

    /**
     * Writes specific task details to the text file in given format.
     *
     * @param fw FileWriter object.
     * @throws IOException if an I/O error has occurred.
     */
    private void writeTask(FileWriter fw, UserList users) throws IOException, DukeException {
        fw.write("Total user: " + users.getTotalUserCount());
        fw.append("\n");
        for (User u : users.getUserList()) {
            fw.write(u.getName() + " | " + u.getEncipheredPassword());
            fw.append("\n");

            for (String day : days) {
                fw.write(day);
                fw.append("\n");
                ArrayList<Event> timetableIndividualDay = u.getTimetable().getTimetable(day);
                int timetableSize = timetableIndividualDay.size();

                for (int k = 0; k < timetableSize; k++) {
                    String classDescription = timetableIndividualDay.get(k).getDescription();
                    String location = timetableIndividualDay.get(k).getLocation();
                    String startTime = timetableIndividualDay.get(k).getTimeStart();
                    String endTime = timetableIndividualDay.get(k).getTimeEnd();
                    fw.write("/" + classDescription + " /" + location + " /" + startTime
                            + "-" + endTime);
                    if (!(k == (timetableSize - 1))) {
                        fw.write(" | ");
                    }
                }
                fw.append("\n");
            }
        }
    }
}
