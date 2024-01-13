package com.app.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.app.pojos.Address;


public interface AddressService {
	Address getAddressOfEmployee(long id);
}
