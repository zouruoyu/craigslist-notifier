package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: roy
 * Date: 12/28/14
 * Time: 10:09 PM
 */
public class Listing {
    @NotNull
    @JsonProperty
    private String url;

    @NotNull
    @JsonProperty
    private String title;

    @NotNull
    @JsonProperty
    private String description;

    public Listing(String url, String title, String description) {
        this.url = url;
        this.title = title;
        this.description = description;
    }

    @JsonProperty
    public String getUrl() {
        return url;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }
}
