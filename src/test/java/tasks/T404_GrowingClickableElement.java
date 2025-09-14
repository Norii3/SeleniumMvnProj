package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class T404_GrowingClickableElement {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");
    }

    @Test
    void growingClick()throws InterruptedException {
        // Click "click me" button
        WebElement theButton = driver.findElement(By.xpath("//button[@id='growbutton']"));
        Thread.sleep(10000);
        theButton.click();

        // Verify "Event Triggered" appears
        WebElement eventText= driver.findElement(By.id("growbuttonstatus"));
        Assertions.assertEquals("Event Triggered", eventText.getText());

    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }}