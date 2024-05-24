import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main extends World
{

    MainMenuButtons mmb = new MainMenuButtons();
    /**
     * Constructor for objects of class Main.
     * 
     */
    public Main()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640, 409, 1);
        prepare();
    }
    
    public void prepare()
    {
        addObject(mmb, 0, 0);
        showText("Presiona espacio para iniciar", getWidth()/2, getHeight()/2);
    }
}
