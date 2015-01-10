package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;


public class SearchResult {

    @NotNull
    @JsonProperty
    private Long id;

    @NotNull
    @JsonProperty
    private String title;

    @JsonProperty
    private double price;

    @NotNull
    @JsonProperty
    private String url;

    @JsonProperty
    private long searchQueryId;

    @NotNull
    @JsonProperty
    private DateTime postedTime;

    public SearchResult(Long id, String title, double price, String url, long searchQueryId, DateTime postedTime) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.url = url;
        this.searchQueryId = searchQueryId;
        this.postedTime = postedTime;
    }

    @JsonProperty
    public Long getId() {
        return id;
    }

    @JsonProperty
    public String getTitle() {
        return title;
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
    public long getSearchQueryId() {
        return searchQueryId;
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
                .add("price", price)
                .add("url", url)
                .add("searchQueryId", searchQueryId)
                .add("postedTime", postedTime)
                .toString();
    }
}
