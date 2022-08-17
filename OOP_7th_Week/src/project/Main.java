package project;

import project.Ability.Attackable;
import project.Ability.Hittable;
import project.Ability.Movable;
import project.Ability.SkillActivatable;
import project.Champ.Dealer;
import project.Champ.Supporter;
import project.Property.LifeProperty;
import project.Property.LocationProperty;
import project.Skill.DealerSkill;
import project.Skill.DoubledDefenseSkill;
import project.Skill.SupporterSkill;
import project.Treasure.MovingTreasureBox;
import project.Treasure.ThickTreasureBox;
import project.Treasure.TreasureBox;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File testcase = new File("/Users/isanghun/study/OOP_Java_Practice/OOP_7th_Week/src/project/testcases/input3.txt");
        Scanner sc = new Scanner(testcase);
        ArrayList<Entity> entities = new ArrayList<>();

        while (true) {
            String line = sc.nextLine();
            String[] splited = line.split(" ");
            System.out.println(line);

            switch (splited[0]) {
                case "create":
                    create(splited, entities);
                    break;

                case "move":
                    move(splited, entities);
                    break;

                case "attack":
                    attack(splited, entities);
                    break;

                case "skill":
                    skill(splited, entities);
                    break;

                case "end":
                    for (Entity entity : entities) {
                        System.out.println(entity);
                    }
                    return;
            }
        }
    }

    public static void create(String[] splited, ArrayList<Entity> entities) {
        int uid, hp, mp, x, y, attackPower, recoveryPower, gold, defensePower;
        Double additionalAttackMultiplier;
        String name;
        switch (splited[1]) {
            case "Dealer":
                uid = Integer.parseInt(splited[2]);
                name = splited[3];
                hp = Integer.parseInt(splited[4]);
                mp = Integer.parseInt(splited[5]);
                x = Integer.parseInt(splited[6]);
                y = Integer.parseInt(splited[7]);
                attackPower = Integer.parseInt(splited[8]);
                additionalAttackMultiplier = Double.parseDouble(splited[9]);

                entities.add(new Dealer(
                        uid,
                        new LifeProperty(hp, mp),
                        new LocationProperty(x, y),
                        name, "Dealer", attackPower, additionalAttackMultiplier, new DealerSkill()));
                break;

            case "Supporter":
                uid = Integer.parseInt(splited[2]);
                name = splited[3];
                hp = Integer.parseInt(splited[4]);
                mp = Integer.parseInt(splited[5]);
                x = Integer.parseInt(splited[6]);
                y = Integer.parseInt(splited[7]);
                attackPower = Integer.parseInt(splited[8]);
                recoveryPower = Integer.parseInt(splited[9]);

                entities.add(new Supporter(
                        uid,
                        new LifeProperty(hp, mp),
                        new LocationProperty(x, y),
                        name, "Supporter", recoveryPower, attackPower, new SupporterSkill()));
                break;

            case "TreasureBox":
                uid = Integer.parseInt(splited[2]);
                hp = Integer.parseInt(splited[3]);
                mp = Integer.parseInt(splited[4]);
                x = Integer.parseInt(splited[5]);
                y = Integer.parseInt(splited[6]);
                gold = Integer.parseInt(splited[7]);

                entities.add(new TreasureBox(
                        uid,
                        new LifeProperty(hp, mp),
                        new LocationProperty(x, y),
                        gold));
                break;

            case "MovingTreasureBox":
                uid = Integer.parseInt(splited[2]);
                hp = Integer.parseInt(splited[3]);
                mp = Integer.parseInt(splited[4]);
                x = Integer.parseInt(splited[5]);
                y = Integer.parseInt(splited[6]);
                gold = Integer.parseInt(splited[7]);

                entities.add(new MovingTreasureBox(
                        uid,
                        new LifeProperty(hp, mp),
                        new LocationProperty(x, y),
                        gold));
                break;

            case "ThickTreasureBox":
                uid = Integer.parseInt(splited[2]);
                hp = Integer.parseInt(splited[3]);
                mp = Integer.parseInt(splited[4]);
                x = Integer.parseInt(splited[5]);
                y = Integer.parseInt(splited[6]);
                gold = Integer.parseInt(splited[7]);
                defensePower = Integer.parseInt(splited[8]);

                entities.add(new ThickTreasureBox(
                        uid,
                        new LifeProperty(hp, mp),
                        new LocationProperty(x, y),
                        gold, defensePower, new DoubledDefenseSkill()));
                break;
        }
    }

    public static void move(String[] splited, ArrayList<Entity> entities) {
        int uid = Integer.parseInt(splited[1]);
        int xDistance = Integer.parseInt(splited[2]);
        int yDistance = Integer.parseInt(splited[3]);

        for (Entity entity : entities) {
            if (entity.getUid() == uid && entity instanceof Movable) {
                entity.getLocationProperty().move(xDistance, yDistance);
                return;
            }
        }

        System.out.println("It is not movable.");
    }

    public static void attack(String[] splited, ArrayList<Entity> entities) {
        int attackerUid = Integer.parseInt(splited[1]);
        int defenderUid = Integer.parseInt(splited[2]);

        Entity attacker = entities.stream().filter(entity -> entity.getUid() == attackerUid).findFirst().orElseThrow();
        Entity defender = entities.stream().filter(entity -> entity.getUid() == defenderUid).findFirst().orElseThrow();

        if (!(attacker instanceof Attackable)) {
            System.out.println("The attacker cannot attack.");
            return;
        }

        if (!(defender instanceof Hittable)) {
            System.out.println("Object is not hittable.");
        }

        ((Attackable) attacker).attack(defender);
    }

    public static void skill(String[] splited, ArrayList<Entity> entities) {

        int activatorUid = Integer.parseInt(splited[1]);
        String skillName = splited[2];
        Entity activator = entities.stream().filter(entity -> entity.getUid() == activatorUid).findFirst().orElseThrow();
        ArrayList<Entity> targets = new ArrayList<>();

        if (!(activator instanceof SkillActivatable)) {
            System.out.println("invalidated.");
            return;
        }

        if (splited.length > 3) {
            for (int i = 3; i < splited.length; i++) {
                int uid = Integer.parseInt(splited[i]);
                Entity target = entities.stream().filter(entity -> entity.getUid() == uid).findFirst().orElseThrow();
                targets.add(target);
            }
        }

        Entity[] finalTargets = targets.toArray(new Entity[targets.size()]);

        if (activator instanceof Dealer) {
            Dealer dealer = (Dealer) activator;

            if (!(dealer.getDealerSkill().getSkillName().equals(skillName))) {
                System.out.println("invalidated.");
                return;
            }

            dealer.getDealerSkill().activate(activator, finalTargets);
        }

        if (activator instanceof Supporter) {
            Supporter supporter = (Supporter) activator;

            if (!(supporter.getSupporterSkill().getSkillName().equals(skillName))) {
                System.out.println("invalidated.");
                return;
            }

            supporter.getSupporterSkill().activate(activator, finalTargets);
        }

        if (activator instanceof ThickTreasureBox) {
            ThickTreasureBox thickTreasureBox = (ThickTreasureBox) activator;

            if (!(thickTreasureBox.getDoubledDefenseSkill().getSkillName().equals(skillName))) {
                System.out.println("invalidated.");
                return;
            }

            thickTreasureBox.getDoubledDefenseSkill().activate(activator, finalTargets);
        }
    }
}
