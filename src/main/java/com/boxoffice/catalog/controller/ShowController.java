package com.boxoffice.catalog.controller;

import com.boxoffice.catalog.model.Show;
import com.boxoffice.catalog.repository.ShowRepository;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/shows")
public class ShowController {

    private final ShowRepository showRepository;

    public ShowController(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @GetMapping
    public List<Show> listShows() {
        return showRepository.findAll(Sort.by("startsAt"));
    }
}
