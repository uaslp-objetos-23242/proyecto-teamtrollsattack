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
    private int jumpHeight = 100;
    // Gravedad del jugador
    private int gravity = 0;
    private int count = 0;
    // Variable para obligar al jugador a presionar cada que quiera saltar
    private boolean jumpPressed = false;
    public Player()
    {
        // Salud, daño causado, velocidad
        super(1,1,5);
        this.armorPoints = 0;
        this.expPoints = 0;
    }

    public void act()
    {
        nivelateOnFloor();
        increaseGravity();
        count++;
        slideAround();
        fall();
        jump();
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

    // El count y * 9 en gravity es para tratar de nivelar una caida lenta
    public void fall()
    {
        if(!isOnFloor() && count % 2 == 0)
            setLocation(getX(), getY() + gravity * 9);
        else
            gravity = 0;
    }
    // Saltarcal presionar espacio (aun falta una altura maxima de salto y momento cuando empieza a caer por gravedad)
    public void jump()
    {
        if(Greenfoot.isKeyDown("space") && !jumpPressed && isOnFloor())
        {
            setLocation(getX(), getY() - jumpHeight);
            jumpPressed = true;
        }
        if(!Greenfoot.isKeyDown("space"))
            jumpPressed = false;
    }

    // La gravedad solo afecta cuando no esta tocando el suelo y no puede ser mayor a 24
    public void increaseGravity()
    {
        if(gravity < 20 && !isOnFloor())
            gravity++;
    }

    //Nivela a todos al ras del suelo, heredado de forma abstracta de Entity
    public void nivelateOnFloor()
    {
        int x = getX();
        int y = getY();
        if(isOnFloor())
        {
            setLocation(x, y - gravity);
        }
    }

    // Ataca al presionar j
    public void attack()
    {
        if(Greenfoot.isKeyDown("j"))
        {
            //Ataca
        }
    }

    public int getGravity()
    {
        return this.gravity;
    }
}
