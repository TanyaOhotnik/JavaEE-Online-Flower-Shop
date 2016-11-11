package com.mkr.entities;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@ManagedBean(name="mobile")
@SessionScoped
@FacesValidator("mobileValidator")
public class Mobile implements Validator {

	private String mno;

	public String getMno() {
		return mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	int maximumlength = 6;

	public Mobile() {
	}

	@Override
	public void validate(FacesContext fc, UIComponent uic, Object obj)
			throws ValidatorException {

		String model = (String) obj;

		if (model.length() > 6) {
			FacesMessage msg = new FacesMessage(" Maximum Length of 6 is exceeded.Please enter values within range");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);

			throw new ValidatorException(msg);
		}

	}

}