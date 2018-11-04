package boot.project.wintercoding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import boot.project.wintercoding.constant.TodoConstant;
import boot.project.wintercoding.entity.Todo;
import boot.project.wintercoding.repository.TodoRepository;

@Service
public class TodoService {
	@Autowired
	private TodoRepository todoRepository;
	
	/**
	 * 새로운 todo를 추가하거나 수정하는 메소드
	 * @param todo
	 */
	public void save(Todo todo) {
		todoRepository.save(todo);
	}
	
	/**
	 * 마감 기한 정렬순으로 모든 todo 가져오는 메소드
	 * @return List<Todo>
	 */
	public List<Todo> getAllOrderByDeadline(){
		return todoRepository.findAll(sortByDeadlineAsc());
	}
	
	/**
	 * 마감 기한 오름차순 정렬 메소드
	 * @return Sort
	 */
	private Sort sortByDeadlineAsc() {
		return new Sort(Sort.Direction.ASC, TodoConstant.DEADLINE_COLUMN_NAME.getValue());
	}
	
	/**
	 * 우선 순위 정렬순으로 모든 todo 가져오는 메소드
	 * @return List<Todo>
	 */
	public List<Todo> getAllOrderByPriority(){
		return todoRepository.findAll(sortByPriorityDesc());
	}
	
	/**
	 * 우선 순위 내림차순 정렬 메소드
	 * @return Sort
	 */
	private Sort sortByPriorityDesc() {
		return new Sort(Sort.Direction.DESC, TodoConstant.PRIORITY_COLUMN_NAME.getValue());
	}

	/**
	 * id에 해당하는 todo 가져오는 메소드
	 * @param id
	 * @return
	 */
	public Todo getById(int id) {
		return todoRepository.getOne(id);
	}
	
	/**
	 * todo 1개 삭제 메소드
	 * @param id
	 */
	public void removeById(int id) {
		todoRepository.deleteById(id);
	}
}
