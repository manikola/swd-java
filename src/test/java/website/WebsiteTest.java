package website;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SeleniumTest
@ExtendWith(LoggingExtension.class)
public class WebsiteTest {


    @Test
    void testSearch(WebDriver driver) {


        driver.findElement(By.id("id-search-field")).click();
        driver.findElement(By.id("id-search-field")).sendKeys("testing");
        driver.findElement(By.id("submit")).click();
        log.debug("Click Go button");


        String result = driver.findElement(By.cssSelector("h3:nth-child(2)")).getText();

        assertEquals("Results", result);

        System.out.println(result);


    }

    @Test
    void testPfs(WebDriver driver) {

        driver.findElement(By.linkText("PSF")).click();
        log.debug("click on pdf menu item");
        String title = "Python Software Foundation";


        assertEquals(title, driver.getTitle());


    }
}
