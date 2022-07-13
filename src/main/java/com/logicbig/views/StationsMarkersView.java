package com.logicbig.views;

import com.logicbig.model.Routes;
import com.logicbig.model.Stations;
import com.logicbig.repository.StationsRepository;
import com.logicbig.service.BusService;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ManagedBean
@ApplicationScoped
public class StationsMarkersView implements Serializable {

    private MapModel simpleModel;
    private Marker marker;

    @Autowired
    private BusService busService;

    @Autowired
    private StationsRepository stationsRepository;

    @PostConstruct
    public void init() {
        simpleModel = new DefaultMapModel();

        List<Routes> routes = simulateRealData(busService.getRoutes());

        //Shared coordinates
        for (int i = 0; i < routes.size(); i++) {
            Routes route = routes.get(i);
            LatLng coordinate = new LatLng(route.getLat(), route.getLon());
            simpleModel.addOverlay(new Marker(coordinate, route.getName()));
        }
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "E2 Station Selected", marker.getTitle()));
    }

    public Marker getMarker() {
        return marker;
    }

    public List<Routes> simulateRealData(List<Routes> busLocation) {
        ServerCommunicationNotification.serverIsNotReachable = true;
        if (busLocation.size() == 1 && busLocation.get(0).getId().equalsIgnoreCase("default")) {
            busLocation = new ArrayList<>();
            List<Stations> dummyStationsLocation = stationsRepository.findAll();
            for (Stations station : dummyStationsLocation) {
                Routes route = Routes.builder()
                        .id(station.get_id())
                        .lat(station.getLatitude())
                        .lon(station.getLongitude())
                        .name(station.getName()).build();
                busLocation.add(route);
            }
        }
        return busLocation;
    }
}