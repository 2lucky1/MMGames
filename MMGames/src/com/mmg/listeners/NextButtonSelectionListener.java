package com.mmg.listeners;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.mmg.logic.MainMenuController;
import com.mmg.logic.MainMenuModel;
import com.mmg.views.MainMenuView;

public class NextButtonSelectionListener implements SelectionListener {

	@Override
	public void widgetSelected(SelectionEvent e) {
		System.out.println("nextbuttonlistenerworks");
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		
		IViewReference[] views = page.getViewReferences();
	    for (IViewReference view : views) {
	        page.hideView(view);
	    }
	    try {
	    	MainMenuModel menuModel = new MainMenuModel();
	    	page.showView(MainMenuView.ID);
	    	MainMenuView menuView = (MainMenuView) page.getActivePart();
	    	MainMenuController menuController = new MainMenuController(menuModel, menuView);
	    	menuModel.registerObserver(menuController);
	    	menuController.update();
	    } catch (PartInitException event) {
	        event.printStackTrace();
	    }
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
