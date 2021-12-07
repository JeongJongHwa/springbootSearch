package kr.co.searchManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.searchManager.database.mapper.SearchMapper;

@Service
public class HelloService {
	@Autowired
	SearchMapper searchMapper;
}
