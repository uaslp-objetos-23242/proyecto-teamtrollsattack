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
     * Inicia el combate con el jugador, cada subclase de enemigo ataca diferente
     */
    public void engage()
    {

    }

    /**
     * Direccion y velocidad del proyectil
     */
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

    public void turnWhileWandering(){}
}
