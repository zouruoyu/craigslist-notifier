package model;

import org.joda.time.DateTime;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class SearchResultMapper implements ResultSetMapper<SearchResult> {

    @Override
    public SearchResult map(int index, java.sql.ResultSet resultSet, org.skife.jdbi.v2.StatementContext statementContext) throws java.sql.SQLException {
        return new SearchResult(
                resultSet.getLong("id"),
                resultSet.getString("title"),
                resultSet.getString("description"),
                resultSet.getFloat("price"),
                resultSet.getString("url"),
                new DateTime(resultSet.getTimestamp("posted_time").getTime()));
    }
}
