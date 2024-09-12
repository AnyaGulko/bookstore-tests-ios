package data;

import models.BookCard;

import java.util.List;

public class CardDescriptionOnHomePage {
    private CardDescriptionOnHomePage() {}

    public static BookCard bookOne = new BookCard(
            "An Introduction to C & GUI Programming, 2nd Edition",
            "",
            "$12.94",
            "ISBN-13: ",
            "9781912047451"
    );

    public static BookCard bookTwo = new BookCard(
            "Snowflake: The Definitive Guide",
            "Architecting, Designing, and Deploying on the Snowflake Data Cloud",
            "$58.90",
            "ISBN-13: ",
            "9781098103828"
    );

    public static BookCard bookThree = new BookCard(
            "Python for Data Analysis, 3rd Edition",
            "Data Wrangling with pandas, NumPy, and Jupyter",
            "$34.96",
            "ISBN-13: ",
            "9781098104030"
    );

    public static BookCard bookFour = new BookCard(
            "Reliable Machine Learning",
            "Applying SRE Principles to ML in Production",
            "$43.99",
            "ISBN-13: ",
            "9781098106225"
    );

    public static BookCard firstBookInSearch = new BookCard(
            "Effective JavaScript",
            "68 Specific Ways to Harness the Power of JavaScript",
            "$21.99",
            "ISBN-13: ",
            "9780321812186"
    );

    public static BookCard secondBookInSearch = new BookCard(
            "Sams Teach Yourself Java in 24 Hours, 6th Edition",
            "Covering Java 7 and Android",
            "$5.71",
            "ISBN-13: ",
            "9780672335754"
    );


    public static List<BookCard> cards = List.of(bookOne, bookTwo, bookThree, bookFour);
    public static List<BookCard> bookInSearch = List.of(firstBookInSearch,secondBookInSearch);
}
