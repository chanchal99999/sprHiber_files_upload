package com.sprhiber.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sprhiber.model.Address;

@Service
@Component
public interface AddressService {
	
	void save(Long stateId,Long cityId,Address address);
	List<Address> list();
	
}
