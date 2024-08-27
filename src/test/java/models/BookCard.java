package models;

public class BookCard {
    private final String title;
    private final String description;
    private final String price;
    private final String series;
    private final String number;


    public BookCard(String title, String description, String price, String series, String number) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.series = series;
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public String getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getSeries() {
        return series;
    }
}
