import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Entity
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //Si es jefe, tebdra atributos especiales como daño y vida aumentados
    private boolean isBoss;
    public Enemy(int health, int damageDealt, int speed)
    {
        // Salud, daño causado, velocidad
        super(health,damageDealt,speed);
    }

    public void act()
    {
        // Add your action code here.
    }

    public void slideAround()
    {
        int x = getX();
        int y = getY();
        setLocation(x + speed, y);
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
}
