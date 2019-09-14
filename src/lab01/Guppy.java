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

    public Guppy() {
        this.genus = DEFAULT_GENUS;
        this.species = DEFAULT_SPECIES;
        this.isFemale = true;
        this.isAlive = true;
        this.healthCoefficient = DEFAULT_HEALTH_COEFFICIENT;

        numberOfGuppiesBorn ++;
        this.identificationNumber = numberOfGuppiesBorn;
    }

    public Guppy(String newGenus, String newSpecies, int newAgeInWeeks, boolean newIsFemale, int newGenerationNumber, double newHealthCoefficient) {
        this.genus = formatGenus(newGenus);
        this.species = formatSpecies(newSpecies);
        this.ageInWeeks = formatAgeInWeeks(newAgeInWeeks);
        this.isFemale = newIsFemale;
        this.isAlive = true;
        this.generationNumber = formatGenerationNumber(newGenerationNumber);
        this.healthCoefficient = formatHealthCoefficient(newHealthCoefficient);

        numberOfGuppiesBorn ++;
        this.identificationNumber = numberOfGuppiesBorn;
    }

    public String getGenus() {
        return this.genus;
    }

    public String getSpecies() {
        return this.species;
    }

    public int getAgeInWeeks() {
        return this.ageInWeeks;
    }

    public boolean getIsFemale() {
        return this.isFemale;
    }

    public int getGenerationNumber() {
        return this.generationNumber;
    }

    public boolean getIsAlive() {
        return this.isAlive;
    }

    public double getHealthCoefficient() {
        return this.healthCoefficient;
    }

    public int getIdentificationNumber() {
        return this.identificationNumber;
    }

    public static int getNumberOfGuppiesBorn() {
        return numberOfGuppiesBorn;
    }



    private String formatGenus(String genus) {
        genus = genus.strip();
        return genus.substring(0, 1).toUpperCase() + genus.substring(1).toLowerCase();
    }

    private String formatSpecies(String species) {
        return species.strip().toLowerCase();
    }

    private int formatAgeInWeeks(int ageInWeeks) {
        return Math.max(0, ageInWeeks);
    }

    private int formatGenerationNumber(int generationNumber) {
        return Math.max(1, generationNumber);
    }

    private double formatHealthCoefficient(double healthCoefficient) {
        if (healthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            return MAXIMUM_HEALTH_COEFFICIENT;
        } else {
            return Math.max(MINIMUM_HEALTH_COEFFICIENT, healthCoefficient);
        }
    }
}
