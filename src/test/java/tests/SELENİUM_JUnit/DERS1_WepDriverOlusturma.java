package tests.SELENİUM_JUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DERS1_WepDriverOlusturma {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.testotomasyonu.com");

        System.out.println(driver.getTitle()); // Test Otomasyonu - Test Otomasyonu

        System.out.println(driver.getCurrentUrl()); // https://www.testotomasyonu.com/

        System.out.println(driver.getWindowHandle());
        // 70D734CFCE622F54221448B49A2FFBD4
        // B4C52493E577C3540B2E78F71C5CAA09

        System.out.println(driver.getWindowHandles());
        // [B4C52493E577C3540B2E78F71C5CAA09]

        System.out.println(driver.getPageSource());




        driver.get("https://www.testotomasyonu.com");

        Thread.sleep(2000);

        driver.navigate().to("https://www.walmart.com");

        Thread.sleep(2000);

        // eski sayfadaki testotomasyonu sayfasina donun

        driver.navigate().back();

        Thread.sleep(2000);

        // bir daha walmart'a gidin

        driver.navigate().forward();













    }
}
