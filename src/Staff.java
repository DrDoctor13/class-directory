/**
 * Subclass of person. Staff are persons with additional
 * variables for their office and title
 */
public class Staff extends Student {
    private String office;
    private String title;

    Staff(String lastName, String title, String firstName, String email, String office, Integer id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.office = office;
        this.title = title;
        this.id = id;
    }

    public String toString() {
        return  "Name: " + lastName + ", " + title + " " + firstName + " - ID: " + id + " - Email: " + email + " - Office: " + office;
    }
}
