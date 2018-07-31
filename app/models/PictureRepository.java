package models;

import play.db.jpa.JPAApi;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.stream.Stream;
import static java.util.concurrent.CompletableFuture.supplyAsync;


public class PictureRepository {
    private final JPAApi jpaApi;
    @Inject
    public PictureRepository(JPAApi jpaApi){
        this.jpaApi = jpaApi;
    }
    public CompletionStage<Picture> add(Picture picture) {
        return supplyAsync(() -> wrap(em -> insert(em, picture)));
    }
    public CompletionStage<Stream<Picture>> list() {
        return supplyAsync(() -> wrap(em -> list(em)));
    }
    public CompletionStage<Picture> find(long id) {
        return supplyAsync(() -> wrap(em -> find(em, id)));
    }
    public CompletionStage<Boolean> remove(long id) {
        return supplyAsync(() -> wrap(em -> remove(em, id)));
    }
    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }
    private Picture insert(EntityManager em, Picture picture) {
        em.persist(picture);
        return picture;
    }
    private Stream<Picture> list(EntityManager em) {
        List<Picture> pictures = em.createQuery("select p from picture p", Picture.class).getResultList();
        return pictures.stream();
    }
    private Picture find(EntityManager em, long id) {
        return em.find(Picture.class, id);
    }
    private Boolean remove(EntityManager em, long id) {
        Picture picture = em.find(Picture.class, id);
        if(null != picture) {
            em.remove(picture);
            return true;

        }
        return false;
    }


}
