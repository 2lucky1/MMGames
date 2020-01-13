package com.mmg.game.stoneage.views;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.mmg.game.stoneage.Application;


public class StoneAgeView extends ViewPart {
	public static final String ID = "com.mmg.stoneage.views.stoneageview";
	public static final String FIELD = "/images/field800.jpg";
	public static final Point START_GAME_WINDOW_POSITION = new Point(100,10);
	public static final String MEEPLE1 = "/images/meeple24x24.png";
	

	@Override
	public void createPartControl(Composite parent) {
//		parent.setLayout(new FormLayout());
		Shell shell = parent.getParent().getShell();
		shell.setSize(825,690);
		shell.setLocation(START_GAME_WINDOW_POSITION);
		Composite field = new Composite(parent, SWT.BORDER);
//		field.setLocation(parent.getSize().x, 20);
		ImageDescriptor descriptor = AbstractUIPlugin.imageDescriptorFromPlugin(Application.PLUGIN_ID, 
				FIELD);
		Image image = descriptor.createImage();
		
		descriptor = AbstractUIPlugin.imageDescriptorFromPlugin(Application.PLUGIN_ID, 
				MEEPLE1);
		Image meepleImage = descriptor.createImage();
		
		field.setBackgroundImage(image);
		field.setLayout(new FillLayout());
		Canvas canvas = new Canvas(field, SWT.NONE);
		canvas.addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				e.gc.drawImage(meepleImage, 8, 8);
				e.gc.drawText("Hello canvas", 100, 100);
				e.gc.drawText("Hello canvas", 500, 500);
				e.gc.drawText("Hello canvas", 1000, 1000);
			}
		});
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}
}
