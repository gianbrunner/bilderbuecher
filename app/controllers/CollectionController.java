package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Collection;
import models.Picture;
import play.*;
import play.mvc.*;
import services.CollectionService;
import services.DefaultCollectionService;
import services.DefaultPictureService;
import services.PictureService;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

public class CollectionController extends Controller{
    private final CollectionService collectionService;

    public CollectionController(){
        collectionService = new DefaultCollectionService();
    }

    public Result getAllCollections(){
        return ok (Json.toJson(collectionService.get()));
    }

    public Result getCollection(Long id){
        return ok (Json.toJson(collectionService.get(id)));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result addCollection(){
        final JsonNode json = request().body().asJson();
        final Collection collection = Json.fromJson(json, Collection.class);
        return ok (Json.toJson(collectionService.add(collection)));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result updateCollection(Long id){
        final JsonNode json = request().body().asJson();
        final Collection collection = Json.fromJson(json, Collection.class);
        collection.setId(id);
        final Collection updatedCollection = collectionService.update(collection);
        if(null != updatedCollection){
            return ok (Json.toJson(updatedCollection));
        }
        return internalServerError();
    }
    public Result deleteCollection(Long id){
        if(collectionService.delete(id)){
            return ok("Collection deleted");
        }
        return internalServerError();
    }
}
