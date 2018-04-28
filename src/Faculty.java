/**
 * Subclass of person. Faculty is similar to staff but
 * with tenure instead of title.
 */
public class Faculty extends Student {
    private String office;
    private String tenure;

    Faculty(String lastName, String firstName, String email, String office, String tenure, Integer id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.office = office;
        this.tenure = tenure;
        this.id = id;
    }

    public String toString() {
        return "Name: " + lastName + ", " + firstName + " - ID: " + id + " - Email: " + email + " - Office: " + office + " - Tenured: " + tenure;
    }
}