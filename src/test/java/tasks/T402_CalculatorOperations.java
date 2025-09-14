package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import java.util.List;

public class T402_CalculatorOperations extends TestBase {

    @Test
    void test1() throws InterruptedException {

//        Go to https://testpages.eviltester.com/styled/calculator
        driver.get("https://testpages.eviltester.com/styled/calculator");
        Thread.sleep(3000);

//        Type any number in first and second input
        WebElement n1 = driver.findElement(By.id("number1"));
        n1.sendKeys("10");
        Thread.sleep(2000);
        WebElement n2 = driver.findElement(By.id("number2"));
        n2.sendKeys("9");
        Thread.sleep(3000);

        WebElement dd = driver.findElement(By.id("function"));
        dd.click();
        List<WebElement> options = driver.findElements(By.xpath("//option[@value='times']"));
        for (WebElement option : options) {
            driver.findElement(By.xpath("//option[@value='times']")).click();
            option.click();
            Thread.sleep(2000);

            //        Click Calculate for each operation
            WebElement calculate = driver.findElement(By.id("calculate"));
            calculate.click();
            Thread.sleep(2000);

        }

//        Get and verify results for all operations
        WebElement answer = driver.findElement(By.id("answer"));
        System.out.println("Result: " + answer.getText());
        Assertions.assertEquals("1", answer.getText(), "Error");
    }

}
