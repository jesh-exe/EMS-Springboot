package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AddressDao;
import com.app.pojos.Address;

@Service
@Transactional
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressDao addrDao;

	@Override
	public Address getAddressOfEmployee(long id) {
		return addrDao.findById(id).orElseThrow();
	}
	
	
	
}
