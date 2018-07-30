package controllers;

import play.*;
import play.mvc.*;

public class PictureController extends Controller{
    public Result getAllPictures(){
        return ok ("getAllPictures works!");
    }
    public Result getPicture(Long id){
        return ok ("getPicture works!");
    }
    public Result addPicture(){
        return ok ("addPicture works!");
    }
    public Result updatePicture(Long id){
        return ok ("updatePicture works!");
    }
    public Result deletePicture(Long id){
        return ok ("deletePicture works!");
    }
}
