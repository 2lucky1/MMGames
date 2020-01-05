package com.mmg.game.stone_age.activator;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.mmg.game.stone_age.StoneAgeMainController;

public class StoneAgeActivator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("StoneAgeActivator start");
		StoneAgeMainController.getInstance().launch();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub

	}

}
