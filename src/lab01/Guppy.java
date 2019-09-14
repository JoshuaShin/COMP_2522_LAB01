package lab01;

public class Guppy {

    public static final int YOUNG_FISH_AGE_IN_WEEKS = 10;
    public static final int MATURE_FISH_AGE_IN_WEEKS = 30;
    public static final int MAXIMUM_AGE_IN_WEEKS = 50;
    public static final double MINIMUM_WATER_VOLUME_ML = 250.0;
    public static final String DEFAULT_GENUS = "Poecilia";
    public static final String DEFAULT_SPECIES = "reticulata";
    public static final double DEFAULT_HEALTH_COEFFICIENT = 0.5;
    public static final double MINIMUM_HEALTH_COEFFICIENT = 0.0;
    public static final double MAXIMUM_HEALTH_COEFFICIENT = 1.0;
    private static int numberOfGuppiesBorn = 0;

    private String genus;
    private String species;
    private int ageInWeeks;
    private boolean isFemale;
    private int generationNumber;
    private boolean isAlive;
    private double healthCoefficient;
    private int identificationNumber;
}
