package boot.project.wintercoding.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import boot.project.wintercoding.dto.Test;

@Repository
public interface TestMapper {
	List<Test> selectAll();
}
