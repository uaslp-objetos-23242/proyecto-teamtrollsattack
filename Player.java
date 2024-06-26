import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase jugador, la parte mas importante del juego
 * 
 * @author Miguel Angel Enriquez Cisneros y Joaquin Manuel Trujillo Viveros
 * @version 1
 */
public class Player extends Entity
{
    // Sobreescudo que tiene al entrar a una nueva sala
    private int armorPoints;
    // Puntos de experiencia para mejorar sus atributos
    private int expPoints;
    // Altura maxima que puede saltar
    private int jumpHeight = -14;
    // Gravedad del jugador
    private int gravity = 0;
    // Sirve para llevar un flujo mas manejable de la gravedad y algunos temporizadores
    private int count = 0;
    // Frames antes de poder volver a atacar
    private int attackDelayTimer = 30;
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
    private World2 w2 = new World2();
    private World3 w3 = new World3();
    private World4 w4 = new World4();
    private World5 w5 = new World5();
    private World6 w6 = new World6();
    private World7 w7 = new World7();
    private World8 w8 = new World8();
    private World9 w9 = new World9();
    private WorldFinal wf = new WorldFinal();
    private GameOver go = new GameOver();
    private YouWin win = new YouWin();
    // Lleva la cuenta de cuantos enemigos ha eliminado, se debe reiniciar por cada mundo
    private int worldKillCount = 0;
    private boolean isHardcore = false;

    private GreenfootSound espadazo = new GreenfootSound("espadazo.mp3");
    
    private Goal goal = new Goal();
    /**
     * El constructor, que mas xd
     */
    public Player()
    {
        // Salud, da�o causado, velocidad
        super(10,1,5);
        this.armorPoints = 5;
        espadazo.setVolume(40);
        //scaleDownImage(4, 4);
    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act()
    {
        if(getIsAlive())
        {
            checkFalling();
            getPushedByInvisibleWalls();
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
            spawnGoal();
            changeWorld();
        }
        else
        {
            getWorld().removeObject(this);
            Greenfoot.setWorld(go);
        }
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
            setLocation(x + getSpeed(), y);
            facingLeft = false;
            moveAnimation();
        }
        if(Greenfoot.isKeyDown("a") && !usingShield && !attackAnimation)
        {
            setLocation(x - getSpeed(), y);
            facingLeft = true;
            moveAnimation();
        }
        if(Greenfoot.isKeyDown("space") && !usingShield && !attackAnimation && !jumpPressed && onGround())
        {
            setVSpeed(jumpHeight);
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
        if(Greenfoot.isKeyDown("j") && !attackOnCooldown && !attackPressed && !attackAnimation && onGround() && !usingShield)
        {
            espadazo.play();
            if(facingLeft)
            {
                setImage("HA.png");
                getImage().mirrorHorizontally();
                //scaleDownImage(4, 4);
            }
            else
            {
                setImage("HA.png");
                //scaleDownImage(4, 4);
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
            attackDelayTimer = 30;
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
            else if(getHealth() > 0)
            {
                setHealth(getHealth() - 1);
                playerInvincible = true;
                if(getHealth() <= 0)
                    setIsAlive(false);
            }
        }
    }

    /**
     * Revisa si ha sido impactado con alguien o algo de la clase Enemy
     */
    public boolean isDamaged()
    {
        Actor attacker = getOneObjectAtOffset(0, 0, Projectile.class);
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
        inivicibilityIndicator();
        invincibilityFrames--;
        if(invincibilityFrames == 0)
        {
            playerInvincible = false;
            invincibilityFrames = 60;
        }
    }

    /**
     * Da un efecto de parpadeo al jugador al ser da�ado
     */
    public void inivicibilityIndicator()
    {
        if(invincibilityFrames % 3 == 0 && playerInvincible)
            getImage().setTransparency(100);
        else
            getImage().setTransparency(255);
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
            setImage("H.png");
            getImage().mirrorHorizontally();
            //scaleDownImage(4, 4);
        }
        else
        {
            setImage("H.png");
            //scaleDownImage(4, 4);
        }
    }

    /**
     * Muestra un sprite diferente de uso del escudo dependiendo de en que posicion se mueva
     */
    public void shieldAnimation()
    {
        if(facingLeft)
        {
            setImage("HS.png");
            getImage().mirrorHorizontally();
            //scaleDownImage(4, 4);
        }
        else
        {
            setImage("HS.png");
            //scaleDownImage(4, 4);
        }
    }

    /**
     * Muestra informacion del personaje en pantalla
     */
    public void hud()
    {
        getWorld().showText("health: " + getHealth(), 50, 50);
        getWorld().showText("armor: " + armorPoints, 50, 70);
    }

    /**
     * Cambia de mundo conservando al jugador
     */
    public void changeWorld()
    {   Actor goalHole = getOneObjectAtOffset(0, 0, Goal.class);
        if(goalHole != null)
        {
            getWorld().removeObject(goal);
            worldKillCount = 0;
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
                case 5:
                    w6.addPlayer(this);
                    Greenfoot.setWorld(w6);
                    break;
                case 6:
                    w7.addPlayer(this);
                    Greenfoot.setWorld(w7);
                    break;
                case 7:
                    w8.addPlayer(this);
                    Greenfoot.setWorld(w8);
                    break;
                case 8:
                    w9.addPlayer(this);
                    Greenfoot.setWorld(w9);
                    break;
                case 9:
                    wf.addPlayer(this);
                    Greenfoot.setWorld(wf);
                    break;
                case 10:
                    Greenfoot.setWorld(win);
                    break;                    
            }
            actualWorld++;
        }
    }

