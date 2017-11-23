package sports_news;

import java.util.Arrays;
import java.util.List;

public class OnlineNews {

    private String newsOutletName;
    private List<IAthelete> atheleteList;

    public OnlineNews(String newsOutlet, IAthelete... atheletes){
        this.newsOutletName = newsOutlet;
        atheleteList = Arrays.asList(atheletes);
    }

//    public void
}
