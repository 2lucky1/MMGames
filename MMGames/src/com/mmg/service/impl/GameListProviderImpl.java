package com.mmg.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.mmg.services.GamesListProvider;

public class GameListProviderImpl implements GamesListProvider {

	private ArrayList<String> gamesList = new ArrayList<String>();
	
	@Override
	public ArrayList<String> getAvailableGamesList() {
		gamesList.add("No games yet");
		return null;
	}

}
