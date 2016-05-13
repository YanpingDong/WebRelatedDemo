package org.bootapp.service;

import org.bootapp.dao.ForTestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForTestService {
	@Autowired
	ForTestDao forTestDao;
	
	public String getInfo(int id) {
		return null;
	}
}
