import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InvisibleWall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InvisibleWall extends Actor
{
    /**
     * Act - do whatever the InvisibleWall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean turnBlocksInvisible = true;
    public void act()
    {
        // Add your action code here.
    }
    
    public void turnInvisible()
    {
        getImage().setTransparency(0);
    }
}
