package dev.joseph.practice.student_management.school;


import java.util.List;

import dev.joseph.practice.student_management.student.Student;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "schoolTable")
public class School {
    @Id
    @GeneratedValue
    private int Id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "school")
    private List<Student> student;

    public School() {
    }

    public School(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return student;
    }

    public void addStudentToList(Student stud) {
        this.student.add(stud);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
