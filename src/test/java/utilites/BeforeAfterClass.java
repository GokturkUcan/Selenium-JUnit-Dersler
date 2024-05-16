package utilites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BeforeAfterClass {



        public static WebDriver driver;

        @BeforeClass
        public static void setup(){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        }

        @AfterClass
        public static void teardown(){

            driver.quit();
        }






}
