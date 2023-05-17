package com.microservice.moviecatelogservice.web;

import com.microservice.moviecatelogservice.domain.CatalogItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class MovieCatalogController {
    @RequestMapping("/catalog/{id}")
   public List<CatalogItem> getCatalog(@PathVariable String id) {
        return Collections.singletonList(
                new CatalogItem("The note book", "love story", 3)
        );
    }
}
