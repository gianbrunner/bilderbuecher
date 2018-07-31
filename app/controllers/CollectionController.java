package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import models.Collection;
import play.libs.concurrent.HttpExecutionContext;
import play.libs.Json;

import play.mvc.*;
import services.CollectionService;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;


public class CollectionController extends Controller{
    private final CollectionService collectionService;
    private final HttpExecutionContext ec;

    @Inject
    public CollectionController(CollectionService collectionService, HttpExecutionContext ec){
        this.collectionService = collectionService;
        this.ec = ec;
    }

    public CompletionStage<Result> getCollections(){
        return collectionService.get().thenApplyAsync(collectionStream->{
            return ok(Json.toJson(collectionStream.collect(Collectors.toList())));
        }, ec.current());
    }

    public CompletionStage<Result> createNewCollection(){
        final JsonNode json = request().body().asJson();
        final Collection collectionToPersist = Json.fromJson(json, Collection.class);
        return collectionService.add(collectionToPersist).thenApplyAsync(collection -> {
            return ok(Json.toJson(collection));
        }, ec.current());
    }

    public CompletionStage<Result> getCollection(long id){
        return collectionService.get(id).thenApplyAsync(collection -> {
            return ok(Json.toJson(collection));
        }, ec.current());
    }

    public CompletionStage<Result> deleteCollection(long id){
        return collectionService.delete(id).thenApplyAsync(removed ->{
            return removed ? ok() : internalServerError();
        }, ec.current());
    }
}
