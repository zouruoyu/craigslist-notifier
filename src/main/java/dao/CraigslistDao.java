package dao;

import model.SearchQuery;
import model.SearchQueryMapper;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.sqlobject.stringtemplate.StringTemplate3StatementLocator;
import org.skife.jdbi.v2.tweak.HandleCallback;

import java.util.List;

public class CraigslistDao
{
    private final DBI dbi;

    public CraigslistDao(final DBI dbi) {
        this.dbi = dbi;
        dbi.setStatementLocator(StringTemplate3StatementLocator.builder(this.getClass()).build());
    }

    public SearchQuery insertSearchQuery(final SearchQuery searchQuery) {
        return dbi.withHandle(new HandleCallback<SearchQuery>()
        {
            @Override
            public SearchQuery withHandle(Handle handle) throws Exception
            {
                SearchQuery result = (SearchQuery) handle.createQuery("insert_search_query")
                        .bind("keyword", searchQuery.getKeyword())
                        .bind("min_price", searchQuery.getMinPrice())
                        .bind("max_price", searchQuery.getMaxPrice())
                        .map(new SearchQueryMapper()).first();
                return result;
            }
        });
    }

    public List<SearchQuery> getAllSearchQueries() {
        return dbi.withHandle(new HandleCallback<List<SearchQuery>>()
        {
            @Override
            public List<SearchQuery> withHandle(Handle handle) throws Exception
            {
                List<SearchQuery> result = handle.createQuery("get_all_search_queries")
                        .map(new SearchQueryMapper()).list();
                return result;
            }
        });
    }

    public void deleteOneSearchQuery(final long id) {
        dbi.withHandle(new HandleCallback<Void>()
        {
            @Override
            public Void withHandle(Handle handle) throws Exception
            {
                handle.createStatement("delete_one_search_query").bind("id", id).execute();
                return null;
            }
        });
    }
}
