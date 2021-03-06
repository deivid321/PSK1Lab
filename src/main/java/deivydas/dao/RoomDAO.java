package deivydas.dao;

import deivydas.entities.RoomEntity;
import deivydas.entities.StudentEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class RoomDAO implements IRoomDAO{
    @Inject
    protected EntityManager em;

    public void create(RoomEntity room) {
        em.persist(room);
    }

    public List<RoomEntity> getAllRooms() {
        return em.createNamedQuery("Room.findAll", RoomEntity.class).getResultList();
    }
}
