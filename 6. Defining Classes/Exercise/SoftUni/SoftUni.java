package SoftUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
    private int capacity;
    private List<Student> students;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getCount() {
        return this.students.size();
    }

    public String insert(Student student) {
        if (getCount() + 1 > this.capacity) {
            return "The hall is full.";
        } else {
            if (this.students.contains(student)) {
                return "Student is already in the hall.";
            } else {
                this.students.add(student);
                return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
            }
        }
    }

    public String remove(Student student) {
        if (this.students.contains(student)) {
            this.students.remove(student);
            return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
        } else {
            return "Student not found.";
        }
    }

    public Student getStudent(String firstname, String lastName) {
        for (Student student : this.students) {
            if (student.getFirstName().equals(firstname) &&
                    student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hall size: ").append(this.students.size()).append(System.lineSeparator());
        this.students.forEach(student -> sb.append(student.toString()).append(System.lineSeparator()));
        return sb.toString();
    }
}
