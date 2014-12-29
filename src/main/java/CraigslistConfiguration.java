/**
 * Created with IntelliJ IDEA.
 * User: roy
 * Date: 12/28/14
 * Time: 9:52 PM
 * Configuration file for starting the service.
 */
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.flyway.FlywayFactory;

public class CraigslistConfiguration extends Configuration {

    @JsonProperty
    private String name = "craigslist-notifier";

    @JsonCreator
    public CraigslistConfiguration(@JsonProperty("name") String name) {
        this.name = name;
    }

    public DataSourceFactory getDataSourceFactory() {
        return new DataSourceFactory();
    }

    public FlywayFactory getFlywayFactory() {
        return new FlywayFactory();
    }
}
