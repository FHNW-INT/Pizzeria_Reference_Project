package com.example.demo.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacher_id", nullable = false)
    private Long teacherId;

    @Column(name = "teacher_firstname", nullable = false)
    private String teacherFirstname;

    @Column(name = "teacher_lastname", nullable = false)
    private String teacherLastname;

    // Getters and Setters
    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherFirstname() {
        return teacherFirstname;
    }

    public void setTeacherFirstname(String teacherFirstname) {
        this.teacherFirstname = teacherFirstname;
    }

    public String getTeacherLastname() {
        return teacherLastname;
    }

    public void setTeacherLastname(String teacherLastname) {
        this.teacherLastname = teacherLastname;
    }
}
