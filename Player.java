import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Entity
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    // Sobreescudo que tiene al entrar a una nueva sala
    private int armorPoints;
    // Puntos de experiencia para mejorar sus atributos
    private int expPoints;
    // Altura maxima que puede saltar
    private int jumpHeight = 10;
    public Player()
    {
        // Salud, daño causado, velocidad
        super(1,1,5);
        this.armorPoints = 0;
        this.expPoints = 0;
    }

    public void act()
    {
        slideAround();
        jump();
        nivelateOnFloor();
    }

    // Movimiento casual, izquierda y derecha
    public void slideAround()
    {
        int x = getX();
        int y = getY();
        if(Greenfoot.isKeyDown("d"))
        {
            setLocation(x + speed, y);
            // Hay que hacerlo girar a la derecha
        }
        if(Greenfoot.isKeyDown("a"))
        {
            setLocation(x - speed, y);
            // Hay que hacerlo girar a la izquierda
        }
    }

    // Saltarcal presionar espacio (aun falta una altura maxima de salto y momento cuando empieza a caer por gravedad)
    public void jump()
    {
        int x = getX();
        int y = getY();
        int i;
        for(i = 0; i < jumpHeight && Greenfoot.isKeyDown("space"); i++)
        {
            setLocation(x, y--);
            sleepFor(5);
        }
        sleepFor(10);
    }

    // Ataca al presionar j
    public void attack()
    {
        if(Greenfoot.isKeyDown("j"))
        {
            //Ataca
        }
    }
}
