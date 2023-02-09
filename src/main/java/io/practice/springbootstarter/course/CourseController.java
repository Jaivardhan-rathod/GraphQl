package io.practice.springbootstarter.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.practice.springbootstarter.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService topicService;
	
	//GET all data
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourseFromService(@PathVariable String topicId) {
		return topicService.getAllCourse(topicId);
	}
	
	//GET method.
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Optional<Course> singleCourse(@PathVariable String id) {
		return topicService.getCourse(id);
	}
	
	//POST method. {NEW}
	/*
	 * here we have to tell which type of method we are requesting by default it's get method.
	 * this is an old way to do this.
	 *
	 *	@RequestMapping(method = RequestMethod.POST,value = "/topic")
	 *	public String addTopic(@RequestBody Course topic) {
	 *	topicService.addTopic(topic);
	 *	return "OLD";
	 *	}
	 */
	
	//shortcut for the post mapping method. 	 
	@PostMapping("/topics/{topicId}/courses")
	public String addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		topicService.addCourse(course);
		return "NEW";
	}
	
	//PUT method. {UPDATE}
	/*
	 * 	@RequestMapping(method =RequestMethod.PUT, value = "/topic/{id}")
	 *	public String updateTopic(@RequestBody Course topic ,@PathVariable String id) {
	 *	topicService.updateTopic(id,topic);
	 *	return "OLD";
	 *	}
	 */

	@PutMapping("/topics/{topicId}/courses/{id}")
	public String updateCourse(@RequestBody Course course ,@PathVariable String topicId ,@PathVariable String id) {
		course.setTopic(new Topic(topicId,"",""));
		topicService.updateCourse(id,course);
		return "NEW";
	}
	
	//DELETE method. {DELETE}
	/*
	 * 	@RequestMapping(method =RequestMethod.DELETE, value = "/topic/{id}")
	 *	public String deleteTopic(@PathVariable String id) {
	 *	topicService.deleteTopic(id);
	 *	return "OLD";
	 *	}
	 * 
	 */

	@DeleteMapping("/topics/{topicId}/courses/{id}")
	public String deleteMapTopic(@PathVariable String id) {
		topicService.deleteCourse(id);
		return "NEW";
	}
	
}
