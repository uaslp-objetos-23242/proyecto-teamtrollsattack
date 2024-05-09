import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase engloba todos los metodos y variables que tienen en comun algunos actores
 * Principalmente Player y Enemy
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
    
    GreenfootSound covenantDance = new GreenfootSound("Covenant Dance.mp3");
    
    //Estado de la entidad, vivo o muerto, no creo se ocupe pero por si acaso
    protected boolean isAlive;

    public Entity(int health, int damageDealt, int speed)
    {
        this.health = health;
        this.damageDealt = damageDealt;
        this.speed = speed;
        this.isAlive = true;
    }

    public void act()
    {
        
    }

    /**
     * Reescala la imagen para hacerla mas pequeña
     */
    public void scaleDownImage(int horizontalScaleDown, int verticalScaleDown)
    {
        getImage().scale(getImage().getWidth()/horizontalScaleDown, getImage().getHeight()/verticalScaleDown);
    }

    /**
     * Reescala la imagen para hacerla mas grande
     */
    public void scaleUpImage(int horizontalScaleDown, int verticalScaleDown)
    {
        getImage().scale(getImage().getWidth() * horizontalScaleDown, getImage().getHeight() * verticalScaleDown);
    }

    /**
     * Nivela a todos al ras del suelo
     */
    public abstract void nivelateOnFloor();

    /**
     * Checa si el personaje esta tocando el suelo
     */
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
    
    public void playBackgroundMusic()
    {
        covenantDance.setVolume(30);
        covenantDance.playLoop();
    }

    /**
     * Muestra informacion oculta en pantalla para debugear
     */
    public abstract void debugHud();
}
