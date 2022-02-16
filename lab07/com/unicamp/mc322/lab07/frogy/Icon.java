package com.unicamp.mc322.lab07.frogy;

import java.util.Objects;

public class Icon {

    public final int ICON_MAX_SIZE = 3;

    private final String icon;

    Icon(String icon) {
        Objects.requireNonNull(icon, "icon");

        if (icon.length() > ICON_MAX_SIZE) throw new RuntimeException("Icon max size is 3!");

        this.icon = icon;
    }

    @Override
    public String toString() {
        return icon;
    }

}
