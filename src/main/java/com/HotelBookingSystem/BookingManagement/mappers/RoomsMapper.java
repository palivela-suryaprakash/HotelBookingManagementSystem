package com.HotelBookingSystem.BookingManagement.mappers;

import com.HotelBookingSystem.BookingManagement.dto.RoomMtMDto;
import com.HotelBookingSystem.BookingManagement.dto.RoomsDto;
import com.HotelBookingSystem.BookingManagement.entity.Rooms;

public class RoomsMapper {
    public static RoomsDto RoomsToRoomsDto(Rooms rooms){
        if(rooms == null){
            return null;
        }
        RoomsDto roomDto = new RoomsDto();
        roomDto.setRoomNo(rooms.getRoomNo());
        roomDto.setRoomType(rooms.getRoomType());
        return roomDto;
    }
    public static Rooms RoomsDtoToRooms(RoomsDto roomsDto){
        if(roomsDto== null){
            return null;
        }
        Rooms rooms = new Rooms();
        rooms.setRoomNo(roomsDto.getRoomNo());
        rooms.setRoomType(roomsDto.getRoomType());
        return rooms;
    }

    public static RoomMtMDto RoomsToRoomMtMDto(Rooms rooms){
        if(rooms == null){
            return null;
        }
        RoomMtMDto roomMtMDto = new RoomMtMDto();
        roomMtMDto.setRoomNo(rooms.getRoomNo());
        roomMtMDto.setRoomType(rooms.getRoomType());
        return roomMtMDto;
    }
    public static Rooms RoomMtMDtoToRooms(RoomMtMDto roomMtMDto){
        if(roomMtMDto== null){
            return null;
        }
        Rooms rooms = new Rooms();
        rooms.setRoomNo(roomMtMDto.getRoomNo());
        rooms.setRoomType(roomMtMDto.getRoomType());
        return rooms;
    }

}
