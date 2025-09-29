package com.example.demo.course;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public void addNewCourse(Course course) {
        Optional<Course> courseOptional = courseRepository.findCourseByTitle(course.getTitle());
        if(courseOptional.isPresent()) {
            throw new IllegalStateException("title taken");
        }
        courseRepository.save(course);
    }

    public void deleteCourse(Long courseId) {
        boolean exists = courseRepository.existsById(courseId);
        if(!exists) {
            throw new IllegalStateException(
                    "course with id " + courseId + " does not exist");
        }
        courseRepository.deleteById(courseId);
    }

    @Transactional
    public void updateCourse(Long courseId, String title, String instructor, String dept) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalStateException("course with id " + courseId + " does not exist"));
        
        if(title != null && title.length() > 0 &&
        !Objects.equals(course.getTitle(), title)) {
            Optional<Course> courseOptional = courseRepository.findCourseByTitle(title);
            if(courseOptional.isPresent()) {
                throw new IllegalStateException("title taken");
            }
            course.setTitle(title);
        }
        
        if(instructor != null && instructor.length() > 0 &&
        !Objects.equals(course.getInstructor(), instructor)) {
            course.setInstructor(instructor);
        }
        
        if(dept != null && dept.length() > 0 &&
        !Objects.equals(course.getDept(), dept)) {
            course.setDept(dept);
        }
    }
}
