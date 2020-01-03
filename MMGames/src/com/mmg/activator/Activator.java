package com.mmg.activator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

import com.mmg.logic.MainMenuController;
import com.mmg.logic.MainMenuModel;
import com.mmg.views.MainMenuView;

public class Activator extends AbstractUIPlugin {

	public Activator() {
		BundleContext ctx =  FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		Bundle[] bundles = ctx.getBundles();
//		MainMenuView menuView = new MainMenuView();
//		MainMenuModel menuModel = new MainMenuModel();
//		MainMenuController menuController = new MainMenuController(menuModel, menuView); 
		
		List<String> gamesNames = new ArrayList<String>();
		List<Bundle> gameBundles = new ArrayList<Bundle>();
		Map<String,Long> gameBundleId= new HashMap<String, Long>();
		for (Bundle bundle : bundles) {
			String symbolicName = bundle.getSymbolicName();
			if(symbolicName.contains("com.mmg.game")) {
				String bundleName = bundle.getHeaders().get("Bundle-Name");
				gamesNames.add(bundleName);
				gameBundles.add(bundle);
				gameBundleId.put(bundleName, bundle.getBundleId());
			}
			
			System.out.println(symbolicName);
		}
		
		System.out.println("*******************************************");
		System.out.println(gamesNames);
	}

}
