package services;

import models.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultCollectionService implements CollectionService{
    private List<Collection> collections;
    private DefaultPictureService defaultPictureService;

    public DefaultCollectionService(){
        collections = new ArrayList<>();
        defaultPictureService = new DefaultPictureService();
        collections.add(createCollection());
    }

    private Collection createCollection(){
        final Collection collection = new Collection();
        collection.setId(1L);
        collection.setName("Sunrise Dubai");
        collection.setPicture(defaultPictureService.createPicture());

        return collection;
    }

    public List<Collection> get() {return collections; }

    public Collection get (final Long id){
        for(Collection collection: collections){
            if(collection.getId() == id){
                return collection;
            }
        }
        return null;
    }

    public boolean delete(final Long id){
        for (Iterator<Collection> it = collections.iterator(); it.hasNext();){
            Collection collection = it.next();
            if(collection.getId() == id){
                it.remove();
                return true;
            }
        }
        return false;
    }

    public Collection update(final Collection updatedCollection){
        for(Collection collection: collections){
            if(collection.getId() == updatedCollection.getId()){
                collection.setName(updatedCollection.getName());
                collection.setPicture(updatedCollection.getPicture());
                return collection;
            }
        }
        return null;
    }

    public Collection add(final Collection collection){
        collections.add(collection);
        return collection;
    }
}
