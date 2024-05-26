import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase representa una estalactita filosa, una instancia de Stalactite
 * 
 * @author Miguel Angel Enriquez Cisneros y Joaquin Manuel Trujillo Viveros
 * @version 1
 */
public class Stalactite extends Projectile
{
    public Stalactite(){}

    /**
     * Act - do whatever the Stalactite wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setOriginalPosition();
        checkFalling();
        despawnStalactite();
    }

    /**
     * Hace desaparecer las estalactitas
     */
    public void despawnStalactite()
    {
        int maxDistance = 50;
        if(getY() == getOriginalYPos() + maxDistance || isAtEdge() || isTouching(Floor.class))
        {
            getWorld().removeObject(this);
        }
    }
}
