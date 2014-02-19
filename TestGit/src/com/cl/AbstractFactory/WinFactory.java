package com.cl.AbstractFactory;

class WinFactory extends GUIFactory
{
    public Button createButton()
    {
        return(new WinButton());
    }
}