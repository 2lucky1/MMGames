package com.mmg.logic;

public interface Observable {
	void registerObserver(Observer o);
	void removeObserver(Observer o);
	void notifyObservers();
}
