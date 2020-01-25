package com.sprhiber.service;

import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.sprhiber.model.*;

@Service
@Component
public interface CityService {
	void save(Long stateId,City city);
	List<City> allCity();
	List<String> loadCity(Long stateId);
	public List<City> getCities(Long stateId);
}
