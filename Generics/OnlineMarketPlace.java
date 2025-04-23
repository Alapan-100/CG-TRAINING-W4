import java.util.*;
interface Category {
    String getCategoryName();
}
class BookCategory implements Category {
    public String getCategoryName() {
        return "Books";
    }
}
class ClothingCategory implements Category {
    public String getCategoryName() {
        return "Clothing";
    }
}
class GadgetCategory implements Category {
    public String getCategoryName() {
        return "Gadgets";
    }
}
class Product<T extends Category> {
    private String name;
    private double price;
    private T category;
    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public T getCategory() {
        return category;
    }
    public void setPrice(double newPrice) {
        this.price = newPrice;
    }
    public void showDetails() {
        System.out.println("Product: " + name + ", Price: $" + price + ", Category: " + category.getCategoryName());
    }
}
class DiscountUtil {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double original = product.getPrice();
        double discounted = original - (original * percentage / 100);
        product.setPrice(discounted);
        System.out.println("Applied " + percentage + "% discount to " + product.getName());
    }
}

// Main class
public class OnlineMarketPlace {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Programming", 500.0, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 300.0, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone", 15000.0, new GadgetCategory());
        List<Product<? extends Category>> catalog = new ArrayList<>();
        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);
        System.out.println("=== Product Catalog ===");
        for (Product<? extends Category> p : catalog) {
            p.showDetails();
        }
        System.out.println("\n=== Applying Discounts ===");
        DiscountUtil.applyDiscount(book, 10);
        DiscountUtil.applyDiscount(shirt, 20);
        DiscountUtil.applyDiscount(phone, 5);
        System.out.println("\n=== Updated Catalog ===");
        for (Product<? extends Category> p : catalog) {
            p.showDetails();
        }
    }
}
