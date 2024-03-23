/*
RoomTypeRepositoryTest.java
RoomTypeRepositoryTest class
Author: Moegamat Zaihd Behardien (219233829)
Date: 23 March 2024
*/

package za.ac.cput.repository;
import za.ac.cput.domain.RoomType;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class RoomTypeRepositoryTest
{
    private RoomTypeRepository roomTypeRepository;

    @BeforeEach
    public void setUp()
    {
        roomTypeRepository = new RoomTypeRepositoryImpl();
    }

    @Test
    public void testCreateRoomType()
    {
        RoomType roomType = new RoomType();
        roomType.setName("Standard");
        roomType.setPrice(100.0);

        RoomType savedRoomType = roomTypeRepository.create(roomType);

        assertNotNull(savedRoomType);
        assertNotNull(savedRoomType.getId());
        assertEquals(roomType.getName(), savedRoomType.getName());
        assertEquals(roomType.getPrice(), savedRoomType.getPrice());
    }

    @Test
    public void testFindById()
    {
        RoomType roomType = new RoomType();
        roomType.setName("Deluxe");
        roomType.setPrice(150.0);

        RoomType savedRoomType = roomTypeRepository.create(roomType);
        RoomType foundRoomType = roomTypeRepository.findById(savedRoomType.getId());

        assertNotNull(foundRoomType);
        assertEquals(savedRoomType.getId(), foundRoomType.getId());
        assertEquals(savedRoomType.getName(), foundRoomType.getName());
        assertEquals(savedRoomType.getPrice(), foundRoomType.getPrice());
    }

    @Test
    public void testUpdateRoomType()
    {
        RoomType roomType = new RoomType();
        roomType.setName("Economy");
        roomType.setPrice(80.0);

        RoomType savedRoomType = roomTypeRepository.create(roomType);
        savedRoomType.setName("Standard");

        RoomType updatedRoomType = roomTypeRepository.update(savedRoomType);

        assertNotNull(updatedRoomType);
        assertEquals(savedRoomType.getId(), updatedRoomType.getId());
        assertEquals(savedRoomType.getName(), updatedRoomType.getName());
        assertEquals(savedRoomType.getPrice(), updatedRoomType.getPrice());
    }

    @Test
    public void testDeleteRoomType()
    {
        RoomType roomType = new RoomType();
        roomType.setName("Suite");
        roomType.setPrice(200.0);

        RoomType savedRoomType = roomTypeRepository.create(roomType);
        roomTypeRepository.delete(savedRoomType);
        RoomType deletedRoomType = roomTypeRepository.findById(savedRoomType.getId());

        assertNull(deletedRoomType);
    }
}
