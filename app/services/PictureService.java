package services;

import models.Picture;

import java.util.List;

public interface PictureService {

    /**
     * Return's list of all pictures.
     * @return list of all pictures
     */
    List<Picture> get();

    /**
     * Returns picture with given identifier.
     * @param id picture identifier
     * @return picture with given identifier or {@code null}
     */
    Picture get(final Long id);

    /**
     * Removes picture with given identifier.
     * @param id picture identifier
     * @return {@code true} on success  {@code false} on failure
     */
    boolean delete(final Long id);

    /**
     * Updates picture with given identifier.
     * @param updatedPicture picture with updated fields
     * @return updated picture
     */
    Picture update(final Picture updatedPicture);

    /**
     * Adds the given picture.
     * @param picture to add
     * @return added picture
     */
    Picture add(final Picture picture);

}