package labyGame.personnage;
import java.util.Random;


public class Monster extends Role {
    //All args constructor
    public Monster(int hp, CharacterState status, String name, int power, int positionX, int positionY){
        super(hp,name, power, status);
        super.positionX = positionX;
        super.positionY = positionY;
    }

    //Basic status
    public Monster(int hp, String name, int power, int positionX, int positionY){
        super(hp,name,power);
        super.positionX = positionX;
        super.positionY = positionY;
    }

    @Override
    public void basicAttack(Role target) {
        Random rand = new Random();
        target.setHp(-rand.nextInt(power - power/3+2) + power/3+2);
    }

    @Override
    public String toString() {
        return String.format("My name is %s, I'm one of the labyrinth's guardians !", name);
    }

    @Override
    public String basicTalk(String sentence) {
        return sentence.substring(0,1).toUpperCase() + toString().substring(1);
    }

    @Override
    public void secretAttack(Role target) {
        Random rand = new Random();
        if (CharacterState.NORMAL == currentStatus)
            target.setHp(-rand.nextInt(power * power - power * 10) + power * 10);
    }
}
