package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;


public class SearchResult {

    @NotNull
    @JsonProperty
    private long id;
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

    public SearchResult(long id, String title, String description, double price, String url, DateTime postedTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.url = url;
        this.postedTime = postedTime;
    }

    @JsonProperty
    public long getId() {
        return id;
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
    public String toString()
    {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("title", title)
                .add("description", description)
                .add("price", price)
                .add("url", url)
                .add("postedTime", postedTime)
                .toString();
    }
}
