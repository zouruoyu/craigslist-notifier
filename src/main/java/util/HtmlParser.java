package util;


import model.SearchQuery;
import model.SearchResult;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HtmlParser {
    public static List<SearchResult> getSearchResults(SearchQuery searchQuery) throws IOException {
        List<SearchResult> listings = new ArrayList<>();

        Document doc = Jsoup.connect(constructUrl(searchQuery)).get();
        Elements content = doc.getElementsByClass("row");

        for (Element element : content)
        {
            Elements links = element.getElementsByClass("hdrlnk");
            String title = links.get(0).text();
            String url = searchQuery.getUrl() + links.get(0).attr("href");
            Elements prices = element.getElementsByClass("price");
            double price = searchQuery.getMinPrice();
            if (prices.size() > 0) {
                price = Double.valueOf(prices.get(0).text().substring(1));
            }

            DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-mm-dd HH:mm");
            DateTime postedTime = formatter.parseDateTime(element.getElementsByAttribute("datetime").get(0).attr("datetime"));

            if (price >= searchQuery.getMinPrice() && price <= searchQuery.getMaxPrice()) {
                listings.add(new SearchResult(null, title, price, url, searchQuery.getId(), postedTime));
            }
        }
        return listings;
    }

    private static String constructUrl(SearchQuery searchQuery) {
        if (searchQuery.getByOwner()) {
            return searchQuery.getUrl() + "/search/sso?sort=date&postedToday=1&srchType=T&query=" + searchQuery.getKeyword();
        } else {
            return searchQuery.getUrl() + "/search/sss?sort=date&postedToday=1&srchType=T&query=" + searchQuery.getKeyword();
        }
    }

    public static void main(String[] args) {
        try {

            SearchQuery query = new SearchQuery(1, "miata", 1000, 10000, "http://sfbay.craigslist.org", true, null, null);
            System.out.println(getSearchResults(query));
            System.out.println(getSearchResults(query).size());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }
}
