package com.boxoffice.catalog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * A live performance (concert, play, stand-up night...) whose tickets are sold on the platform.
 * Mapped to the {@code shows} table created by {@code schema.sql}.
 */
@Entity
@Table(name = "shows")
public class Show {

    @Id
    private String id;
    private String title;
    private String performer;
    private String category;
    private String venue;
    private String city;
    private OffsetDateTime startsAt;
    private BigDecimal startingPrice;
    private String currency;

    protected Show() {
        // Required by JPA
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPerformer() {
        return performer;
    }

    public String getCategory() {
        return category;
    }

    public String getVenue() {
        return venue;
    }

    public String getCity() {
        return city;
    }

    public OffsetDateTime getStartsAt() {
        return startsAt;
    }

    public BigDecimal getStartingPrice() {
        return startingPrice;
    }

    public String getCurrency() {
        return currency;
    }
}
