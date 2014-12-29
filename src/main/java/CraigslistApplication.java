/**
 * Created with IntelliJ IDEA.
 * User: roy
 * Date: 12/28/14
 * Time: 9:58 PM
 */

import io.dropwizard.Application;
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
        // nothing to do yet
    }

    @Override
    public void run(CraigslistConfiguration configuration, Environment environment) {
        final CraigslistResource resource = new CraigslistResource();
        environment.jersey().register(resource);    }

}
