package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}
