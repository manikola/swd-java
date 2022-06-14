package website;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class SeleniumExtension implements BeforeAllCallback, BeforeEachCallback, AfterEachCallback, ParameterResolver {

    WebDriver driver;


    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        WebDriverManager.chromedriver().setup();
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", List.of("enable-automation"));
        driver = new ChromeDriver(options);
        driver.get("https://www.python.org/");
        driver.manage().window().maximize();
    }


    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        driver.quit();
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == WebDriver.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return driver;
    }
}
