package handlers;

import common.Type;

/**
 * //TODO - Implement approval implementation for President level
 */
public class President extends Approver{
    @Override
    public void approve(int id, double cost, Type type) {

        if (canApprove(id, cost, type)) {
            System.out.println("President approved purchase with id " + id + " that costs " + cost);
        }else {
            System.out.println("Purchase with id " + id + " needs approval from higher position than President.");
            next.approve(id, cost, type);
        }
    }

    @Override
    protected boolean canApprove(int id, double cost, Type type) {
        //If cost is bigger than the max amount possible for the current class, then directly return false
        if(cost > 8000) {
            return false;
        }

        switch(type) {
            case CONSUMABLES -> {
                return cost <= 1000;
            }
            case CLERICAL -> {
                return cost <= 2000;
            }
            case GADGETS -> {
                return cost <= 3000;
            }
            case GAMING -> {
                return cost <= 5000;
            }
            case PC -> {
                return cost <= 8000;
            }
            default -> {
                return false;
            }
        }
    }
}

