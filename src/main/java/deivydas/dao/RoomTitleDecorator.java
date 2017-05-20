package deivydas.dao;

import deivydas.entities.RoomEntity;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by vdeiv on 2017-05-20.
 */
@Decorator
public class RoomTitleDecorator implements IRoomDAO {
    @Inject
    @Delegate
    @Any
    private RoomDAO roomDAO;

    public void create(RoomEntity room) {
        room.setName("s"+room.getName().substring(0,1));
        roomDAO.create(room);
    }
    public List<RoomEntity> getAllRooms() {
        return roomDAO.getAllRooms();
    }
}
