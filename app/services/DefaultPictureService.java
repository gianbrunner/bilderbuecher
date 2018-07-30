package services;

import models.Picture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultPictureService implements PictureService{
    private List<Picture> pictures;

    public DefaultPictureService(){
        pictures = new ArrayList<>();
        pictures.add(createPicture());
    }

    public Picture createPicture(){
        final Picture picture = new Picture();
        picture.setId(1L);
        picture.setName("Sunrise Dubai");
        picture.setPhotographer("Gian Brunner");
        picture.setDetails("Sony Alpha A6000");
        picture.setPathToImage("/pictures/001.jpg");
        picture.setCategory("Weitwinkel");

        return picture;
    }

    public List<Picture> get() {return pictures; }

    public Picture get (final Long id){
        for(Picture picture: pictures){
            if(picture.getId() == id){
                return picture;
            }
        }
        return null;
    }

    public boolean delete(final Long id){
        for (Iterator<Picture> it = pictures.iterator(); it.hasNext();){
            Picture picture = it.next();
            if(picture.getId() == id){
                it.remove();
                return true;
            }
        }
        return false;
    }

    public Picture update(final Picture updatedPicture){
        for(Picture picture: pictures){
            if(picture.getId() == updatedPicture.getId()){
                picture.setName(updatedPicture.getName());
                picture.setPhotographer(updatedPicture.getPhotographer());
                picture.setDetails(updatedPicture.getDetails());
                picture.setDetails(updatedPicture.getDetails());
                picture.setPathToImage(updatedPicture.getPathToImage());
                picture.setCategory(updatedPicture.getCategory());
                return picture;
            }
        }
        return null;
    }

    public Picture add(final Picture picture){
        pictures.add(picture);
        return picture;
    }
}
