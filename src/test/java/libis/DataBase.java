package libis;

import pages.MoviePage;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DataBase {
    private final String url = "jdbc:postgresql://localhost:5432/ninjaplus";
    private final String user = "postgres";
    private final String pass = "qaninja";

    Properties prop = new Properties();
    InputStream inputFile = getClass().getClassLoader().getResourceAsStream("movies.properties");


    private Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }

    public void deleteMovie(String title){


        String sql = "DELETE FROM PUBLIC.MOVIES WHERE TITLE = ?;";
        try {
            PreparedStatement query = this.connect().prepareStatement(sql);
            query.setString(1,title);
            query.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }



    }


}
