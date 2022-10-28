package handlers;

import common.Type;

/**
 * //TODO - If needed, validate logic and if possible optimize code
 */
public class Manager extends Approver {
    @Override
    public void approve(int id, double cost, Type type) {
        //Validation for invalid input
        if (cost < 0 || type == null) {
            System.out.println("Invalid input!");
            return;
        }

        if (canApprove(id, cost, type)) {
            System.out.println("Manager approved purchase with id " + id + " that costs " + cost);
        }else {
            System.out.println("Purchase with id " + id + " needs approval from higher position than Manager.");
            next.approve(id, cost, type);
        }
    }

    @Override
    protected boolean canApprove(int id, double cost, Type type) {
        //If cost is bigger than the max amount possible for the current class, then directly return false
        if(cost > 5000) {
            return false;
        }

        switch(type) {
            case CONSUMABLES -> {
                return cost <= 300;
            }
            case CLERICAL -> {
                return cost <= 500;
            }
            case GADGETS -> {
                return cost <= 1000;
            }
            case GAMING -> {
                return cost <= 2000;
            }
            case PC -> {
                return cost <= 5000;
            }
            default -> {
                return false;
            }
        }
    }
}

