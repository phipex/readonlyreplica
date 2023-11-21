package co.com.ies.pruebas.readonlyreplica;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class TransactionRoutingDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<DataSourceType> currentDataSource = new ThreadLocal<>();

    public TransactionRoutingDataSource(DataSource master, DataSource slave) {
        Map<Object, Object> dataSources = new HashMap<>();
        dataSources.put(DataSourceType.READ_WRITE, master);
        dataSources.put(DataSourceType.READ_ONLY, slave);

        super.setTargetDataSources(dataSources);
        super.setDefaultTargetDataSource(master);
    }

    static void setReadonlyDataSource(boolean isReadonly) {
        System.out.println("TransactionRoutingDataSource.setReadonlyDataSource isReadonly = " + isReadonly);
        currentDataSource.set(isReadonly ? DataSourceType.READ_ONLY : DataSourceType.READ_WRITE);
    }

    public static void unload() {
        currentDataSource.remove();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return currentDataSource.get();
    }

    private enum DataSourceType {
        READ_ONLY,
        READ_WRITE;
    }

}
