package data;

import lombok.Getter;
import models.BookCard;

import java.util.List;

public class CardDescriptionOnHomePage {
    private CardDescriptionOnHomePage() {}

    @Getter
    public static BookCard bookOne = new BookCard(
            "An Introduction to C & GUI Programming, 2nd Edition",
            "",
            "$12.94",
            "ISBN-13: ",
            "9781912047451"
    );

    @Getter
    public static BookCard bookTwo = new BookCard(
            "Snowflake: The Definitive Guide",
            "Architecting, Designing, and Deploying on the Snowflake Data Cloud",
            "$58.90",
            "ISBN-13: ",
            "9781098103828"
    );

    @Getter
    public static BookCard bookThree = new BookCard(
            "Python for Data Analysis, 3rd Edition",
            "Data Wrangling with pandas, NumPy, and Jupyter",
            "$34.96",
            "ISBN-13: ",
            "9781098104030"
    );

    @Getter
    public static BookCard bookFour = new BookCard(
            "Reliable Machine Learning",
            "Applying SRE Principles to ML in Production",
            "$43.99",
            "ISBN-13: ",
            "9781098106225"
    );

    public static List<BookCard> cards = List.of(bookOne, bookTwo, bookThree, bookFour);
}
