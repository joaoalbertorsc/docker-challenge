package com.boxoffice.catalog.repository;

import com.boxoffice.catalog.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Access to the shows table. Spring Data JPA generates the implementation at startup.
 */
public interface ShowRepository extends JpaRepository<Show, String> {
}
