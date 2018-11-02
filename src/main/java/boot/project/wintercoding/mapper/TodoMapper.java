package boot.project.wintercoding.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import boot.project.wintercoding.dto.Todo;

@Mapper
public interface TodoMapper {
	/**
	 * 새로운 todo insert
	 * @param todo
	 */
	void insert(Todo todo);
	
	/**
	 * 마감기한 오름차순 정렬 select
	 * @return List<Todo>
	 */
	List<Todo> selectAllOrderByDeadline();
	
	/**
	 * 우선순위 내림차순 정렬 select
	 * @return List<Todo>
	 */
	List<Todo> selectAllOrderByPriority();
	
	/**
	 * id로 todo select
	 * @param id
	 * @return Todo
	 */
	Todo selectById(int id);
	
	/**
	 * id로 todo update
	 * @param todo
	 */
	void updateById(Todo todo);
	
	/**
	 * id로 todo delete
	 * @param id
	 */
	void deleteById(int id);
}
