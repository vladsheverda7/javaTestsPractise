package core;

import com.codeborne.selenide.Selenide;

public class Navigation {
    public static void open(String url){
        Selenide.open(url);
    }
}
