package com.kirin.springmvcangularjs.service;

import java.util.List;

import com.kirin.springmvcangularjs.beans.RailwayStation;


public interface RailwayStationService {
	
    public List<RailwayStation> getAllRailwayStations();

    public RailwayStation getRailwayStationById(Long id);

    public void addRailwayStation(RailwayStation RailwayStation);

    public void deleteRailwayStationById(Long id);

    public void deleteAll();

    public void updateRailwayStation(RailwayStation RailwayStation);
}
