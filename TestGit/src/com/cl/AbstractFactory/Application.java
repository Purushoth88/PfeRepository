package com.cl.AbstractFactory;

public class Application
{
    public static void main(String[] args)
    {
        GUIFactory aFactory = GUIFactory.getFactory();
        Button aButton = aFactory.createButton();
        aButton.setCaption("Play");
        aButton.paint();
        
        
    }

    //output
    
    //is
    //I'm a WinButton: Play
    //or
    //I'm a OSXButton: Play
}