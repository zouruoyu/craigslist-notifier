package dao;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.sqlobject.stringtemplate.StringTemplate3StatementLocator;

public class CraigslistDao
{
    private final DBI dbi;

    public CraigslistDao(final DBI dbi) {
        this.dbi = dbi;
        dbi.setStatementLocator(StringTemplate3StatementLocator.builder(this.getClass()).build());
    }
}
