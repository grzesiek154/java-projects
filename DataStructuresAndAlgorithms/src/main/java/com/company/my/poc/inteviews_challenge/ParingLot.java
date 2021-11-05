package com.company.my.poc.inteviews_challenge;

/*
Goals:
- Your solution should be in Java - if you would like to use another language, please let the interviewer know.
- Boilerplate is provided. Feel free to change the code as you see fit

Assumptions:
- The parking lot can hold motorcycles, cars and vans
- The parking lot has motorcycle spots, car spots and large spots
- A motorcycle can park in any spot
- A car can park in a single compact spot, or a regular spot
- A van can park, but it will take up 3 regular spots
- These are just a few assumptions. Feel free to ask your interviewer about more assumptions as needed

Here are a few methods that you should be able to run:
- Tell us how many spots are remaining
- Tell us how many total spots are in the parking lot
- Tell us when the parking lot is full
- Tell us when the parking lot is empty
- Tell us when certain spots are full e.g. when all motorcycle spots are taken
- Tell us how many spots vans are taking up
* */

import java.util.ArrayList;
import java.util.HashMap;

public class ParingLot {
    //classes:
    //vehicle, parking lot
    //questions:
    //how to save space for a car?
    //how many spots are in total?
    // types of spots: regular, compact spot?

    public static void main(String[] args) {
        Vehicle car1 = new Vehicle(1, "Car");
        Vehicle van1 = new Vehicle(3, "Van");
        Vehicle  motorcycle1 = new Vehicle(1, "motorcycle");
        HashMap test = new HashMap();
    }



    static class Vehicle {
        private int spotsNeeded;
        private String type;

        public Vehicle (int spotsNeeded, String type) {
            this.spotsNeeded = spotsNeeded;
            this.type = type;
        }

        public int getSpotsNeeded() {
            return spotsNeeded;
        }

        public String getType() {
            return type;
        }
    }

    static class Parking {
        int numberOfSpotsTotal;
        int numberOfRemainingSpots;
        ArrayList<Vehicle> vehicles;
        // how to connect spots with vehicles?


        public Parking(int numberOfSpotsTotal, ArrayList<Vehicle> vehicles) {
            this.numberOfSpotsTotal = numberOfSpotsTotal;
            this.vehicles = vehicles;
            this.numberOfRemainingSpots = numberOfSpotsTotal;
        }

        public void parkVehicle(Vehicle vehicle) {
            if(numberOfRemainingSpots > 0) {
              switch (vehicle.getType().toLowerCase()) {
                  case "car":
                      numberOfRemainingSpots = numberOfRemainingSpots - 1;
                      break;
              }
            } else {
                System.out.println("There are no spaces in parking lot");
            }

        }
    }
}
