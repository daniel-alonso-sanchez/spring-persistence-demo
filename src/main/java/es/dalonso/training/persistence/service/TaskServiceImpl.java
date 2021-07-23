package es.dalonso.training.persistence.service;

import es.dalonso.training.persistence.repository.TaskRepository;
import es.dalonso.training.persistence.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskServiceImpl implements ITaskService {
	
	private TaskRepository taskDAO;
	@Autowired
	public TaskServiceImpl(TaskRepository taskDAO) {
		super();
		this.taskDAO = taskDAO;
	}

	@Override
	@Transactional(readOnly=true)
	public Iterable<Task> getAll() {
		
		return taskDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Task getById(Long key) {
		
		return taskDAO.findById(key).orElse(null);
	}

	@Override
	@Transactional
	public Task add(Task element) {
		taskDAO.save(element);
		return element;
	}

	@Override
	@Transactional
	public void update(Task element) {
	
		taskDAO.save(element);
	}

	@Override
	@Transactional
	public void delete(Long key) {
	
		taskDAO.deleteById(key);
	}

}
