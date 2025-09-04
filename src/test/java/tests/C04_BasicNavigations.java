package tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_BasicNavigations {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        ;// Go to the w3school URL : https://www.w3schools.com/
        driver.get("https://www.google.com/");

        // Print the position and size of the page.

        int height= driver.manage().window().getSize().height;
        int width= driver.manage().window().getSize().width;
        System.out.println("The height= " + height);
        System.out.println("The width= " + width);

        int x = driver.manage().window().getPosition().x;
        int y = driver.manage().window().getPosition().y;
        System.out.println("X = " + x);
        System.out.println("Y = " + y);

        Thread.sleep(3000);
        // Adjust the position and size of the page as desired.
        driver.manage().window().setPosition(new Point(300, 10));
        Thread.sleep(3000);
        driver.manage().window().setSize(new Dimension(945, 500));
        // Test that the page is in the position and size you want.

        int newheight= driver.manage().window().getSize().height;
        int newwidth= driver.manage().window().getSize().width;

        int newx = driver.manage().window().getPosition().x;
        int newy = driver.manage().window().getPosition().y;

        if (newheight == 500 && newwidth == 945 && newx == 600 && newy == 10){
            System.out.println("Test Passed!");
        }else{
            System.out.println("Test Passed!");
        }

        // Close the page.

    }
}
