package boot.project.wintercoding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import boot.project.wintercoding.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer>{
	
}
