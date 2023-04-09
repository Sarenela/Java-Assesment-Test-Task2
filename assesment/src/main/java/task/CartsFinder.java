package task;
/*
because the cart link does not work,  i assume that a cart is a dict with "userID", and "products"=list of productIDs
example:{
"userId": 7,
"products:": (1,2,4,5,3,2,2,1,1)}
 */
import objects.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CartsFinder {

    //This method should not have any arguments. I allow passing an arrayList of carts only for testing purposes, normally I wouldn't do that and just use DataRetriever.createCartList();.
    public static String findHighestCartValueAndItsUser(ArrayList<Cart> carts) throws Exception {
        double maxValue =0;
        String maxUser="";
        try {
            HashMap<Integer,User> users = DataRetriever.createUserMap();
            HashMap<Integer,Product>products = DataRetriever.createProductMap();
            if(carts == null)
                carts = DataRetriever.createCartList();

            for (Cart cart : carts) {
                if(!users.containsKey(cart.getUserID())) throw new NullPointerException("error: the user does not exist! ");
                double currentVal = cart.getTotalValue(products);
                if (currentVal > maxValue) {
                    maxValue = currentVal;
                    maxUser = users.get(cart.getUserID()).getIdentity();
                }
            }
            return "cart's value: "+maxValue+"   cart's user: "+maxUser;
        }
        catch(NullPointerException | IOException e) {
            throw new Exception("could not find a cart with the highest value: "+e);
        }


    }

    public static void cartFindertTest()
    {
        System.out.println("Cart with the highest value and its user:");
        try {
            System.out.println(findHighestCartValueAndItsUser(null));
        }
        catch (Exception e){
            System.out.println(e);
        }

        System.out.println();
    }

    public static void cartFindertTest_ExampleActuallyWorks()
    {
        System.out.println("Cart with the highest value and its user:  - example that actually works");

        ArrayList<Cart> example= new ArrayList<>();
        //creating an example
        int[] prodIds ={1,2,1,1,2,4};
        example.add(new Cart(1,prodIds));
        int[] prodIds2 ={1,3};
        example.add((new Cart(3,prodIds2)));

        try {
            System.out.println(findHighestCartValueAndItsUser(example));
        }
        catch (Exception e){
            System.out.println(e);
        }

        System.out.println();
    }

    public static void cartFindertTest_InvalidProductId()
    {
        System.out.println("Cart with the highest value and its user:    -example when invalid product ID");

        ArrayList<Cart> example= new ArrayList<>();
        //creating an example
        int[] prodIds ={1,2,1,1,100,4};
        example.add(new Cart(1,prodIds));
        int[] prodIds2 ={1,3};
        example.add((new Cart(3,prodIds2)));

        try {
            System.out.println(findHighestCartValueAndItsUser(example));
        }
        catch (Exception e){
            System.out.println(e);
        }

        System.out.println();
    }

    public static void cartFindertTest_InvalidUserId()
    {
        System.out.println("Cart with the highest value and its user:    -example when invalid user ID");

        ArrayList<Cart> example= new ArrayList<>();
        //creating an example
        int[] prodIds ={1,2,1,1,3,4};
        example.add(new Cart(100,prodIds));
        int[] prodIds2 ={1,3};
        example.add((new Cart(3,prodIds2)));

        try {
            System.out.println(findHighestCartValueAndItsUser(example));
        }
        catch (Exception e){
            System.out.println(e);
        }

        System.out.println();
    }






}
