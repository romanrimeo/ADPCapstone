/*
RoomTypeFactoryTest.java
RoomTypeFactoryTest class
Author: Moegamat Zaihd Behardien (219233829)
Date: 23 March 2024
*/
package za.ac.cput.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.RoomType;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTypeFactoryTest
{
    @Test
    void buildRoomType() {
        RoomType rt = RoomTypeFactory.createRoomType(1021513L, "Eric", 6.2);
        RoomType rt2 = rt;

        assertNotNull(rt);
        assertEquals(rt, rt2);
    }

    @Test
    void missingDetails()
    {
        RoomType rt = RoomTypeFactory.createRoomType(213L, "John", 53);
        assertNull(rt);
    }

    @Test
    void buildGenerateId()
    {
        RoomType rt = RoomTypeFactory.createRoomType(315135L, "Bruce",32);
        RoomType rt2 = rt;

        assertNull(rt);
        assertEquals(rt,rt2);
    }

}
