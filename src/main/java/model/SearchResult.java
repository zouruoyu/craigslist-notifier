package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: roy
 * Date: 12/28/14
 * Time: 10:09 PM
 */
public class SearchResult {
    @NotNull
    @JsonProperty
    private String title;

    @NotNull
    @JsonProperty
    private String description;

    @JsonProperty
    private double price;

    @NotNull
    @JsonProperty
    private String url;

    @NotNull
    @JsonProperty
    private DateTime postedTime;

    public SearchResult(String title, String description, double price, String url, DateTime postedTime) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.url = url;
        this.postedTime = postedTime;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }

    @JsonProperty
    public double getPrice() {
        return price;
    }

    @JsonProperty
    public String getUrl() {
        return url;
    }

    @JsonProperty
    public DateTime getPostedTime() {
        return postedTime;
    }

    @Override
    public String toString() {
        return "Listing{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", url='" + url + '\'' +
                ", postedTime=" + postedTime +
                '}';
    }
}
