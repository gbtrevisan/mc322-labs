package com.unicamp.mc322.lab03.hotel;

public class Room {

    private boolean vip;
    private boolean reserved;
    private boolean airConditioning;
    private boolean acceptSmokers;

    public Room(RoomType roomType) {
        switch (roomType) {
            case NOVIP_NOAIR_NOSMOKE:
                setRoomSpecifications(false, false , false);
                break;

            case NOVIP_NOAIR_SMOKE:
                setRoomSpecifications(false, false, true);
                break;

            case NOVIP_AIR_NOSMOKE:
                setRoomSpecifications(false, true, false);
                break;

            case NOVIP_AIR_SMOKE:
                setRoomSpecifications(false, true ,true);
                break;

            case VIP_NOAIR_NOSMOKE:
                setRoomSpecifications(true, false , false);
                break;

            case VIP_NOAIR_SMOKE:
                setRoomSpecifications(true, false, true);
                break;

            case VIP_AIR_NOSMOKE:
                setRoomSpecifications(true, true, false);
                break;

            case VIP_AIR_SMOKE:
                setRoomSpecifications(true, true, true);
                break;
        }
    }

    private void setRoomSpecifications(boolean vip, boolean airConditioning, boolean acceptSmokers) {
        this.vip = vip;
        this.airConditioning = airConditioning;
        this.acceptSmokers = acceptSmokers;
    }

    public static boolean roomTypeIsVip(RoomType roomType) {
        Room room = new Room(roomType);
        return room.vip;
    }

    public boolean isVip() {
        return vip;
    }

    public boolean isReserved() {
        return reserved;
    }

    public boolean isFree() {
        return !reserved;
    }

    public void reserve() {
        reserved = true;
    }

    public void free() {
        reserved = false;
    }

    public boolean haveAirConditioning() {
        return airConditioning;
    }

    public boolean canHaveSmokers() {
        return acceptSmokers;
    }

    public String getRoomInformation() {
        StringBuilder formattedString = new StringBuilder("VIP: ");
        if (vip)
            formattedString.append("YES");
        else
            formattedString.append("NO");
        formattedString.append("\nAir conditioning: ");
        if (airConditioning)
            formattedString.append("YES");
        else
            formattedString.append("NO");
        formattedString.append("\nAccept smokers: ");
        if (acceptSmokers)
            formattedString.append("YES");
        else
            formattedString.append("NO");
        return formattedString.toString();
    }

}
