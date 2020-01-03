package com.mmg.logic;

import java.util.ArrayList;
import java.util.List;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.FrameworkUtil;

public class MainMenuModel implements Observable {
	private List<Observer> _observers;

	List<Bundle> _gameBundles;
	private ArrayList<String> _gamesList;
//	private List<Class<? extends Game>> gameClassesList;

//	private Map<String, Object> _bundleProperties = new HashMap<String, Object>();

	public MainMenuModel() {
		_observers = new ArrayList<Observer>();
		_gamesList = new ArrayList<String>();
		_gameBundles = new ArrayList<Bundle>();
		fillModel();
	}

	public ArrayList<String> getGamesList() {
		return _gamesList;
	}

	public void setGamesList(ArrayList<String> gamesList) {
		this._gamesList = gamesList;
	}

	private void fillModel() {

		BundleContext ctx =  FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		Bundle[] bundles = ctx.getBundles();
        
		for (Bundle bundle : bundles) {
			String symbolicName = bundle.getSymbolicName();
			if(symbolicName.contains("com.mmg.game")) {
				_gameBundles.add(bundle);
				
				String gameName = bundle.getHeaders().get("Bundle-Name");
				_gamesList.add(gameName);
			}
		}
		notifyObservers();
	}


	public void startGame(String gameName) {
		for (Bundle bundle : _gameBundles) {
			String nameFromBundle = getGameNameFromBundle(bundle);
			if(gameName.equals(nameFromBundle)) {
				try {
					System.out.println("Start game bundle: " + bundle.toString());
					bundle.start();
				} catch (BundleException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private String getGameNameFromBundle(Bundle bundle) {
		return bundle.getHeaders().get("Bundle-Name");
	}
	
	@Override
	public void registerObserver(Observer o) {
		_observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		_observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for (Observer o : _observers) {
			o.update();
		}
	}

//	public Map<String, Object> getParams() {
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("games_names", _gamesList.add(_gamesId.get));
//		return arams;
//	}

}
