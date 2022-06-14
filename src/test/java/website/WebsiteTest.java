package website;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebsiteTest {

    WebDriver driver;

    @BeforeAll
    static void initWebDriverManager() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", List.of("enable-automation"));
         driver = new ChromeDriver(options);
        driver.get("https://www.python.org/");
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void testSearch() {


        driver.findElement(By.id("id-search-field")).click();
        driver.findElement(By.id("id-search-field")).sendKeys("testing");
        driver.findElement(By.id("submit")).click();


        String result = driver.findElement(By.cssSelector("h3:nth-child(2)")).getText();

        assertEquals("Results", result);

        System.out.println(result);


    }

    @Test
    void testPfs() {

        driver.findElement(By.linkText("PSF")).click();

        String title = "Python Software Foundation";


        assertEquals(title, driver.getTitle());


    }
}
