package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class SearchQuery {
    @JsonProperty
    private final String keyword;

    @JsonProperty
    private final double minPrice;

    @JsonProperty
    private final double maxPrice;

    @JsonCreator
    public SearchQuery(@JsonProperty("keyword") final String keyword,
                       @JsonProperty("minPrice") final double minPrice,
                       @JsonProperty("maxPrice") final double maxPrice) {
        this.keyword = keyword;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
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

    @Override
    public String toString() {
        return "SearchQuery{" +
                "keyword='" + keyword + '\'' +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                '}';
    }
}
