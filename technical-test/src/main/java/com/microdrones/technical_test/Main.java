package com.microdrones.technical_test;

import com.google.gson.Gson;
import com.microdrones.technical_test.config.Config;
import com.microdrones.technical_test.drone.Drone;
import com.microdrones.technical_test.mission.Mission;
import com.microdrones.technical_test.mission.Point;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;


/* assuming distance travelled between coordinates is in kilometers */

public class Main {

    private static final String DATA_DIRECTORY_PATH_PREFIX = "/Users/gurpreetsingh/Desktop/challenge-skeleton-code/technical-test/src/main/java/com/microdrones/technical_test/data";
    static Gson gson = new Gson();
    static Drone drone = null;
    static Config configuration = null;
    static ArrayList<Drone> arrayList = new ArrayList<>();
    static ArrayList<Config> configList = new ArrayList<>();

    public static void main(String[] args) {

        File path = new File(DATA_DIRECTORY_PATH_PREFIX);
        File[] files = path.listFiles();

        for (int i = 0; i <=files.length; i++) {
            if (files[i].isDirectory()) {

                if (files[i].getName().equals("drones")) {

                    File[] droneinnerfiles = files[i].listFiles();
                    for (int z = 0; z < droneinnerfiles.length; z++) {
                        try {
                            drone = gson.fromJson(new FileReader(droneinnerfiles[z]), Drone.class);
                            arrayList.add(drone);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }

                } else if (files[i].getName().equals("configurations")) {
                    File[] configinnerfiles = files[i].listFiles();

                    for (int j = 0; j < configinnerfiles.length; j++) {
                        try {
                            configuration = gson.fromJson(new FileReader(configinnerfiles[j]),
                                    Config.class);
                            configList.add(configuration);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }

                } else if (files[i].getName().equals("missions")) {

                    File[] innerfiles = files[i].listFiles();

                    for (int k = 0; k < innerfiles.length; k++) {

                        double currentload = arrayList.get(k).getCurrentLoadInFlight().getTranslation();
                        double totalEnergy = configList.get(k).getEnergy().getCapacity();

                        double time = missionDistanceCalculation(innerfiles[k], currentload, totalEnergy);
                        System.out.println("Time taken in seconds " + " " + time);
                        System.out.println(" ");
                    }
                }
            }
        }
    }

    // mission distance calculation
    static double missionDistanceCalculation(File file, double currentload, double totalEnergy) {

        Mission mission = null;
        double distance = 0.0;
        try {
            mission = gson.fromJson(new FileReader(file), Mission.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (mission != null) {
            System.out.print(mission.getName() + " ");

            for (int i = 1; i < mission.getPoints().size(); i++) {

                Point pointStart = mission.getPoints().get(i - 1);
                Point pointEnd = mission.getPoints().get(i);
                // calculating distance between coordinates
                distance += haversineCalcution(pointStart.getLatitude(), pointStart.getLongitude(), pointEnd.getLatitude(), pointEnd.getLongitude());
            }
        }

        // getting the speed from mission file
        double speed = mission.getHorizontalSpeed();
        // calculating time based on speed from mission file and distance calculated assuming distance is in KMS
        double time = distance / mission.getHorizontalSpeed() * 1000;
        // energy needed for flight distance
        double energy = time * currentload * speed * speed;
        if (energy > totalEnergy) {
            System.out.print(false);
        } else {
            System.out.print(true);
        }
        System.out.println(" ");
        System.out.println("assuming Distance travelled in Kms " + " " + distance);

        return time;
    }

    // HAVERSINE CALCULATION
    static double haversineCalcution(double startLat, double startLong,
                                     double endLat, double endLong) {

        final int EARTH_RADIUS = 6371;

        double dLat = Math.toRadians((endLat - startLat));
        double dLong = Math.toRadians((endLong - startLong));

        startLat = Math.toRadians(startLat);
        endLat = Math.toRadians(endLat);

        double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversin(dLong);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double d = EARTH_RADIUS * c;

        return d;
    }

    // USED IN HAVERSINCALCULATION METHOD
    public static double haversin(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }

}


