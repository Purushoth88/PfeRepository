package com.cl.AbstractFactory;

public class OSXButton extends Button {

	@Override
	public void paint() {
		System.out.println("I'm an OSXButton: "+ getCaption());

	}

}
