package com.starwars.model;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

/**
 * Created by root on 14/07/17.
 */

@Projection(name = "filmsTitleWithOpening", types = Film.class)
public interface FilmsTitleWithOpening {
    String getTitle();
    String getOpeningCrawl();
    List<PeopleWithNoPersonalInfo> getPeople();
}