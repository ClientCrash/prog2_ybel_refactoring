package refactoring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class BikeShopTest {

    private Mountainbike mountainbike;
    private EBike eBike;
    private Brompton brompton;
    private Bill bill;
    private Date testDate;

    @BeforeEach
    void setUp() {
        testDate = new Date(2024, 5, 15);
        mountainbike = new Mountainbike("Mountain Explorer", 800.0, 45, 11, 3);
        eBike = new EBike("E-Power", 1500.0, 25, 8, 2, 500);
        brompton = new Brompton("Folding Pro", 1200.0, 30, 6, 1);
        bill = new Bill("John Doe", "Johnny", "Main Street", "123", 12345, testDate, "john@example.com", "Sample City");
    }

    @Test
    void testMountainbikeBasics() {
        assertEquals("Mountain Explorer", mountainbike.productName);
        assertEquals(800.0, mountainbike.price);
        assertEquals(45, mountainbike.getMaxSpeed());
        assertEquals(33, mountainbike.getGearsCount());
        assertNull(mountainbike.getBatteryCapacity());
    }

    @Test
    void testEBikeBasics() {
        assertEquals("E-Power", eBike.productName);
        assertEquals(1500.0, eBike.price);
        assertEquals(25, eBike.getMaxSpeed());
        assertEquals(16, eBike.getGearsCount());
        assertEquals(Integer.valueOf(500), eBike.getBatteryCapacity());
    }

    @Test
    void testBromptonBasics() {
        assertEquals("Folding Pro", brompton.productName);
        assertEquals(1200.0, brompton.price);
        assertEquals(30, brompton.getMaxSpeed());
        assertEquals(6, brompton.getGearsCount());
        assertNull(brompton.getBatteryCapacity());
    }

    @Test
    void testArticleCreation() {
        Article article = new Article(mountainbike, 2);
        assertEquals(mountainbike, article.bike);
        assertEquals(2, article.purchaseAmount);
    }

    @Test
    void testBillCreation() {
        assertEquals("John Doe", bill.customerName);
        assertEquals("Johnny", bill.nickname);
        assertEquals("Main Street", bill.street);
        assertEquals("123", bill.streetNumber);
        assertEquals(12345, bill.postalCode);
        assertEquals(testDate, bill.birthday);
        assertEquals("john@example.com", bill.email);
        assertEquals("Sample City", bill.city);
        assertTrue(bill.articles.isEmpty());
    }

    @Test
    void testAddArticleToBill() {
        Article article = new Article(mountainbike, 1);
        assertTrue(bill.addArticle(article));
        assertEquals(1, bill.articles.size());
        assertEquals(article, bill.articles.get(0));
    }

    @Test
    void testMountainbikePricing_SingleItem() {
        Article article = new Article(mountainbike, 1);
        bill.addArticle(article);
        String details = bill.getDetails();
        assertTrue(details.contains("800.0"));
        assertTrue(details.contains("Total price:\t800.0"));
    }

    @Test
    void testMountainbikePricing_TwoItems() {
        Article article = new Article(mountainbike, 2);
        bill.addArticle(article);
        String details = bill.getDetails();
        assertTrue(details.contains("1280.0"));
        assertTrue(details.contains("Total price:\t1280.0"));
    }

    @Test
    void testEBikePricing_SingleItem() {
        Article article = new Article(eBike, 1);
        bill.addArticle(article);
        String details = bill.getDetails();
        assertTrue(details.contains("1200.0"));
        assertTrue(details.contains("Total price:\t1200.0"));
    }

    @Test
    void testEBikePricing_TwoItems() {
        Article article = new Article(eBike, 2);
        bill.addArticle(article);
        String details = bill.getDetails();
        assertTrue(details.contains("2400.0"));
        assertTrue(details.contains("Total price:\t2400.0"));
    }

    @Test
    void testBromptonPricing_SingleItem() {
        Article article = new Article(brompton, 1);
        bill.addArticle(article);
        String details = bill.getDetails();
        assertTrue(details.contains("960.0"));
        assertTrue(details.contains("Total price:\t960.0"));
    }

    @Test
    void testBromptonPricing_TwoItems() {
        Article article = new Article(brompton, 2);
        bill.addArticle(article);
        String details = bill.getDetails();
        assertTrue(details.contains("2400.0"));
        assertTrue(details.contains("Total price:\t2400.0"));
    }

    @Test
    void testBromptonPricing_ThreeItems() {
        Article article = new Article(brompton, 3);
        bill.addArticle(article);
        String details = bill.getDetails();
        assertTrue(details.contains("3840.0"));
        assertTrue(details.contains("Total price:\t3840.0"));
    }

    @Test
    void testMixedArticles() {
        Article mountainArticle = new Article(mountainbike, 1);
        Article ebikeArticle = new Article(eBike, 1);
        bill.addArticle(mountainArticle);
        bill.addArticle(ebikeArticle);
        String details = bill.getDetails();
        assertTrue(details.contains("Total price:\t2000.0"));
    }

    @Test
    void testBillFormat() {
        Article article = new Article(mountainbike, 1);
        bill.addArticle(article);
        String details = bill.getDetails();
        assertTrue(details.contains("Details for \"John Doe\""));
        assertTrue(details.contains("Main Street 123"));
        assertTrue(details.contains("12345 Sample City"));
        assertTrue(details.contains("Geburtstag: " + testDate));
        assertTrue(details.contains("Email: john@example.com"));
        assertTrue(details.contains("refactoring.Article:"));
        assertTrue(details.contains("Mountain Explorer"));
        assertTrue(details.contains("Total price:"));
    }

    @Test
    void testEmptyBill() {
        String details = bill.getDetails();
        assertTrue(details.contains("Total price:\t0.0"));
    }

    @Test
    void testExactlyThousandEuros() {
        Mountainbike expensiveBike = new Mountainbike("Expensive", 1000.0, 50, 10, 3);
        Article article = new Article(expensiveBike, 1);
        bill.addArticle(article);
        String details = bill.getDetails();
        assertTrue(details.contains("800.0"));
        assertTrue(details.contains("Total price:\t800.0"));
    }
}
