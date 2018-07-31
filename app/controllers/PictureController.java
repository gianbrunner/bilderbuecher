package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import models.Picture;
import play.libs.concurrent.HttpExecutionContext;
import play.libs.Json;

import play.mvc.*;
import services.PictureService;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;


public class PictureController extends Controller{
    private final PictureService pictureService;
    private final HttpExecutionContext ec;

    @Inject
    public PictureController(PictureService pictureService, HttpExecutionContext ec){
        this.pictureService = pictureService;
        this.ec = ec;
    }

    public CompletionStage<Result> getPictures(){
        return pictureService.get().thenApplyAsync(pictureStream->{
            return ok(Json.toJson(pictureStream.collect(Collectors.toList())));
        }, ec.current());
    }

    public CompletionStage<Result> createNewPicture(){
        final JsonNode json = request().body().asJson();
        final Picture pictureToPersist = Json.fromJson(json, Picture.class);
        return pictureService.add(pictureToPersist).thenApplyAsync(picture -> {
            return ok(Json.toJson(picture));
        }, ec.current());
    }

    public CompletionStage<Result> getPicture(long id){
        return pictureService.get(id).thenApplyAsync(picture -> {
            return ok(Json.toJson(picture));
        }, ec.current());
    }

    public CompletionStage<Result> deletePicture(long id){
        return pictureService.delete(id).thenApplyAsync(removed ->{
            return removed ? ok() : internalServerError();
        }, ec.current());
    }
}
