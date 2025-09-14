package tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class T204_MultipleNavigationAndVerification {

        //    Task 4: MultipleNavigationAndVerification
        //    Setup:
        static WebDriver driver;

        //    Launch Chrome and maximize in @BeforeEach.
        @BeforeEach
        void openBrowser() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }


        //            Test 1:
        @Test
        void testNaviAndTitle() {
            //    Navigate Google → YouTube → LinkedIn.
            //    Assert titles contain "Google", "YouTube", "LinkedIn" respectively.
            driver.get("https://www.google.com");
            assertTrue(driver.getTitle().contains("Google"), "Title should contain 'Google'");

            driver.get("https://www.youtube.com");
            assertTrue(driver.getTitle().contains("YouTube"), "Title should contain 'YouTube'");

            driver.get("https://www.linkedin.com");
            assertTrue(driver.getTitle().contains("LinkedIn"), "Title should contain 'LinkedIn'");
        }


        //            Test 2:
        @Test
        void testNavigBack() {
            //    Navigate back twice and assert the URL of Google.
            driver.get("https://www.google.com");
            driver.get("https://www.youtube.com");
            driver.get("https://www.linkedin.com");

            driver.navigate().back();
            driver.navigate().back();

            assertTrue(driver.getCurrentUrl().contains("google"), "URL should contain 'google'");


            //    Navigate forward twice and assert URL of LinkedIn.
            driver.navigate().forward();
            driver.navigate().forward();

            assertTrue(driver.getCurrentUrl().contains("linkedin"), "URL should contain 'linkedin'");
        }



        //            Teardown:
        //    Use @AfterAll to quit the browser.
        @AfterAll
        static void tearDown() {
            // Close the browser
            if (driver != null) {
                driver.quit();
            }
        }
}
