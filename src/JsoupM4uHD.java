import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class JsoupM4uHD {

    private Document document;
    private Element link;
    private String title, url;

    private void SetTitle(String title){
        this.title = title;
    }

    public String GetTitle(){
        return title;
    }

    private void SetURL(String url){
        this.url = url;
    }

    public String GetURL(){
        return url;
    }

    public Document LoadWebsite(String url){
        try {
            this.document = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return this.document;
    }

    private Element GetFirstAAttribute(){
        return link = document.select("a").first();
    }

    private void GetWebsiteTitle(){
        GetFirstAAttribute();
        SetTitle(link.text());
    }

    private void GetWebsiteURL(){
        GetFirstAAttribute();
        SetURL(link.absUrl("href"));
    }


    private void PrintWebsiteDetail(){
        System.out.println("Website: "+ GetTitle());
        System.out.println("Website URL: " + GetURL());
    }


    public static void main( String[] args ) throws IOException {

        JsoupM4uHD M4uhd = new JsoupM4uHD();
        M4uhd.LoadWebsite("http://m4uhd.net/top-recommended-movies");
        M4uhd.GetWebsiteTitle();
        M4uhd.GetWebsiteURL();
        M4uhd.PrintWebsiteDetail();

    }

}
