package dev.joseph.practice.student_management.student;

import dev.joseph.practice.student_management.school.School;
import dev.joseph.practice.student_management.studentProfile.StudentProfile;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "studentTable")
public class Student {
    @Id
    @GeneratedValue

    private int Id;

    private String name;

    private String email;

    private int age;

    @ManyToOne
    @JoinColumn(name = "schoolId")
    private School school;

    @OneToOne(mappedBy = "student")
    private StudentProfile studentProfile;
    
    

    public Student() {
    }

    public Student(String name, String email, int age){
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }



    public int getId() {
        return Id;
    }



    public void setId(int id) {
        Id = id;
    }

    
}
