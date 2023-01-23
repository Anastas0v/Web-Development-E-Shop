package mk.ukim.finki.wpaud.bootstrap;

import mk.ukim.finki.wpaud.model.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder
{
    public static List<Category> categoryList = new ArrayList<>();
    public static List<User> userList = new ArrayList<>();
    public static List<Manufacturer> manufacturerList = new ArrayList<>();
    public static List<Product> productList = new ArrayList<>();
    public static List<ShoppingCart> shoppingCarts = new ArrayList<>();

//    @PostConstruct
//    public void init()
//    {
//        categoryList.add(new Category("Software", "Best"));
//        categoryList.add(new Category("Books", "No"));
//
//        userList.add(new User("anastasov", "davidpass","David","Anastasov"));
//        userList.add(new User("user", "test123","Test","Person"));
//
//        Manufacturer manufacturer = new Manufacturer("Adidas", "NY");
//        manufacturerList.add(manufacturer);
//
//        Category category = new Category("Sport", "Category");
//        categoryList.add(category);
//        productList.add(new Product("Ball", 45.2, 4, category, manufacturer));
//        productList.add(new Product("Runner", 45.4, 4, category, manufacturer));
//        productList.add(new Product("Lifestyle", 45.5, 4, category, manufacturer));
//    }
}
