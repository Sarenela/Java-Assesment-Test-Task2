package objects;
/*
because the cart link does not work, i assume that a cart instance has: int- userID and int[]- productIDs
example:
{ "userId": 7, "products:": [1,2,4,5,3,2,2,1,1] }
 */
import objects.Product;
import task.DataRetriever;

import java.io.IOException;
import java.util.HashMap;

public class Cart {
    private int userID;
    private int[] productIDs;

    public Cart(){}

    public Cart(int userID, int[] productIDs) {
        this.userID = userID;
        this.productIDs = productIDs;
    }

    public double getTotalValue(HashMap<Integer,Product> products) throws NullPointerException{
        double value=0;

        for( int id : productIDs) {
            if(!products.containsKey(id)) throw new NullPointerException("error! the product does not exist!");
            value +=products.get(id).getPrice();
        }
        return value;


    }


    public int getUserID() {
        return userID;
    }

    public int[] getProductIDs() {
        return productIDs;
    }
}
