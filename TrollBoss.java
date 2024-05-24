import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TrollBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrollBoss extends Enemy
{
    private int rockRainSpawnDelayCounter = 200;
    private boolean rockRainSpawnOnCooldown = false;
    private boolean alreadyScreamed = false;
    GreenfootSound screamTrollBoss = new GreenfootSound("Troll_Boss_muere.mp3");
    /**
     * Act - do whatever the TrollBoss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
            if(enemyInvincible)
                enemyInvincibilityTimer();
        }
        else if(!isAlive && isBoss)
        {
            if(!alreadyScreamed)
                trollBossDeathScream();
        }
    }

    public void engage()
    {
        lockOnPlayer();
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

    public void lockOnPlayer()
    {
        if(isPlayerAtLeft)
            setImage("Troll_boss.png");
        else
        {
            setImage("Troll_boss.png");
            getImage().mirrorHorizontally();
        }
    }

    public void turnWhileWandering()
    {
        if(speed > 0)
            setImage("Troll_boss.png");
        else
        {
            setImage("Troll_boss.png");
            getImage().mirrorHorizontally();
        }
    }
    
    public void trollBossDeathScream()
    {
        screamTrollBoss.play();
        alreadyScreamed = true;
    }

    public void boss()
    {
        screamTrollBoss.setVolume(50);
        this.health = 1;
        isBoss = true;
    }
}