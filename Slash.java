import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Slash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Slash extends Projectile
{
    /**
     * Act - do whatever the Slash wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    private boolean moveLeft;
    public Slash(boolean moveLeft)
    {
        this.moveLeft = moveLeft;
    }

    public void act()
    {
        setOriginalPosition();
        slashMovement();
        despawnSlash();
    }

    public void slashMovement()
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

    public void despawnSlash()
    {
        int maxDistance = 200;
        if(getX() == originalXPos - maxDistance || getX() == originalXPos + maxDistance || isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
}
