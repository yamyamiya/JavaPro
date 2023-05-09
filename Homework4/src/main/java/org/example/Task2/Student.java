package org.example.Task2;
//Создать класс Студент с полями имя, фамилия, номер курса, средний балл.
public class Student {
    String firstName;
    String lastName;

    int classNumber;
    double averageNote;

    public Student(String firstName, String lastName, int classNumber, double averageNote) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.classNumber = classNumber;
        this.averageNote = averageNote;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", classNumber=" + classNumber +
                ", averageNote=" + averageNote +
                '}';
    }
}
