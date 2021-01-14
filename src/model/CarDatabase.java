package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Simon Sperr
 * @version 2020.3, 14.01.2021
 **/
public class CarDatabase {
    protected HashMap<String, Vehicle> db = new HashMap<>();

    public CarDatabase()
    {
        for (int c = 0; c < 1000; c++)
        {
            Vehicle vh = new Vehicle();
            db.put(vh.getLicensePlate(), vh);
            System.out.println("Created vehicle " + vh.getLicensePlate() + ".");
        }
    }
    public ArrayList<Vehicle> search(String licencePlate, boolean exact) {
        long starttime = System.nanoTime();
        ArrayList<Vehicle> found = new ArrayList<>();
        if (exact)
        {
            found.add(db.get(licencePlate));
        }
        else
        {
            Iterator<String> it = db.keySet().iterator();
            while (it.hasNext())
            {
                String searched = it.next();
                if (db.get(searched).getLicensePlate().contains(licencePlate))
                    found.add(db.get(searched));
            }
        }
        long endtime = System.nanoTime();
        long searchtime = endtime - starttime;
        System.out.println("Results found in " + searchtime + " Nanoseconds");
        return found;
    }

}
