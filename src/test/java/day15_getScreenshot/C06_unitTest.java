package day15_getScreenshot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class C06_unitTest {


    public boolean tekSayiKontrolu( int kontrolEdilecekSayi){
        // Unit : tek basina calisabilen ve test edilebilen en kucuk kod parcacigi

        // verilen sayi tek sayi ise true, cift sayi ise false donduren bir method olusturun

        boolean sonuc = kontrolEdilecekSayi % 2 == 0 ? false : true ;

        return sonuc;

    }



    @Test
    public void unitTestTekSayiKontrolu(){

        Random random = new Random();

        for (int i = 1; i <100 ; i++) {

            int testsayisi = random.nextInt(1000000);

            if (testsayisi % 2 == 0 ){ // urettigimiz sayi cift

                Assertions.assertFalse(tekSayiKontrolu(testsayisi));

            }else { // urettigimiz sayi tek

                Assertions.assertTrue(tekSayiKontrolu(testsayisi));
            }

        }

    }

}
