package com.mmg.game.stoneage.views;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.mmg.game.stoneage.Application;


public class StoneAgeView extends ViewPart {
	public static final String ID = "com.mmg.stoneage.views.stoneageview";
	public static final String FIELD = "/images/field800.jpg";

	@Override
	public void createPartControl(Composite parent) {
//		parent.setLayout(new FormLayout());
		parent.getParent().getShell().setSize(825,690);
		Composite field = new Composite(parent, SWT.BORDER);
		field.setSize(1200,1200);
//		parent.setSize(1300,900);
		ImageDescriptor descriptor = AbstractUIPlugin.imageDescriptorFromPlugin(Application.PLUGIN_ID, 
				FIELD);
		Image image = descriptor.createImage();
		field.setBackgroundImage(image);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}
}
