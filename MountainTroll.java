import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MountainTroll here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MountainTroll extends Enemy
{
    /**
     * Act - do whatever the MountainTroll wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int waveSpawnDelayCounter = 150;
    private boolean waveSpawnOnCooldown = false;
    public MountainTroll()
    {
        super(5,3,1);
    }

    public void act()
    {
        if(isAlive)
        {
            checkFalling();
            checkForPlayerAtLeft();
            wander(200, 200, 200);
            getDamaged();
            if(enemyInvincible)
                enemyInvincibilityTimer();
        }
    }

    public void engage()
    {
        lockOnPlayer();
        spawnShockWaves();
        if(waveSpawnOnCooldown)
            waveSpawnDelay();
    }
    
    public void lockOnPlayer()
    {
        if(isPlayerAtLeft)
            setImage("Mountain_Troll.png");
        else
        {
            setImage("Mountain_Troll.png");
            getImage().mirrorHorizontally();
        }
    }

    public void turnWhileWandering()
    {
        if(speed > 0)
            setImage("Mountain_Troll.png");
        else
        {
            setImage("Mountain_Troll.png");
            getImage().mirrorHorizontally();
        }
    }

    public void spawnShockWaves()
    {
        if(!waveSpawnOnCooldown)
        {
            getWorld().addObject(new Shockwave(true), getX(), getY() + getImage().getHeight()/2 - 20);
            getWorld().addObject(new Shockwave(false), getX(), getY() + getImage().getHeight()/2 - 20);
            waveSpawnOnCooldown = true;
        }
    }

    public void waveSpawnDelay()
    {
        waveSpawnDelayCounter--;
        if(waveSpawnDelayCounter == 0)
        {
            waveSpawnDelayCounter = 150;
            waveSpawnOnCooldown = false;
        }
    }
}
