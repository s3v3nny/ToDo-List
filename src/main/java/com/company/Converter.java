package com.company;

import java.util.ArrayList;

interface Converter {
    public ArrayList<Tasks> fromString(String FileString);

    public String asString(ArrayList<Tasks> tasksList);
}
