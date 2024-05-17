import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Projectile
{
    /**
     * Act - do whatever the rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean lanzada;
    private boolean checkDir=false;

    public Rock()
    {
        
    }

    public void act()
    {
        check();
        Movimiento();
    }

    public void engage()
    {
        
    }
    
    public void Movimiento()
    {
        if (isPlayerAtLeft==true)
        {    
            //setRotation(180);
            move(-10);
        }
        else
        {
            move(10);
        }
        
        if(isAtEdge()==true)
        {
            getWorld().removeObject(this);
        }
    }  
    
    public void check()
    {
        if (checkDir==false)
        {
            checkForPlayerAtLeft();
            checkDir=true;
        }
    }
}
