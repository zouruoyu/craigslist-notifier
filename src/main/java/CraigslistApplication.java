/**
 * Created with IntelliJ IDEA.
 * User: roy
 * Date: 12/28/14
 * Time: 9:58 PM
 */

import dao.CraigslistDao;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.flyway.FlywayBundle;
import io.dropwizard.flyway.FlywayFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;


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
    public void run(CraigslistConfiguration configuration, Environment environment) throws ClassNotFoundException {
        final CraigslistResource resource = new CraigslistResource(new CraigslistDao(getDbi(configuration, environment)));
        environment.jersey().register(resource);
    }

    private DBI getDbi(CraigslistConfiguration configuration, Environment environment) throws ClassNotFoundException{
        DBIFactory factory = new DBIFactory();
        return factory.build(environment, configuration.getDataSourceFactory(), "postgres-dib");
    }

}
