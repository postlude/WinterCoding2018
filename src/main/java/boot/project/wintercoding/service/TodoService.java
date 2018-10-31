package boot.project.wintercoding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.project.wintercoding.dto.Todo;
import boot.project.wintercoding.mapper.TodoMapper;

@Service
public class TodoService {
	@Autowired
	private TodoMapper todoMapper;
	
	public void add(Todo todo) {
		todoMapper.insert(todo);
	}
	
	public List<Todo> getAll(){
		return todoMapper.selectAll();
	}
	
	public Todo getById(int id) {
		return todoMapper.selectById(id);
	}
	
	public void setById(Todo todo) {
		todoMapper.updateById(todo);
	}
	
	public void removeById(int id) {
		todoMapper.deleteById(id);
	}
}
