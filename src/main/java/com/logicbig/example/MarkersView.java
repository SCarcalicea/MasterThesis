package com.logicbig.example;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@Component
@ManagedBean
@RequestScoped
public class MarkersView implements Serializable {

    private MapModel simpleModel;
    private Marker marker;

    @PostConstruct
    public void init() {
        simpleModel = new DefaultMapModel();

        //Shared coordinates
        LatLng coord1 = new LatLng(45.73112968, 21.26176688);
        LatLng coord2 = new LatLng(45.73128785, 21.26178426);
        LatLng coord3 = new LatLng(45.73144714, 21.26169956);
        LatLng coord4 = new LatLng(45.73160808, 21.26147460);

        //Basic marker
        simpleModel.addOverlay(new Marker(coord1, "Plecare"));
        simpleModel.addOverlay(new Marker(coord2, "Statie 1"));
        simpleModel.addOverlay(new Marker(coord3, "Statie 2"));
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