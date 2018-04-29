import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    // Opens scanner to receive user input
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Creating tree maps to hold people
        TreeMap<Integer, Student> studentMap = new TreeMap<>();
        TreeMap<Integer, Staff> staffMap = new TreeMap<>();
        TreeMap<Integer, Faculty> facultyMap = new TreeMap<>();

        // Method to create some sample entries to populate the list
        initialEntries(studentMap, staffMap, facultyMap);

        // Boolean to keep the program looping back to its main menu
        //noinspection InfiniteLoopStatement
        while (true) {
            menu(studentMap, staffMap, facultyMap);
        }
    }

    /**
     * Method to add sample entries for initial manipulation
     *
     * @param studentMap: Map containing student information
     * @param staffMap:   Map containing staff information
     * @param facultyMap: Map containing faculty information
     */
    private static void initialEntries(TreeMap<Integer, Student> studentMap, TreeMap<Integer, Staff> staffMap, TreeMap<Integer, Faculty> facultyMap) {
        studentMap.put(348134, new Student("Rose", "Ruby", "rubyrose@haven.edu", 1, 348134));
        studentMap.put(464253, new Student("Schnee", "Weiss", "weissschnee@haven.edu", 1, 464253));
        studentMap.put(972493, new Student("Belladonna", "Blake", "blakebelladonna@haven.edu", 1, 972493));
        studentMap.put(189348, new Student("Xiao Long", "Yang", "yangxiaolong@haven.edu", 1, 189348));

        staffMap.put(498267, new Staff("Port", "Mr.", "Peter", "peterport@haven.edu", "HIST202", 498267));
        staffMap.put(917348, new Staff("Oobleck", "Mr.", "Bartholomew", "bartoobleck@haven.edu", "HIST301", 917348));
        staffMap.put(430789, new Staff("Goodwitch", "Ms.", "Glynda", "glyndagoodwitch@haven.edu", "ADMIN-3", 430789));

        facultyMap.put(111111, new Faculty("Ozpin", "Oscar", "ozpin@haven.edu", "ADMIN-1", "yes", 111111));
    }

    private static void menu(TreeMap<Integer, Student> studentMap, TreeMap<Integer, Staff> staffMap, TreeMap<Integer, Faculty> facultyMap) {
        System.out.println("****");
        System.out.println("Welcome to the Haven Academy Directory");
        System.out.println("****");
        System.out.println("Please enter a command:");
        String in = input.nextLine();
        // Switch to call various methods depending on input from scanner
        switch (in) {
            case "add student":
                addStudent(studentMap, staffMap, facultyMap);
                break;
            case "add staff":
                addStaff(studentMap, staffMap, facultyMap);
                break;
            case "add faculty":
                addFaculty(studentMap, staffMap, facultyMap);
                break;
            case "modify":
                modifyPerson(studentMap, staffMap, facultyMap);
                break;
            case "print all":
                printDirectory(studentMap, staffMap, facultyMap);
                break;
            case "print":
                printPerson(studentMap, staffMap, facultyMap);
                break;
            case "remove":
                removePerson(studentMap, staffMap, facultyMap);
                break;
            case "help":
                System.out.println("add student, add staff, add faculty, modify, print, print all, remove, help, exit");
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("Input not recognized. For a list of commands, type help.");
                break;
        }
    }

    /**
     * Method for adding student to database
     * Asks for ID, first/last name, email,
     * and year then adds them to tree
     *
     * @param studentMap : Map containing student information
     * @param staffMap : Map containing staff information
     * @param facultyMap : Map containing faculty information
     */
    private static void addStudent(TreeMap<Integer, Student> studentMap, TreeMap<Integer, Staff> staffMap, TreeMap<Integer, Faculty> facultyMap) {
        System.out.println("Please enter the new student ID (six digits):");
        String in = input.nextLine();
        if (in.toLowerCase().equals("exit")) {
            menu(studentMap, staffMap, facultyMap);
        }

        // Checks entered string to be sure zero is not the first digit
        String idCheck = in.substring(0, 1);
        if ((in.length() <= 6) && !idCheck.equals(0)) { // If zero is not the first digit, function continues

            // Checks if entered ID is a number
            try {
                Integer.parseInt(in);
            }
            catch (NumberFormatException e) {
                System.out.println("Student ID must be a number.");
                // Recursive calls are used to restart the specific method
                addStudent(studentMap, staffMap, facultyMap);
            }
            int id = Integer.parseInt(in);

            // If statement to make sure studentMap does not already contain the entered ID
            if (!studentMap.containsKey(id)) {
                // Uses input from user and stores them into appropriate strings
                System.out.println("Please enter the student's first name:");
                String firstName = input.nextLine();

                System.out.println("Please enter the student's last name:");
                String lastName = input.nextLine();

                System.out.println("Please enter the student's email address:");
                String email = input.nextLine();

                System.out.println("Please enter what year the student is in (1 - 4):");
                int year = Integer.parseInt(input.nextLine());

                // Adds all input to a new entry into the map when all fields filled, creating a new student
                studentMap.put(id, new Student(lastName, firstName, email, year, id));

                // Prints confirmation message then returns to main menu
                System.out.println("Student added!");
                System.out.println(studentMap.get(id));
            }
            else {
                System.out.println("This ID already exists!");
                addStudent(studentMap, staffMap, facultyMap);
            }
        }
        else { // If zero is the first digit (or the ID is less than six digits), error is thrown
            System.out.println("ID length error - ID must be six digits and cannot begin with zero");
            addStudent(studentMap, staffMap, facultyMap);
        }
    }

    /**
     * Method for adding staff to database
     * Asks for ID, first/last name, title,
     * email, and office then adds them to tree
     *
     * @param studentMap : Map containing student information
     * @param staffMap : Map containing staff information
     * @param facultyMap : Map containing faculty information
     */
    private static void addStaff(TreeMap<Integer, Student> studentMap, TreeMap<Integer, Staff> staffMap, TreeMap<Integer, Faculty> facultyMap) {
        System.out.println("Please enter the new staff ID (six digits):");
        String in = input.nextLine();
        if (in.toLowerCase().equals("exit")) {
            menu(studentMap, staffMap, facultyMap);
        }
        String idCheck = in.substring(0, 1);
        if ((in.length() <= 6) && !idCheck.equals(0)) {
            try {
                Integer.parseInt(in);
            }
                catch (NumberFormatException e) {
                System.out.println("Staff ID must be a number.");
                addStaff(studentMap, staffMap, facultyMap);
            }
            int id = Integer.parseInt(in);

            if (!staffMap.containsKey(id)) {

                System.out.println("Please enter the staff's last name:");
                String lastName = input.nextLine();

                System.out.println("Please enter this staff's title (Mr., Ms., etc.):");
                String title = input.nextLine();

                System.out.println("Please enter this staff's first name:");
                String firstName = input.nextLine();

                System.out.println("Please enter the staff's email address:");
                String email = input.nextLine();

                System.out.println("Please enter what office this staff is in:");
                String office = input.nextLine();

                staffMap.put(id, new Staff(lastName, title, firstName, email, office, id));
                System.out.println("Staff added!");
                System.out.println(staffMap.get(id));
            }
            else {
                System.out.println("This ID already exists!");
                addStaff(studentMap, staffMap, facultyMap);
            }
        }
        else {
            System.out.println("ID length error - ID must be six digits and cannot begin with zero");
            addStaff(studentMap, staffMap, facultyMap);
        }
    }

    /**
     * Method for adding a faculty member
     * @param studentMap : Map containing student information
     * @param staffMap : Map containing staff information
     * @param facultyMap : Map containing faculty information
     */
    private static void addFaculty(TreeMap<Integer, Student> studentMap, TreeMap<Integer, Staff> staffMap, TreeMap<Integer, Faculty> facultyMap) {
        System.out.println("Please enter the new faculty ID (six digits):");
        String in = input.nextLine();
        if (in.toLowerCase().equals("exit")) {
            menu(studentMap, staffMap, facultyMap);
        }
        String idCheck = in.substring(0, 1);
        if ((in.length() <= 6) && !idCheck.equals(0)) {
            try {
                Integer.parseInt(in);
            } catch (NumberFormatException e) {
                System.out.println("Faculty ID must be a number.");
                addFaculty(studentMap, staffMap, facultyMap);
            }
            int id = Integer.parseInt(in);

            if (!facultyMap.containsKey(id)) {
                System.out.println("Please enter the faculty member's last name:");
                String lastName = input.nextLine();

                System.out.println("Please enter this faculty member's first name:");
                String firstName = input.nextLine();

                System.out.println("Please enter the faculty member's email address:");
                String email = input.nextLine();

                System.out.println("Please enter what office this faculty member is in:");
                String office = input.nextLine();

                System.out.println("Is this faculty member tenured?");
                String tenure = input.nextLine();

                facultyMap.put(id, new Faculty(lastName, firstName, email, office, tenure, id));
                System.out.println("Staff added!");
                System.out.println(facultyMap.get(id));
            } else {
                System.out.println("This ID already exists!");
                addFaculty(studentMap, staffMap, facultyMap);
            }
        } else {
            System.out.println("ID length error - ID must be six digits and cannot begin with zero");
            addFaculty(studentMap, staffMap, facultyMap);
        }
    }

    /**
     * Method for modifying an existing entry
     * in the tree maps.
     * @param studentMap: Map containing student information
     * @param staffMap: Map containing staff information
     * @param facultyMap: Map containing faculty information
     */
    private static void modifyPerson(TreeMap<Integer, Student> studentMap, TreeMap<Integer, Staff> staffMap, TreeMap<Integer, Faculty> facultyMap) {
        System.out.println("Which category do you want to modify (student, staff, faculty)?");
        String in = input.nextLine();

        switch (in.toLowerCase()) {
            case "student":
                modifyStudent(studentMap, staffMap, facultyMap);
                break;
            case "staff":
                modifyStaff(studentMap, staffMap, facultyMap);
                break;
            case "faculty":
                modifyFaculty(studentMap, staffMap, facultyMap);
                break;
            case "exit":
                System.out.println("Returning to menu...");
                break;
            default:
                System.out.println("Category does not exist.");
                modifyPerson(studentMap, staffMap, facultyMap);
                break;
        }

    }

    /**
     * Method to modify a student in the directory
     *
     * @param studentMap: Map containing student information
     * @param staffMap:   Map containing staff information
     * @param facultyMap: Map containing faculty information
     */
    private static void modifyStudent(TreeMap<Integer, Student> studentMap, TreeMap<Integer, Staff> staffMap, TreeMap<Integer, Faculty> facultyMap) {
        System.out.println("Please enter the ID of the student you want to modify:");
        if (input.nextLine().toLowerCase().equals("exit")) {
            menu(studentMap, staffMap, facultyMap);
        }
        try {
            int id = Integer.parseInt(input.nextLine());
            if (studentMap.containsKey(id)) {
                System.out.println("Modify this student? (y/n)");
                System.out.println(studentMap.get(id));
                String in = input.nextLine();
                switch (in.toLowerCase()) {
                    case "y":
                        System.out.println("Please enter the new information.");
                        System.out.println("Enter the first name:");
                        String firstName = input.nextLine();

                        System.out.println("Enter the last name:");
                        String lastName = input.nextLine();

                        System.out.println("Enter the email:");
                        String email = input.nextLine();

                        System.out.println("Enter the year:");
                        int year = Integer.parseInt(input.nextLine());

                        studentMap.replace(id, new Student(lastName, firstName, email, year, id));
                        System.out.println("Entry updated!");
                        System.out.println(studentMap.get(id));
                        break;
                    case "n":
                        break;
                    default:
                        System.out.println("Input not recognized.");
                }
            }
            else if (!studentMap.containsKey(id)) {
                System.out.println("ID not found.");
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Entry must be a number.");
            modifyPerson(studentMap, staffMap, facultyMap);
        }
    }

    /**
     * Method to modify a staff in the directory
     *
     * @param studentMap: Map containing student information
     * @param staffMap:   Map containing staff information
     * @param facultyMap: Map containing faculty information
     */
    private static void modifyStaff(TreeMap<Integer, Student> studentMap, TreeMap<Integer, Staff> staffMap, TreeMap<Integer, Faculty> facultyMap) {
        System.out.println("Please enter the ID of the staff you want to modify:");
        if (input.nextLine().toLowerCase().equals("exit")) {
            menu(studentMap, staffMap, facultyMap);
        }
        try {
            int id = Integer.parseInt(input.nextLine());
            if (staffMap.containsKey(id)) {
                System.out.println("Modify this staff? (y/n)");
                System.out.println(staffMap.get(id));
                String in = input.nextLine();
                switch (in.toLowerCase()) {
                    case "y":
                        System.out.println("Please enter the new information.");
                        System.out.println("Please enter the staff's last name:");
                        String lastName = input.nextLine();

                        System.out.println("Please enter this staff's title (Mr., Ms., etc.):");
                        String title = input.nextLine();

                        System.out.println("Please enter this staff's first name:");
                        String firstName = input.nextLine();

                        System.out.println("Please enter the staff's email address:");
                        String email = input.nextLine();

                        System.out.println("Please enter what office this staff is in:");
                        String office = input.nextLine();

                        staffMap.replace(id, new Staff(lastName, title, firstName, email, office, id));
                        System.out.println("Entry updated!");
                        System.out.println(staffMap.get(id));
                        break;
                    case "n":
                        modifyPerson(studentMap, staffMap, facultyMap);
                        break;
                }
            }
            else if (!staffMap.containsKey(id)) {
                System.out.println("ID not found.");
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Entry must be a number.");
            modifyPerson(studentMap, staffMap, facultyMap);
        }

    }

    /**
     * Method to modify a faculty in the directory
     *
     * @param studentMap: Map containing student information
     * @param staffMap:   Map containing staff information
     * @param facultyMap: Map containing faculty information
     */
    private static void modifyFaculty(TreeMap<Integer, Student> studentMap, TreeMap<Integer, Staff> staffMap, TreeMap<Integer, Faculty> facultyMap) {
        System.out.println("Please enter the ID of the faculty you want to modify:");
        if (input.nextLine().toLowerCase().equals("exit")) {
            menu(studentMap, staffMap, facultyMap);
        }
        try {
            int id = Integer.parseInt(input.nextLine());
            if (facultyMap.containsKey(id)) {
                System.out.println("Modify this faculty? (y/n)");
                System.out.println(facultyMap.get(id));
                String in = input.nextLine();
                switch (in.toLowerCase()) {
                    case "y":
                        System.out.println("Please enter the new information.");
                        System.out.println("Please enter the faculty member's last name:");
                        String lastName = input.nextLine();

                        System.out.println("Please enter this faculty member's first name:");
                        String firstName = input.nextLine();

                        System.out.println("Please enter the faculty member's email address:");
                        String email = input.nextLine();

                        System.out.println("Please enter what office this faculty member is in:");
                        String office = input.nextLine();

                        System.out.println("Is this faculty member tenured?");
                        String tenure = input.nextLine();

                        facultyMap.replace(id, new Faculty(lastName, firstName, email, office, tenure, id));
                        System.out.println("Entry updated!");
                        System.out.println(facultyMap.get(id));
                        break;
                    case "n":
                        break;
                }
            }
            else if (!facultyMap.containsKey(id)) {
                System.out.println("ID not found.");
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Entry must be a number.");
            modifyPerson(studentMap, staffMap, facultyMap);
        }

    }

    /**
     * Prints the contents of all three maps,
     * sorted in alphabetical order by last name
     * @param studentMap: Map containing student information
     * @param staffMap:   Map containing staff information
     * @param facultyMap: Map containing faculty information
     */
    private static void printDirectory(TreeMap<Integer, Student> studentMap, TreeMap<Integer, Staff> staffMap, TreeMap<Integer, Faculty> facultyMap) {
        // Get a set of entries from each map
        Set studentSet = studentMap.entrySet();
        Set staffSet = staffMap.entrySet();
        Set facultySet = facultyMap.entrySet();

        // Making an iterator to go through each set
        Iterator studentIt = studentSet.iterator();
        Iterator staffIt = staffSet.iterator();
        Iterator facultyIt = facultySet.iterator();


        // Printing the data
        System.out.println("--- STUDENTS ---");
        while (studentIt.hasNext()) {
            Map.Entry a = (Map.Entry) studentIt.next();
            System.out.println(a.getValue());
        }
        System.out.println("--- STAFF ---");
        while (staffIt.hasNext()) {
            Map.Entry a = (Map.Entry) staffIt.next();
            System.out.println(a.getValue());
        }
        System.out.println("--- FACULTY ---");
        while (facultyIt.hasNext()) {
            Map.Entry a = (Map.Entry) facultyIt.next();
            System.out.println(a.getValue());
        }


        }

    /**
     * Method that asks for the ID of a person
     * then prints their information
     * @param studentMap: Map containing student information
     * @param staffMap:   Map containing staff information
     * @param facultyMap: Map containing faculty information
     */
    private static void printPerson(TreeMap<Integer, Student> studentMap, TreeMap<Integer, Staff> staffMap, TreeMap<Integer, Faculty> facultyMap) {
        System.out.println("Select where to print from: student, staff, faculty:");
        String in = input.nextLine();

        if (in.toLowerCase().equals("exit")) {
            menu(studentMap, staffMap, facultyMap);
        }

        switch (in.toLowerCase()) {
            case "student":
                // Asks user for ID of relevant category then prints the matching value
                System.out.println("Please enter the ID of the student you want to print:");
                int id = Integer.parseInt(input.nextLine());
                if (studentMap.containsKey(id)) {
                    System.out.println(studentMap.get(id));
                }
                else {
                    System.out.println("ID does not exist!");
                }
                break;
            case "staff":
                System.out.println("Please enter the ID of the staff you want to print:");
                id = Integer.parseInt(input.nextLine());
                if (staffMap.containsKey(id)) {
                    System.out.println(staffMap.get(id));
                }
                else {
                    System.out.println("ID does not exist!");
                }
                break;
            case "faculty":
                System.out.println("Please enter the ID of the faculty you want to print:");
                id = Integer.parseInt(input.nextLine());
                if (facultyMap.containsKey(id)) {
                    System.out.println(facultyMap.get(id));
                }
                else {
                    System.out.println("ID does not exist!");
                }
                break;
            case "exit":
                System.out.println("Returning to menu...");
                break;
            default:
                System.out.println("Category not recognized.");
                printPerson(studentMap, staffMap, facultyMap);
                break;
        }
    }

    /**
     * Method for removing an individual
     * from the maps.
     * @param studentMap: Map containing student information
     * @param staffMap:   Map containing staff information
     * @param facultyMap: Map containing faculty information
     */
    private static void removePerson(TreeMap<Integer, Student> studentMap, TreeMap<Integer, Staff> staffMap, TreeMap<Integer, Faculty> facultyMap) {
        System.out.println("Select what to remove: student, staff, faculty:");
        String in = input.nextLine();

        if (in.toLowerCase().equals("exit")) {
            menu(studentMap, staffMap, facultyMap);
        }

        switch (in.toLowerCase()) {
            case "student":
                removeStudent(studentMap, staffMap, facultyMap);

                break;
            case "staff":
                removeStaff(studentMap, staffMap, facultyMap);
                break;
            case "faculty":
                removeFaculty(studentMap, staffMap, facultyMap);
                break;
            case  "exit":
                System.out.println("Returning to menu...");
                break;
            default:
                System.out.println("Category not recognized.");
                removePerson(studentMap, staffMap, facultyMap);
        }
    }

    private static void removeStudent(TreeMap<Integer,Student> studentMap, TreeMap<Integer,Staff> staffMap, TreeMap<Integer,Faculty> facultyMap) {
        System.out.println("Please enter the student ID:");

        if (input.nextLine().toLowerCase().equals("exit")) {
            menu(studentMap, staffMap, facultyMap);
        }

        int id = Integer.parseInt(input.nextLine());

        if (studentMap.containsKey(id)) {
            System.out.println(studentMap.get(id));
            System.out.println("Remove this student? (y/n)");
            switch (input.nextLine().toLowerCase()) {
                case "y":
                    studentMap.remove(id);
                    System.out.println("Student removed.");
                    break;
                case "n":
                    removePerson(studentMap, staffMap, facultyMap);
                default:
                    System.out.println("Input not recognized.");
                    removePerson(studentMap, staffMap, facultyMap);
            }
        }
    }

    private static void removeStaff(TreeMap<Integer,Student> studentMap, TreeMap<Integer,Staff> staffMap, TreeMap<Integer,Faculty> facultyMap) {
        System.out.println("Please enter the staff ID:");

        if (input.nextLine().toLowerCase().equals("exit")) {
            menu(studentMap, staffMap, facultyMap);
        }

        int id = Integer.parseInt(input.nextLine());

        if (staffMap.containsKey(id)) {
            System.out.println(staffMap.get(id));
            System.out.println("Remove this staFff? (y/n)");
            switch (input.nextLine().toLowerCase()) {
                case "y":
                    staffMap.remove(id);
                    System.out.println("Staff removed.");
                    break;
                case "n":
                    removePerson(studentMap, staffMap, facultyMap);
                default:
                    System.out.println("Input not recognized.");
                    removePerson(studentMap, staffMap, facultyMap);
            }
        }
    }

    private static void removeFaculty(TreeMap<Integer,Student> studentMap, TreeMap<Integer,Staff> staffMap, TreeMap<Integer,Faculty> facultyMap) {
        System.out.println("Please enter the faculty ID:");

        if (input.nextLine().toLowerCase().equals("exit")) {
            menu(studentMap, staffMap, facultyMap);
        }

        int id = Integer.parseInt(input.nextLine());

        if (facultyMap.containsKey(id)) {
            System.out.println(facultyMap.get(id));
            System.out.println("Remove this staff? (y/n)");
            switch (input.nextLine().toLowerCase()) {
                case "y":
                    facultyMap.remove(id);
                    System.out.println("Faculty removed.");
                    break;
                case "n":
                    removePerson(studentMap, staffMap, facultyMap);
                default:
                    System.out.println("Input not recognized.");
            }
        }
    }
}