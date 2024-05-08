import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Enemy extends Entity
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //Si es jefe, tebdra atributos especiales como daño y vida aumentados
    private boolean isBoss;

    protected boolean isPlayerInSight = false;

    private int originalXPos = -1;
    private int originalYPos = -1;

    public Enemy(int health, int damageDealt, int speed)
    {
        // Salud, daño causado, velocidad
        super(health,damageDealt,speed);
    }

    public void act()
    {
        // Add your action code here.
    }

    public void wander()
    {
        lookingForPlayer();
        if(!isPlayerInSight)
        {
            setLocation(getX() + speed, getY());
            if(getX() == originalXPos - 100 || getX() == originalXPos + 100)
            {
                speed *= -1;
            }
            setRotation(0);
        }
        else
            engage();
    }
    
    public abstract void engage();

    public void lookingForPlayer()
    {
        if(playerIsNearby())
            isPlayerInSight = true;
        else 
            isPlayerInSight = false;
    }

    public boolean playerIsNearby()
    {
        return !getObjectsInRange(200, Player.class).isEmpty();
    }

    public void setOriginalPosition()
    {
        if(originalXPos == -1 || originalYPos == -1)
        {
            originalXPos = getX();
            originalYPos = getY();
        }

    }

    //Nivela a todos al ras del suelo, heredado de Entity
    public void nivelateOnFloor()
    {
        int x = getX();
        int y = getY();
        if(isOnFloor())
        {
            setLocation(x, y - 1);
        }
    }

    public void despawnOnDeath()
    {
        if(getHealth() <= 0)
        {

        }
    }

    public void debugHud()
    {
        getWorld().showText("X pos: " + getX(), 700, 50);
        getWorld().showText("Y pos: " + getY(), 700, 70);
        getWorld().showText("Player nerby: " + playerIsNearby(), 700, 90);
    }
    
}
