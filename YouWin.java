import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class YouWin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YouWin extends World
{

    GreenfootSound v = new GreenfootSound("Victory.mp3");
    /**
     * Constructor for objects of class YouWin.
     * 
     */
    public YouWin()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        prepare();
        v.setVolume(50);
    }
    
    public void act()
    {
        v.play();
    }
    
    public void prepare()
    {
        showText("Victoria, la humanidad ha ganado.", getWidth()/2, getHeight()/2 - 200);
    }
}
