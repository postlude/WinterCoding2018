package boot.project.wintercoding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.project.wintercoding.dto.Test;
import boot.project.wintercoding.mapper.TestMapper;

@Service
public class TestService {
	@Autowired
	private TestMapper testMapper;
	
	public List<Test> getAll(){
		return testMapper.selectAll();
	}
}
