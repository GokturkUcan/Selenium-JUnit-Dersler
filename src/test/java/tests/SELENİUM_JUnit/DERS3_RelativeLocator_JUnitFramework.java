package tests.SELENİUM_JUnit;

public class DERS3_RelativeLocator_JUnitFramework {

    public static void main(String[] args) {


        // Relative locator icin 2 bilgiye sahip olmaliyiz
        // 1- hedef webelement'e ait HTML kodu veya en azindan HTML kodun bir bolumu
        // 2- hedef elementin etrafinda olup kullanabilecegimiz en az bir webelement

      /*
            StaleElementReferenceException
            bir sayfada daha once kullandigimiz bir webelementi
            yeniden kullanmak istedigimizde
            sayfa degistirmis olmamiz gibi farkli sebeplerden oturu
            webelement'e ulasamadiginda ortaya cikar

            bu sorunun cozumu icin
            stale element (bayatlamis)'i yeniden locate etmeliyiz
      */





    /*
        JUnit'deki @Test notasyonu sayesinde
        istedigimiz her method, bagimsiz calisabilen bir test method'u haline donusur

        JUnit'de test method'larinin hangi sira ile calisacagini
        ONGOREMEYIZ ve KONTROL EDEMEYIZ

        eger sira ile calistirmak istediginiz test method'lari varsa
        isimlerini test01() , test02(), test03() .... kullanabilirsiniz
     */

        /*
        Eger her test method'un once MUTLAKA calismasi gereken bir method varsa
        o method'u @Before notasyonu ile isaretleyebiliriz

        Eger her test method'un sonra MUTLAKA calismasi gereken bir method varsa
        o method'u @After notasyonu ile isaretleyebiliriz
     */

          /*
        JUnit testlerin PASSED veya FAILED olmasina
        kodlarin problemsiz calisp calismadigina bakarak karar verir

        Eger testler hic sorun yasanmadan
        sonuna kadar calisip
        Process finished with exit code 0 diyerek calisma biterse
        JUnit testleri PASSED olarak algilar ve raporlar

        Diger bir deyisle
        JUnit'de bir testin FAILED olarak algilanmasi icin
        kodlar calisirken exception olusmalidir

     */





































    }
}
