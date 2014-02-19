package com.cl.AbstractFactory;

public class WinButton extends Button {

	@Override
	public void paint() {
		 System.out.println("I'm a WinButton: "+ getCaption());

	}

}
