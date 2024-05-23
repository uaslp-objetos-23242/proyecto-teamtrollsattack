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
    private int jumpHeight = -20;
    // Gravedad del jugador
    private int gravity = 0;
    // Sirve para llevar un flujo mas manejable de la gravedad y algunos temporizadores
    private int count = 0;
    // Frames antes de poder volver a atacar
    private int attackDelayTimer = 20;
    // Obligar al jugador a soltar el boton de salto para volver a saltar
    private boolean jumpPressed = false;
    // Determina si se puede atacar o no
    private boolean attackOnCooldown = false;
    // Obliga a que el jugador suelte el boton de ataque para volver a atacar
    private boolean attackPressed = false;
    // Inicia el contador de frames de ataque
    private boolean attackAnimation = false;
    // Frames que dura la animacion de ataque
    private int attackFrames = 10;
    // Estado de invencibilidad del jugador
    private boolean playerInvincible = false;
    // Tiempo que el jugador es invencile despues de recibir da�o
    private int invincibilityFrames = 60;
    // Estado de uso del escudo
    private boolean usingShield = false;
    // Checa la direccio que el personaje esta viendo, sirve para la direccion de los sprites
    private boolean facingLeft = false;
    // Guarda y muestra el numero de mundo en el que se encuentra
    private int actualWorld = 1;
    // Mundos por si se ocupa algo
    World1 w1 = new World1();
    World2 w2 = new World2();
    World3 w3 = new World3();
    World4 w4 = new World4();
    WorldFinal w5 = new WorldFinal();
    /**
     * Pos el constructor, que mas xd
     */
    public Player()
    {
        // Salud, da�o causado, velocidad
        super(3,1,5);
        this.armorPoints = 2;
        this.expPoints = 0;
        scaleDownImage(4, 4);
    }

    public void act()
    {
        //playBackgroundMusic();
        checkFalling();
        debugHud();
        hud();
        count++;
        slideAround();
        attack();
        useShield();
        if(playerInvincible)
            invincibilityTimer();
        reduceHealth();
        if(attackAnimation)
            playAttackAnimation();
        if(attackOnCooldown)
            attackDelay();
        changeWorld();
    }

    /**
     * Movimiento casual, izquierda, derecha y ademas saltar
     * Obtiene la posicion del personaje y le agrega o resta valor a x para moverse
     */
    public void slideAround()
    {
        int x = getX();
        int y = getY();
        if(Greenfoot.isKeyDown("d") && !usingShield && !attackAnimation)
        {
            setLocation(x + speed, y);
            facingLeft = false;
            moveAnimation();
        }
        if(Greenfoot.isKeyDown("a") && !usingShield && !attackAnimation)
        {
            setLocation(x - speed, y);
            facingLeft = true;
            moveAnimation();
        }
        if(Greenfoot.isKeyDown("space") && !usingShield && !attackAnimation && !jumpPressed && onGround())
        {
            vSpeed = jumpHeight;
            fall();
            jumpPressed = true;
        }
        if(!Greenfoot.isKeyDown("space"))
        {
            jumpPressed = false;
        }
    }

    /**
     * Ataca al presionar j
     * Solo puede atacar si no esta en cooldown, se solto la tecla despues del ataque anterior y la animacion de ataque ya acabo
     */
    public void attack()
    {
        if(Greenfoot.isKeyDown("j") && !attackOnCooldown && !attackPressed && !attackAnimation && onGround())
        {
            if(facingLeft)
            {
                setImage("Hero_Attack.png");
                getImage().mirrorHorizontally();
                scaleDownImage(4, 4);
            }
            else
            {
                setImage("Hero_Attack.png");
                scaleDownImage(4, 4);
            }
            attackPressed = true;
            attackAnimation = true;
        }
        if(!Greenfoot.isKeyDown("j"))
            attackPressed = false;
    }

    /**
     * Contador para la duracion de la animacion de ataque
     */
    public void playAttackAnimation()
    {
        attackFrames--;
        if(attackFrames == 0)
        {
            setRotation(0);
            attackAnimation = false;
            attackOnCooldown = true;
            attackFrames = 10;
        }
    }

    /**
     * Contador para el cooldown entre ataques
     */
    public void attackDelay()
    {
        //setRotation(0);
        attackDelayTimer--;
        if(attackDelayTimer == 0)
        {
            moveAnimation();
            attackDelayTimer = 20;
            attackOnCooldown = false;
        }
    }

    /**
     * Recude la salud del personaje
     * Unicamente si el jugador no esta invencible ni usando el escudo
     * Despues checa si aun tiene armadura, de ser asi la reduce primero y al terminarse comienza a reducir salud
     */
    public void reduceHealth()
    {
        if(isDamaged() && !playerInvincible && !usingShield)
        {
            if(armorPoints > 0)
            {
                armorPoints--;
                playerInvincible = true;
            }
            else if(this.health > 0)
            {
                this.health--;
                playerInvincible = true;
            }
        }
    }

    /**
     * Revisa si ha sido impactado con alguien o algo de la clase Enemy
     */
    public boolean isDamaged()
    {
        Actor attacker = getOneObjectAtOffset(0, 0, Enemy.class);
        if(attacker != null)
            return true;
        else
            return false;
    }

    /**
     * Temporizador de invencibilidad
     */
    public void invincibilityTimer()
    {
        invincibilityFrames--;
        if(invincibilityFrames == 0)
        {
            playerInvincible = false;
            invincibilityFrames = 60;
        }
    }

    /**
     * Usa el escudo al presionar k
     */
    public void useShield()
    {
        if(Greenfoot.isKeyDown("k"))
        {
            usingShield = true;
            shieldAnimation();
        }
        else
        {
            usingShield = false;
            // Hay que hacer que deje de mostrar la animacion de usar el escudo
        }
    }

    /**
     * Muestra un sprite diferente dependiendo de en que posicion se mueva
     */
    public void moveAnimation()
    {
        if(facingLeft)
        {
            setImage("Hero.png");
            getImage().mirrorHorizontally();
            scaleDownImage(4, 4);
        }
        else
        {
            setImage("Hero.png");
            scaleDownImage(4, 4);
        }
    }

    /**
     * Muestra un sprite diferente de uso del escudo dependiendo de en que posicion se mueva
     */
    public void shieldAnimation()
    {
        if(facingLeft)
        {
            setImage("Hero_Shield.png");
            getImage().mirrorHorizontally();
            scaleDownImage(4, 4);
        }
        else
        {
            setImage("Hero_Shield.png");
            scaleDownImage(4, 4);
        }
    }

    /**
     * Muestra informacion del personaje en pantalla
     */
    public void hud()
    {
        getWorld().showText("health: " + health, 50, 50);
        getWorld().showText("armor: " + armorPoints, 50, 70);
    }

    public void changeWorld()
    {   Actor goalHole = getOneObjectAtOffset(0, 0, Goal.class);
        if(goalHole != null)
        {
            switch(actualWorld)
            {
                case 1:
                    w2.addPlayer(this);
                    Greenfoot.setWorld(w2);
                    break;
                case 2:
                    w3.addPlayer(this);
                    Greenfoot.setWorld(w3);
                    break;
                case 3:
                    w4.addPlayer(this);
                    Greenfoot.setWorld(w4);
                    break;
                case 4:
                    w5.addPlayer(this);
                    Greenfoot.setWorld(w5);
                    break;
            }
            actualWorld++;
        }
    }

    /**
     * Muestra informacion sobre variables para debuguear
     */
    public void debugHud()
    {
        getWorld().showText("Invincibility timer: " + invincibilityFrames, 200, 50);
        getWorld().showText("Invincibility: " + usingShield, 200, 70);
        getWorld().showText("Facing left: " + facingLeft, 200, 90);
        getWorld().showText("On floor: " + onGround(), 200, 110);
        getWorld().showText("Player world: " + actualWorld, 200, 130);
        getWorld().showText("Actual world ID: " + showWorldId(), 200, 150);
        getWorld().showText("X pos: " + getX(), 350, 50);
        getWorld().showText("Y pos: " + getY(), 350, 70);
    }
    
    public int showWorldId()
    {
        switch(actualWorld)
            {
                case 1:
                    return w1.getWorldId();
                case 2:
                    return w2.getWorldId();
                case 3:
                    return w3.getWorldId();
                case 4:
                    return w4.getWorldId();
                case 5:
                    return w5.getWorldId();
            }
        return 0;
    }

    /**
     * Getters para uso externo a la clase
     */
    public boolean getAttackAnimation()
    {
        return attackAnimation;
    }
}
