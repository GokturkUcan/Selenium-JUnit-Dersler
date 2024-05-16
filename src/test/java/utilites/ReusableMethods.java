package utilites;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static utilites.BeforeAfterClass.driver;

public class ReusableMethods {

    public static List<String> stringListeDonustur(List<WebElement> donusturulecekListe){

        List<String> stingListe = new ArrayList<>();


        for (WebElement eachElement : donusturulecekListe
        ) {

            stingListe.add(eachElement.getText());
        }

        return stingListe;

    }


    public static void bekle(int second){

        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            System.out.println("bekletme isleminde sorun olustu");
        }

    }



    public static void windowDegistir(WebDriver driver, String gecmekİstediginizWindowUrl) {

        Set<String> tumWHDleriSeti = driver.getWindowHandles();

        for ( String eachWhd : tumWHDleriSeti
        ) {

            driver.switchTo().window(eachWhd);
            String looplaGecilenUrl = driver.getCurrentUrl();

            if (looplaGecilenUrl.equals(gecmekİstediginizWindowUrl)){
                break;

                //BURDA DRİVER ESKİ WİNDOWDA KALMİŞTİ, KONTROLSUZ AÇİLAN YENİ WİNDOW GEÇİRMİŞ OLDUK
                //YOKSA KONTROLSUZ AÇİLAN WİNDOWDA İŞLEM YAPAMAZDİK, BU DURUM BİR LİNK BASTİĞİMİZDA BAŞKA
                //WİNDOW DA AÇİYORSA DRİVER DA KONTRULSUZ AÇİLAN WİNDOW GEÇİRMELİYİZ
            }
        }


    }



    public static String WebTableDataBulma(int satirNo , int sutunNo){

        //             //tbody/tr[    satirNo    ]/td[    sutunNo     ]

        String dinamikXpath = "//tbody/tr[" + satirNo + "]/td[" + sutunNo + "]";
        WebElement istenenDataElementi = driver.findElement(By.xpath(dinamikXpath));

        return istenenDataElementi.getText();
    }




    public static void printData(int satir , int sutun){

        //         ((//div[@role='trow'])[  2   ] / *[@role='tdata'])[   2   ]

        String dinamikXpath = "((//div[@role='trow'])[" + satir +
                "] / *[@role='tdata'])[" + sutun + "]";

        WebElement istenenDataElementi = driver.findElement(By.xpath(dinamikXpath));

        System.out.println(satir +".satir, " + sutun+".sutundaki data : " + istenenDataElementi.getText());
    }




    public static void sayfaScreenshot(WebDriver driver,String screenShotName){

        // 1.adim TakesScreenShot objesi olusturun
        TakesScreenshot tss = (TakesScreenshot) driver;


        // 2.screenShoot'i kaydedecegimiz File olusturun, raporlara tarih etiketi ekleyelim

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyyMMdd");
        String tarihEtiketi = ldt.format(format1);

        screenShotName = screenShotName.replaceAll("\\s","");

        File tumSayfaScreenshot = new File("target/Screenshoots/"+screenShotName+tarihEtiketi+".png");


        // 3.screenshot'i alip gecici bir dosyaya kaydedelim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);


        // 4. gecici dosyayi asil kaydetmek istedigimiz dosyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);

        } catch (IOException e) {

            throw new RuntimeException(e);
        }


    }



    public static void webelementScreenShot(WebElement scrennshotAlinacakWebelement, String screenShotName){

        // 1- screenshot almak istediginiz webelementi locate edin
        // 2- Screenshot'i kaydedecegimiz file'i olusturun

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyyMMdd");
        String tarihEtiketi = ldt.format(format1);

        screenShotName = screenShotName.replaceAll("\\s","");
        File webelementScreenshot = new File("target/Screenshoots/"+screenShotName+tarihEtiketi+".png");


        // 3- webelementi kullanarak screenshot alip, gecici dosyaya kaydedin
        File geciciDosya = scrennshotAlinacakWebelement.getScreenshotAs(OutputType.FILE);


        // 4- gecici dosyayi, asil dosyaya kopyalayin
        try {
            FileUtils.copyFile(geciciDosya,webelementScreenshot);

        } catch (IOException e) {

            throw new RuntimeException(e);
        }

    }


}
