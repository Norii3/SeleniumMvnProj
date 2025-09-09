package tasks;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class task305 {

    @Test
    void toDoListTest(){

//        Go to "http://webdriveruniversity.com/To-Do-List/index.html" and create a test that:
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");

//        Uses Faker to generate 5 random task
        Faker faker = new Faker();
        WebElement addTask = driver.findElement(By.xpath("//input[@type='text']"));
        for (int i = 0; i < 5; i++) {
            String randomTask = faker.lorem().word();
            //        Adds all tasks to the todo list
            addTask.sendKeys(randomTask, Keys.ENTER);
        }


//        Marks every other task as completed (strikethrough)
        List<WebElement> tasks = driver.findElements(By.tagName("li"));
        for (int i = 0; i < tasks.size(); i++) {
            if (i % 2 == 1) {
                WebElement task = tasks.get(i);
                task.click();

                wait.until(ExpectedConditions.attributeContains(task, "class", "completed"));
            }
        }

//        Deletes all completed tasks
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//ul/li[@class='completed']/span"));
        for (WebElement deleteButton : deleteButtons) {
            driver.findElement(By.className("fa fa-trash")).click();
            //deleteButton.click();
        }

//        Verifies only incomplete tasks remain
        List<WebElement> remainingTasks = driver.findElements(By.tagName("li"));
        for (WebElement remainingTask : remainingTasks) {
            String classAttribute = remainingTask.getAttribute("class");
            Assertions.assertFalse(classAttribute.contains("completed"), "There are still completed tasks remaining.");
        }

    }


    WebDriver driver;
    WebDriverWait wait;


    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(6000);
        driver.quit();
    }
}
