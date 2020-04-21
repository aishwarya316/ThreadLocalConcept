package test1;
import org.openqa.selenium.Capabilities;

public class CapabilityFactory  {
  public Capabilities  capabilites;
 
    public Capabilities getCapabilities (String browser) {
        if (browser.equals("firefox"))
            capabilites = OptionsManager.getFirefoxOptions();
        else 
            capabilites = OptionsManager.getChromeOptions();
        return capabilites;
    }
}