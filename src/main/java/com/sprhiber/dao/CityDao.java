package com.sprhiber.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.sprhiber.model.City;

@Repository
@Component
public interface CityDao {
	void save(Long stateId,City city);
	List<City> allCity();
	List<String> loadCity(Long stateId);
	City getCity(Long cityId);
	List<City> getCities(Long stateId);
	void deleteCity(Long cityId);
}
