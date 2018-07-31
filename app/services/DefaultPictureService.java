package services;

import models.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

public class DefaultPictureService implements PictureService {

    private List<Picture> pictures;
    private PictureRepository pictureRepository;

    @Inject
    public DefaultPictureService (PictureRepository pictureRepository){
        pictures = new ArrayList<>();
        this.pictureRepository = pictureRepository;
    }

    public CompletionStage<Stream<Picture>> get() { return pictureRepository.list();}

    public CompletionStage<Picture> get(final long id){ return pictureRepository.find(id);}

    public CompletionStage<Boolean> delete(final long id){ return pictureRepository.remove(id); }

    public CompletionStage<Picture> add(final Picture picture) {return pictureRepository.add(picture);}

}
