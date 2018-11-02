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
	
	/**
	 * 새로운 todo 추가 메소드
	 * @param todo
	 */
	public void add(Todo todo) {
		todoMapper.insert(todo);
	}
	
	/**
	 * 마감 기한 정렬순으로 모든 todo 가져오는 메소드
	 * @return List<Todo>
	 */
	public List<Todo> getAllOrderByDeadline(){
		return todoMapper.selectAllOrderByDeadline();
	}
	
	/**
	 * 우선 순위 정렬순으로 모든 todo 가져오는 메소드
	 * @return List<Todo>
	 */
	public List<Todo> getAllOrderByPriority(){
		return todoMapper.selectAllOrderByPriority();
	}

	/**
	 * id에 해당하는 todo 가져오는 메소드
	 * @param id
	 * @return
	 */
	public Todo getById(int id) {
		return todoMapper.selectById(id);
	}
	
	/**
	 * todo 1개 수정 메소드
	 * @param todo
	 */
	public void setById(Todo todo) {
		todoMapper.updateById(todo);
	}
	
	/**
	 * todo 1개 삭제 메소드
	 * @param id
	 */
	public void removeById(int id) {
		todoMapper.deleteById(id);
	}
}
