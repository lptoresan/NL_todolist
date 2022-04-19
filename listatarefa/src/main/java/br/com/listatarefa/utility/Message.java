package br.com.listatarefa.utility;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Message {
	
	public static void okmsg(String message2) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, message2, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public static void erro(String message2) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, message2, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public static void warn(String message2) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, message2, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
}
