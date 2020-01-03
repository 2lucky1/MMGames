package com.mmg;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import com.mmg.views.MainMenuView;
import com.mmg.views.WelcomeView;

public class Perspective implements IPerspectiveFactory {

	public static final String ID = "com.mmg.perspective";
	
	@Override	
	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		layout.addStandaloneView(WelcomeView.ID, false, IPageLayout.LEFT, 1.0f, layout.getEditorArea());
	}
}
