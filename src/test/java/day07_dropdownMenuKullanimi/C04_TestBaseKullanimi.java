package day07_dropdownMenuKullanimi;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_All;

public class C04_TestBaseKullanimi extends TestBase_All {


     @Test
     public void checkBoxTesti (){

         //	a. Verilen web sayfasına gidin.
         //	     https://the-internet.herokuapp.com/checkboxes
         driver.get("https://the-internet.herokuapp.com/checkboxes");

         ReusableMethods.bekle(2);
         //	b. Checkbox1 ve checkbox2 elementlerini locate edin.

         WebElement checkbox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
         WebElement checkbox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));


         //	c. Checkbox1 seçili değilse onay kutusunu tıklayın

         if(!checkbox1.isSelected()){
             checkbox1.click();
         }

         //	d. Checkbox2 seçili değilse onay kutusunu tıklayın


         if(!checkbox2.isSelected()){
             checkbox2.click();
         }

         ReusableMethods.bekle(3);

         //	e. Checkbox1ve Checkbox2’nin seçili olduğunu test edin

         Assertions.assertTrue(checkbox1.isSelected());
         Assertions.assertTrue(checkbox2.isSelected());

     }


}
