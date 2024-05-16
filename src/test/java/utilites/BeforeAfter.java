package utilites;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BeforeAfter{


    public WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        // WebdriverManager selenium webdriver yerine
        // baska bir webdriver kullanilmasi gerektiginde
        // yapilacak islemi gostermek icin eklendi
        // Bu satiri eklemek ZORUNLU DEGILDIR, selenium webdriver her zaman kullanilabilir
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public void teardown(){
        driver.quit();
    }


}
