package com.unicamp.mc322.lab03.hotel;

import com.unicamp.mc322.lab03.utils.Address;

public class Hotel {

    public final int MAX_HOTEL_SIZE = 100;
    public final int DEFAULT_NUMBER_VIP_ROOMS = 10;
    public final RoomType DEFAULT_COMMON_ROOM_TYPE = RoomType.NOVIP_NOAIR_NOSMOKE;
    public final RoomType DEFAULT_VIP_ROOM_TYPE = RoomType.VIP_AIR_SMOKE;

    private int NUMBER_VIP_ROOMS;
    private int NUMBER_ROOMS;
    private final String name;
    private final String phone;
    private final Address address;
    private Room[] rooms;
    private int[] timeRoomIsReservedInDays;
    private int commonDaily;
    private int vipDaily;

    public Hotel (String name, String phone, Address address, int commonDaily, int vipDaily) throws Exception {
        if (name == null || phone == null || address == null)
            throw new Exception("Not a valid hotel!");

        if (commonDaily > vipDaily)
            throw new Exception("Normal daily must be cheaper then vip daily!");

        if (commonDaily <= 0)
            throw new Exception("Daily`s must be higher then 0 ...");

        this.name = name;
        this.phone = phone;
        this.address = address;
        this.commonDaily = commonDaily;
        this.vipDaily = vipDaily;
        this.NUMBER_VIP_ROOMS = DEFAULT_NUMBER_VIP_ROOMS;
        this.NUMBER_ROOMS = MAX_HOTEL_SIZE;
        this.rooms = new Room[NUMBER_ROOMS];
        this.timeRoomIsReservedInDays = new int[NUMBER_ROOMS];

        createRooms(DEFAULT_COMMON_ROOM_TYPE, DEFAULT_VIP_ROOM_TYPE);
    }

    public Hotel
            (String name, String phone, Address address, int commonDaily, int vipDaily,
             RoomType commonRoomType, RoomType vipRoomType, int numberOfCommonRooms, int numberOfVipRooms)
            throws Exception
    {
        this(name, phone, address, commonDaily, vipDaily);

        if (numberOfCommonRooms == 0 || numberOfVipRooms == 0)
            throw new Exception("Hotel must have common and vip rooms!");

        if (numberOfCommonRooms + numberOfVipRooms > MAX_HOTEL_SIZE)
            throw new Exception("Hotel max size is 100 rooms!");

        this.NUMBER_VIP_ROOMS = numberOfVipRooms;
        this.NUMBER_ROOMS = numberOfCommonRooms + numberOfVipRooms;
        this.rooms = new Room[NUMBER_ROOMS];
        this.timeRoomIsReservedInDays = new int[NUMBER_ROOMS];

        if (Room.roomTypeIsVip(commonRoomType) || !Room.roomTypeIsVip(vipRoomType))
            throw new Exception("Common room type must be common and vip room must be vip!");

        createRooms(commonRoomType, vipRoomType);
    }

    private void createRooms(RoomType commonRoomType, RoomType vipRoomType) {
        for (int i = 0; i < NUMBER_ROOMS; i++) {
            if (i < NUMBER_VIP_ROOMS)
                this.rooms[i] = new Room(vipRoomType);
            else
                this.rooms[i] = new Room(commonRoomType);
            timeRoomIsReservedInDays[i] = 0;
        }
    }

    public int getTimeRoomIsReserved(int roomNumber) {
        return timeRoomIsReservedInDays[roomNumber];
    }

    public boolean checkRoomIsAvailable(int number) {
        return rooms[number].isFree();
    }

    public int calculateStayPrice(int roomNumber, int days) {
        Room room = rooms[roomNumber];
        int daily;
        if (room.isVip())
            daily = vipDaily;
        else
            daily = commonDaily;
        return days * daily;
    }

    public boolean clientMatchRoom(int roomNumber, boolean smoker) {
        Room room = rooms[roomNumber];
        return room.canHaveSmokers() || !smoker;
    }

    public void reserveRoom(int roomNumber, int days) {
        rooms[roomNumber].reserve();
        timeRoomIsReservedInDays[roomNumber] = days;

    }

    public void finishReserve(int roomNumber) {
        rooms[roomNumber].free();
        timeRoomIsReservedInDays[roomNumber] = 0;
    }

    public void changeCommonDaily(int newCommonDaily) throws Exception {
        if (newCommonDaily > vipDaily)
            throw new Exception("Hotel common daily must be cheaper then vip daily!");

        commonDaily = newCommonDaily;
    }

    public void changeVipDaily(int newVipDaily) throws Exception {
        if (newVipDaily < commonDaily)
            throw new Exception("Hotel common daily must be cheaper then vip daily!");

        vipDaily = newVipDaily;
    }

    public int getNumberOfAvailableRooms() {
        int availableRooms = 0;
        for (int i = 0; i < NUMBER_ROOMS; i++)
            if (rooms[i].isFree())
                availableRooms++;
        return availableRooms;
    }

    public int getCommonDaily() {
        return  commonDaily;
    }

    public int getVipDaily() {
        return vipDaily;
    }

    public String getRoomsInformation() {
        return "## COMMON ROOM ##\n" + rooms[NUMBER_ROOMS - 1].getRoomInformation() + "\n" +
                "## * VIP * ROOM * ##\n" +
                rooms[NUMBER_VIP_ROOMS - 1].getRoomInformation() + "\n";
    }

    public String getAvailableRoomsInfo() {
        final String NEXT_LINE = "\n";
        StringBuilder formattedString = new StringBuilder("Common room daily - R$ " + commonDaily +
                NEXT_LINE + "Vip room daily - R$ " + vipDaily +
                NEXT_LINE + "Number of available rooms: " + getNumberOfAvailableRooms() +
                NEXT_LINE + "Available rooms: " + NEXT_LINE);
        for (int i = 0, nextLineCounter = 0; i < NUMBER_ROOMS; i++, nextLineCounter++) {
            if (nextLineCounter == 6 ) {
                formattedString.append(NEXT_LINE);
                nextLineCounter = 0;
            }
            if (rooms[i].isFree())
                formattedString.append(i).append(" ");
            else
                formattedString.append("  ");
        }
        return formattedString.toString();
    }

    public String getHotelInformation() {
        final String NEXT_LINE = "\n";
        return "Name: " + name +
                NEXT_LINE + "Phone: " + phone +
                NEXT_LINE + address.getAddressInformation();
    }

}
