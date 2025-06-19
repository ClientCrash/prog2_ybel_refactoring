package refactoring;

import java.util.ArrayList;
import java.util.Date;

/**
 * Represents a bill for a customer with purchased articles.
 */
public class Bill {

    private String customerName;
    private String nickname;
    private Date birthday;
    private String email;
    private String street;
    private String streetNumber;
    private int postalCode;
    private String city;
    private ArrayList<Article> articles;

    /**
     * Creates a new bill for a customer.
     */
    public Bill(String customerName, String nickname, String street, String streetNumber, int postalCode, Date birthday, String email, String city) {
        this.customerName = customerName;
        this.nickname = nickname;
        this.street = street;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.birthday = birthday;
        this.email = email;
        this.city = city;
        this.articles = new ArrayList<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getNickname() {
        return nickname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public boolean addArticle(Article article) {
        return articles.add(article);
    }

    public String getDetails() {
        String result = buildCustomerHeader();
        result += buildArticlesList();
        return result;
    }

    /**
     * Builds the customer information header for the bill.
     * @return formatted customer information
     */
    private String buildCustomerHeader() {
        String result = "Details for \"" + customerName + "\"\n";
        result += street + " " + streetNumber + "\n";
        result += postalCode + " " + city + "\n";
        result += "Geburtstag: " + birthday + "\n";
        result += "Email: " + email + "\n\n";
        result += "refactoring.Article: \n";
        return result;
    }

    /**
     * Builds the articles list with prices and total.
     * @return formatted articles list with total price
     */
    private String buildArticlesList() {
        double total = 0;
        String result = "";

        for (Article article : articles) {
            double price = calculateArticlePrice(article);
            result += formatArticleLine(article, price);
            total += price;
        }

        result += "\nTotal price:\t" + String.valueOf(total) + "\n";
        return result;
    }

    /**
     * Calculates the price for a single article including discounts.
     * @param article the article to calculate price for
     * @return the final price after all discounts
     */
    private double calculateArticlePrice(Article article) {
        double price = calculateBasePrice(article);
        return applyHighValueDiscount(price);
    }

    /**
     * Calculates the base price before high-value discount.
     * @param article the article to calculate base price for
     * @return the base price with bike-specific discounts applied
     */
    private double calculateBasePrice(Article article) {
        double price = 0;
        if (article.getBike() instanceof Brompton) {
            price = calculateBromptonPrice(article);
        } else if (article.getBike() instanceof EBike) {
            price = calculateEBikePrice(article);
        } else if (article.getBike() instanceof Mountainbike) {
            price = calculateMountainbikePrice(article);
        }
        return price;
    }

    /**
     * Calculates price for Brompton bikes (additional bikes at half price).
     */
    private double calculateBromptonPrice(Article article) {
        double price = article.getBike().getPrice() * article.getPurchaseAmount();
        if (article.getPurchaseAmount() > 1) {
            price += (article.getPurchaseAmount() - 1) * article.getBike().getPrice() / 2;
        }
        return price;
    }

    /**
     * Calculates price for EBikes (standard pricing).
     */
    private double calculateEBikePrice(Article article) {
        return article.getBike().getPrice() * article.getPurchaseAmount();
    }

    /**
     * Calculates price for Mountainbikes (bulk discount for 3+).
     */
    private double calculateMountainbikePrice(Article article) {
        if (article.getPurchaseAmount() > 2) {
            return article.getPurchaseAmount() * article.getBike().getPrice() * 9 / 10;
        } else {
            return article.getBike().getPrice() * article.getPurchaseAmount();
        }
    }

    /**
     * Applies 20% discount for purchases >= 1000 euros.
     */
    private double applyHighValueDiscount(double price) {
        if (price >= 1000.0) {
            return price * 0.8;
        }
        return price;
    }

    /**
     * Formats a single article line for the bill.
     */
    private String formatArticleLine(Article article, double price) {
        return "\t"
            + article.getBike().getProductName()
            + "\tx\t"
            + article.getPurchaseAmount()
            + "\t=\t"
            + String.valueOf(price)
            + "\n";
    }
}
