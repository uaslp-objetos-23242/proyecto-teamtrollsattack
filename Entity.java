import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Entity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Entity extends Actor
{
    /**
     * Act - do whatever the Entity wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    //La entidad unifica aspectos que todos comparte como salud, daño y velocidad, obvio varia por personaje
    protected int health;
    protected int damageDealt;
    protected int speed;

    public Entity(int health, int damageDealt, int speed)
    {
        this.health = health;
        this.damageDealt = damageDealt;
        this.speed = speed;
    }

    public void act()
    {

    }
    
    public void scaleDownImage(int horizontalScaleDown, int verticalScaleDown)
    {
        getImage().scale(getImage().getWidth()/horizontalScaleDown, getImage().getHeight()/verticalScaleDown);
    }
    
    public void scaleUpImage(int horizontalScaleDown, int verticalScaleDown)
    {
        getImage().scale(getImage().getWidth() * horizontalScaleDown, getImage().getHeight() * verticalScaleDown);
    }

    //Nivela a todos al ras del suelo
    public abstract void nivelateOnFloor();

    //Checa si el personaje esta tocando el suelo
    public boolean isOnFloor()
    {
        if(isTouching(Floor.class))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //Regresa la salud
    public int getHealth()
    {
        return this.health;
    }
    
    public void setHealth()
    {
        this.health--;
    }

    //Metodo abstracto para moverse
    public abstract void slideAround();
}
