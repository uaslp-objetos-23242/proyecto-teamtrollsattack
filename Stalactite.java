import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stalactite here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stalactite extends Projectile
{
    /**
     * Act - do whatever the Stalactite wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Stalactite(){}

    public void act()
    {
        setOriginalPosition();
        checkFalling();
        despawnWaves();
    }

    public void despawnWaves()
    {
        int maxDistance = 50;
        if(getY() == originalYPos + maxDistance || isAtEdge() || isTouching(Floor.class))
        {
            getWorld().removeObject(this);
        }
    }
}
