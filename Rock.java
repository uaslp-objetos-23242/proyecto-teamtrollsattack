import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase representa una piedra para dañar al jugador, una instancia de Rock
 * 
 * @author Miguel Angel Enriquez Cisneros y Joaquin Manuel Trujillo Viveros
 * @version 1
 */
public class Rock extends Projectile
{
    private boolean lanzada;
    private boolean checkDir=false;
    public Rock(){}

    /**
     * Act - do whatever the rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        check();
        Movimiento();
    }

    /**
     * Direccion y velocidad del proyectil
     */
    public void Movimiento()
    {
        if (getIsPlayerAtLeft())
        {    
            //setRotation(180);
            move(-10);
        }
        else
        {
            move(10);
        }

        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }  

    public void check()
    {
        if (!checkDir)
        {
            checkForPlayerAtLeft();
            checkDir=true;
        }
    }
}
