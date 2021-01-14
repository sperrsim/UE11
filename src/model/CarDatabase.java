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
        MagicGenerator mg = new MagicGenerator();
        for (int c = 0; c < 1000; c++)
        {
            Vehicle vehicle = new Vehicle();
            vehicle.setColor(mg.getRandomColor());
            vehicle.setLicensePlate(mg.getRandomLicencePlate());
            vehicle.setManufacturer(mg.getRandomManufacturer());
            vehicle.setModel(mg.getRandomModel(vehicle.getManufacturer()));
            vehicle.setOwner(mg.getRandomName());
            db.put(vehicle.getLicensePlate(), vehicle);
            System.out.println("Created vehicle " + vehicle.getLicensePlate() + ".");
        }
    }
    public Vehicle[] search(String licencePlate, boolean exact) {
        long starttime = System.nanoTime();
        Vehicle[] found;
        if (exact) {
            found = new Vehicle[1];
            if (db.containsKey(licencePlate)) {
                found[0] = db.get(licencePlate);
            }
        } else {
            Iterator<String> it = db.keySet().iterator();
            ArrayList<Vehicle> notexact = new ArrayList();
            while (it.hasNext()) {
                String searched = it.next();
                if (db.get(searched).getLicensePlate().contains(licencePlate))
                    notexact.add(db.get(searched));
            }
            found = new Vehicle[notexact.size()];
            for (int i = 0; i < notexact.size(); i++) {
                found[i] = notexact.get(i);
            }
        }
        long endtime = System.nanoTime();
        long searchtime = endtime - starttime;
        System.out.println("Results found in " + searchtime + " Nanoseconds");
        return found;
    }

}
