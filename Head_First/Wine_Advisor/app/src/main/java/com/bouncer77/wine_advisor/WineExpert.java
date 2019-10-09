package com.bouncer77.wine_advisor;


import java.util.ArrayList;
import java.util.List;

public class WineExpert {
    List<String> getWineType(String grapeColor) {
        List<String> gCollor = new ArrayList<>();
        if (grapeColor.equals("Белый")) {
            gCollor.add("ШАРДОНЕ");
            gCollor.add("СОВИНЬОН БЛАН");
            gCollor.add("РИСЛИНГ");
        } else {
            gCollor.add("КАБЕРНЕ СОВИНЬОН");
            gCollor.add("МЕРЛО");
            gCollor.add("ПИНО НУАР");
        }
        return gCollor;
    }
}
