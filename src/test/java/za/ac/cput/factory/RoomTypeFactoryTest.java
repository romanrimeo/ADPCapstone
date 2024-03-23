package za.ac.cput.factory;
import za.ac.cput.domain.RoomType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
public class RoomTypeFactoryTest
{
    @Test
    public void testCreateRoomType() {
        Long id = 1L;
        String name = "Standard";
        double price = 100.0;

        RoomType roomType = RoomTypeFactory.createRoomType(id, name, price);

        assertNotNull(roomType);
        assertEquals(id, roomType.getId());
        assertEquals(name, roomType.getName());
        assertEquals(price, roomType.getPrice());
    }
}
