package com.hello.dptrade;

public class Drink {
    private String name;
    private String country;
    private String description;
    private int imageResourceId;

    public static final Drink[] drinks = {
            new Drink("Clarendelle Blanc","France", "Clarendelle – это бленд двух традиционных для Бордо сортов Семийон и Совиньон Блан.",
                    R.drawable.clarendelle_blanc),
            new Drink("Clarendelle Rouge", "France", "Элегантное и гармоничное вино. Бленд традиционных бордоских сортов: Мерло, Каберне Совиньон и Каберне Фран.",
                    R.drawable.clarendelle_rouge),
            new Drink("Barbaresco", "Italy", "Одно из величайших красных вин Италии, Барбареско – исторически самое важное вино семейства Гайя.",
                    R.drawable.barbaresco)
    };

    public Drink(String name, String country, String description, int imageResourceId) {
        this.name = name;
        this.country = country;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    @Override
    public String toString() {
        return name;
    }
}
