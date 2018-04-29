/**
 * Defines variables for each person in the database.
 * Every entry in the database is a student by default,
 * different classes inherit it
 */
class Student {
    String firstName;
    String lastName;
    String email;
    int year;
    int id;

    Student(String lastName, String firstName, String email, int year, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.year = year;
        this.id = id;
    }

    Student() {
    }

    public String toString() {
        return  "Name: " + lastName + ", " + firstName + " - ID: " + id + " - Year: " + year + " - Email address: " + email;
    }
}
