package com.notes.util;

import com.notes.Main;

public class Resources {

    public static String getResource(String name){
        return String.valueOf(Main.class.getResource(name));
    }
}
