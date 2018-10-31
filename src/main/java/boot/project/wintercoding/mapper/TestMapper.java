package boot.project.wintercoding.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import boot.project.wintercoding.dto.Test;

@Mapper
public interface TestMapper {
	List<Test> selectAll();
}
