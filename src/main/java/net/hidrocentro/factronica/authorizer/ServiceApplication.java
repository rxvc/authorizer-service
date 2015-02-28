package net.hidrocentro.factronica.authorizer;

import net.hidrocentro.factronica.authorizer.bundle.ServiceHibernateBundle;
import net.hidrocentro.factronica.authorizer.configuration.ServiceConfiguration;
import net.hidrocentro.factronica.authorizer.health.TemplateHealthCheck;
import net.hidrocentro.factronica.authorizer.resources.HelloWorldResource;
import net.hidrocentro.factronica.authorizer.bundle.DBMigrationsBundle;
import com.google.common.annotations.VisibleForTesting;
import io.dropwizard.Application;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.hibernate.SessionFactory;

public class ServiceApplication extends Application<ServiceConfiguration> {
    private final ServiceHibernateBundle hibernateBundle = new ServiceHibernateBundle();

    public static void main(String[] args) throws Exception {
        new ServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "authorizer";
    }

    @Override
    public void initialize(Bootstrap<ServiceConfiguration> bootstrap) {
        bootstrap.addBundle(new DBMigrationsBundle());
        bootstrap.addBundle(getHibernate());

    }

    @Override
    public void run(ServiceConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().setUrlPattern(String.format("/%s/api/*",getName()));
        final HelloWorldResource resource = new HelloWorldResource("hello","hello");
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck("hello");
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }


    private HibernateBundle<ServiceConfiguration> getHibernate() {
        return hibernateBundle;
    }

    @VisibleForTesting
    public SessionFactory getSessionFactory(){
        return hibernateBundle.getSessionFactory();
    }

}
