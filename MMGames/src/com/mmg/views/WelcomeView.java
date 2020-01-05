package com.mmg.views;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.mmg.Application;
import com.mmg.listeners.NextButtonSelectionListener;

public class WelcomeView extends ViewPart {
	
	private static final String SPACE_EARTH_JPG = "/icons/space_earth.jpg";
	private static final String INFO1_JPG = "/icons/info1.jpg";
	private static final String NEXT_BUTTON_PNG = "/icons/next_button.png";
	public static final String ID = "com.mmg.views.welcomeview";

	public WelcomeView() {
		super();
	}

	@Override
	public void createPartControl(Composite parent) {
		Display display = parent.getDisplay();

		ImageDescriptor descriptor = AbstractUIPlugin.imageDescriptorFromPlugin(Application.PLUGIN_ID, 
				SPACE_EARTH_JPG);
		Image image = descriptor.createImage();
		parent.setBackgroundImage(image);
		GridLayout gridLayout = new GridLayout(4, false);
		gridLayout.verticalSpacing = 290;
		parent.setLayout(gridLayout);
		
		GridData gridData = new GridData();
		Label welcomeLbl = new Label(parent,SWT.NONE);
		welcomeLbl.setText("Welcome Page");
		FontData fontData = new FontData();
		fontData.setHeight(50);
		fontData.setStyle(SWT.BOLD);
		Font font = new Font(parent.getDisplay(),fontData);
		welcomeLbl.setForeground(display.getSystemColor(SWT.COLOR_WHITE));
		welcomeLbl.setFont(font);
		gridData.horizontalSpan = 4;
		gridData.horizontalIndent = 150;
		welcomeLbl.setLayoutData(gridData);
		
		Button infoBtn = new Button(parent, SWT.PUSH);
		gridData = new GridData();
		gridData.horizontalIndent = 80;
		infoBtn.setLayoutData(gridData);
		descriptor = AbstractUIPlugin.imageDescriptorFromPlugin(Application.PLUGIN_ID,
				INFO1_JPG);
		image = descriptor.createImage();
		infoBtn.setImage(image);
		
		Button nextButton = new Button(parent, SWT.TOGGLE);
		gridData = new GridData();
		gridData.horizontalIndent = 400;
		nextButton.setLayoutData(gridData);
		descriptor = AbstractUIPlugin.imageDescriptorFromPlugin(Application.PLUGIN_ID,
				NEXT_BUTTON_PNG);
		image = descriptor.createImage();
		nextButton.setImage(image);
		nextButton.setBackground(null);
		
		nextButton.addSelectionListener(new NextButtonSelectionListener());
		
		infoBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Info button was prased");
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

}
