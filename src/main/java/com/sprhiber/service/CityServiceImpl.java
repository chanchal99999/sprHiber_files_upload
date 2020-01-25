package com.sprhiber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprhiber.dao.CityDao;
import com.sprhiber.model.*;

@Service("cityService")
public class CityServiceImpl implements CityService {

	@Autowired
	CityDao cityDao;
	public void save(Long stateId,City city) {
		cityDao.save(stateId,city);
	}

	public List<City> allCity() {
		return cityDao.allCity();
	}

	public List<String> loadCity(Long stateId) {
			return cityDao.loadCity(stateId);
	}

	public List<City> getCities(Long stateId) {
		return cityDao.getCities(stateId);
	}

}