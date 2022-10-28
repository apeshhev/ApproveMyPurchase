package handlers;

import common.Type;

/**
 * //TODO - If needed, validate logic and if possible optimize code.
 */
public class Director extends Approver {

    @Override
    public void approve(int id, double cost, Type type) {

        if (canApprove(id, cost, type)) {
            System.out.println("Director approved purchase with id " + id + " that costs " + cost);
        } else {
            System.out.println("Purchase with id " + id + " needs approval from higher position than Director.");
            next.approve(id, cost, type);
        }
    }

    @Override
    protected boolean canApprove(int id, double cost, Type type) {
        //If cost is bigger than the max amount possible for the current class, then directly return false
        if(cost > 6000) {
            return false;
        }

        switch (type) {
            case CONSUMABLES -> {
                return cost <= 500;
            }
            case CLERICAL -> {
                return cost <= 1000;
            }
            case GADGETS -> {
                return cost <= 1500;
            }
            case GAMING -> {
                return cost <= 3500;
            }
            case PC -> {
                return cost <= 6000;
            }
            default -> {
                return false;
            }
        }
    }
}

