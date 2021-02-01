package models;

import java.io.File;
import java.util.List;

public class MovieModel {
    private String title;
    private String status;
    private Integer year;
    private String releaseData;
    private List<String> cast;
    private String plot;
    private File cover;

    public MovieModel(String title, String status, Integer year, String releaseData, List<String> cast, String plot, String cover){
        this.title = title;
        this.status = status;
        this.year = year;
        this.releaseData = releaseData;
        this.cast = cast;
        this.plot = plot;
        this.cover = new File(this.converPath() + cover);
    }

    private String converPath(){
        String searchPath = System.getProperty("user.dir");
        String os = System.getProperty("os.name");
        String target;
        if (os.contains("Windows")) {
            target = searchPath + "\\src\\main\\resources\\cover\\";
        } else {
            target = searchPath + "src/main/resources/cover/";
        }
        return target;
    }
}
