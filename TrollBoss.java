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
    private int rockRainSpawnDelayCounter = 200;
    private boolean rockRainSpawnOnCooldown = false;
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
            wander(100, 100, 200);
            getDamaged();  
        }
    }

    public void engage()
    {
        spawnSlash();
        if(rockRainSpawnOnCooldown)
            slashSpawnDelay();
    }
    
    public void spawnSlash()
    {
        if(!rockRainSpawnOnCooldown)
        {
            getWorld().addObject(new Rock(), getX(), getY() + getImage().getHeight()/2);
            getWorld().addObject(new Rock(), getX(), getY() + getImage().getHeight()/2);
            getWorld().addObject(new Rock(), getX(), getY() + getImage().getHeight()/2);
            rockRainSpawnOnCooldown = true;
        }
    }

    public void slashSpawnDelay()
    {
        rockRainSpawnDelayCounter--;
        if(rockRainSpawnDelayCounter == 0)
        {
            rockRainSpawnDelayCounter = 200;
            rockRainSpawnOnCooldown = false;
        }
    }
}