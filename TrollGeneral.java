import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TrollGeneral here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrollGeneral extends Enemy
{
    /**
     * Act - do whatever the TrollGeneral wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public TrollGeneral()
    {
        super(3,2,3);
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
