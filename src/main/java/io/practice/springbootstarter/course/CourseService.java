package io.practice.springbootstarter.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
//	private List<Topic> topics = new ArrayList<>( Arrays.asList(
//			new Topic("Spring", "SpringBoot", "Spring Boot Description"),
//			new Topic("java", "java", "java Description"),
//			new Topic("Angular", "angular-TS", "Frontend Description")
//			));
	
	public List<Course> getAllCourse(String topicId) {
		//return topics;
		List<Course> topic = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(topic::add);
		return topic;
	}
	
	public Optional<Course> getCourse(String id) {
		//return topics.stream().filter(f->f.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id);
	}

	public void addCourse(Course topic) {
		//topics.add(topic);
		courseRepository.save(topic);
	}


	public void updateCourse(String id, Course topic) {
//		for (int i = 0; i < topics.size(); i++) {
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//		}
		courseRepository.save(topic);
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
		
	}
	
	
}
