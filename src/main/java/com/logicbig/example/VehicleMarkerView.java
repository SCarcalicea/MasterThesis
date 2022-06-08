package com.logicbig.example;

import com.logicbig.model.Routes;
import com.logicbig.service.BusService;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.*;
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
public class VehicleMarkerView implements Serializable {

    private MapModel simpleModel;
    private Marker marker;

    @Autowired
    private BusService busService;

    @PostConstruct
    public void init() {
        simpleModel = new DefaultMapModel();

        List<Routes> busLocation = busService.getBusLocation();

        if (busLocation != null) {
            for (Routes route : busLocation) {
                LatLng coordinate = new LatLng(route.getLat(), route.getLon());

                Circle circle1 = new Circle(coordinate, 20);
                circle1.setStrokeColor("#4f284b");
                circle1.setFillColor("#4f284b");
                circle1.setFillOpacity(0.5);

                simpleModel.addOverlay(circle1);
            }
        }
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public void onCircleSelect(OverlaySelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bus E2 selected", null));
    }

    public Marker getMarker() {
        return marker;
    }
}