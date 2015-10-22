package io.github.web.selenium.grid;

import org.openqa.grid.internal.utils.GridHubConfiguration;
import org.openqa.grid.web.Hub;

public class StartHub {

	public static void main(String[] args) throws Exception {
		String hubAddress = "127.0.0.1";
		int hubPort = 4444;
		int timeout = 60; // seconds

		GridHubConfiguration config = new GridHubConfiguration();
		config.setHost(hubAddress);
		config.setPort(hubPort);
		config.setTimeout(timeout);

		Hub hub = new Hub(config);
		hub.start();
	}
}
