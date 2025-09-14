package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class T503_DragAndDropPractice extends TestBase {

    /*
Go to https://claruswaysda.github.io/dragAndDrop.html
Drag the items in their right places
Assert the success message
*/

    @Test
    void dragAndDropTest() throws InterruptedException {

        // Go to https://claruswaysda.github.io/dragAndDrop.html
        driver.get("https://claruswaysda.github.io/dragAndDrop.html");

        Thread.sleep(3000);

        // Drag the items in their right places

        Actions actions = new Actions(driver);

        WebElement d1 = driver.findElement(By.id("piece1"));
        WebElement d2 = driver.findElement(By.id("piece2"));
        WebElement d3 = driver.findElement(By.id("piece3"));

        WebElement s1 = driver.findElement(By.id("slot1"));
        WebElement s2 = driver.findElement(By.id("slot2"));
        WebElement s3 = driver.findElement(By.id("slot3"));

        actions
                .dragAndDrop(d1, s1)
                .dragAndDrop(d2, s2)
                .dragAndDrop(d3, s3)
                .perform();


        // Assert the success message

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("celebrate")));

        Thread.sleep(3000);
        Assertions.assertEquals("Congratulations!", message.getText());
        Thread.sleep(3000);
    }

}
