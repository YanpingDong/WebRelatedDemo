package org.bootapp.dao;

import org.springframework.stereotype.Repository;

@Repository
public class ForTestDaoImp implements ForTestDao {

	@Override
	public String getInfo(int id) {
		return "read info from DB";
	}

}
