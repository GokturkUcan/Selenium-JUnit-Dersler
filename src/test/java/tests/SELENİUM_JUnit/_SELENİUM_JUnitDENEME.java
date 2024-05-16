package tests.SELENİUM_JUnit;


import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilites.BeforeAfterClass;
import utilites.ReusableMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class _SELENİUM_JUnitDENEME extends BeforeAfterClass {



    //KONU[1]
    //@Before ve @After olarak
    // 3 farkli method olusturarak, asagidaki testleri yapin
    // test method'lari ayri ayri veya bir butun olarak calistirilabilmelidir
    // 1- testotomasyonu anasayfaya gidip, sayfaya gidildigini test edin
    // 2- unityverseacademy.com anasayfaya gidip, sayfaya gidildigini test edin
    // 3- youtube anasayfaya gidip, sayfaya gidildigini test edin


    @Test
    public void testotomasyonTest(){

        // 1- testotomasyonu anasayfaya gidip, sayfaya gidildigini test edin
        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "otomasyon";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

    }

    @Test
    public void unityverseTest(){

        driver.get("https://www.unityverseacademy.com");

        String expectedUrlIcerik = "unity";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }

    @Test
    public void youtubeTest(){

        driver.get("https://www.youtube.com");

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }













    //KONU[2]
    //ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “Facebook - Giriş Yap veya Kaydol" oldugunu doğrulayin
    //Sayfa URL’inin “https://www.facebook.com/” kelimesi oldugunu dogrulayin
    //https://www.walmart.com/ sayfasina gidin.
    //Sayfa basliginin “Walmart” icerdigini dogrulayin.
    //Tekrar “facebook” sayfasina donun
    //Sayfayi yenileyin
    //Sayfayi tam sayfa (maximize) yapin



    @Test
    public void facebookWlmartTest(){

        //facebook sayfasina gidin ve sayfa basliginin (title) “Facebook” içerdiğini dogrulayin

        driver.get("https://www.facebook.com");

        String expectedFacebookTitle = "Facebook";
        String actualFacebookTitle = driver.getTitle();

        Assert.assertTrue(actualFacebookTitle.contains(expectedFacebookTitle));


        //Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin

        String expectedUrl = "facebook";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));


        //https://www.walmart.com/ sayfasina gidin

        driver.navigate().to("https://www.walmart.com/");


        //Sayfa basliginin “Walmart” icerdigini dogrulayin.

        String expectedWalmartTitle = "Walmart";
        String actualWalmartTitle = driver.getTitle();

        Assert.assertTrue(actualWalmartTitle.contains(expectedWalmartTitle));

        //Tekrar “facebook” sayfasina donun
        driver.navigate().back();
        //Sayfayi yenileyin
        driver.navigate().refresh();
        //Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();

    }















    //KONU[3]
    //@BeforeClass ve @AfterClass olarak
    // 1- test otomasyonu anasayfaya gidin, testotomasyonu sayfasina gidildigini test edin
    // 2- arama kutusuna phone yazip aratin, arama sonucunda urun bulunabildigini test edin
    // 3- ilk urune tiklayin, urun aciklama bolumunde case sensitive olmadan phone kelimesi gectigini test edin


    @Test
    public void testotomasyonuTest(){

        // 1- test otomasyonu anasayfaya gidip
        //testotomasyonu sayfasina gidildigini test edin
        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));



        // 2- arama kutusuna phone yazip aratin
        //    arama sonucunda urun bulunabildigini test edin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.xpath("//*[@class='product-box my-2  py-1']"));

        Assert.assertTrue(bulunanUrunElementleriList.size()  > 0);



        // 3- ilk urune tiklayin
        driver.findElement(By.xpath("(//*[@class='product-box my-2  py-1'])[1]"))
                .click();

        //urun aciklama bolumunde case sensitive olmadan phone kelimesi gectigini test edin

        WebElement urunAciklamaElementi = driver.findElement(By.xpath("//*[@class='product-short-desc  my-2']"));

        String expectedUrunIcerik = "phone";
        String aciklamaKucukHarf = urunAciklamaElementi.getText().toLowerCase();

        Assert.assertTrue(aciklamaKucukHarf.contains(expectedUrunIcerik));

    }













    //KONU[4]
    //https://www.bestbuy.com/ Adresine gidin
    //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //○ logoTest => BestBuy logosunun görüntülendigini test edin


    @Test
    public void bestBuyTest(){

        //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin

        driver.get("https://www.bestbuy.com/");

        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);


        //○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin

        String unExpectedTitleIcerik = "Rest";
        String actualTitle = driver.getTitle();

        Assert.assertFalse( actualTitle.contains(unExpectedTitleIcerik));


        //○ logoTest => BestBuy logosunun görüntülendigini test edin

        WebElement logoElementi = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));

        Assert.assertTrue(logoElementi.isDisplayed());

    }













    //KONU[5]
    // Relative locator icin 2 bilgiye sahip olmaliyiz
    // 1- hedef webelement'e ait HTML kodu veya en azindan HTML kodun bir bolumu
    // 2- hedef elementin etrafinda olup kullanabilecegimiz en az bir webelement

    //1 ) https://testotomasyonu.com/relativeLocators adresine gidin
    // 2 ) DSLR Camera’yi  etrafindaki elementleri kullanarak
    //3 ) relative locator ile locate edip test etmek istediğimiz ürün tiklayin
    //4 ) Acilan urunun DSLR Camera oldugunu test edin.



    @Test
    public void relativeLocatorTest(){


        driver.get("https://testotomasyonu.com/relativeLocators");


        WebElement appleKulaklik = driver.findElement(By.id("apple-headphone"));
        WebElement motorTelefon = driver.findElement(By.id("motor"));
        WebElement batKulaklik = driver.findElement(By.id("bat-rockerz"));

        WebElement releativeDslr1 = driver.findElement(RelativeLocator.with(By.id("dslr-camera"))
                .below(batKulaklik)
                .toRightOf(appleKulaklik)
                .toLeftOf(motorTelefon));

        releativeDslr1.click();


        WebElement urunisimElementi = driver.findElement(By.xpath("(//*[text()='DSLR Camera'])[1]"));

        String expectedUrunIsmi = "DSLR Camera";
        String actualUrunIsmi = urunisimElementi.getText();

        Assert.assertEquals(actualUrunIsmi,expectedUrunIsmi);


    }














    //KONU[6]
    //https://demoqa.com/checkbox
    // home yazisinin yanindaki > ile menuyu acin
    // desktop yazinin yanindaki > ile menuyu acin
    // Notes checkbox'ini secin
    // Notes checkbox'in görünür oldugunu test edin
    // Commands checkbox'in secili olmadigini test edin


    @Test
    public void checkBoxTest() {

        //https://demoqa.com/checkbox
        driver.get("https://demoqa.com/checkbox");


        // home yazisinin yanindaki > ile menuyu acin
        driver.findElement(By.xpath("(//*[@title='Toggle'])[1]"))
                .click();

        // desktop yazinin yanindaki > ile menuyu acin
        driver.findElement(By.xpath("(//*[@title='Toggle'])[2]"))
                .click();


        // Notes checkbox'ini secin
        WebElement notesCheckbox = driver.findElement(By.xpath("(//*[@class='rct-icon rct-icon-uncheck'])[3]"));
        notesCheckbox.click();


        // Notes checkbox'in secili oldugunu test edin
        notesCheckbox = driver.findElement(By.xpath("//*[@class='rct-icon rct-icon-check']"));
        Assert.assertTrue(notesCheckbox.isDisplayed());


        // Commands checkbox'in secili olmadigini test edin
       WebElement commandsCheckbox = driver.findElement(By.xpath("(//*[@class='rct-icon rct-icon-uncheck'])[1]"));

       Assert.assertFalse(commandsCheckbox.isSelected());
    }











    //KONU[7]
    //https://testotomasyonu.com/form sayfasina gidin
    //Cinsiyet Radio button elementlerini locate edin
    //direk buton’dan size uygun olani secin
    //Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

    @Test
    public void radioButtonTest(){

        //https://testotomasyonu.com/form sayfasina gidin
        driver.get("https://testotomasyonu.com/form");

        //Cinsiyet Radio button elementlerini locate edin

        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));


        //yazidan veya direk buton’dan size uygun olani secin

        WebElement erkekRadioButtonYaziElementi = driver.findElement(By.xpath("//*[@for='inlineRadio2']"));
        erkekRadioButtonYaziElementi.click();


        //Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

        Assert.assertTrue(erkekRadioButton.isSelected());
        Assert.assertFalse(kadinRadioButton.isSelected());
        Assert.assertFalse(digerRadioButton.isSelected());

    }











    //KONU[8]
    //[1]https://testotomasyonu.com/form adresine gidin
    //[2]Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
    //[3]Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
    //[4]Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
    //[5]Secilen değerleri konsolda yazdirin

    @Test
    public void dropDownMenuTest() {
        //[1]https://testotomasyonu.com/form adresine gidin
        driver.get("https://testotomasyonu.com/form");

        //[2]Dogum tarihi gun seçeneğinden index kullanarak 5’i secin

        // 1.adim : kullanilacak Webelementi locate et
        WebElement gunDropdown = driver.findElement(By.xpath("(//select[@class=\"form-control\"])[1]"));

        // 2.adim : select objesi olusturalim, parametre olarak kullanacagimiz DDM'yu yazalim
        Select selectGun = new Select(gunDropdown);

        // 3.adim : olusturdugumuz select objesi ile, hazir methodlari kullanalim
        selectGun.selectByIndex(5);


        //[3] Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin

        WebElement ayDropdown = driver.findElement(By.xpath("(//select[@class=\"form-control\"])[2]"));
        Select selectAy = new Select(ayDropdown);
        selectAy.selectByValue("nisan");


        //[4] Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin

        WebElement yilDropdown = driver.findElement(By.xpath("(//select[@class=\"form-control\"])[3]"));
        Select selectYil = new Select(yilDropdown);
        selectYil.selectByVisibleText("1990");


        //[5] Secilen değerleri konsolda yazdirin

        System.out.println(selectGun.getFirstSelectedOption().getText());
        System.out.println(selectAy.getFirstSelectedOption().getText());
        System.out.println(selectYil.getFirstSelectedOption().getText());

    }











    //KONU[9]
    //[1]http://zero.webappsecurity.com/ Adresine gidin
    //[2]Sign in butonuna basin
    //[3]Login kutusuna “username” yazin
    //[4]Password kutusuna “password” yazin
    //[5]Sign in tusuna basin
    //[6]Geri tusuna basin ve Online Banking menusunden Pay Bills sayfasina gidin
    //[7]Purchase Foreign Currency” tusuna basin
    //[8]Currency drop down menusunden Eurozone’u secin
    //[9]amount kutusuna bir sayi girin
    //[10]US Dollars in secilmedigini test edin
    //[11]Selected currency butonunu secin
    //[12]Calculate Costs butonuna basin sonra “purchase” butonuna basin
    //[13]Foreign currency cash was successfully purchased yazisinin ciktigini kontrol edin.


    @Test
    public void DropDownMenuTest(){
        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //2. Sign in butonuna basin
        driver.findElement(By.id("signin_button"))
                .click();

        //3. Login kutusuna “username” yazin
        driver.findElement(By.id("user_login"))
                .sendKeys("username");

        //4. Password kutusuna “password” yazin
        driver.findElement(By.id("user_password"))
                .sendKeys("password");

        //5. Sign in tusuna basin,
        driver.findElement(By.xpath("//input[@name='submit']"))
                .click();

        //6. Geri tusuna basin ve Online Banking menusunden Pay Bills sayfasina gidin
        driver.navigate().back();

        driver.findElement(By.id("onlineBankingMenu"))
                .click();

        driver.findElement(By.id("pay_bills_link"))
                .click();


        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']"))
                .click();


        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement currencyDropdownMenu = driver.findElement(By.id("pc_currency"));
        Select select = new Select(currencyDropdownMenu);
        select.selectByValue("EUR");



        //9. “amount” kutusuna bir sayi girin
        driver.findElement(By.id("pc_amount"))
                .sendKeys("200");



        //10. “US Dollars” in secilmedigini test edin
        WebElement usDollarRadioButton = driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(usDollarRadioButton.isSelected());



        //11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false"))
                .click();



        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs"))
                .click();

        driver.findElement(By.id("purchase_cash"))
                .click();


        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        WebElement sonucYaziElementi = driver.findElement(By.id("alert_content"));

        String expectedSonucYazisi = "Foreign currency cash was successfully purchased.";
        String actualSonucYazisi = sonucYaziElementi.getText();

        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);

    }










    //KONU[10]
    //https://testotomasyonu.com/javascriptAlert adresine gidin
    //JS alert'e tiklayin
    //OK tusuna basip alert'i kapatin

    @Test
    public void jsAlertTestAccept(){

        //https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //alert'e tiklayin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']"))
                .click();


        //OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();

    }


    //KONU[10]
    //https://testotomasyonu.com/javascriptAlert adresine gidin
    //JS Confirm alert'e tiklayin
    //Cancel'a basip
    //cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin

    @Test
    public void jsAlertTestCancel(){

        //https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");


        //alert'e tiklayalin
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']"))
                .click();


        //Cancel'a basip
        driver.switchTo().alert().dismiss();


        //cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        String actualSonucYazisi = driver.findElement(By.xpath("//*[@id='result']"))
                .getText();
        String expectedSonucYazisi = "You clicked: Cancel";

        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);
    }


    //KONU[10]
    //https://testotomasyonu.com/javascriptAlert adresine gidin
    //JS Prompt alert'e tiklayin
    //Cikan prompt ekranina "Abdullah" yazdiralim
    //OK tusuna basarak alert'i kapatalim
    //Cikan sonuc yazisinin Abdullah icerdigini test edelim

    @Test
    public void jsAlertTestPrompt(){

        //https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //alert'e tiklayalin
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']"))
                .click();

        //Cikan prompt ekranina "Abdullah" yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");

        //OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();


        //Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String expectedYaziIcerik = "Abdullah";
        String actualSonucYazisi = driver.findElement(By.xpath("//*[@id='result']"))
                .getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedYaziIcerik));
    }











    //KONU[11]
    //basic authentication daha cok bilgisayarlar/uygulamalar arasi iletisimde kullanilir
    //hizmet saglayicisi her isteyenin hic bir kontrol olmadan sistemine giris yapmasina izin vermez
    //Basic authentication ile giris yapabilmemiz icin 2 bilgiyi hizmet saglayicidan ogrenmeliyiz
    //kullanacagimiz username ve password
    //bu username ve password'u nasil url'e ekleyecegimiz

    //[1]https://testotomasyonu.com/basicauth sayfasina gidin
    //[2]asagidaki yontem ve test datalarini kullanarak authentication’i yapin
    //Html komutu : https://username:password@URL
    //	Username     : membername
    // 	password      : sunflower
    //[3]Basarili girildiyse "Congratulations! You are logged in as: membername" olduğunu dogrulayin



    @Test
    public void basicAuthenticationTest(){

        //1 https://testotomasyonu.com/basicauth sayfasina gidin
        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");

        //2 asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //Html komutu : https://username:password@URL
        //	Username     : membername
        // 	password      : sunflower


        //3 Basarili sekilde sayfaya girildigini dogrulayin

        WebElement basariliGirisYazielementi= driver.findElement(By.tagName("h1"));

        String expectedYazi = "Basic Auth";
        String actualYazi = basariliGirisYazielementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);

    }













    //KONU[12]
    //[1]https://the-internet.herokuapp.com/iframe adresine gidin
    //[2]“An IFrame containing” textinin erisilebilir oldugunu test edin ve konsolda yazdirin
    //[3]Text Box’a “Merhaba Dunya!” yazin
    /*
     Textbox iframe icerisinde oldugu icin, TexBox direk Kullanamayiz
     iFrame icerisindeki bir webelement'e ulasmak icin, once o iFrame'e gecis yapmaliyiz
     iFrame'e gecis yapabilmek icin de,  iFrame'i locate etmeliyiz
    */

    //[4]TextBox’in altinda bulunan “Elemental Selenium”,linkinin gorunur oldugunu dogrulayin ve  konsolda yazdirin
    /*
     driver'a iFrame'e gecis yaptirdigimizda, biz onu yeniden anasayfaya dondurunceye kadar driver iFrame'de kalir
     Bu durumda ana sayfadaki webElementleri goremez,  Biz Elemental Selenium linkine ulasmak istiyorsak
     once gecis yaptigimiz iFrame'den anasayfaya donmeliyiz,  anasayfaya donus icin 2 yontem kullanabiliriz
     parentFrame() : icice birden fazla iframe varsa,  defaultContent() : direk anasayfaya done
     */


    @Test
    public void iFrameTest(){

        //1 https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //2 “An IFrame containing” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement anIframeyaziElementi = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(anIframeyaziElementi.isEnabled());

        System.out.println(anIframeyaziElementi.getText());


        //3 Text Box’a “Merhaba Dunya!” yazin.
        WebElement iFrameElementi = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrameElementi);

        WebElement textBox = driver.findElement(By.xpath("//*[@id='tinymce']"));

        textBox.clear();
        textBox.sendKeys("Merhaba Dunya");


        //4 TextBox’in altinda bulunan “Elemental Selenium”,linkinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
        driver.switchTo().parentFrame();

        WebElement elementalSeleniumElementi = driver.findElement(By.linkText("Elemental Selenium"));

        Assert.assertTrue(elementalSeleniumElementi.isDisplayed());

        System.out.println(elementalSeleniumElementi.getText());



    }

















    //KONU[13]
    //1- https://testotomasyonu.com/discount adresine gidin
    //2- Elektronics Products yazisinin gorunur olduğunu test edin
    //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
    //4- ‘Fashion’ yazisinin gorunur olduğunu test edin, once sagdaki iFrame'e gecmeliyiz,
    //ama biz soldaki iFrame'in icinde oldugumuzdan, en once oradan anasayfaya donmeliyiz
    //6- ‘Here are some products’ yazisinin gorunur olduğunu test edin


    @Test
    public void IFrameTest() {

        //[1]- https://testotomasyonu.com/discount adresine gidin

        driver.get("https://testotomasyonu.com/discount");


        //[2]- Elektronics Products yazisinin gorunur olduğunu test edin

        WebElement electronicsIFrame = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(electronicsIFrame);

        WebElement electronicsYaziElementi = driver.findElement(By.xpath("//h2[text()='Electronics Products']"));
        Assert.assertTrue(electronicsYaziElementi.isDisplayed());


        //[3]- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin

        WebElement dellElementi = driver.findElement(By.id("dell-core"));
        String expectedUrunIsmi = "DELL Core I3 11th Gen";
        String actualUrunIsmi = dellElementi.getText();

        Assert.assertEquals(expectedUrunIsmi, actualUrunIsmi);


        //[4]‘Fashion’ yazisinin gorunur olduğunu test edin,
        // once sagdaki iFrame'e gecmeliyiz, ama biz soldaki iFrame'in icinde oldugumuzdan,  en once oradan anasayfaya donmeliyiz


        driver.switchTo().defaultContent();

        WebElement fashionIFrame = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fashionIFrame);



        WebElement fashionYaziElementi = driver.findElement(By.xpath("//h2[text()='Fashion']"));

        Assert.assertTrue(fashionYaziElementi.isDisplayed());



        //[6]- ‘Here are some products’ yazisinin gorunur olduğunu test edin

        driver.switchTo().defaultContent();

        WebElement hereAreYaziElementi = driver.findElement(By.xpath("//*[text()='Here are some products.']"));

        Assert.assertTrue(hereAreYaziElementi.isDisplayed());

    }









    //[14]
    //● testotomasyonu anasayfa adresine gidin.
    //● Sayfa’nin window handle degerini String bir degiskene atayin
    //● Sayfa title’nin “Otomasyon” icerdigini test edin
    //● Yeni bir tab olusturup, acilan tab’da unityverseacademy.com adresine gidin
    //● Sayfa title’nin “UNITYVERSE ACADEMY” icerdigini test edin
    //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
    //● Sayfa title’nin “Walmart” icerdigini test edin
    //● Ilk actigimiz window’a donun ve testotomasyonu sayfasina dondugumuzu test edin


    @Test
    public void windowlarAarasiGecisTest(){

        //● testotomasyonu anasayfa adresine gidin.
        driver.get("https://www.testotomasyonu.com");

        //● Sayfa’nin window handle degerini String bir degiskene atayin
        String toWhd = driver.getWindowHandle();

        //● Sayfa title’nin “Otomasyon” icerdigini test edin
        String expectedTitleIcerik = "Otomasyon";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));


        //● Yeni bir tab olusturup, acilan tab’da unityverseacademy.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.unityverseacademy.com");


        //● Sayfa title’nin “unityverse” icerdigini test edin
        expectedTitleIcerik = "UNITYVERSE";
        actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));


        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");


        //● Sayfa title’nin “Walmart” icerdigini test edin
        expectedTitleIcerik = "Walmart";
        actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));


        //● Ilk actigimiz window’a donun ve testotomasyonu sayfasina dondugumuzu test edin
        driver.switchTo().window(toWhd);

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(3);

    }











    //[15]
    //1- https://testotomasyonu.com/discount adresine gidin
    //2- Elektronics Products yazisinin gorunur olduğunu test edin
    //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
    //4- Dell bilgisayar’a tiklayip acilan sayfada urun fiyatinin $399.00 olduğunu test edin, dikkat kontrolsuz acilan window
    //5- Ilk sayfaya donun ve Fashion yazisinin gorunur olduğunu test edin

    @Test
    public void kontrolsuzAcilanWindowTest() {

        //1- https://testotomasyonu.com/discount adresine gidin, en sonda bu sayfa donecegiz
        driver.get("https://testotomasyonu.com/discount");

        //2- Elektronics Products yazisinin gorunur olduğunu test edin
        String ilkWindowWhd = driver.getWindowHandle();

        WebElement electronicsIframe = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(electronicsIframe);

        WebElement electronicsYaziElementi = driver.findElement(By.xpath("//*[text()='Electronics Products']"));

        Assert.assertTrue(electronicsYaziElementi.isDisplayed());


        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        WebElement dellBilgElementi = driver.findElement(By.id("dell-core"));

        String expectedUrunIsmi = "DELL Core I3 11th Gen";
        String actualUrunIsmi = dellBilgElementi.getText();

        Assert.assertEquals(expectedUrunIsmi, actualUrunIsmi);


        //4- Dell bilgisayar’a tiklayip acilan sayfada urun fiyatinin $399.00 olduğunu test edin
        //dikkat kontrolsuz acilan window
        dellBilgElementi.click();

        String gecmekIstedigimizWindowUrl = "https://testotomasyonu.com/product/58";

        Set<String> tumSayfaWHDleri = driver.getWindowHandles();

        for (String  eachWHD : tumSayfaWHDleri
        ) {

            driver.switchTo().window(eachWHD);
            String gecilenWindowUrl = driver.getCurrentUrl();
            System.out.println(gecilenWindowUrl);

            if (gecmekIstedigimizWindowUrl.equals(gecilenWindowUrl)){
                break;
            }

        }

        String  expectedUrunFiyati = "$399.00";
        WebElement urunFiyatElementi  = driver.findElement(By.id("priceproduct"));
        String actualUrunFiyati = urunFiyatElementi.getText();

        Assert.assertEquals(expectedUrunFiyati,actualUrunFiyati);




        //5- Ilk sayfaya donun ve Fashion yazisinin gorunur olduğunu test edin
        driver.switchTo().window(ilkWindowWhd);

        WebElement fashionIframe = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fashionIframe);

        WebElement fashionYaziElementi = driver.findElement(By.xpath("//*[text()='Fashion']"));

        Assert.assertTrue(fashionYaziElementi.isDisplayed());




    }











    //[16]
    //● https://the-internet.herokuapp.com/windows adresine gidin.
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın. dikkat kontrolsuz acilan window
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki sayfa dönün,  sonra sayfa başlığının “The Internet” olduğunu doğrulayın

    @Test
    public void kontrolsuzAcilanWindowMethodileTest(){

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement yaziElementi = driver.findElement(By.tagName("h3"));

        String expectedYazi = "Opening a new window";
        String actualYazi = yaziElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);


        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);


        //● Click Here butonuna basın. dikkat kontrolsuz acilan window
        driver.findElement(By.linkText("Click Here"))
                .click();

        ReusableMethods.windowDegistir(driver,"https://the-internet.herokuapp.com/windows/new");



        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        expectedTitle = "New Window";
        actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);


        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        yaziElementi = driver.findElement(By.tagName("h3"));

        expectedYazi = "New Window";
        actualYazi = yaziElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);


        //● Bir önceki sayfa dönün,  sonra sayfa başlığının “The Internet” olduğunu doğrulayın
        ReusableMethods.windowDegistir(driver,"https://the-internet.herokuapp.com/windows");

        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);


    }













    //[17]
    //1- https://testotomasyonu.com/click sitesine gidin
    //2- “DGI Drones” uzerinde sag click yapin
    //3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.
    //4- Tamam diyerek alert’i kapatalim

    @Test
    public void mouseActionSagClickMethodTest(){

        //1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");

        //2- “DGI Drones” uzerinde sag click yapin
        WebElement dgiDronesElementi = driver.findElement(By.id("pic2_thumb"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        actions.contextClick(dgiDronesElementi).perform();
        ReusableMethods.bekle(1);

        //3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.

        String expectedAlertYazisi = "Tebrikler!... Sağ click yaptınız.";
        String actualAlertYazisi = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        //4- Tamam diyerek alert’i kapatalim

        driver.switchTo().alert().accept();

        ReusableMethods.bekle(3);
    }




    //[18]
    //1- https://testotomasyonu.com/droppable adresine gidelim
    //2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
    //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
    //4- Sayfayi yenileyin
    //5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
    //6- “Drop Here” yazisinin degismedigini test edin

    @Test
    public void mouseActionDragAndDropMethodTest(){

        //1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");

        //2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        WebElement acceptableButonu = driver.findElement(By.xpath("//*[text()='Acceptable']"));
        WebElement dropHereKutusu = driver.findElement(By.xpath("//*[@id='droppable2']"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        actions.dragAndDrop(acceptableButonu,dropHereKutusu).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        ReusableMethods.bekle(1);
        WebElement droppedYaziElementi = driver.findElement(By.xpath("//*[text()='Dropped!']"));
        Assert.assertTrue(droppedYaziElementi.isDisplayed());

        //4- Sayfayi yenileyin
        driver.navigate().refresh();

        //5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        WebElement notAccaptableElementi = driver.findElement(By.id("draggable-nonvalid2"));
        dropHereKutusu = driver.findElement(By.xpath("//*[@id='droppable2']"));
        ReusableMethods.bekle(1);
        actions.dragAndDrop(notAccaptableElementi,dropHereKutusu).perform();

        //6- “Drop Here” yazisinin degismedigini test edin
        WebElement dropHereYaziElementi = driver.findElement(By.xpath("//*[text()='Drop Here']"));

        String expectedYazi = "Drop Here";
        String actualYazi = dropHereYaziElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);

        ReusableMethods.bekle(3);
    }





    //[19]
    //1- https://www.testotomasyonu.com/ adresine gidin
    //2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
    //3- “Boys” linkine basin
    //4- Acilan sayfadaki ilk urunu tiklayin
    //5- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin

    @Test
    public void mouseActionMoveToElementMethodTest(){

        //1- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");

        //2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        WebElement kidsWearMenu = driver.findElement(By.xpath("(//li[@class='has-sub'])[7]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(kidsWearMenu).perform();

        //3- “Boys” linkine basin
        driver.findElement(By.linkText("Boys"))
                .click();

        //4- Acilan sayfadaki ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@*='product-box mb-2 pb-1'])[1]"))
                .click();

        //5- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin
        WebElement urunIsimElementi = driver.findElement(By.xpath("//*[text()='Boys Shirt White Color']"));

        String expectedUrunIsmi = "Boys Shirt White Color";
        String actualUrunIsmi = urunIsimElementi.getText();

        Assert.assertEquals(expectedUrunIsmi,actualUrunIsmi);

        ReusableMethods.bekle(3);
    }














    //[20]
    //1- https://www.testotomasyonu.com sayfasina gidelim
    //2- Arama kutusuna actions method’larini kullanarak
    //   “DELL Core I3” yazdirin ve Enter’a basarak arama yaptirin
    //3- Bulunan urun isminde “DELL Core I3” bulundugunu test edin

    @Test
    public void klavyeActionAramaTest(){

        //1- https://www.testotomasyonu.com sayfasina gidelim
        driver.get("https://www.testotomasyonu.com");

        //2- Arama kutusuna actions method’larini kullanarak
        //   “DELL Core I3” yazdirin ve Enter’a basarak arama yaptirin

        Actions actions = new Actions(driver);

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        actions.click(aramaKutusu)
                .keyDown(Keys.SHIFT)
                .sendKeys("dell c")
                .keyUp(Keys.SHIFT)
                .sendKeys("ore ")
                .keyDown(Keys.SHIFT)
                .sendKeys("i")
                .keyUp(Keys.SHIFT)
                .sendKeys("3")
                .sendKeys(Keys.ENTER)
                .perform();

        //3- Bulunan urun isminde “DELL Core I3” bulundugunu test edin

        String expectedIsimIcerik = "DELL Core I3";

        WebElement urunIsimElementi = driver.findElement(By.xpath("//*[@class='prod-title mb-3 ']"));
        String actualIsim = urunIsimElementi.getText();

        Assert.assertTrue(actualIsim.contains(expectedIsimIcerik));

        ReusableMethods.bekle(3);
    }




    //[21]
    //1- https://www.testotomasyonu.com adresine gidelim
    //2- Account linkine tiklayin
    //3 Sign Up tusuna Link basalim
    //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
    //5- Kaydin olusturuldugunu test edin, account linkine basinca, girdigimiz isimle login olundugu gorunuyor

    @Test
    public void klavyeActionFormTest(){

        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");

        //2- Account linkine tiklayin
        driver.findElement(By.xpath("//*[text()='Account']"))
                .click();

        //3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[text()=' Sign Up']"))
                .click();

        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
        WebElement firstnameKutusu = driver.findElement(By.id("firstName"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);
        actions.click(firstnameKutusu)
                .sendKeys("Ali")
                .sendKeys(Keys.TAB)
                .sendKeys("Yildiz")
                .sendKeys(Keys.TAB)
                .sendKeys("aliYildiz@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .perform();

        //kaydol tusuna basalim
        driver.findElement(By.id("btn-submit-form"))
                .click();
        ReusableMethods.bekle(1);

       //5- Kaydin olusturuldugunu test edin, account linkine basinca, girdigimiz isimle login olundugu gorunuyor
        driver.findElement(By.xpath("//*[text()='Account']"))
                .click();

        WebElement isimElementi = driver.findElement(By.xpath("(//h3)[1]"));
        String expectedIsim = "ali";
        String actualIsim = isimElementi.getText();

        Assert.assertEquals(expectedIsim,actualIsim);

    }












    //[22]
    //20 denemedeki testi, Faker class'indan degerler ile yapin
    //1- https://www.testotomasyonu.com adresine gidelim
    //2- Account linkine tiklayin
    //3- Sign Up linkine basalim
    //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
    //5- Kaydin olusturuldugunu test edin, account linkine basinca, girdigimiz isimle login olundugu gorunuyor

    @Test
    public void klavyeActionFakerFormTest(){

        //20 denemedeki testi, Faker class'indan degerler ile yapin
        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");

        //2- Account linkine tiklayin
        driver.findElement(By.xpath("//*[text()='Account']"))
                .click();

        //3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[text()=' Sign Up']"))
                .click();

        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
        WebElement firstnameKutusu = driver.findElement(By.id("firstName"));

        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        String fakePassword = faker.internet().password();
        String fakeIsim = faker.name().firstName();

        ReusableMethods.bekle(1);
        actions.click(firstnameKutusu)
                .sendKeys(fakeIsim)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(fakePassword)
                .sendKeys(Keys.TAB)
                .sendKeys(fakePassword)
                .perform();
        ReusableMethods.bekle(1);

        //kaydol tusuna basalim
        driver.findElement(By.id("btn-submit-form"))
                .click();
        ReusableMethods.bekle(1);


       //5- Kaydin olusturuldugunu test edin, account linkine basinca, girdigimiz isimle login olundugu gorunuyor
        driver.findElement(By.xpath("//*[text()='Account']"))
                .click();

        WebElement isimElementi = driver.findElement(By.xpath("(//h3)[1]"));

        String actualIsim = isimElementi.getText();

        Assert.assertEquals(fakeIsim,actualIsim);

    }











    //[23]
    //1- https://html.com/tags/iframe/ sayfasina gidelim
    //2- video’yu gorecek kadar asagi inin,
     /*
      driver objesi gorunmeyen bir webelementi kullanmasi gerektiginde,  farkli websayfalarinda farkli davranabilir
      bazi websayfalarinda webelementi goremesek de driver kullanabilirken, bazi sayfalarda gorunmeyen webelementleri kullanamayiz
      Testimiz sirasinda gorunmeyen bir webelementi kullanmamiz gerekirse, deneyip sonucu gozlemlemek en iyi yol olacaktir

     */
    //3- videoyu izlemek icin Play tusuna basin, video iframe icinde oldugundan, once iframe'e gecis yapmaliyiz
    //4- videoyu calistirdiginizi test edin, calistigini test etmek icin, mouse'u volume butonuna yaklastirip
    //volume logosunun gorunur oldugunu test edelim

    @Test
    public void scroolDownAndPageDownTest(){

        //1- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //2- video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //actions.scrollToElement(videoIframeElementi); EGER webelementi locate edip kullanabileceksek, bu methodu kullanabiliriz
        ReusableMethods.bekle(3);


        //3- videoyu izlemek icin Play tusuna basin, video iframe icinde oldugundan, once iframe'e gecis yapmaliyiz
        WebElement videoIframeElementi = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(videoIframeElementi);


        driver.findElement(By.xpath("//*[@class=\"ytp-large-play-button ytp-button ytp-large-play-button-red-bg\"]"))
                .click();


        //4- videoyu calistirdiginizi test edin, calistigini test etmek icin, mouse'u volume butonuna yaklastirip
        //volume logosunun gorunur oldugunu test edelim

        ReusableMethods.bekle(3);

        WebElement volumeButonu = driver.findElement(By.className("ytp-volume-panel"));
        actions.moveToElement(volumeButonu).perform();

        Assert.assertTrue(volumeButonu.isDisplayed());

        ReusableMethods.bekle(2);
    }








    //[24]
    //1. https://the-internet.herokuapp.com/download adresine gidelim.
    //2. logo.png dosyasını indirelim
    //3. Dosyanın başarıyla indirilip indirilmediğini test edelim

    @Test
    public void FileExistDosyaİndermeTest(){

        //1. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //2. logo.png dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='file-name.png']"))
                .click();

        //3. Dosyanın başarıyla indirilip indirilmediğini test edelim

        String dosyaYolu = "C:\\Users\\User\\Downloads"+"/"+"\\file-name.png";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }








    //[25]
    //1- projede calistigimiz package altinda deneme.txt dosyasinin oldugunu Dinamik dosya yolu yapmadan test edin
    //2- projedeki package icinde deneme dosyasi oldugunu Dinamik dosyaYolu ile test edin
    // "/Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/unityverseTeam2_JUnit" ==> yerine System.getProperty("user.dir") Kullaniriz
    //3- Downloads'da nRoBo-Logo.png dosyasinin var oldugunu test edin
    // "/Users/ahmetbulutluoz" ==> yerine System.getProperty("user.home") kullaniriz
    //Dinamik dosya yolu yapinca kime göndersek gönderelim kodu herkesin bilgiseyarinda çalişir

    @Test
    public void fileExistDinamikDosyaYoluTest(){

        //1- projede calistigimiz package altinda deneme.txt dosyasinin oldugunu Dinamik dosya yolu yapmadan test edin
        String dinamikOlmayanDosyaYolu = "C:\\Users\\User\\IdeaProjects\\unityverseTeam2_JUnitt\\src\\test\\java\\tests\\SELENİUM_JUnit\\deneme";
        Assert.assertTrue(Files.exists(Paths.get(dinamikOlmayanDosyaYolu)));

        //2- projedeki package icinde deneme dosyasi oldugunu Dinamik dosyaYolu ile test edin
        // "/Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/unityverseTeam2_JUnit" ==> yerine System.getProperty("user.dir") Kullaniriz

        String dinamikFileWay = System.getProperty("user.dir") +"/"+ "src/test/java/tests/SELENİUM_JUnit/deneme";
        Assert.assertTrue(Files.exists(Paths.get(dinamikFileWay)));


        //3- Downloads'da spectrum-logo.png dosyasinin var oldugunu test edin
        // "/Users/ahmetbulutluoz" ==> yerine System.getProperty("user.home") kullaniriz

        dinamikFileWay = System.getProperty("user.home") +"/"+ "Downloads\\file-name.png";
        Assert.assertTrue(Files.exists(Paths.get(dinamikFileWay)));


    }










    //[26]
    //1- https://the-internet.herokuapp.com/upload adresine gidelim
    //2- chooseFile butonuna basalim, Yuklemek istediginiz dosyayi secelim
    /*
     Selenium ile bilgisayarimizda varolan bir dosyayi, secmek istedigimizde
     chooseFile butonuna bilgisayarimizdaki yuklemek istedigimiz dosyanin, dosya yolunu sendKeys() ile gondermemiz yeterlidir
    */
    //3- Upload butonuna basalim
    //4- “File Uploaded!” textinin goruntulendigini test edelim

    @Test
    public void fileExistBilgiseyardanDosyaSecipİndirmeTest(){

        //1- https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");


        //2- chooseFile butonuna basalim, Yuklemek istediginiz dosyayi secelim
        String dinamikDosyaYolu = System.getProperty("user.home") +"/"+ "Downloads\\file-name.png";
        WebElement secigimizDosya = driver.findElement(By.xpath("//*[@id='file-upload']"));
        secigimizDosya.sendKeys(dinamikDosyaYolu);


        //3- Upload butonuna basalim
        driver.findElement(By.xpath("//*[@id='file-submit']"))
                .click();

        //4- “File Uploaded!” textinin goruntulendigini test edelim
        WebElement uploadedText = driver.findElement(By.xpath("//*[text()='File Uploaded!']"));
        Assert.assertTrue(uploadedText.isDisplayed());

    }













    //[27]
    //1- https://the-internet.herokuapp.com/upload adresine gidelim
    //2- chooseFile butonuna basalim, package altindaki deneme dosyasini secelim.
    /*
     Selenium ile bilgisayarimizda varolan bir dosyayi, secmek istedigimizde
     chooseFile butonuna bilgisayarimizdaki yuklemek istedigimiz dosyanin, dosya yolunu sendKeys() ile gondermemiz yeterlidir
    */
    //3- Upload butonuna basalim.
    //4- “File Uploaded!” textinin goruntulendigini test edelim

    @Test
    public void fileExistProjedenDosyaSecipİndirmeTest(){

        //1- https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //2- chooseFile butonuna basalim, package altindaki deneme dosyasini secelim.
        String dinamikDosyaYolu = System.getProperty("user.dir") +"/"+ "src/test/java/tests/SELENİUM_JUnit/deneme";
        WebElement sectigimDosya = driver.findElement(By.xpath("//*[@id='file-upload']"));
        sectigimDosya.sendKeys(dinamikDosyaYolu);

        //3- Upload butonuna basalim.
        driver.findElement(By.xpath("//*[@id='file-submit']"))
                .click();


        //4- “File Uploaded!” textinin goruntulendigini test edelim
        WebElement uploadedText = driver.findElement(By.xpath("//*[text()='File Uploaded!']"));
        Assert.assertTrue(uploadedText.isDisplayed());

    }
















    //[28]
    //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //2. Textbox’in etkin olmadigini(enabled) dogrulayın
    //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    //5. implicitlyWait suresini dusurdugumuz icin, bekleme yeterli olmayacaktir
    //textbox'a ozel enable oluncaya kadar bekleme tanimlayalim
    //6. Textbox’in etkin oldugunu(enabled) dogrulayın.
    //7. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

    @Test
    public void explicitWaitTest(){

        /*
            Implicitlywait sayfanin yuklenmesi ve webelementlerin bulunmasi icin belirlenmis
            maximim bekleme suresidir
            Bu sure internet ve bilgisayardaki yavasliklari tolere edecek kadar uzun,
            tum testlerin calisma suresini cok fazla uzatmayacak kadar kisa secilmelidir

            Testlerimiz sirasinda genel bekleme suresi olan implicitly wait suresi icinde
            sonuclandirilamayan islemler olabilir,
            bu durumda sadece o webelement'e ve sadece o goreve ozel
            explicit wait tanimlanabilir
         */


        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox = driver.findElement(By.xpath("//*[@type='text']"));
        Assert.assertFalse(textBox.isEnabled());

        //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//*[text()='Enable']"))
                .click();

        //5. implicitlyWait suresini dusurdugumuz icin, bekleme yeterli olmayacaktir
        // textbox'a ozel enable oluncaya kadar bekleme tanimlayalim

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(textBox));

        //6. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(textBox.isEnabled());

        //7. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabledYaziElementi = driver.findElement(By.id("message"));
        Assert.assertTrue(itsEnabledYaziElementi.isDisplayed());


        ReusableMethods.bekle(3);
        driver.quit();

    }







    //[29]
    //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //2. Remove butonuna basin.
    //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
      /*
        WebElement itsGoneyaziElementi = driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));
        wait.until(ExpectedConditions.visibilityOf(itsGoneyaziElementi));

        bu iki islemin ikisi de once diger islemin calismasini istiyor, locate etmek icin beklemek gerekiyor, beklemek icin de locate'e ihtiyac var
        Bu durum icin explicitly wait'de,   bekleme ve locate islemleri tek satirda yapilabilir
         */
    //4. Add buttonuna basin
    //5. It’s back mesajinin gorundugunu test edin
    // mesajin goruntulenebilmesi icin locate islemi ve wait'i birlestiriyoruz

    @Test
    public void explicitlyWaitTesti(){

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']"))
                .click();

        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));



        WebElement itsGoneyaziElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));


        //4. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']"))
                .click();


        //5. It’s back mesajinin gorundugunu test edin
        // mesajin goruntulenebilmesi icin locate islemi ve wait'i birlestiriyoruz

        WebElement itsBackYaziElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));
        Assert.assertTrue(itsBackYaziElementi.isDisplayed());


        ReusableMethods.bekle(3);
        driver.quit();
    }












    //[30]
    //1- Amazon anasayfaya gidin
    //2- tum cookie’leri listeleyin
    //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
    //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun,ve sayfaya ekleyin
    //6- eklediginiz cookie’nin sayfaya eklendigini test edin
    //7- ismi skin olan cookie’yi silin ve silindigini test edin
    //8- tum cookie’leri silin ve silindigini test edin

    @Test
    public void cookiesTest(){

        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2- tum cookie’leri listeleyin
        Set<Cookie> cookiesSeti  = driver.manage().getCookies();
        int no = 1;

        for (Cookie each : cookiesSeti
        ) {
            System.out.println(no + ". cookie :  " + each);
            no++;
        }



        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookiesSeti.size() > 5);


        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String expectedDeger = "USD";
        String actualDeger = driver
                .manage()
                .getCookieNamed("i18n-prefs")
                .getValue();
        Assert.assertEquals(expectedDeger,actualDeger);


        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun,ve sayfaya ekleyin
        Cookie newCookie = new Cookie("En Sevdigim Cookie","cikolatali");
        driver.manage().addCookie(newCookie);


        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        cookiesSeti  = driver.manage().getCookies();
        boolean cikolataliCookieVarMi = false;

        for (Cookie eachCookie : cookiesSeti
        ) {

            if (eachCookie.getName().equals("En Sevdigim Cookie")){
                cikolataliCookieVarMi = true;
            }

        }

        Assert.assertTrue(cikolataliCookieVarMi);


        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        cookiesSeti  = driver.manage().getCookies();

        boolean skinCookieVarMi = false;

        for (Cookie eachCookie : cookiesSeti
        ) {

            if (eachCookie.getName().equals("skin")){
                skinCookieVarMi = true;
            }

        }

        Assert.assertFalse(skinCookieVarMi);


        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookiesSeti  = driver.manage().getCookies();

        Assert.assertEquals(cookiesSeti.size(),0);


        ReusableMethods.bekle(2);
    }














    //[31]
    //1- "https://testotomasyonu.com/webtables" adresine gidin
    //2-  Web table tum body’sini yazdirin
    //3-  Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
    //4-  Web table’daki satir sayisinin 5 oldugunu test edin
    //5-  Tum satirlari yazdirin
    //6-  Web table’daki sutun sayisinin 4 olduğunu test edin,  WebTable'larda sutun yapisi yoktur
    //kac sutun oldugunu bulmak icin, herhangi bir satirdaki data sayisini bulalim
    //7-  3.sutunu yazdirin
    //8-  Tablodaki basliklari yazdirin
    //9-  Satir ve sutunu parametre olarak alip,hucredeki bilgiyi döndüren bir method olusturun
    //10-  4.satirdaki category degerinin "Furniture" oldugunu test edin

    @Test
    public void classicWebTableOlanTest(){

        //1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");

        //2. Web table tum body’sini yazdirin
        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        System.out.println("======Tum Body======");
        System.out.println(tumBody.getText());

        //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
        String expectedBodyIcerik = "Comfortable Gaming Chair";
        String actualBody = tumBody.getText();

        Assert.assertTrue(actualBody.contains(expectedBodyIcerik));

        //4. Web table’daki satir sayisinin 5 oldugunu test edin
        List<WebElement> satirElementleriList =
                driver.findElements(By.xpath("//tbody/tr"));

        int expectedSatirSayisi = 5;
        int actualSatirSayisi = satirElementleriList.size();

        Assert.assertEquals(expectedSatirSayisi,actualSatirSayisi);

        //5. Tum satirlari yazdirin
        System.out.println("======Tum Satirlar======");
        System.out.println(ReusableMethods.stringListeDonustur(satirElementleriList));


        //6. Web table’daki sutun sayisinin 4 olduğunu test edin,  WebTable'larda sutun yapisi yoktur
        //kac sutun oldugunu bulmak icin, herhangi bir satirdaki data sayisini bulalim

        List<WebElement> satir4DataElementleri = driver.findElements(By.xpath("//tbody/tr[4]/td"));
        Assert.assertEquals(4,satir4DataElementleri.size());


        //7. 3.sutunu yazdirin
        List<WebElement> sutun3Elementleri =
                driver.findElements(By.xpath("//tbody/tr/td[3]"));

        System.out.println(ReusableMethods.stringListeDonustur(sutun3Elementleri));

        //8. Tablodaki basliklari yazdirin
        List<WebElement> baslikElementleriList =
                driver.findElements(By.xpath("//thead/tr/th"));

        System.out.println(ReusableMethods.stringListeDonustur(baslikElementleriList));


        //9. Satir ve sutunu parametre olarak alip,hucredeki bilgiyi döndüren bir method olusturun

        System.out.println(ReusableMethods.WebTableDataBulma(2,3)); // $40.00
        System.out.println(ReusableMethods.WebTableDataBulma(1,2)); // Electronics


        //10. 4.satirdaki category degerinin "Furniture" oldugunu test edin
        String expectedData = "Furniture";
        String actualData = ReusableMethods.WebTableDataBulma(4,2);

        Assert.assertEquals(expectedData,actualData);

    }












    //[32]
    //  1. “https://testotomasyonu.com/webtables2” sayfasina gidin
    //  2. Headers da bulunan basliklari yazdirin
    //  3.sutunun basligini yazdirin
    //  4. Tablodaki tum datalari yazdirin
    //  5. Tabloda kac tane cell (data) oldugunu yazdirin
    //  6. Tablodaki satir sayisini yazdirin
    //  7. Tablodaki sutun sayisini yazdirin
    //  8. Tablodaki 3.kolonu yazdirin
    //  9. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin
    //     tum satirlari kontrol etmesi gerektigi icin, bir for loop olusturalim
    // 10. Bir method olusturun, Test sayfasindan satir ve sutun verildiginde datayi yazdirsin

    @Test
    public void classicWebTableOlmayanTest() {

        //  1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");

        //  2. Headers da bulunan basliklari yazdirin
        List<WebElement> baslikSutunElementleriList =
                driver.findElements(By.xpath("//div[@role='hrow']/ *[@role='hdata']"));

        System.out.println(ReusableMethods.stringListeDonustur(baslikSutunElementleriList));


        //  3.sutunun basligini yazdirin
        System.out.println("3.sutun basligi : " + baslikSutunElementleriList.get(2).getText());


        //  4. Tablodaki tum datalari yazdirin
        List<WebElement> bodydekiTumDataElementleriList =
                driver.findElements(By.xpath("//div[@role='trow']/ *[@role='tdata']"));

        System.out.println(ReusableMethods.stringListeDonustur(bodydekiTumDataElementleriList));


        //  5. Tabloda kac tane cell (data) oldugunu yazdirin
        System.out.println("Tablo body'sindeki data sayisi : " + bodydekiTumDataElementleriList.size());


        //  6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirElementleriList = driver.findElements(By.xpath("//div[@role='trow']"));

        System.out.println("Tablodaki satir sayisi : " + satirElementleriList.size());


        //  7. Tablodaki sutun sayisini yazdirin
        System.out.println("Tablodaki sutun sayisi : " + baslikSutunElementleriList.size());


        //  8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuSutunElementleriList =
                driver.findElements(By.xpath("//div[@role='trow']/ *[@role='tdata'][3]"));

        System.out.println("3.Sutun : " + ReusableMethods.stringListeDonustur(ucuncuSutunElementleriList));


        //  9. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin
        //     tum satirlari kontrol etmesi gerektigi icin, bir for loop olusturalim

        for (int i = 1; i <= satirElementleriList.size(); i++) {

            //     ((//div[@role='trow'])[   5   ] / *[@role='tdata'])[2]
            String dinamikCategoryXpathi = "((//div[@role='trow'])[" + i + "] / *[@role='tdata'])[2]";

            //     ((//div[@role='trow'])[   5   ] / *[@role='tdata'])[3]
            String dinamikFiyatXpathi = "((//div[@role='trow'])[" + i + "] / *[@role='tdata'])[3]";

            String satirdakiCategory = driver.findElement(By.xpath(dinamikCategoryXpathi))
                    .getText();

            String satirdakiFiyat = driver.findElement(By.xpath(dinamikFiyatXpathi))
                    .getText();

            if (satirdakiCategory.equalsIgnoreCase("Furniture")) {
                System.out.println("Category'si furniture olan urunun fiyati : " + satirdakiFiyat);
            }

        }


        // 10. Bir method olusturun, Test sayfasindan satir ve sutun verildiginde datayi yazdirsin
        ReusableMethods.printData(3,2);

    }
















    //[33]
    //Selenium bilgisayarimizdaki excel'e webDriver ile ulasamayiz
    //Java ile bilgisayarimizdaki dosyalara erişip bilgileri okuyabilir veya update edebiliriz
    //1. dosyayolu Oluşturmak
    //2. java dosya yolunu okutmak fileInputStream Objesi
    //3. Workbook objesi oluşturup excell deki bütün bilgileri workbook kopyalamak
    //4  Sheet objesi oluşturup excell de hangi sayfada işlem yapacaksak o sayfanin adini "" yazmak
    //5. artik sheet objes.Row(satir).Cell(hucre) index kullanarak erişebilir yazdirabiliriz
    //6. sayfa1 de 10.satirdaki ulkenin Turkce ismini yazdirin
    //7. Row objesi veya Cell Objesi olmadan da direk Sheet Objesi veya Wokbook objesi ile de erişebilriz

    @Test
    public void ReadExcelTest() throws IOException {

        //1. dosyayolu Oluşturmak
        String dosyaYolu = "src/test/java/tests/day08_webTables_excelOtomasyonu/ulkeler.xlsx";

        //2. java dosya yolunu okutmak fileInputStream Objesi
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        //3. Workbook objesi oluşturup excell deki bütün bilgileri workbook kopyalamak
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //4  Sheet objesi oluşturup excell de hangi sayfada işlem yapacaksak o sayfanin adini "" yazmak
        Sheet sayfa1 = workbook.getSheet("Sayfa1");


        //6. sayfa1 de 10.satirdaki ulkenin Turkce ismini yazdirin
        Row onuncuSatir = sayfa1.getRow(9);
        Cell istenenBilgi = onuncuSatir.getCell(2);

        System.out.println(istenenBilgi);


        //7. Row objesi veya Cell Objesi olmadan da direk Sheet Objesi veya Wokbook objesi ile de erişebilriz
        System.out.println(workbook.getSheet("Sayfa1").getRow(9).getCell(2));

    }














    //[34]
    //1) Read Excel icin gereken ayarlari yapin
    //2) 1 satirdaki 2.hucreye gidelim ve yazdiralim
    //3) 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
    //4) 2.satir 4.cell’in afganistan’in baskenti Kabil oldugunu test edelim
    //5) 3.satir 6.sutun'daki bilgiyi yazdirin
    //6) 200.satir 3.sutundaki bilgiyi yazdiralim, kullanilan satirlardaki, kullanilmayan sutunlar icin default deger olarak null veriyor
    //ama kullanilmayan satirlar olusturulmadigi icin NullPointerException verir
    //7) index olarak Excel de kullanilan Satir sayisini yazdiralim
    //8) Fiziki olarak kullanilan satir sayisini bulun
    //9) Excel de Sayfa2'de bulunan sayfa sayisini index ve fiziksel olarak yazdirin
    //10) Manuel Olarak Excel de bulunan Ingilizce baskent isimlerinde Amsterdam isimli baskentin oldugunu test edin
    //11) Manuel Olarak Excel de bulunan Ingilizce ulke isimlerinde Pakistan oldugunu test edin
    //12) Otomatik olarak o ulke bu baskent var mi gibi sorgulamalari Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
    //13) Map ile otomatik olarak Ingilizce baskent ismi Berlin olan bir ulke bulundugunu test edin
    //14) Map ile otomatik olarak Ingilizce ismi Turkey olan bir ulke bulundugunu test edin
    //15) Map ile otomatik olarak Ingilizce ismi Banana Republic olan bir ulke bulunmadigini test edin

    @Test
    public void ReadExcellTest() throws IOException {

        //1) Read Excel icin gereken ayarlari yapin
        String dosyaYolu = "src/test/java/tests/day08_webTables_excelOtomasyonu/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        //2) 1 satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(sayfa1.getRow(0).getCell(1));

        //3) 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String istenenHucredekiYazi = sayfa1.getRow(0).getCell(1).toString();
        System.out.println(istenenHucredekiYazi);

        //4) 2.satir 4.cell’in afganistan’in baskenti Kabil oldugunu test edelim
        String expectedCellYazi = "Kabil";
        String actualCellYazi = sayfa1.getRow(1).getCell(3).toString();

        Assert.assertEquals(expectedCellYazi,actualCellYazi);

        //5) 3.satir 6.sutun'daki bilgiyi yazdirin
        System.out.println(sayfa1.getRow(2).getCell(5));

        //6) 200.satir 3.sutundaki bilgiyi yazdiralim, kullanilan satirlardaki, kullanilmayan sutunlar icin default deger olarak null veriyor
        //ama kullanilmayan satirlar olusturulmadigi icin NullPointerException verir
         System.out.println(sayfa1.getRow(199).getCell(2));


        //7) İndex olarak Excell de kullanilan Satir sayisini yazdiralim
        System.out.println(sayfa1.getLastRowNum());

        //8) Fiziki olarak kullanilan satir sayisini bulun
        System.out.println(sayfa1.getPhysicalNumberOfRows());


        //9) Excell de Sayfa2'de bulunan sayfa sayisini index ve fiziksel olarak yazdirin
        System.out.println(workbook.getSheet("sayfa2").getLastRowNum());
        System.out.println(workbook.getSheet("Sayfa2").getPhysicalNumberOfRows());



        //10) Manuel Olarak Excell de bulunan Ingilizce baskent isimlerinde Amsterdam isimli baskentin oldugunu test edin
        boolean amsterdamVarMi = false;

        for (int i = 1; i <= sayfa1.getLastRowNum() ; i++) {

            String satirdakiIngilizceBaskentIsmi = sayfa1.getRow(i).getCell(1).toString();

            if (satirdakiIngilizceBaskentIsmi.equalsIgnoreCase("amsterdam")){
                amsterdamVarMi = true;
                break;
            }

        }

        Assert.assertTrue(amsterdamVarMi);



        //11) Manuel Olarak Excell de bulunan Ingilizce ulke isimlerinde Pakistan oldugunu test edin
        boolean pakistanVarMi = false;

        for (int i = 1; i <= sayfa1.getLastRowNum() ; i++) {

            String satirdakiIngilizceUlkeIsmi =
                    sayfa1.getRow(i).getCell(0).toString();


            if (satirdakiIngilizceUlkeIsmi.equalsIgnoreCase("pakistan")){
                pakistanVarMi = true;
                break;
            }
        }

        Assert.assertTrue(pakistanVarMi);



        //12) Otomatik olarak o ulke bu baskent var mi gibi sorgulamalari Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        Map<String,String> ulkelerMap = new TreeMap();

        for (int i = 1; i <= sayfa1.getLastRowNum() ; i++) {

            String satirdakiIngilizceBaskentIsmi = sayfa1.getRow(i).getCell(1).toString();
            String satirdakiIngilizceUlkeIsmi = sayfa1.getRow(i).getCell(0).toString();

            ulkelerMap.put(satirdakiIngilizceUlkeIsmi,satirdakiIngilizceBaskentIsmi);
        }


        //13) Map ile otomatik olarak Ingilizce baskent ismi Berlin olan bir ulke bulundugunu test edin
        Assert.assertTrue(ulkelerMap.containsValue("Berlin"));

        //14) Map ile otomatik olarak Ingilizce ismi Turkey olan bir ulke bulundugunu test edin
        Assert.assertTrue(ulkelerMap.containsKey("Turkey"));

        //15) Map ile otomatik olarak Ingilizce ismi Banana Republic olan bir ulke bulunmadigini test edin
        Assert.assertFalse(ulkelerMap.containsKey("Banana Republic"));

    }














    //[35]
    //1) Write Excel için gereken ayarlari yapalim
    //2) 1.satir 5.hucreye yeni bir cell yani hucre olusturalim
    //3) Olusturdugumuz hucreye “Nufus” yazdiralim
    //4) 2.satir nufus kolonuna 1500000 yazdiralim
    //5) 10.satir nufus kolonuna 250000 yazdiralim
    //6) 15.satir nufus kolonuna 54000 yazdiralim
    //7) biz bunlari workbook da yaptik excele kaydetmek için Dosyayi kaydedelim
    //8) Ram sağliği icin fileInput,fileOutput,workbook objeleri.close olarak Dosyayi kapatalim

    @Test
    public void WriteExcelTest() throws IOException {

        //1) Write Excel için gereken ayarlari yapalim
        String dosyaYolu = "src/test/java/tests/day08_webTables_excelOtomasyonu/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        //2) 1.satir 5.hucreye yeni bir cell yani hucre olusturalim
        sayfa1.getRow(0).createCell(4);

        //3) Olusturdugumuz hucreye “Nufus” yazdiralim
        sayfa1.getRow(0).getCell(4).setCellValue("Nufus");

        //4) 2.satir nufus kolonuna 1500000 yazdiralim
        sayfa1.getRow(1).createCell(4).setCellValue("1500000");

        //5) 10.satir nufus kolonuna 250000 yazdiralim
        sayfa1.getRow(9).createCell(4).setCellValue("250000");

        //6) 15.satir nufus kolonuna 54000 yazdiralim
        sayfa1.getRow(14).createCell(4).setCellValue("54000");

        //7) biz bunlari workbook da yaptik excele kaydetmek için Dosyayi kaydedelim
        FileOutputStream fileOutputStream = new FileOutputStream(dosyaYolu);
        workbook.write(fileOutputStream);

        //8)Ram sağliği icin fileInput,fileOutput,workbook objeleri.close olarak Dosyayi kapatalim
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();
    }












    //[36]
    //1) testotomasyonu anasayfaya gidin
    //2) phone icin arama yapin
    //3) arama sonucunda urun bulunabildigini test edin
    //4) arama sonucunda urun bulunduguna dair sayfanin screenshot'ini alin
    //screenShot Almak icin 4 adim gerekir
    //1. adim TakesScreenShot objesi olusturun
    //2. screenShoot'i kaydedecegimiz File objesi olusturun target dan dosyaYolunu vererek
    //3. screenshot'i alip gecici bir dosyaya kaydedelim
    //4. gecici dosyayi asil kaydetmek istedigimiz dosyaya kopyalayalim

    @Test
    public void sayfaScreenShotTest() throws IOException {

        //1) testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        //2) phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        //3) arama sonucunda urun bulunabildigini test edin
        WebElement aramaSonucElementi = driver.findElement(By.xpath("//*[@class='product-count-text']"));

        String unExpectedAramaSonucu = "0 Products Found";
        String actualAramaSonucu = aramaSonucElementi.getText();

        Assert.assertNotEquals(unExpectedAramaSonucu,actualAramaSonucu);
        ReusableMethods.bekle(1);


        //4) arama sonucunda urun bulunduguna dair sayfanin screenshot'ini alin

        //1. adim TakesScreenShot objesi olusturun
        TakesScreenshot tss = (TakesScreenshot) driver;

        //2. screenShoot'i kaydedecegimiz File objesi olusturun target dan dosyaYolunu vererek
        File tumSayfaScreenshot = new File("target/Screenshoots/tumSayfaScreenshot.png");

        //3. screenshot'i alip gecici bir dosyaya kaydedelim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        //4. gecici dosyayi asil kaydetmek istedigimiz dosyaya kopyalayalim
        FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);

        ReusableMethods.bekle(2);


    }









    //[36]
    //1) testotomasyonu anasayfaya gidin
    //2) phone icin arama yapin
    //3) arama sonucunda urun bulunabildigini test edin
    //4) arama sonucunda urun bulunduguna dair bulunan urun sayisi yazisinin screenshot'ini alin
    //screenShot Almak icin 4 adim gerekir
    //1. adim TakesScreenShot objesi olusturun
    //2. screenShoot'i kaydedecegimiz File objesi olusturun target dan dosyaYolunu vererek
    //3. screenshot'i alip gecici bir dosyaya kaydedelim
    //4. gecici dosyayi asil kaydetmek istedigimiz dosyaya kopyalayalim

    @Test
    public void webElementScreenShotTest() throws IOException {

        //1) testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        //2) phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        //3) arama sonucunda urun bulunabildigini test edin
        WebElement aramaSonucElementi = driver.findElement(By.xpath("//*[@class='product-count-text']"));

        String unExpectedAramaSonucu = "0 Products Found";
        String actualAramaSonucu = aramaSonucElementi.getText();

        Assert.assertNotEquals(unExpectedAramaSonucu,actualAramaSonucu);
        ReusableMethods.bekle(1);


        //4) arama sonucunda urun bulunduguna dair bulunan urun sayisi yazisinin screenshot'ini alin

        // 1- screenshot almak istediginiz webelementi locate edin

        // 2- Screenshot'i kaydedecegimiz file'i olusturun
        File webelementScreenshot = new File("target/Screenshoots/webelementScreenshot.png");

        // 3- webelementi kullanarak screenshot alip, gecici dosyaya kaydedin
        File geciciDosya = aramaSonucElementi.getScreenshotAs(OutputType.FILE);

        // 4- gecici dosyayi, asil dosyaya kopyalayin
        FileUtils.copyFile(geciciDosya,webelementScreenshot);


    }










    //[38]
    //javaScripExecutor obje ile javaScript kodlari koyarak ve wepelement vererek birçok işlem yapabiliriz
    //1) Testotomasyonu anasayfaya gidin
    //3) acilan sayfada "chat with experts" butonuna basin
    //4) javaScriptExecutor da alert çikarin
    @Test
    public void javaScriptExecutorTest(){

        //1) Testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");


        //2) javascriptExecutor kullanarak Men Fashion'a click yapin
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement menFashionLinki = driver.findElement(By.xpath("(//*[@class='has-sub'])[2]"));
        ReusableMethods.bekle(2);
        jse.executeScript("arguments[0].click();",menFashionLinki);



        //3) acilan sayfada "chat with experts" butonuna basin
        WebElement chatWithExperts = driver.findElement(By.className("button-block"));
        jse.executeScript("arguments[0].scrollIntoView();",chatWithExperts);

        ReusableMethods.bekle(2);


        //4) javaScriptExecutor da alert çikarin
        jse.executeScript("window.alert('Merhaba, bu bir JavaScript alertidir!');");



    }















}
