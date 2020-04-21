package test1;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.server.RemoteServer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
 
public class BaseTest {
    //Declare ThreadLocal Driver (ThreadLocalMap) for ThreadSafe Tests
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
    public CapabilityFactory capabilityFactory = new CapabilityFactory();
 
    @BeforeMethod
    @Parameters(value={"browser"})
    public synchronized  void setup (String browser) throws MalformedURLException {
        //Set Browser to ThreadLocalMap
        driver.set(new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
    }
 
    public synchronized  WebDriver getDriver() {
        //Get driver from ThreadLocalMap
        return driver.get();
    }
 
    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }
 
   
}