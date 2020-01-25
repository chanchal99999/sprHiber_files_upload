package com.sprhiber.model;

import java.util.Comparator;

public class StateSorted implements Comparator<State> {

	public int compare(State s1, State s2) {
		// TODO Auto-generated method stub
		return s1.getStateName().compareToIgnoreCase( s2.getStateName() );
	}

}
