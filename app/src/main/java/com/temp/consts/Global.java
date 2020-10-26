package com.temp.consts;

import com.temp.dao.PersonInfo;

/**
 *
 */
public class Global {


    private static PersonInfo currentPerson;

    public static void setCurrentPerson(PersonInfo person) {
        currentPerson = person;
    }

    public static PersonInfo getCurrentPerson() {
        return currentPerson;
    }
}
