package com.mmg.game.stoneage.logic;

import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.mmg.game.stoneage.views.StoneAgeView;
import com.mmg.interfaces.Game;

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
//		Display display = PlatformUI.getWorkbench().getDisplay();
//		Shell shell = new Shell(display);
//		
//		Label label = new Label(shell, SWT.NONE);
//		label.setText("StoneAgeGame");
//		
//		shell.setSize(700,700);
//		shell.open();
//		
//		while(!shell.isDisposed()) {
//			if(!display.readAndDispatch()) {
//				display.sleep();
//			}
//		}
//		
//		display.dispose();
		
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		
		IViewReference[] views = page.getViewReferences();
	    for (IViewReference view : views) {
	        page.hideView(view);
	    }
	    try {
	    	StoneAgeModel gameModel = new StoneAgeModel();
	    	page.showView(StoneAgeView.ID);
	    	StoneAgeView stoneAgeView = (StoneAgeView) page.getActivePart();
//	    	MainMenuController menuController = new MainMenuController(menuModel, menuView);
//	    	menuModel.registerObserver(menuController);
//	    	menuController.update();
	    } catch (PartInitException event) {
	        event.printStackTrace();
	    }
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}

}
