package es.dalonso.training.persistence.resource;


import es.dalonso.training.persistence.service.ITaskService;
import es.dalonso.training.persistence.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	@Autowired
	private ITaskService taskService;

	@GetMapping("/{id}")
	public Task getById(@PathVariable("id") Long id) {
		Task article = taskService.getById(id);
		return article;
	}

	@GetMapping
	public Iterable<Task> getAll() {
		Iterable<Task> list = taskService.getAll();
		return list;
	}

	@PostMapping
	public Task addArticle(@RequestBody Task element) {
		Task returned = taskService.add(element);
		
		return returned;
	}

	@PutMapping
	public Task update(@RequestBody Task element) {
		taskService.update(element);
		return element;
	}

	@DeleteMapping("/{id}")
	public Optional<Void> delete(@PathVariable("id") Long id) {
		taskService.delete(id);
		return Optional.empty();

	}
}
