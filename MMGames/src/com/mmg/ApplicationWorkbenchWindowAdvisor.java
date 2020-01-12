package com.mmg;

import java.awt.Dimension;
import java.awt.Toolkit;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;


public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

    public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        super(configurer);
    }
    
    @Override
    public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
        return new ApplicationActionBarAdvisor(configurer);
    }
    
    @Override
    public void preWindowOpen() {
        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
        configurer.setInitialSize(new Point(810, 610));
        configurer.setShowCoolBar(true);
        configurer.setShowStatusLine(true);
    }

	@Override
	public void postWindowOpen() {
		Shell shell = getWindowConfigurer().getWindow().getShell();
	    shell.setLocation(calcInitLocation(shell));
	    super.postWindowCreate();
	}
    
    private Point calcInitLocation(Shell shell) {
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	int x = (int) (screenSize.getWidth()/2-shell.getSize().x/2);
    	int y = (int) (screenSize.getHeight()/2-shell.getSize().y/2);
    	return new Point(x,y);
    }
	
}
