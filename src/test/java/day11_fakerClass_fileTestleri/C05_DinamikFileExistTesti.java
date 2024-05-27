package day11_fakerClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C05_DinamikFileExistTesti extends TestBase {

    @Test
    public void test01(){

        // masaustumuzde selenium-snapshot.png isimli bir dosya oldugunu test edin


       String dosyaYolu = "/Users/erolkahraman/Downloads/selenium-snapshot.png";

        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));


        //       /Users/ahmetbulutluoz                       /Desktop/upload.png
        //      /Users/burhanakyuz                          /Desktop/upload.png

        // Tum bilgisayarlarda tanimli bir anaDosyaYolu vardir
        // Java bu temel dosya yolunu bize veren bir koda sahiptir

        //bu sekılde dinamik hale gelir ve herkes ıcın calısır

        System.out.println(System.getProperty("user.home"));  // /Users/erolkahraman
        dosyaYolu =System.getProperty("user.home") + "/Downloads/selenium-snapshot.png";

        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }
}
