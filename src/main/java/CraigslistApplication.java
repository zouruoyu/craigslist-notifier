/**
 * Created with IntelliJ IDEA.
 * User: roy
 * Date: 12/28/14
 * Time: 9:58 PM
 */

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.flyway.FlywayBundle;
import io.dropwizard.flyway.FlywayFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class CraigslistApplication extends Application<CraigslistConfiguration> {
    public static void main(String[] args) throws Exception {
        new CraigslistApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<CraigslistConfiguration> bootstrap) {
        bootstrap.addBundle(new FlywayBundle<CraigslistConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(CraigslistConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }

            @Override
            public FlywayFactory getFlywayFactory(CraigslistConfiguration configuration) {
                return configuration.getFlywayFactory();
            }
        });
    }

    @Override
    public void run(CraigslistConfiguration configuration, Environment environment) {
        final CraigslistResource resource = new CraigslistResource();
        environment.jersey().register(resource);    }

}
