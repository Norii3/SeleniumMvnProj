package tasks;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class T408_FreePractice {

    @Test
    void test1(){

//        Practice on https://demo.guru99.com/test/newtours/register.php
//        Apply dropdown and form handling techniques

        Faker faker = new Faker();
        driver.findElement(By.name("firstName")).click();
        driver.findElement(By.name("firstName")).sendKeys(faker.name().firstName());

        driver.findElement(By.name("lastName")).click();
        driver.findElement(By.name("lastName")).sendKeys(faker.name().lastName());

        driver.findElement(By.name("phone")).click();
        driver.findElement(By.name("phone")).sendKeys(faker.phoneNumber().cellPhone());

        driver.findElement(By.id("userName")).click();
        driver.findElement(By.id("userName")).sendKeys(faker.internet().emailAddress());

        driver.findElement(By.name("address1")).click();
        driver.findElement(By.name("address1")).sendKeys(faker.address().streetAddress());

        driver.findElement(By.name("city")).click();
        driver.findElement(By.name("city")).sendKeys(faker.address().city());

        driver.findElement(By.name("state")).click();
        driver.findElement(By.name("state")).sendKeys(faker.address().state());

        driver.findElement(By.name("postalCode")).click();
        driver.findElement(By.name("postalCode")).sendKeys(faker.address().zipCode());

        driver.findElement(By.name("country")).click();
        driver.findElement(By.name("country")).sendKeys("SAUDI ARABIA");

        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys(faker.name().username());

        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(faker.internet().password());

        driver.findElement(By.name("confirmPassword")).click();
        driver.findElement(By.name("confirmPassword")).sendKeys(faker.internet().password());

        driver.findElement(By.name("submit")).click();


    }

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/newtours/register.php");

    }
    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
