import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase representa un corte con una espada, una instancia de Slash
 * 
 * @author Miguel Angel Enriquez Cisneros y Joaquin Manuel Trujillo Viveros
 * @version 1
 */
public class Slash extends Projectile
{
    private boolean moveLeft;
    private boolean spriteSet = false;
    public Slash(boolean moveLeft)
    {
        this.moveLeft = moveLeft;
    }

    /**
     * Act - do whatever the Slash wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(!spriteSet)
            setSprites();
        setOriginalPosition();
        slashMovement();
        despawnSlash();
    }

    /**
     * Realiza el movimiento del corte
     */
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

    /**
     * Hace desaparecer los cortes
     */
    public void despawnSlash()
    {
        int maxDistance = 200;
        if(getX() == originalXPos - maxDistance || getX() == originalXPos + maxDistance || isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }

    /**
     * Pone las imagenes de forma coherente a su direccion
     */
    public void setSprites()
    {
        if(moveLeft)
            getImage().mirrorHorizontally();
        spriteSet = true;
    }

    public void turnWhileWandering(){}
}
