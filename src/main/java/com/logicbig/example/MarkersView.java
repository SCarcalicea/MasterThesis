package com.logicbig.example;

import com.logicbig.model.Routes;
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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@Component
@ManagedBean
@RequestScoped
public class MarkersView implements Serializable {

    private MapModel simpleModel;
    private Marker marker;

    @Autowired
    private BusService busService;

    @PostConstruct
    public void init() {
        simpleModel = new DefaultMapModel();

        List<Routes> routes = busService.getRoutes();

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

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Selected", marker.getTitle()));
    }

    public Marker getMarker() {
        return marker;
    }
}