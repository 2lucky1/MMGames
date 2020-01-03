package com.mmg.services;

import java.util.List;

import com.mmg.interfaces.Game;

public interface GamesListProvider {

	List<String> getAvailableGamesList();
}
