import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class task04 {

    public static void main(String[] args) throws InterruptedException {


//    Invoke FireFox Driver
        WebDriver driver = new EdgeDriver();
        Thread.sleep(300);

//    Go to https://www.youtube.com/
        driver.get("https://www.youtube.com/");
        Thread.sleep(300);

//    Verify the page title contains the word video.
        String title = driver.getTitle();
        System.out.println("Title of the page is: " + title);
        Thread.sleep(300);

        if (title.equals("Contact video")) {
            System.out.println("Title is correct");
        } else {
            System.err.println("Title is incorrect");
        }

//    Close the driver.
        Thread.sleep(300);
        driver.close();
    }
}

