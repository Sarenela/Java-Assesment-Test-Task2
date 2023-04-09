package task;
import objects.*;
import java.io.*;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import objects.Product;
import org.json.JSONArray;
import org.json.JSONException;


public class DataRetriever {
    private static final String USER_URL = "https://fakestoreapi.com/users";
    private static final String CART_URL = "https://fakestoreapi.com/carts";
    private static final String PRODUCT_URL = "https://fakestoreapi.com/products";

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONArray jsonArray = new JSONArray(jsonText);
            return jsonArray;
        }
        finally {
            is.close();
        }
    }

    private static <T> ArrayList<T> createDataArrayList(Class<T> c,JSONArray jData) throws IOException {
        try {
            ObjectMapper objMap= new ObjectMapper();
            ArrayList<T> data = new ArrayList<T>();
            for ( int i=0;i< jData.length();i++) {
                data.add(objMap.readValue(jData.getJSONObject(i).toString(),c));
            }
            return data;
        }
        catch(IOException e) {
            throw new IOException("error! could not load "+c.getName()+" data");
        }
    }

    private static <T> HashMap<Integer,T> createDataHashMap(Class<T> c,JSONArray jData) throws IOException {
        try {
            ObjectMapper objMap= new ObjectMapper();
            HashMap<Integer,T> data = new HashMap<>();
            for ( int i=0;i< jData.length();i++) {
                data.put(jData.getJSONObject(i).getInt("id"),objMap.readValue(jData.getJSONObject(i).toString(),c));
            }
            return data;
        }
        catch(IOException e) {
            throw new IOException("error! could not load "+c.getName()+" data");
        }
    }


    public static JSONArray retrieveUsers() throws IOException, JSONException{
        return readJsonFromUrl(USER_URL);
    }

    public static JSONArray retrieveProducts() throws IOException{
        return readJsonFromUrl(PRODUCT_URL);
    }

    public static JSONArray retrieveCarts() throws IOException{
        return readJsonFromUrl(CART_URL);
    }

    public static HashMap<Integer,Product> createProductMap()throws IOException {
       return createDataHashMap(Product.class,retrieveProducts());
    }

    public static HashMap<Integer,User> createUserMap()throws IOException {
        return createDataHashMap(User.class,retrieveUsers());
    }

    public static ArrayList<Cart>  createCartList() throws IOException {
        return createDataArrayList(Cart.class,retrieveCarts());
    }

    public static ArrayList<Product>  createProductList() throws IOException {
        return createDataArrayList(Product.class,retrieveProducts());
    }
    public static ArrayList<User>  createUserList() throws IOException {
        return createDataArrayList(User.class,retrieveUsers());
    }

    public static void printJsonArray(JSONArray jArray) {
        for (int i=0;i< jArray.length();i++) {
            System.out.println(jArray.getJSONObject(i));
        }
        System.out.println();
    }


    public static void retrieve_data_test() {
        try {
            System.out.println("retrieving users: ");
            printJsonArray(retrieveUsers());
        }
        catch (IOException e ) {
            System.out.println("could not load data:  "+e);
        }

        try {
            System.out.println("retrieving products: ");
            printJsonArray(retrieveProducts());
        }
        catch (IOException e ) {
            System.out.println("could not load data:  "+e);
        }

        try {
            System.out.println("retrieving carts: ");
            printJsonArray(retrieveCarts());
        }
        catch (IOException e ) {
            System.out.println("could not load data:  "+e);
        }
        System.out.println();
        System.out.println();


    }
}
