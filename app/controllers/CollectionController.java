package controllers;

import play.*;
import play.mvc.*;

public class CollectionController extends Controller{
    public Result getAllCollections(){
        return ok ("getAllCollections works!");
    }
    public Result getCollection(Long id){
        return ok ("getCollection works!");
    }
    public Result addCollection(){
        return ok ("addCollection works!");
    }
    public Result updateCollection(Long id){
        return ok ("updateCollection works!");
    }
    public Result deleteCollection(Long id){
        return ok ("deleteCollection works!");
    }
}
