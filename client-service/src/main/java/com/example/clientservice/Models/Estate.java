package com.example.clientservice.Models;


import com.example.clientservice.Enums.EstateAddress;
import com.example.clientservice.Enums.EstateBuilding;
import com.example.clientservice.Enums.EstateDistrict;
import com.example.clientservice.Enums.EstateRooms;

import java.util.UUID;

public final class Estate {
    private String id;
    private EstateDistrict district;
    private EstateAddress address;
    private EstateBuilding building;
    private EstateRooms rooms;
    private int price;

    public Estate(EstateDistrict district, EstateAddress address, EstateBuilding building, EstateRooms rooms, int price) {
        this.district = district;
        this.address = address;
        this.building = building;
        this.rooms = rooms;
        this.price = price;
    }

    public Estate() {

    }

    public String getId() {
        return id;
    }

    public EstateDistrict getDistrict() {
        return district;
    }

    public EstateAddress getAddress() {
        return address;
    }

    public EstateBuilding getBuilding() {
        return building;
    }

    public EstateRooms getRooms() {
        return rooms;
    }


    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return district + " " + address + " with " + rooms + ". Price: " + price + ". Estate Id: " + id;
    }

}