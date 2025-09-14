package tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;
import java.time.Duration;

public class T406_OldStyleSelectMenu extends TestBase{

    @Test
    void test() {
//        Launch browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Open https://demoqa.com/select-menu
        driver.get("https://demoqa.com/select-menu");

        // Select Old Style Select Menu using element id
        driver.findElement(By.id("oldSelectMenu"));

        // Print all dropdown options
        Select dropdown = new Select(driver.findElement(By.id("oldSelectMenu")));
        dropdown.getOptions().forEach(option -> System.out.println(option.getText()));

        // Select 'Purple' using index
        dropdown.selectByIndex(4);

        // Select 'Magenta' using visible text
        dropdown.selectByVisibleText("Magenta");

        // Select an option using value
        dropdown.selectByValue("5");

        // Close browser
        driver.quit();
    }

}
