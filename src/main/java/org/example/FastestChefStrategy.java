package org.example;

public class FastestChefStrategy implements ChefAssignmentStrategy {
    @Override
    public String assignChef(String orderDetails) {
        return "Assigned to Chef Alex (Fastest track) for order: " + orderDetails;
    }
}