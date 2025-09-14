package tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class T405_BasicDropDownOperations extends TestBase {

    @Test
    void selectByIndexTest() throws InterruptedException {

//        Go to https://the-internet.herokuapp.com/dropdown
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Thread.sleep(3000);


//        Create selectByIndexTest method - Select Option 1 using index
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByIndex(1);
        Thread.sleep(2000);

//        Create selectByValueTest method - Select Option 2 by value
        dropdown.selectByValue("2");
        Thread.sleep(2000);

//        Create selectByVisibleTextTest method - Select Option 1 by visible text
        dropdown.selectByVisibleText("Option 1");
        Thread.sleep(2000);

//        Create printAllTest method - Print all dropdown values
        dropdown.getOptions().forEach(option -> System.out.println(option.getText()));
        Thread.sleep(2000);

//        Verify dropdown has Option 2 text
        String selectedOption = dropdown.getFirstSelectedOption().getText();
        System.out.println("Selected option: " + selectedOption);
        //Assertions.assertTrue(selectedOption.contains("Option 1"));
        if (selectedOption.contains("Option 2")) {
            System.out.println("Dropdown contains Option 2");
        } else {
            System.out.println("Dropdown does not contain Option 2");
        }
        Thread.sleep(2000);

//        Create printFirstSelectedOptionTest - Print first selected option
        System.out.println("First selected option: " + dropdown.getFirstSelectedOption().getText());
        Thread.sleep(2000);

//        Verify dropdown size equals 3 elements
        int dropdownSize = dropdown.getOptions().size();
        System.out.println("Dropdown size: " + dropdownSize);
        assert dropdownSize == 3;
        Thread.sleep(2000);

    }
}
