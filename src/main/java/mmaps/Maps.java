package mmaps;

import deliverX.Driver;

import java.util.Arrays;

public class Maps {

    private String [] map ;

    public Maps(int distance) {
        map = new String[distance+1];
    }

    public void printInfo(Driver driver){
        Arrays.fill(map, ".");
        System.out.println();
        System.out.print("SencINC - > ");

        map[driver.getDistance()] = driver.getCargo().getBox();

        for (String t : map){
            System.out.print(t);
        }
        System.out.print("<----RecipientINC");
        System.out.println();
    }
}
