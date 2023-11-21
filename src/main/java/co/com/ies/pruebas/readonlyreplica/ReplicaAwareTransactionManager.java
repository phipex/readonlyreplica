package co.com.ies.pruebas.readonlyreplica;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;

public class ReplicaAwareTransactionManager implements PlatformTransactionManager {

    private final PlatformTransactionManager wrapped;

    public ReplicaAwareTransactionManager(PlatformTransactionManager platformTransactionManager) {
        wrapped = platformTransactionManager;
    }

    @Override
    public @NotNull TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
        System.out.println("definition = " + definition);
        TransactionRoutingDataSource.setReadonlyDataSource(definition != null && definition.isReadOnly());
        return wrapped.getTransaction(definition);
    }

    @Override
    public void commit(@NotNull TransactionStatus status) throws TransactionException {
        wrapped.commit(status);
    }

    @Override
    public void rollback(@NotNull TransactionStatus status) throws TransactionException {
        wrapped.rollback(status);
    }
}
