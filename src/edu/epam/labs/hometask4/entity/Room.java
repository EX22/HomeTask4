package edu.epam.labs.hometask4.entity;

import java.util.ArrayList;

/**
 * Game room, container for toys.
 */
public class Room {

    private RoomConfig roomConfig;
    private ArrayList<Toy> toyArrayList;

    public Room(RoomConfig roomConfig, ArrayList<Toy> toyArrayList) {
        this.roomConfig = roomConfig;
        this.toyArrayList = toyArrayList;
    }

    public RoomConfig getRoomConfig() {
        return roomConfig;
    }

    public void setRoomConfig(RoomConfig roomConfig) {
        this.roomConfig = roomConfig;
    }

    public ArrayList<Toy> getToyArrayList() {
        return toyArrayList;
    }

    public void setToyArrayList(ArrayList<Toy> toyArrayList) {
        this.toyArrayList = toyArrayList;
    }
}
