package io.github.web.selenium.grid;

import io.github.bonigarcia.wdm.ChromeDriverManager;

import java.util.HashMap;
import java.util.Map;

import org.openqa.grid.common.GridRole;
import org.openqa.grid.common.RegistrationRequest;
import org.openqa.grid.internal.utils.SelfRegisteringRemote;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class StartNode {

    public static void main(String[] args) throws Exception {

        ChromeDriverManager.getInstance().setup();

        String hubAddress = "127.0.0.1";
        int hubPort = 4444;
        String nodeAddress = "127.0.0.1";
        int nodePort = 5555;

        RegistrationRequest req = new RegistrationRequest();

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.PLATFORM, Platform.WIN8_1);
        cap.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        req.addDesiredCapability(cap);
        req.setRole(GridRole.NODE);

        Map<String, Object> nodeConfiguration = new HashMap<String, Object>();
        nodeConfiguration.put(RegistrationRequest.AUTO_REGISTER, true);
        nodeConfiguration.put(RegistrationRequest.HUB_HOST, hubAddress);
        nodeConfiguration.put(RegistrationRequest.HUB_PORT, hubPort);
        nodeConfiguration.put(RegistrationRequest.PORT, nodePort);
        nodeConfiguration.put(RegistrationRequest.REMOTE_HOST,
                "http://" + nodeAddress + ":" + nodePort);
        nodeConfiguration.put(RegistrationRequest.PROXY_CLASS,
                "org.openqa.grid.selenium.proxy.DefaultRemoteProxy");
        nodeConfiguration.put(RegistrationRequest.MAX_SESSION, 1);
        nodeConfiguration.put(RegistrationRequest.MAX_INSTANCES, 1);
        req.setConfiguration(nodeConfiguration);

        SelfRegisteringRemote remote = new SelfRegisteringRemote(req);
        remote.startRemoteServer();
        remote.startRegistrationProcess();
    }
}
