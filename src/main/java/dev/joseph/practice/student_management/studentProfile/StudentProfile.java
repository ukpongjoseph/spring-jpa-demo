package dev.joseph.practice.student_management.studentProfile;

import dev.joseph.practice.student_management.student.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "studentProfileTable")
public class StudentProfile {
    @Id
    @GeneratedValue
    private int Id;

    private String profile;
    
    @OneToOne
    @JoinColumn(name = "studentProfile")
    private Student student;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }


    public StudentProfile(String profile) {
        this.profile = profile;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
