/**
 * Created with IntelliJ IDEA.
 * User: roy
 * Date: 12/28/14
 * Time: 10:02 PM
 * To change this template use File | Settings | File Templates.
 */

import com.codahale.metrics.annotation.ExceptionMetered;
import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;

import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.common.collect.ImmutableMap;
import dao.CraigslistDao;
import model.SearchQuery;
import model.SearchResult;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Path("/craigslist")
@Produces(MediaType.APPLICATION_JSON)
public class CraigslistResource {

    private final CraigslistDao dao;

    public CraigslistResource(final CraigslistDao dao) {
        this.dao = dao;
    }

    @GET
    @Timed
    public String getListing(@QueryParam("name") Optional<String> name) {
        return "test";
    }

    @POST
    @Path("search-query")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createSearchQuery(@Valid SearchQuery query) {
        SearchQuery insertedQuery = dao.insertSearchQuery(query);
        return Response.ok(ImmutableMap.of("result", insertedQuery)).build();
    }

    @GET
    @Path("search-query")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSearchQueries() {
        List<SearchQuery> searchQueries = dao.getAllSearchQueries();
        return Response.ok(ImmutableMap.of("result", searchQueries)).build();
    }

    @DELETE
    @Path("search-query/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteOneSearch(@PathParam("id") long id) {
        dao.deleteOneSearchQuery(id);
        return Response.ok(ImmutableMap.of("status", "success")).build();
    }

}
