package pl.diakowski.blog.DataSourceProvider;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceProvider {
    private static DataSource dataSource;

    public DataSourceProvider() {
    }

    public static DataSource getDataSource() throws NamingException {
        if (dataSource == null) {
            InitialContext context = new InitialContext();
            Context envContext = (Context) context.lookup("java:comp/env/");
            dataSource = (DataSource) envContext.lookup("jdbc/secret");
        }
        return dataSource;
    }
}
