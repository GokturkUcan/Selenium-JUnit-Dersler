package tests.SELENİUM_JUnit;

public class DERS7_Waits_Cookies_WebTables {



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



     /*
        Explicit Wait implicitly wait'in yeterli olmadigi durumlarda
        spesifik bir webelement uzerinde, spesific bir condition'in calismasini kontrol etmek icin kullanilir

        1- WebDriverWait wait = new  WebDriverWait(driver, bekleme suresi);

        2- bekledigimiz element locate edilebiliyorsa
           once o webelement'i locate edip, sonra wait....

        3- Eger bekledigimiz element bekleme yapilmadan locate edilemiyorsa
           locate islemi ve wait tek bir satirda birlikte tanimlanabilir
     */






     /*
        WebElement itsGoneyaziElementi = driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));
        wait.until(ExpectedConditions.visibilityOf(itsGoneyaziElementi));

        bu iki islemin ikisi de once diger islemin calismasini istiyor
        locate etmek icin beklemek gerekiyor, beklemek icin de locate'e ihtiyac var

        Bu durum icin explicitly wait'de
        bekleme ve locate islemleri tek satirda yapilabilir
         */





















































}
