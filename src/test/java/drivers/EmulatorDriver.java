package drivers;

import com.codeborne.selenide.WebDriverProvider;
import configs.EmulatorConfig;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.IOS_XCUI_TEST;
import static io.appium.java_client.remote.MobilePlatform.IOS;

public class EmulatorDriver implements WebDriverProvider {
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        EmulatorConfig emulatorConfig = ConfigFactory.create(EmulatorConfig.class);
        XCUITestOptions options = new XCUITestOptions();

        options.setAutomationName(IOS_XCUI_TEST)
                .setPlatformName(IOS)
                .setPlatformVersion(emulatorConfig.platformVersion())
                .setDeviceName(emulatorConfig.deviceName())
                .setApp(getAppPath());

        return new IOSDriver(getAppiumServerUrl(), options);
    }

    public static URL getAppiumServerUrl() {
        EmulatorConfig emulatorConfig = ConfigFactory.create(EmulatorConfig.class);
        try {
            return new URI(emulatorConfig.appiumServer()).toURL();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private String getAppPath() {
        EmulatorConfig emulatorConfig = ConfigFactory.create(EmulatorConfig.class);

        return new File(emulatorConfig.appPath()).getAbsolutePath();
    }
}
