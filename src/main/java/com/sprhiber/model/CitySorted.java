package com.sprhiber.model;

import java.util.Comparator;

public class CitySorted implements Comparator<City> {

	public int compare(City o1, City o2) {
		// TODO Auto-generated method stub
		return o1.getCityName().compareToIgnoreCase( o2.getCityName() );
	}

}
