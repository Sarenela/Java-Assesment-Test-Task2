package task;

import objects.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Categorizer {
    public static HashMap<String, Double> categorizeProducts() throws Exception
    {
        try{
            HashMap<String,Double> categories = new HashMap<>();
            ArrayList<Product>products = DataRetriever.createProductList();
            for(Product product : products) {
                categories.put(product.getCategory(),categories.getOrDefault(product.getCategory(),0.0) + product.getPrice());
            }
            return categories;
        }
        catch (IOException | NullPointerException e)
        {
            throw new Exception("error! Could not categorize products: "+e);
        }

    }

    public static void categoriesTest() {
        System.out.println("All available categories and the value of all products in them:");
        try {
            System.out.println(categorizeProducts());
        }
        catch (Exception e){
            System.out.println("error!: "+e);
        }
        System.out.println();
    }
}
