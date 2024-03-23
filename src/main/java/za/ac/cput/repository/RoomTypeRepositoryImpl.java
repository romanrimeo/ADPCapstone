/*
GuestRepositoryTest.java
GuestRepositoryTest class
Author: Moegamat Zaihd Behardien (219233829)
Date: 23 March 2024
*/
package za.ac.cput.repository;
import za.ac.cput.domain.RoomType;
import za.ac.cput.repository.RoomTypeRepository;

import java.util.HashMap;
import java.util.Map;
public class RoomTypeRepositoryImpl implements RoomTypeRepository
{
    private Map<Long, RoomType> roomTypeMap = new HashMap<>();
    private Long idCounter = 1L;

    @Override
    public RoomType create(RoomType roomType)
    {
        if (roomType.getId() == null) {
            roomType.setId(idCounter++);
        }
        roomTypeMap.put(roomType.getId(), roomType);
        return roomType;
    }

    @Override
    public RoomType findById(Long id) {
        return roomTypeMap.get(id);
    }

    @Override
    public RoomType update(RoomType roomType)
    {
        if (roomTypeMap.containsKey(roomType.getId()))
        {
            roomTypeMap.put(roomType.getId(), roomType);
            return roomType;
        } else {
            throw new RuntimeException("RoomType not found");
        }
    }

    @Override
    public void delete(RoomType roomType)
    {
        roomTypeMap.remove(roomType.getId());
    }

}
