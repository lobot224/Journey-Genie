package org.example;

import java.util.Scanner;

public class TravelItinerary {
    private String country;
    private String city;
    private double budget;
    private String activity;
    private String currency;

    public TravelItinerary(String country, String city, double budget) {
        this.country = country;
        this.city = city;
        this.budget = budget;
    }

    public TravelItinerary(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public double getBudget() {
        return budget;
    }

    public void addBudget(double amount, String currency) {
        if (isValidBudget(amount) && isValidCurrency(currency)) {
            System.out.println("Please confirm added budget (yes or no)\nAdded budget: " + amount);
            Scanner scan = new Scanner(System.in);
            String confirm = scan.nextLine();
            if (confirm.equals("yes")) {
                this.budget = amount;
                this.currency = currency;
                System.out.println("Budget added");
            } else {
                this.budget = 0;
                this.currency = "";
                System.out.println("Budget not added");
            }
        } else if (!isValidCurrency(currency)) {
            this.budget = 0;
            this.currency = "";
            System.out.println("Invalid currency");
        } else {
            this.budget = 0;
            this.currency = "";
            System.out.println("Invalid budget or currency");
        }
    }

    public void editBudget(double amount) {
        if (isValidBudget(amount)) {
            System.out.println("Please confirm new budget (yes or no)\nNew budget: " + amount);
            Scanner scan = new Scanner(System.in);
            String confirm = scan.nextLine();
            if (confirm.equals("yes")) {
                this.budget = amount;
                System.out.println("Budget updated");
            } else {
                System.out.println("Budget not updated");
            }
        } else {System.out.println("Invalid budget");}
    }

    public String getCurrency() {
        return currency;
    }

    public boolean isValidCurrency(String currency) {
        return currency.equals("USD");
    }


    public boolean isValidCountry() {
        return country.equals("USA");
    }

    public boolean isValidCity() {
        return city.equals("Dallas");
    }

    public boolean isValidBudget(double budget) {
        return budget > 0;
    }

    public String getDallasActivityList() {
        return "1. Visit the Dallas Museum of art. Cost: $0\n" + "2. Visit Six Flags. Cost: $50\n" + "3. Visit the Dallas World Aquarium. Cost: $30\n" + "4. Visit the Dallas Farmer's Market. Cost: $0";
    }

    public void selectDallasActivity(int activityNum) {
        boolean validActivity = false;
        while (!validActivity) {
            if (activityNum == 1) {
                budget -= 0;
                activity = "Dallas Museum of Art";
                validActivity = true;
            } else if (activityNum == 2) {
                budget -= 50;
                activity = "Six Flags";
                validActivity = true;
            } else if (activityNum == 3) {
                budget -= 30;
                activity = "Dallas World Aquarium";
                validActivity = true;
            } else if (activityNum == 4) {
                budget -= 0;
                activity = "Farmer's Market";
                validActivity = true;
            } else {
                activity = "Invalid activity";
                validActivity = true;
            }
        }
    }

    public String getActivity() {
        return activity;
    }
    public String toString() {
        return "Country: " + country + "\nCity: " + city + "\nBudget: " + budget + "\nCurrency: " + currency + "\nActivity: " + activity;
    }


}