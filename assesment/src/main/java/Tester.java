

import task.*;
import objects.*;

import java.util.ArrayList;

public class Tester {

    public static void main(String[] args)
    {
        DataRetriever.retrieve_data_test();
        Categorizer.categoriesTest();

        CartsFinder.cartFindertTest();
        CartsFinder.cartFindertTest_ExampleActuallyWorks();
        CartsFinder.cartFindertTest_InvalidProductId();
        CartsFinder.cartFindertTest_InvalidUserId();

        FurthestUsersFinder.furthestUsersTest();

    }
}
