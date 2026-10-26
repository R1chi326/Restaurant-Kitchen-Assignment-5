package org.example;

public class LoadBalancedChefStrategy implements ChefAssignmentStrategy {
    private final KitchenLoadService loadService;

    public LoadBalancedChefStrategy(KitchenLoadService loadService) {
        this.loadService = loadService;
    }

    @Override
    public String assignChef(String orderDetails) {
        int queue = loadService.getCurrentQueueLength();
        if (queue > 5) {
            return "Assigned to Backup Chef (Kitchen overloaded, queue: " + queue + ") for order: " + orderDetails;
        } else {
            return "Assigned to Regular Chef (Kitchen normal, queue: " + queue + ") for order: " + orderDetails;
        }
    }
}