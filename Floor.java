import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor extends Actor
{
    /**
     * Act - do whatever the Floor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    // El suelo sirve para nivelar a los personajes
    public Floor()
    {
        getImage().scale(getImage().getWidth()*6, getImage().getHeight()/3);
    }

    public void act()
    {
        // Add your action code here.
    }
}
