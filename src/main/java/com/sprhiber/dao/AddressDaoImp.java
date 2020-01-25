package com.sprhiber.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sprhiber.model.Address;
import com.sprhiber.model.City;
import com.sprhiber.model.State;

@Repository
public class AddressDaoImp implements AddressDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void save(Long stateId,Long cityId,Address address) {
		Session session=sessionFactory.getCurrentSession();
		State state=(State)session.load(State.class, stateId);
		City city=(City)session.load(City.class, cityId);
		address.setState(state);
		address.setCity(city);
		session.saveOrUpdate(address);
	}
	
	@Transactional
	public List<Address> list() {
		Query query=sessionFactory.getCurrentSession().createQuery("from Address");
		@SuppressWarnings("unchecked")
		List<Address> list=(List<Address>)query.list();
		return list;
	}

}