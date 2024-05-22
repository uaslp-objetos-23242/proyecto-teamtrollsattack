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
    private int slashSpawnDelayCounter = 100;
    private boolean slashSpawnOnCooldown = false;
    public TrollGeneral()
    {
        super(3,2,5);
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
        if(slashSpawnOnCooldown)
            slashSpawnDelay();
    }
    
    public void spawnSlash()
    {
        if(!slashSpawnOnCooldown)
        {
            getWorld().addObject(new Slash(), getX(), getY());
            slashSpawnOnCooldown = true;
        }
    }

    public void slashSpawnDelay()
    {
        slashSpawnDelayCounter--;
        if(slashSpawnDelayCounter == 0)
        {
            slashSpawnDelayCounter = 100;
            slashSpawnOnCooldown = false;
        }
    }
}
