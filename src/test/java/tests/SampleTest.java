package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SampleTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Setup WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void openGoogleTest() {
        // Navigate to Google
        driver.get("https://www.google.com");
        // Check that the title contains 'Google'
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        Assert.assertTrue(title.contains("Google"), "Title should contain 'Google'");
    }

    @AfterClass
    public void tearDown() {
        // Quit the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
