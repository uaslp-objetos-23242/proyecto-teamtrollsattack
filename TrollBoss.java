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
    public TrollBoss(boolean isBoss)
    {
        super(6,1,5);
        if(isBoss)
            boss();
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
        debugHud();
    }

    public void engage()
    {
        spawnRockRain();
        if(rockRainSpawnOnCooldown)
            rockRainSpawnDelay();
    }

    public void spawnRockRain()
    {
        if(!rockRainSpawnOnCooldown)
        {
            if(isPlayerAtLeft)
            {
                getWorld().addObject(new Stalactite(), getX() - 100, getY() + getImage().getHeight() * -1);
                getWorld().addObject(new Stalactite(), getX() - 120, getY() + getImage().getHeight() * -1);
                getWorld().addObject(new Stalactite(), getX() - 140, getY() + getImage().getHeight() * -1);
                getWorld().addObject(new Stalactite(), getX() - 160, getY() + getImage().getHeight() * -1);
                getWorld().addObject(new Stalactite(), getX() - 180, getY() + getImage().getHeight() * -1);
                getWorld().addObject(new Stalactite(), getX() - 200, getY() + getImage().getHeight() * -1);
                rockRainSpawnOnCooldown = true;
            }
            else
            {
                getWorld().addObject(new Stalactite(), getX() + 100, getY() + getImage().getHeight() * -1);
                getWorld().addObject(new Stalactite(), getX() + 120, getY() + getImage().getHeight() * -1);
                getWorld().addObject(new Stalactite(), getX() + 140, getY() + getImage().getHeight() * -1);
                getWorld().addObject(new Stalactite(), getX() + 160, getY() + getImage().getHeight() * -1);
                getWorld().addObject(new Stalactite(), getX() + 180, getY() + getImage().getHeight() * -1);
                getWorld().addObject(new Stalactite(), getX() + 200, getY() + getImage().getHeight() * -1);
                rockRainSpawnOnCooldown = true;
            }
        }
    }

    public void rockRainSpawnDelay()
    {
        rockRainSpawnDelayCounter--;
        if(rockRainSpawnDelayCounter == 0)
        {
            rockRainSpawnDelayCounter = 200;
            rockRainSpawnOnCooldown = false;
        }
    }
    
        
    public void boss()
    {
        this.health = 12;
    }
}