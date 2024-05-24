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
    private int slashSpawnDelayCounter = 130;
    private boolean slashSpawnOnCooldown = false;
    public TrollGeneral()
    {
        super(3,2,4);
    }

    public void act()
    {
        if(isAlive)
        {
            checkFalling();
            checkForPlayerAtLeft();
            wander(100, 100, 200);
            getDamaged();
            if(enemyInvincible)
                enemyInvincibilityTimer();
        }
    }

    public void engage()
    {
        lockOnPlayer();
        spawnSlash();
        if(slashSpawnOnCooldown)
            slashSpawnDelay();
    }

    public void lockOnPlayer()
    {
        if(isPlayerAtLeft)
            setImage("Troll_general.png");
        else
        {
            setImage("Troll_general.png");
            getImage().mirrorHorizontally();
        }
    }

    public void turnWhileWandering()
    {
        if(speed > 0)
            setImage("Troll_general.png");
        else
        {
            setImage("Troll_general.png");
            getImage().mirrorHorizontally();
        }
    }

    public void spawnSlash()
    {
        if(!slashSpawnOnCooldown)
        {
            if(isPlayerAtLeft)
                getWorld().addObject(new Slash(true), getX(), getY());
            else
                getWorld().addObject(new Slash(false), getX(), getY());
            slashSpawnOnCooldown = true;
        }
    }

    public void slashSpawnDelay()
    {
        slashSpawnDelayCounter--;
        if(slashSpawnDelayCounter == 0)
        {
            slashSpawnDelayCounter = 130;
            slashSpawnOnCooldown = false;
        }
    }
}
