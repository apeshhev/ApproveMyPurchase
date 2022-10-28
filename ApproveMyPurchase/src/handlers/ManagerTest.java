package handlers;

import common.Type;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ManagerTest {
    private final Approver manager = new Manager();

    @Test
    void canApprove_True() {
        boolean result = manager.canApprove(1,200,Type.CONSUMABLES);
        assertTrue(result);
    }

    @Test
    void canApprove_False() {
        boolean result = manager.canApprove(2,9000,Type.PC);
        assertFalse(result);
    }
}