import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shockwave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shockwave extends Projectile
{
    /**
     * Act - do whatever the Shockwave wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean moveLeft;

    public Shockwave(boolean moveLeft)
    {
        this.moveLeft = moveLeft;
    }

    public void act()
    {
        setOriginalPosition();
        waveMovement();
        despawnWaves();
    }

    public void waveMovement()
    {
        if(moveLeft)
        {    
            move(-3);
        }
        else
        {
            move(3);
        }
    }

    public void despawnWaves()
    {
        if(getX() == originalXPos - 300 || getX() == originalXPos + 300 || isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
}
