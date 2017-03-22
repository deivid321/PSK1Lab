package lt.vu.dao;

import Deivydas.RoomEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class RoomDAO {
    @Inject
    private EntityManager em;

    public void create(RoomEntity room) {
        em.persist(room);
    }
}
