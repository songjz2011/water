package com.trains.domain;

import java.util.List;

import com.trains.util.StringUtil;

public class TrainStation {

    private String name;

    private List<AdjacentStation> adjacentStationList;

    public Integer getAdjacentStationDistance(String adjacentStationName) {
        Integer distance = null;
        List<AdjacentStation> adjacentStationList = getAdjacentStationList();
        if (StringUtil.isEmpty(adjacentStationName) || adjacentStationList == null) {
            return distance;
        }
        for (AdjacentStation train : adjacentStationList) {
            if (adjacentStationName.equals(train.getName())) {
                distance = train.getDistance();
                break;
            }
        }
        return distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AdjacentStation> getAdjacentStationList() {
        return adjacentStationList;
    }

    public void setAdjacentStationList(List<AdjacentStation> adjacentStationList) {
        this.adjacentStationList = adjacentStationList;
    }

}
