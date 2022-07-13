package com.logicbig.views;

import com.logicbig.model.Bus;
import com.logicbig.model.Routes;
import com.logicbig.repository.BussesRepository;
import com.logicbig.service.BusService;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.*;
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
public class VehicleMarkerView implements Serializable {

    private MapModel simpleModel;
    @Autowired
    private BusService busService;
    @Autowired
    private BussesRepository bussesRepository;

    @PostConstruct
    public void init() {
        simpleModel = new DefaultMapModel();

        List<Routes> busLocation = simulateRealData(busService.getBusLocation());

        if (busLocation != null) {
            for (Routes route : busLocation) {
                LatLng coordinate = new LatLng(route.getLat(), route.getLon());

                Circle circle1 = new Circle(coordinate, 30);
                circle1.setStrokeColor("#000000");
                circle1.setFillColor("#000000");
                circle1.setData(route.id);
                circle1.setFillOpacity(1);

                simpleModel.addOverlay(circle1);
            }
        }
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public void onCircleSelect(OverlaySelectEvent event) {
        Circle circle = (Circle) event.getOverlay();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bus E2 selected", circle.getData().toString()));
    }

    public List<Routes> simulateRealData(List<Routes> busLocation) {
        ServerCommunicationNotification.serverIsNotReachable = true;
        if (busLocation == null) {
            busLocation = new ArrayList<>();
            List<Bus> dummyBusLocation = bussesRepository.findAll();
            for (Bus bus : dummyBusLocation) {
                Routes route = Routes.builder()
                        .id(bus.get_id())
                        .lat(bus.getLatitude())
                        .lon(bus.getLongitude())
                        .name(bus.getName()).build();
                busLocation.add(route);
            }
        }
        return busLocation;
    }
}