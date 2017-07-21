package com.starwars.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
/**
 * Created by root on 14/07/17.
 */
@Projection(name = "peopleWithNoPersonalInfo", types = People.class)
public interface PeopleWithNoPersonalInfo {
    @Value("#{target.gander} #{target.eyeColor}")
    String getName();
    String getBirthYear();
}
