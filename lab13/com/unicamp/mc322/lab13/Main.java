package com.unicamp.mc322.lab13;

import com.unicamp.mc322.lab13.manager.*;
import com.unicamp.mc322.lab13.manager.order.OnlineOrder;
import com.unicamp.mc322.lab13.manager.order.Person;
import com.unicamp.mc322.lab13.manager.strategy.NameSizeStrategy;

import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) {
        ICrazyDS crazyDS = new InsaneDS(new NameSizeStrategy());

        IOrder order1 = new OnlineOrder(new Person("SmallName", "CPF1", LocalDate.of(1985, Month.JANUARY, 1)), "ID1");
        IOrder order2 = new OnlineOrder(new Person("MediumName", "CPF2", LocalDate.of(1986, Month.JANUARY, 2)), "ID2");
        IOrder order3 = new OnlineOrder(new Person("BiggestName", "CPF3", LocalDate.of(1987, Month.JANUARY, 3)), "ID3");

        crazyDS.add(order1);
        crazyDS.add(order2);
        crazyDS.add(order3);

        System.out.println("---- A: Elements ---");
        crazyDS.print();

        System.out.println("---- B: Getting and removing the element with highest priority ----");
        IOrder p1;

        try {
            p1 = crazyDS.peek();
            System.out.println("-selected element");
            p1.printOwner();
            crazyDS.remove(p1);
            System.out.println("-elements");
            crazyDS.print();

        } catch (EmptyCrazyDSException e) {
            e.printStackTrace();
        }

        System.out.println("---- C: Adding a person with a long name ----");
        IOrder order4 = new OnlineOrder(new Person("PersonWithReallyBigName", "CPF4", LocalDate.of(1985, Month.JANUARY, 1)), "ID4");
        crazyDS.add(order4);
        crazyDS.print();
        System.out.println("-selected element");

        try {
            IOrder p2 = crazyDS.peek();
            p2.printOwner();
        } catch (EmptyCrazyDSException e) {
            e.printStackTrace();
        }

        System.out.println("---- D: Checking and exception ----");

        try {
            crazyDS.add(null);
        } catch (CrazyDSException e) {
            System.out.println("Null order can`t be added");
        }
    }

}
