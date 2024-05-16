import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TrollBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrollBoss extends Enemy
{
    /**
     * Act - do whatever the TrollBoss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public TrollBoss()
    {
        super(3,1,5);
    }

    public void act()
    {
        if(isAlive)
        {
            checkFalling();
            checkForPlayerAtLeft();
            wander(200, 200, 200);
            getDamaged();  
        }
    }

    public void engage()
    {

    }
}
