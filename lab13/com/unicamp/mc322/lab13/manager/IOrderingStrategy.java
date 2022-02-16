package com.unicamp.mc322.lab13.manager;

import com.unicamp.mc322.lab13.manager.IOrder;

public interface IOrderingStrategy {

    double calculatePriority(IOrder order);

}
