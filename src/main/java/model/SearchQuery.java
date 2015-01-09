package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import org.joda.time.DateTime;


public class SearchQuery {

    @JsonProperty
    private final long id;
    @JsonProperty
    private final String keyword;

    @JsonProperty
    private final double minPrice;

    @JsonProperty
    private final double maxPrice;

    @JsonIgnore
    @JsonProperty
    private final DateTime createdTime;

    @JsonIgnore
    @JsonProperty
    private final DateTime updatedTime;

    @JsonCreator
    public SearchQuery(@JsonProperty("id") final long id,
                       @JsonProperty("keyword") final String keyword,
                       @JsonProperty("minPrice") final double minPrice,
                       @JsonProperty("maxPrice") final double maxPrice,
                       @JsonProperty("createTime") final DateTime createdTime,
                       @JsonProperty("updatedTime") final DateTime updatedTime) {
        this.id = id;
        this.keyword = keyword;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public long getId() {
        return id;
    }

    public String getKeyword() {
        return keyword;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public DateTime getCreatedTime()
    {
        return createdTime;
    }

    public DateTime getUpdatedTime()
    {
        return updatedTime;
    }

    @Override
    public String toString()
    {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("keyword", keyword)
                .add("minPrice", minPrice)
                .add("maxPrice", maxPrice)
                .toString();
    }
}
