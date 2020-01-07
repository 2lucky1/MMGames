package com.mmg.game.stoneage.views;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.mmg.game.stoneage.Application;


public class StoneAgeView extends ViewPart {
	public static final String ID = "com.mmg.stoneage.views.stoneageview";
	public static final String FIELD = "/images/field.jpg";

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FormLayout());
		ImageDescriptor descriptor = AbstractUIPlugin.imageDescriptorFromPlugin(Application.PLUGIN_ID, 
				FIELD);
		Image image = descriptor.createImage();
		parent.setBackgroundImage(image);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}
}
