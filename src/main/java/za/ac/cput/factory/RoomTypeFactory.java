/*
RoomTypeFactory.java
RoomType Factory class
Author: Moegamat Zaihd Behardien (219233829)
Date: 23 March 2024
*/
package za.ac.cput.factory;

import za.ac.cput.domain.RoomType;
public class RoomTypeFactory
{
    public static RoomType createRoomType(Long id, String name, double price)
    {
        RoomType roomType = new RoomType();
        roomType.setId(id);
        roomType.setName(name);
        roomType.setPrice(price);
        return roomType;
    }
}
