package com.sprhiber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprhiber.dao.AddressDao;
import com.sprhiber.model.Address;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressDao addressDao;
	public void save(Long stateId,Long cityId,Address address) {
		addressDao.save(stateId,cityId,address);
	}
	public List<Address> list() {
		return addressDao.list();
	}
}
