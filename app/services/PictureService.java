package services;

import com.google.inject.ImplementedBy;
import models.Picture;

import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

@ImplementedBy(DefaultPictureService.class)
public interface PictureService {

    /**
     * Return's list of all pictures.
     * @return list of all pictures
     */
    CompletionStage<Stream<Picture>> get();

    /**
     * Returns picture with given identifier.
     * @param id picture identifier
     * @return picture with given identifier or {@code null}
     */
    CompletionStage<Picture> get(final long id);

    /**
     * Removes picture with given identifier.
     * @param id picture identifier
     * @return {@code true} on success  {@code false} on failure
     */
    CompletionStage<Boolean> delete(final long id);

    /**
     * Adds the given picture.
     * @param picture to add
     * @return added picture
     */
    CompletionStage<Picture> add(final Picture picture);

}