package com.sprhiber.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.sprhiber.model.Address;

@Repository
@Component
public interface AddressDao {
	void save(Long stateId,Long cityId, Address address);
	List<Address> list();
}
