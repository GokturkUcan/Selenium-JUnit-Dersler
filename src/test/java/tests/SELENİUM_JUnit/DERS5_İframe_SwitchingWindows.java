package tests.SELENİUM_JUnit;

public class DERS5_İframe_SwitchingWindows {
    public static void main(String[] args) {



          /*
            driver'a iFrame'e gecis yaptirdigimizda
            biz onu yeniden anasayfaya dondurunceye kadar
            driver iFrame'de kalir

            Bu durumda ana sayfadaki webElementleri goremez

            Biz Elemental Selenium linkine ulasmak istiyorsak
            once gecis yaptigimiz iFrame'den anasayfaya donmeliyiz

            anasayfaya donus icin 2 yontem kullanabiliriz
            - parentFrame() : icice birden fazla iframe varsa
                              bizi bir ust iFrame'e gecirir
            - defaultContent() : direk anasayfaya doner

         */







          /*
        Coklu window kullaniminda bilmemiz gerekenler
        1- driver bir window actiginda, tiklanan linklerin veya
           yazilan yeni url'lerin ayni window'da acilmasini bekler
        2- Eger yeni bir tab/window olusturmak ve o tab/window'a gecmek istersek
           driver.switchTo().newWindow() kullaniriz
           bu komutla acacagimiz yeni windowlara, driver otomatik olarak gecer
           bizim ekstra bir islem yapmamiza gerek kalmaz
        3- Eger bir test calisirken, birden fazla window aciliyorsa
           ve testin ilerleyen kisimlarinda onceden acilan window'lara donmemiz gerekiyorsa
           acilan window'larin windowHandle degerlerini kaydederiz
           gecmek istedigimiz window'un  windowHandle degerini biliyorsak
           driver.switchTo(istenen Window'un whd) ile gecis yapabiliriz
        4- Bazen test sirasinda tiklanan bir link
           biz  driver.switchTo().newWindow() DEMEDEN yeni bir window acabilir

           bu durumda driver otomatik olarak yeni window'a gecmez
           bizim java kullanarak yeni window'un windowHandle degerini bulmamiz
           ve driver'i o window'a gecirmemiz gerekir
     */












































    }
}
