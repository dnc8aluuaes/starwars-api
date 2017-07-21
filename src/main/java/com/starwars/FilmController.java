package com.starwars;

import com.starwars.model.Film;
import com.starwars.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by root on 14/07/17.
 */
@RepositoryRestController
public class FilmController {

    private FilmRepository filmRepository;

    @Autowired
    public FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "films/search/findAllByReleaseDateGreaterThanEqual")
    public @ResponseBody ResponseEntity<?> withIMdbLink(@RequestParam("releaseDate") @DateTimeFormat(pattern = "yyy-mm-dd'T'HH:mm:ss") Date releaseDate){
        List<Film> films = filmRepository.findAllByReleaseDateGreaterThanEqual(releaseDate);

        Resources<Film> resources = new Resources<Film>(films);
        resources.forEach(resource -> resource.add(new Link("www.imdb.com").withRel("imdb")));


        return ResponseEntity.ok(resources);
    }

}
