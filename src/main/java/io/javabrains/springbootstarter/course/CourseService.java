package io.javabrains.springbootstarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId){
        // return courses;
        List<Course> courses = new ArrayList<>();

        /* Classic way */

        // for (Course course : courseRepository.findAll()) {
        // courses.add(course);
        // }

        /* Lambda way -> but here forEach accepts Consumer which doesnt return any value , so cant use */

        //courseRepository.findAll().forEach(course -> courses.add(course));

        /* Method Reference way */
        courseRepository.findByTopicId(topicId)
                .forEach(courses::add);
        return courses;
    }

    public Course getCourse(String id){
        return courseRepository.findOne(id);
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.delete(id);
    }

    /* Without JPA */

//    List<Course> courses = new ArrayList<>(Arrays.asList(new Course("Spring","Spring  framework","Spring framework description"),
//            new Course("Java","Java  framework","Java framework description"),
//            new Course("JS","JS  framework","JS framework description")));

//    public List<Course> getAllCourse(){
//        return courses;
//    }
//
//    public Course getCourse(String id){
//        return courses.stream().filter(t->t.getId().equals(id)).findFirst().get();
//    }
//
//    public void addCourse(Course course) {
//        courses.add(course);
//    }
//
//    public void updateCourse(String id, Course course) {
//        for(int i=0;i<courses.size();i++){
//            Course t = courses.get(i);
//            if(t.getId().equals(id)){
//                courses.set(i, course);
//                return;
//            }
//        }
//    }

//    public void deleteCourse(String id) {
//        for(int i=0;i<courses.size();i++){
//            courses.removeIf(t->t.getId().equals(id));
//        }
//    }
}
