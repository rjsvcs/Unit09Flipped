package unit09.lambdas;

/**
 * A class that represents a student with a first and last na
 */
public class Student implements Comparable<Student> { // remove Comparable
    /**
     * The student's first name.
     */
    private final String firstName;

    /**
     * The student's last name.
     */
    private final String lastName;

    /**
     * Creates a new student.
     * 
     * @param firstName The new student's first name.
     * @param lastName The new student's last name.
     */
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Student other) {
        return this.firstName.compareTo(other.firstName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "{" + this.lastName + ", " + this.firstName + "}";
    }
}
