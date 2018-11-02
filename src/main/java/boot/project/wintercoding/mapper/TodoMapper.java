package boot.project.wintercoding.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import boot.project.wintercoding.dto.Todo;

@Mapper
public interface TodoMapper {
	void insert(Todo todo);
	List<Todo> selectAllOrderByDeadline();
	List<Todo> selectAllOrderByPriority();
	Todo selectById(int id);
	void updateById(Todo todo);
	void deleteById(int id);
}
