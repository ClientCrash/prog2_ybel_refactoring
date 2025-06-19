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
        double total = 0;

        String result = "Details for \"" + customerName + "\"\n";
        result += street + " " + streetNumber + "\n";
        result += postalCode + " " + city + "\n";
        result += "Geburtstag: " + birthday + "\n";
        result += "Email: " + email + "\n\n";
        result += "refactoring.Article: \n";
        for (Article article : articles) {
            double price = 0;
            if (article.getBike() instanceof Brompton) {
                if (article.getPurchaseAmount() > 1) {
                    price += (article.getPurchaseAmount() - 1) * article.getBike().getPrice() / 2;
                }
                price += article.getBike().getPrice() * article.getPurchaseAmount();
            } else if (article.getBike() instanceof EBike) {
                price += article.getBike().getPrice() * article.getPurchaseAmount();
            } else if (article.getBike() instanceof Mountainbike) {
                if (article.getPurchaseAmount() > 2) {
                    price += article.getPurchaseAmount() * article.getBike().getPrice() * 9 / 10;
                } else {
                    price += article.getBike().getPrice() * article.getPurchaseAmount();
                }
            }
            if (price > 1000f || price == 1000.0) {
                price = price * 0.8;
            }

            result +=
                "\t"
                    + article.getBike().getProductName()
                    + "\tx\t"
                    + article.getPurchaseAmount()
                    + "\t=\t"
                    + String.valueOf(price)
                    + "\n";
            total += price;
        }

        result += "\nTotal price:\t" + String.valueOf(total) + "\n";

        return result;
    }
}
