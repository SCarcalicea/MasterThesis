package com.logicbig.views;

import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@Component
@ManagedBean
@ApplicationScoped
public class ServerCommunicationNotification {

    public static boolean serverIsNotReachable = false;

   private boolean systemStatus;

    public void onIdle() {
        if (serverIsNotReachable) {
            FacesContext.getCurrentInstance().
                    addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Public API is not reachable"));
        }
    }

    public void onActive() {
        if (serverIsNotReachable) {
            FacesContext.getCurrentInstance().
                    addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Public API is not reachable"));
        }
    }

    public boolean getSystemStatus() {
        return !serverIsNotReachable;
    }

    public void setSystemStatus(boolean systemStatus) {
        this.systemStatus = !serverIsNotReachable;
    }
}
