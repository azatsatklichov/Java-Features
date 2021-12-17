package com.joshcummings.cats;

import static spark.Spark.*;
import java.util.Collections;
import com.google.gson.Gson;

import com.joshcummings.cats.model.Cat;
import com.joshcummings.cats.model.DescendentKnowingCat;

import com.joshcummings.cats.service.CatService;
import com.joshcummings.cats.service.SimpleCatService;

public class CatGenealogy {
    
    private CatService catService = new SimpleCatService(DescendentKnowingCat.class);
    
    public static void main(String[] args) {        
        CatGenealogy cg = new CatGenealogy();
        Gson gson = new Gson();
        
        port(8080);
        
        get("/cat/list", (req, res) -> {
            if ( req.params("name") != null ) {
                return cg.catService.findCat(req.params("name"));
            }
            return cg.catService.listCats();
        }, gson::toJson);
        
        post("/cat", (req, res) -> {
            Cat cat = gson.fromJson(req.body(), DescendentKnowingCat.class);
            cg.catService.addCat(cat);
            return cat;
        }, gson::toJson); 
        
        post("/mom/:momid/dad/:dadid/cat", (req, res) -> {
            Cat cat = gson.fromJson(req.body(), DescendentKnowingCat.class);
            Cat mom = cg.catService.findCat(Long.parseLong(req.params(":momid")));
            Cat dad = cg.catService.findCat(Long.parseLong(req.params(":dadid")));
            return cg.catService.addCat(cat.getName(), dad, mom);
        });
        
        get("/cat/:id", (req, res) -> {
            return cg.catService.findCat(Long.parseLong(req.params(":id")));
        }); 
        
        delete("/cat/:id", (req, res) -> {
            cg.catService.removeCat(Long.parseLong(req.params(":id")));
            res.status(204);
            return "";
        });
        
    }
}