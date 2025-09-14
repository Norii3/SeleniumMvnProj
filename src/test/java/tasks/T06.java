package tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T06 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        //    Go to the Amazon URL: https://www.amazon.com/
        driver.get("https://www.amazon.com/");

//    Verify that it writes "Performance Metrics" or " Gateway" from the Source code.
        String pageSource = driver.getPageSource();

        boolean containsPerformanceMetrics = pageSource.contains("Performance Metrics");
        boolean containsGateway = pageSource.contains("Gateway");

        System.out.println("Performance Metrics: " + containsPerformanceMetrics);
        System.out.println("Gateway: " + containsGateway);

        if (containsPerformanceMetrics|| containsGateway) {
            System.out.println("word found");
        } else {
            System.out.println("word not found");
        }

        Thread.sleep(3000);
        driver.quit();

    }
}
