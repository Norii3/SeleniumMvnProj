package tasks;

import utilities.TestBase;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;



public class T407_MultiSelectOperations extends TestBase {

    //    Task 7: Multi-Select Operations
//    Launch browser
//    Open https://demoqa.com/select-menu
//    Select Standard Multi-Select using element id
//    Verify element is multi-select
//    Select 'Opel' using index, then deselect using index Select 'Saab' using value, then deselect using value
//    Deselect all options
//    Close browser

    @Test
    public void testStandardMultiSelect() throws InterruptedException {

        driver.get("https://demoqa.com/select-menu");

        //    Select Standard Multi-Select using element id
        WebElement Standard = driver.findElement(By.id("cars"));
        Select select = new Select(Standard);

        //    Verify element is multi-select
        Assertions.assertTrue(select.isMultiple());

        //    Select 'Opel' using index, then deselect using index Select 'Saab' using value, then deselect using value
        select.selectByIndex(2);
        Thread.sleep(2000);

        select.deselectByIndex(2);
        Thread.sleep(2000);

        select.selectByValue("saab");
        Thread.sleep(2000);

        select.deselectByValue("saab");
        Thread.sleep(2000);
        //    Deselect all options
        select.deselectAll();

        Thread.sleep(2000);
    }

}
