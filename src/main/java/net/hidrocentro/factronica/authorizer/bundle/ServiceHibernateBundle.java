package net.hidrocentro.factronica.authorizer.bundle;


import net.hidrocentro.factronica.authorizer.configuration.ServiceConfiguration;
import net.hidrocentro.factronica.authorizer.core.Document;
import net.hidrocentro.factronica.authorizer.core.Saying;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;

public class ServiceHibernateBundle extends HibernateBundle<ServiceConfiguration>{

    private ServiceConfiguration configuration;

    public ServiceHibernateBundle() {
        super(Saying.class, Document.class);
    }

    @Override
    public DataSourceFactory getDataSourceFactory(ServiceConfiguration configuration) {
        this.configuration = configuration;
        return configuration.getDataSourceFactory();
    }

    public ServiceConfiguration getConfiguration(){
        return configuration;
    }
}
