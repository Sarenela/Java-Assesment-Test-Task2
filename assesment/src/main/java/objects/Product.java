package objects;

public class Product {
    private int id;
    private String title;
    private double price;
    private String image;
    private String description;
    private String category;
    private Rating rating;
    public Product() {}

    public Product(int id, String title,String image, double price, String description, String category, Rating rating) {
        this.title = title;
        this.image = image;
        this.price = price;
        this.description = description;
        this.category = category;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public Rating getRating() {
        return rating;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", rating=" + rating +
                '}';
    }
}
class Rating
{
    private double rate;
    private int count;

    public Rating(){}

    public Rating(double rate, int count) {
        this.rate = rate;
        this.count = count;
    }

    public double getRate() {
        return rate;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "rate=" + rate +
                ", count=" + count +
                '}';
    }
}
