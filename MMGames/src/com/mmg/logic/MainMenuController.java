package com.mmg.logic;


import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import com.mmg.views.MainMenuView;

public class MainMenuController implements Observer{

	private MainMenuModel _model;
	private MainMenuView _view;
	
	public MainMenuController(MainMenuModel model, MainMenuView view) {
		this._model = model;
		this._view = view;
		_view.setPlayButtonListener(new PlayButtonListener());
	}

	@Override
	public void update() {
		_view.setGamesList(_model.getGamesList());
	}
	
	class PlayButtonListener implements SelectionListener{


		@Override
		public void widgetSelected(SelectionEvent e) {
			System.out.println("Play button was pressed From Controller");
			String gameName = _view.getGamesList().getSelection()[0];
			_model.startGame(gameName);
			
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			System.out.println("Ignore");
			
		}
		
	}

}
