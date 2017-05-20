package deivydas.dao;

import deivydas.entities.RoomEntity;
import deivydas.entities.StudentEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Produces;
import java.util.List;

@Alternative
public class RoomDAOAlt extends RoomDAO {
    public void create(RoomEntity room) {
        em.persist(room);
    }

}
