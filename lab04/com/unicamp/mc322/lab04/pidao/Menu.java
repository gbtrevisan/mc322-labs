package com.unicamp.mc322.lab04.pidao;

public class Menu {

    public final int MENU_MAX_SIZE = 100;

    private final Meal[] menu;
    private int numberOfOptions;

    Menu() {
        menu = new Meal[MENU_MAX_SIZE];
        numberOfOptions = 0;
    }

    private boolean checkOptionExists(Meal meal) throws Exception {
        if (meal == null)
            throw new Exception("Meal can`t be null!");
        for (int i = 0; i < numberOfOptions; i++) {
            if (menu[i].equals(meal))
                return true;
        }
        return false;
    }

    private Meal searchMeal(String identifier) {
        for (int i = 0; i < numberOfOptions; i++)
            if (menu[i].getIdentifier().equals(identifier))
                return menu[i];
        return null;
    }

    private void checkMenuIsFull() throws Exception {
        if (numberOfOptions == MENU_MAX_SIZE)
            throw new Exception("Menu is full!");
    }

    boolean isOnMenu(Meal meal) {
        for (int i = 0; i < numberOfOptions; i++) {
            if (menu[i].equals(meal))
                return true;
        }
        return false;
    }

    void addOption(Meal meal) throws Exception {
        if (meal == null)
            throw new Exception("Meal cant be null!");
        checkMenuIsFull();
        if (!checkOptionExists(meal)) {
            menu[numberOfOptions] = meal;
            numberOfOptions++;
        }
    }

    void removeOption(String identifier) {
        boolean removed = false;
        for (int i = 0; i < numberOfOptions && !removed; i++) {
            if (menu[i].getIdentifier().equals(identifier)) {
                if (numberOfOptions - 1 - i >= 0)
                    System.arraycopy(menu, i + 1, menu, i, numberOfOptions - 1 - i);
                numberOfOptions--;
                removed = true;
            }
        }
    }

    void applyDiscount(Discount discount, String identifier) {
        Meal meal = searchMeal(identifier);
        if (meal != null)
            discount.applyDiscountOnMeal(meal);
    }

    void cancelDiscount(String identifier) {
        Meal meal = searchMeal(identifier);
        if (meal != null)
            meal.cancelDiscount();
    }

    public String toString() {
        StringBuilder formattedString = new StringBuilder();
        for (int i = 0; i < numberOfOptions; i++)
            formattedString.append(menu[i].toString()).append("\n");
        return formattedString.toString();
    }

}
