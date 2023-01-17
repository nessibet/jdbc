package com.tpe.repository;

import com.tpe.domain.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {

    void save(Course course);

    List<Course> getAll();

    Optional<Course> findById(Long id);

    void delete(Long id);
}
