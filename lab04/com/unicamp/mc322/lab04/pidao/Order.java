package com.unicamp.mc322.lab04.pidao;

public class Order {

    public final int ORDER_MAX_SIZE = 100;

    private final User user;
    private Meal[] meals;
    private int numberOfMeals;
    private Status status;
    private double finalPrice;

    public Order(User user) throws Exception {
        if (user == null) throw new Exception("User can`t be null");

        this.user = user;
        meals = new Meal[ORDER_MAX_SIZE];
        numberOfMeals = 0;
        status = Status.NEW;
        finalPrice = 0;
    }

    private Order(User user, Meal[] meals, int numberOfMeals, Status status) throws Exception {
        this(user);
        this.meals = meals;
        this.numberOfMeals = numberOfMeals;
        this.status = status;
    }

    private double calculatePrice() {
        double price = 0;
        int numberOfOrders = user.getNumberOfOrders();
        for (int i = 0; i < numberOfMeals; i++)
            price = price + meals[i].calculatePriceWithDiscount();
        if (numberOfOrders == 0)
            price = price * (1 - Discount.USER_FIRST_ORDER_DISCOUNT);
        if (numberOfOrders % 10 == 0 && numberOfOrders > 0)
            if (price - Discount.EVERY_TEN_ORDERS_DISCOUNT > 0)
                price = price - Discount.EVERY_TEN_ORDERS_DISCOUNT;
            else
                price = 0;
        if (price > 100)
            price = price * (1 - Discount.USER_ORDER_OVERLOAD_100_DISCOUNT);
        return price;
    }

    private void checkOrderIsFull() throws Exception {
        if (numberOfMeals == ORDER_MAX_SIZE)
            throw new Exception("Order is full!");
    }

    boolean checkCanCancel() {
        return status == Status.NEW || status == Status.PREPARING;
    }

    boolean isNew() {return status == Status.NEW;}

    public void addMeal(Meal meal) throws Exception {
        checkOrderIsFull();
        if (meal == null) throw new Exception("Not a valid meal!");
        meals[numberOfMeals] = meal;
        numberOfMeals++;
    }

    public void removeMeal(String identifier) {
        boolean removed = false;
        for (int i = 0; i < numberOfMeals && !removed; i++) {
            if (meals[i].getIdentifier().equals(identifier)) {
                if (numberOfMeals - 1 - i >= 0)
                    System.arraycopy(meals, i + 1, meals, i, numberOfMeals - 1 - i);
                numberOfMeals--;
                removed = true;
            }
        }
    }

     void updateStatus() {
        Status[] statusValues = Status.values();
        if (status != Status.DELIVERED)
            status = statusValues[(status.ordinal() + 1)];
        if (status == Status.DELIVERED)
            user.makeOrder();
        if (status == Status.PREPARING)
            finalPrice = calculatePrice();
    }

    boolean checkOrderIsOnMenu(Menu menu) {
        for (int i = 0; i < numberOfMeals; i++)
            if (!menu.isOnMenu(meals[i]))
                return false;
        return true;
    }

    public String toString() {
        StringBuilder formattedString = new StringBuilder("User: " + user + "\n");
        for (int i = 0; i < numberOfMeals; i++)
            formattedString.append("- ").append(meals[i].getIdentifier()).append("\n");
        switch (status) {
            case NEW:
                formattedString.append("Status: ").append("NEW\n");
                break;
            case PREPARING:
                formattedString.append("Status: ").append("PREPARING\n");
                break;
            case ON_THE_WAY:
                formattedString.append("Status: ").append("ON THE WAY\n");
                break;
            case DELIVERED:
                formattedString.append("Status: ").append("DELIVERED\n");
                break;
        }
        if (status != Status.NEW)
            formattedString.append("Price: ").append(finalPrice).append("\n");
        return formattedString.toString();
    }

    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (!getClass().equals(other.getClass()))
            return false;
        return this == other;
    }

    public Order copy() throws Exception {
        Meal[] mealsCopy = new Meal[ORDER_MAX_SIZE];
        for (int i = 0; i < numberOfMeals; i++)
            mealsCopy[i] = meals[i].copy();
        return new Order(user, mealsCopy, numberOfMeals, status);
    }

    User getUser() {
        return user;
    }

}
