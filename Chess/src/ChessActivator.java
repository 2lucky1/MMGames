import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class ChessActivator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("ChessActivator start");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub

	}

}
