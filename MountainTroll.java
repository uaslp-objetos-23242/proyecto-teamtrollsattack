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
        }
    }

    public void engage()
    {
        spawnShockWaves();
        if(waveSpawnOnCooldown)
            waveSpawnDelay();
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
