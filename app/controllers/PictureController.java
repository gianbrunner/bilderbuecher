package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Picture;
import play.*;
import play.mvc.*;
import services.DefaultPictureService;
import services.PictureService;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;


public class PictureController extends Controller{
    private final PictureService pictureService;

    public PictureController(){
        pictureService = new DefaultPictureService();
    }


    public Result getAllPictures(){
        return ok (Json.toJson(pictureService.get()));
    }


    public Result getPicture(Long id){
        return ok (Json.toJson(pictureService.get(id)));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result addPicture(){
        final JsonNode json = request().body().asJson();
        final Picture picture = Json.fromJson(json, Picture.class);
        return ok (Json.toJson(pictureService.add(picture)));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result updatePicture(Long id){
        final JsonNode json = request().body().asJson();
        final Picture picture = Json.fromJson(json, Picture.class);
        picture.setId(id);
        final Picture updatedPicture = pictureService.update(picture);
        if(null != updatedPicture){
            return ok (Json.toJson(updatedPicture));

        }
        return internalServerError();
    }

    public Result deletePicture(Long id){
        if(pictureService.delete(id)){
            return ok("Picture deleted");
        }
        return internalServerError();
    }
}
