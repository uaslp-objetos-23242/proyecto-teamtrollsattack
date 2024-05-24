import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase representa una onda de choque generada por golpear el suelo, una instancia de Shockwave
 * 
 * @author Miguel Angel Enriquez Cisneros y Joaquin Manuel Trujillo Viveros
 * @version 1
 */
public class Shockwave extends Projectile
{
    private boolean moveLeft;
    private boolean spriteSet = false;

    public Shockwave(boolean moveLeft)
    {
        this.moveLeft = moveLeft;
    }

    /**
     * Act - do whatever the Shockwave wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(!spriteSet)
            setSprites();
        setOriginalPosition();
        waveMovement();
        despawnWaves();
    }

    /**
     * Velocidad y direccion a la que se mueven las ondas de choque
     */
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

    /**
     * Pone las imagenes de forma coherente a su direccion
     */
    public void setSprites()
    {
        if(!moveLeft)
            getImage().mirrorHorizontally();
        spriteSet = true;
    }

    /**
     * Hace desaparecer las ondas de choque
     */
    public void despawnWaves()
    {
        int maxDistance = 200;
        if(getX() == originalXPos - maxDistance || getX() == originalXPos + maxDistance || isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }

    public void turnWhileWandering(){}
}
