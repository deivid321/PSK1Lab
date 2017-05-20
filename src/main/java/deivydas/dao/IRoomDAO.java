package deivydas.dao;

import deivydas.entities.RoomEntity;

import java.util.List;

/**
 * Created by vdeiv on 2017-05-20.
 */
public interface IRoomDAO {
    void create(RoomEntity room);
    List<RoomEntity> getAllRooms();
}
