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
        //scaleDownImage(2, 2);
    }

    public void act()
    {
        if(isAlive)
        {
            setOriginalPosition();
            checkFalling();
            getDamaged();
            wander(50,50,500);
            checkForPlayerAtLeft();
            cambiaSprite();
            debugHud();
        }
    }

    public void engage()
    {
        if(this.mun>0)
        {
            Dispara();
        }

        if(10000%10==0)
        {
            Recargar();
        }
    }

    public void Dispara()
    {
        getWorld().addObject(new Rock(), getX(), getY());
        mun --;
    }

    public void cambiaSprite()
    {
        if(isPlayerAtLeft==true && isPlayerInSight)
        {
            setImage("Troll_ranger3.png");
            //scaleDownImage(2, 2);
        }
        else
        {
            setImage("Troll_ranger3.png");
            getImage().mirrorHorizontally();
            //scaleDownImage(2, 2);
        }
    }
}
