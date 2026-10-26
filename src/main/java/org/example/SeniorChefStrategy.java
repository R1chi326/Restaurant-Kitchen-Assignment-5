package org.example;

public class SeniorChefStrategy implements ChefAssignmentStrategy {
    @Override
    public String assignChef(String orderDetails) {
        return "Assigned to Senior Chef Gordon (VIP / Complex dish) for order: " + orderDetails;
    }
}