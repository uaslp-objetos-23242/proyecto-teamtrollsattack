import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Story here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Story extends World
{

    /**
     * Constructor for objects of class Story.
     * 
     */
    public Story()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(411, 410, 1);
        prepare();
    }
    
    public void prepare()
    {
        showText("El rey de los trolls quiere conquistar la tierra ", getWidth()/2, getHeight()/2 -150);
        showText("de los humanos y romper el pacto de paz.", getWidth()/2, getHeight()/2 - 100);
        showText("Los humanos se enteran de esto y", getWidth()/2, getHeight()/2 - 50);
        showText("antes de que salgan a la superficie,", getWidth()/2, getHeight()/2);
        showText("nuestro heroe baja a acabar", getWidth()/2, getHeight()/2 + 50);
        showText("con el rey de los trolls.", getWidth()/2, getHeight()/2 + 100);
        showText("Presiona enter para iniciar", getWidth()/2, getHeight()/2 + 180);
    }
    
    public void addControl(MainMenuButtons mmb)
    {
        addObject(mmb, 0, 0);
    }
}
