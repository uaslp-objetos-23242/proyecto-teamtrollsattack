import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlaceHonderEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlaceHolderEnemy extends Enemy
{
    /**
     * Act - do whatever the PlaceHonderEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public PlaceHolderEnemy()
    {
        super(1,1,5);
    }
    public void act()
    {
        setOriginalPosition();
        wander();
        debugHud();
    }
}
