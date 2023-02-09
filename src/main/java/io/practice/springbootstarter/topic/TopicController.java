package io.practice.springbootstarter.topic;

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

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	//GET all data
	@RequestMapping("/topics")
	public List<Topic> getAllTopicsFromService() {
		return topicService.getAllTopics();
	}
	
	//GET method.
	@RequestMapping("/topics/{id}")
	public Optional<Topic> singleTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	//POST method. {NEW}
	/*
	 * here we have to tell which type of method we are requesting by default it's get method.
	 * this is an old way to do this.
	 * 	@RequestMapping(method = RequestMethod.POST,value = "/topic")
	 *	public String addTopic(@RequestBody Topic topic) {
	 *	topicService.addTopic(topic);
	 *	return "OLD";
	 *	}
	 *
	 *	shortcut for the post mapping method.
	 */

	@PostMapping("/topics")
	public String addMapTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
		return "NEW";
	}
	
	/*
	 * 	PUT method. {UPDATE}
	 * 
	 * 	@RequestMapping(method =RequestMethod.PUT, value = "/topic/{id}")
	 *	public String updateTopic(@RequestBody Topic topic ,@PathVariable String id) {
	 *	topicService.updateTopic(id,topic);
	 *	return "OLD";
   	 *	}
	 */
	
	@PutMapping("/topics/{id}")
	public String updateMapTopic(@RequestBody Topic topic ,@PathVariable String id) {
		topicService.updateTopic(id,topic);
		return "NEW";
	}
	
	
	/*
	 * 	DELETE method. {DELETE}
	 * 
	 *	@RequestMapping(method =RequestMethod.DELETE, value = "/topic/{id}")
	 *	public String deleteTopic(@PathVariable String id) {
	 *	topicService.deleteTopic(id);
	 *	return "OLD";
	 *	}
	 */
	
	@DeleteMapping("/topics/{id}")
	public String deleteMapTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
		return "NEW";
	}
	
}
