package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static void bekle(int saniye)  {

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    public static List<String> stringListesineDonustur(List<WebElement> webelementListesi){

        List<String> istenenStringList = new ArrayList<>();

        for (WebElement eachElement : webelementListesi
        ) {
            istenenStringList.add(eachElement.getText());
        }

        return istenenStringList;
    }



    public static void windowaGec(String hedefUrl, WebDriver driver){
        Set<String> tumWindowlarWHDleriSeti = driver.getWindowHandles();

        for (String eachWhd : tumWindowlarWHDleriSeti
        ) {
            driver.switchTo().window(eachWhd);

            if (driver.getCurrentUrl().equals(hedefUrl)){
                break;
            }
        }

    }


    public static void tumSayfaScreenshot(WebDriver driver){
        // ekran resmi ismini dinamik hale getirebilmek icin
        // tarih muhru ekleyelim ekranResmi240529202344
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter tarihFormati = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String tarihMuhru = ldt.format(tarihFormati);

        // 1.adim TakeScreenshot objesi olusturalim
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.adim cektigimiz screenshot'i kaydedecegimiz dosyayi olusturalim
        //   dosya uzantisi jpg, jpeg, png olabilir
        //   dosya yeri  target/screenshots olsun

        File tumSayfaScreenshot = new File("target/screenshots/ekranResmi"+tarihMuhru+".png");

        // 3.adim sayfa fotografini cekip gecici bir dosyaya yukleyelim

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4.adim gecici dosyayi asil olusturdugumuz dosyaya kopyalayalim

        try {
            FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static void tumSayfaScreenshot(WebDriver driver, String raporIsmi) {
        // 1.adim TakeScreenshot objesi olusturalim
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.adim cektigimiz screenshot'i kaydedecegimiz dosyayi olusturalim
        File tumSayfaScreenshot = new File("target/screenshots/"+raporIsmi+".png");

        // 3.adim sayfa fotografini cekip gecici bir dosyaya yukleyelim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4.adim gecici dosyayi asil olusturdugumuz dosyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static void webElementScreenshot(WebElement fotografCekilecekWebelement){
        // dinamik hale getirmek icin tarih muhru ekleyelim
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter tarihFormati = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String tarihMuhru = ldt.format(tarihFormati);

        // 1.adim : fotograf cekecegimiz webelementi locate edelim

        // 2.adim : resmi kaydedecegimiz File'i olusturalim
        File webElementSS = new File("target/screenshots/webElementSS"+tarihMuhru+".png");

        // 3.adim : screenshot alip gecici dosyaya kaydedelim
        File geciciDosya = fotografCekilecekWebelement.getScreenshotAs(OutputType.FILE);

        // 4.adim : gecici dosyayi asil dosyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciDosya,webElementSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}
