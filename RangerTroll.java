import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RangerTroll here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RangerTroll extends Enemy
{
    /**
     * Act - do whatever the RangerTroll wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public RangerTroll()
    {
        super(1,1,1);
    }

    public void act()
    {
        setOriginalPosition();
        checkFalling();
        wander();
        checkForPlayerAtLeft();
        cambiaSprite();
        if(this.mun>0)
        {
            Dispara();
        }
        
        if(10000%10==0)
        {
            Recargar();
        }
    }

    public void engage()
    {

    }

    public void Dispara()
    {
        getWorld().addObject(new rock(), getX(), getY());
        mun --;
    }
    
    public void cambiaSprite()
    {
        if(isPlayerAtLeft==true)
        {
            setImage("Troll_ranger3.png");
        }
        else
        {
            setImage("Troll_ranger2.png");
        }
    }
}
