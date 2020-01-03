package com.mmg.game.stone_age;

import com.mmg.interfaces.Game;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class StoneAgeMainController implements Game{
	
	private static StoneAgeMainController _instance;
	
	private StoneAgeMainController() {
		
	}
	
	public static StoneAgeMainController getInstance() {
		if(_instance == null) {
			return new StoneAgeMainController();
		}else {
			return _instance;
		}
	}

	@Override
	public String getName() {
		return "Stone Age";
	}

	@Override
	public void launch() {
		System.out.println("Launchs game UI");
		Display display = PlatformUI.getWorkbench().getDisplay();
		Shell shell = new Shell(display);
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("StoneAgeGame");
		
		shell.setSize(700,700);
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
		display.dispose();
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}

}
