package com.sprhiber.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.sprhiber.model.City;
import com.sprhiber.model.State;
@Repository
public class CityDaoImp implements CityDao {

	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public void save(Long stateId,City city) {
		Session session=sessionFactory.getCurrentSession();
		State state=(State)session.load(State.class, stateId);
		city.setState(state);
		session.saveOrUpdate(city);
	}

	@Transactional
	public List<City> allCity() {
		Query query=sessionFactory.getCurrentSession().createQuery("from City");
		@SuppressWarnings("unchecked")
		List<City> list=query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<String> loadCity(Long stateId) {
		Query query=sessionFactory.getCurrentSession().createQuery("select c.cityName from City c where c.stateId="+stateId+")");
		List<String> list=new ArrayList<String>();
		list.addAll(query.list());
		return list;
	}
	@Transactional
	public City getCity(Long cityId) {
		City city=(City)sessionFactory.getCurrentSession().load(City.class, cityId);
		return city;
	}
	@Transactional
	public void deleteCity(Long cityId) {
		City city=(City)sessionFactory.getCurrentSession().load(City.class, cityId);
		if(city!=null) {
			this.sessionFactory.getCurrentSession().delete(city);
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<City> getCities(Long stateId) {
		Query query=sessionFactory.getCurrentSession().createQuery("from City  where stateId="+stateId);
		return query.list();
	}

}
