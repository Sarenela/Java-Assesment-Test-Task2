package task;
import objects.*;
import task.DataRetriever;

import java.util.ArrayList;
import java.util.HashMap;

public class FurthestUsersFinder {

    public static void findUsersFurthestAwayFromEachother()
    {
        double maxDist=0;
        String us1Name="";
        String us2Name="";
        try{
            ArrayList<User> users = DataRetriever.createUserList();

            for(User us1 : users){
                for (User us2 : users )
                {
                    if(us1!=us2){
                        double currentDist = us1.distanceKm(us2);
                        if(currentDist>maxDist){
                            maxDist=currentDist;
                            us1Name=us1.getNameString();
                            us2Name=us2.getNameString();
                        }
                    }

                }
            }
            System.out.println(us1Name+" and "+us2Name+" : distance = "+String.format("%.2f",maxDist)+"km");
        }
        catch (Exception e) {
            System.out.println("could not find the furthest users: "+e);

        }

    }

    public static void furthestUsersTest()
    {
        System.out.println("users that live the furthest apart from each other:");
        findUsersFurthestAwayFromEachother();
        System.out.println();
    }
}
