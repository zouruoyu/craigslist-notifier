/**
 * Created with IntelliJ IDEA.
 * User: roy
 * Date: 12/28/14
 * Time: 10:02 PM
 * To change this template use File | Settings | File Templates.
 */

import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import model.SearchResult;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class CraigslistResource {

    @GET
    @Timed
    public SearchResult getListing(@QueryParam("name") Optional<String> name) {
        return new SearchResult();
    }
}
