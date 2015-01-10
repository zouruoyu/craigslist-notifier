package model;

import org.joda.time.DateTime;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class SearchQueryMapper implements ResultSetMapper
{
    @Override
    public SearchQuery map(int index, java.sql.ResultSet resultSet, org.skife.jdbi.v2.StatementContext statementContext) throws java.sql.SQLException {
        return new SearchQuery(
                resultSet.getLong("id"),
                resultSet.getString("keyword"),
                resultSet.getFloat("min_price"),
                resultSet.getFloat("max_price"),
                resultSet.getString("url"),
                resultSet.getBoolean("by_owner"),
                new DateTime(resultSet.getTimestamp("created_at").getTime()),
                new DateTime(resultSet.getTimestamp("updated_at").getTime()));
    }
}
