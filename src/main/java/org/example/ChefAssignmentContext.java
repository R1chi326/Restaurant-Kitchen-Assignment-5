package org.example;

public class ChefAssignmentContext {
    private ChefAssignmentStrategy strategy;

    public ChefAssignmentContext(ChefAssignmentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(ChefAssignmentStrategy strategy) {
        this.strategy = strategy;
    }

    public String executeAssignment(String orderDetails) {
        return strategy.assignChef(orderDetails);
    }
}