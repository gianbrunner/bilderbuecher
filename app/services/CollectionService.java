package services;

import models.Collection;

import java.util.List;

public interface CollectionService {

    /**
     * Return's list of all collections.
     * @return list of all collections
     */
    List<Collection> get();

    /**
     * Returns collection with given identifier.
     * @param id collection identifier
     * @return collection with given identifier or {@code null}
     */
    Collection get(final Long id);

    /**
     * Removes collection with given identifier.
     * @param id collection identifier
     * @return {@code true} on success  {@code false} on failure
     */
    boolean delete(final Long id);

    /**
     * Updates collection with given identifier.
     * @param updatedCollection collection with updated fields
     * @return updated collection
     */
    Collection update(final Collection updatedCollection);

    /**
     * Adds the given collection.
     * @param collection to add
     * @return added collection
     */
    Collection add(final Collection collection);

}