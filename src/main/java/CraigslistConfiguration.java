/**
 * Created with IntelliJ IDEA.
 * User: roy
 * Date: 12/28/14
 * Time: 9:52 PM
 * Configuration file for starting the service.
 */
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.flyway.FlywayFactory;

public class CraigslistConfiguration extends Configuration {

    @JsonProperty("name")
    private String name = "craigslist-notifier";

    @JsonProperty("postgresConfiguration")
    private DataSourceFactory postgresConfiguration;

    @JsonProperty("flywayFactory")
    private FlywayFactory flywayFactory;

    public DataSourceFactory getDataSourceFactory() {
        return postgresConfiguration;
    }

    public FlywayFactory getFlywayFactory() {
        return flywayFactory;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("postgresConfiguration")
    public void setPostgresConfiguration(DataSourceFactory postgresConfiguration) {
        this.postgresConfiguration = postgresConfiguration;
    }

    @JsonProperty
    public void setFlywayFactory(FlywayFactory flywayFactory) {
        this.flywayFactory = flywayFactory;
    }

    @Override
    public String toString()
    {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("postgresConfiguration", postgresConfiguration)
                .add("flywayFactory", flywayFactory)
                .toString();
    }
}
