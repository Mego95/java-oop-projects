package gr.aueb.cf.oop.ch14;

/**
 * Defines a Singleton SaintGeorgeKnight
 * that "embarks on a mission" saying
 * "embarked on mission!"
 */
public class SaintGeorgeKnight {
    private static final SaintGeorgeKnight INSTANCE = new SaintGeorgeKnight();

    private SaintGeorgeKnight() {}

    public static SaintGeorgeKnight getInstance() {
        return INSTANCE;
    }

    public void embarkOnMission() {
        System.out.println("Embarked on mission!");
    }
}
