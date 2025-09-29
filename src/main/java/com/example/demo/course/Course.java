package com.example.demo.course;

import jakarta.persistence.*;

@Entity
@Table
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String title;
    private String instructor;
    private String dept;

    public Course() {
    }

    public Course(Long courseId, String title, String instructor, String dept) {
        this.courseId = courseId;
        this.title = title;
        this.instructor = instructor;
        this.dept = dept;
    }

    public Course(String title, String instructor, String dept) {
        this.title = title;
        this.instructor = instructor;
        this.dept = dept;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", instructor='" + instructor + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }
}
