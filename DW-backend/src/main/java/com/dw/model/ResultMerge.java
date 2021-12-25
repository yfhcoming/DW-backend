package com.dw.model;

import java.util.HashMap;
import java.util.List;

public class ResultMerge {

    private long Time;
    private HashMap<String,List<String>> data;

    public ResultMerge(long time, HashMap<String, List<String>> data) {
        Time = time;
        this.data = data;
    }
}