    /**
     * Hace aparecer el agujero para avanzar de mundo
     */
    public void spawnGoal()
    {
        switch(actualWorld)
        {
            case 1:
                if(worldKillCount == 1)
                {
                    getWorld().addObject(goal, 600, 410);
                }  
            case 2:
                if(worldKillCount == 1)
                {
                    getWorld().addObject(goal, 50, 377);
                }       
            case 3:
                if(worldKillCount == 1)
                {
                    getWorld().addObject(goal, 550, 416);
                } 
            case 4:
                if(worldKillCount == 2)
                {
                    getWorld().addObject(goal, 40, 416);
                } 
            case 5:
                if(worldKillCount == 2)
                {
                    getWorld().addObject(goal, 40, 416);
                } 
            case 6:
                if(worldKillCount == 2)
                {
                    getWorld().addObject(goal, 50, 207);
                } 
            case 7:
                if(worldKillCount == 2)
                {
                    getWorld().addObject(goal, 330, 396);
                } 
            case 8:
                if(worldKillCount == 3)
                {
                    getWorld().addObject(goal, 550, 416);
                } 
            case 9:
                if(worldKillCount == 3)
                {
                    getWorld().addObject(goal, 40, 416);
                }
        }
    }

    /**
     * Hace que el jugador sea empujado por paredes invisibles
     */
    public void getPushedByInvisibleWalls()
    {
        if(isTouching(InvisibleWallLeft.class))
            setLocation(getX() - getSpeed() * 2, getY());
        if(isTouching(InvisibleWallRight.class))
            setLocation(getX() + getSpeed() * 2, getY());
        if(isTouching(InvisibleCeiling.class))
        {   
            setVSpeed(0);
            setLocation(getX(), getY() + 1);
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
        //getWorld().showText("Actual world ID: " + showWorldId(), 200, 150);
        getWorld().showText("X pos: " + getX(), 350, 50);
        getWorld().showText("Y pos: " + getY(), 350, 70);
    }

    /**
     * Getters para uso externo a la clase
     */
    public boolean getAttackAnimation()
    {
        return attackAnimation;
    }

    /**
     * Configura la dificultad
     */
    public void setDifficulty(boolean hardcore)
    {
        if(hardcore)
        {
            setHealth(5);
            setDamageDealt(2);
            setSpeed(8);
            this.armorPoints = 1;
            isHardcore = true;
        }
    }


    /**
     * Aumenta la cantidad de enemigos eliminados por mundo
     */
    public void increaseWorldKillCount()
    {
        worldKillCount++;
    }
}
