package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        if (transaction == null) {
            throw new RuntimeException("Data is null");
        }
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Quantity is < 0 " + transaction.getQuantity());
        }
        Storage.DB.put(transaction.getFruit(),transaction.getQuantity());
    }
}