package com.mmg.views;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.ui.part.ViewPart;

public class MainMenuView extends ViewPart {

	public static final String ID = "com.mmg.views.menuview";
	
	private List _gamesList;
	private Button _playBtn;

	public MainMenuView() {
		super();
	}

	@Override
	public void createPartControl(Composite parent) {
		GridLayout gridLayout = new GridLayout(1, false);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		parent.setLayout(gridLayout);
		parent.setLayoutData(gridData);

		_gamesList = new List(parent, SWT.BORDER | SWT.V_SCROLL);
		_gamesList.setLayoutData(new GridData(240, 210));
		
		_playBtn = new Button(parent, SWT.PUSH);
		_playBtn.setText("Play");
		gridData = new GridData(GridData.END, GridData.CENTER,false,false);
		_playBtn.setLayoutData(gridData);
		
		
		
//		_playBtn.addListener(SWT.Selection, new Listener() {
//			
//			@Override
//			public void handleEvent(Event event) {
//				switch(event.type) {
//				case SWT.Selection:
//					System.out.println("Push button play for " + _gamesList.getSelection()[0]);
//				}
//			}
//		});
	}

	
	public List getGamesList() {
		return _gamesList;
	}

	public void setGamesList(ArrayList<String> gamesList) {
		_gamesList.removeAll();
		for (String gameName : gamesList) {
			_gamesList.add(gameName);
		}
	}

	public Button getPlayBtn() {
		return _playBtn;
	}

	public void setPlayBtn(Button _playBtn) {
		this._playBtn = _playBtn;
	}
	
	public void setPlayButtonListener(SelectionListener listener) {
		_playBtn.addSelectionListener(listener);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}
}
