package lab01;

import java.util.Objects;

/**
 * Represents a guppy.
 *
 * @author Joshua Shin
 * @version 1.0
 */
public class Guppy {

    /**
     * Age of young fish in weeks.
     */
    public static final int YOUNG_FISH_AGE_IN_WEEKS = 10;

    /**
     * Age of mature fish in weeks.
     */
    public static final int MATURE_FISH_AGE_IN_WEEKS = 30;

    /**
     * Maximum age in weeks.
     */
    public static final int MAXIMUM_AGE_IN_WEEKS = 50;

    /**
     * Minimum volume of water required in mL.
     */
    public static final double MINIMUM_WATER_VOLUME_ML = 250.0;

    /**
     * Default genus.
     */
    public static final String DEFAULT_GENUS = "Poecilia";

    /**
     * Default species.
     */
    public static final String DEFAULT_SPECIES = "reticulata";

    /**
     * Default health coefficient.
     */
    public static final double DEFAULT_HEALTH_COEFFICIENT = 0.5;

    /**
     * Minimum health coefficient.
     */
    public static final double MINIMUM_HEALTH_COEFFICIENT = 0.0;

    /**
     * Maximum health coefficient.
     */
    public static final double MAXIMUM_HEALTH_COEFFICIENT = 1.0;

    /**
     * Total number of Guppy created.
     */
    private static int numberOfGuppiesBorn = 0;

    /**
     * Genus
     */
    private String genus;

    /**
     * Species.
     */
    private String species;

    /**
     * Age in weeks.
     */
    private int ageInWeeks;

    /**
     * Gender is female.
     */
    private boolean isFemale;

    /**
     * Guppy generation number.
     */
    private int generationNumber;

    /**
     * Guppy is alive.
     */
    private boolean isAlive;

    /**
     * Health coefficient.
     */
    private double healthCoefficient;

    /**
     * Guppy identification number.
     */
    private int identificationNumber;

    /**
     * Constructs a default Guppy.
     */
    public Guppy() {
        numberOfGuppiesBorn ++;
        this.genus = DEFAULT_GENUS;
        this.species = DEFAULT_SPECIES;
        this.isFemale = true;
        this.isAlive = true;
        this.healthCoefficient = DEFAULT_HEALTH_COEFFICIENT;
        this.identificationNumber = numberOfGuppiesBorn;
    }

    /**
     * Constructs a Guppy of specified values.
     *
     * @param newGenus              a String
     * @param newSpecies            a String
     * @param newAgeInWeeks         an int
     * @param newIsFemale           a bool
     * @param newGenerationNumber   an int
     * @param newHealthCoefficient  a double
     */
    public Guppy(String newGenus, String newSpecies, int newAgeInWeeks, boolean newIsFemale, int newGenerationNumber, double newHealthCoefficient) {
        numberOfGuppiesBorn ++;
        this.genus = formatGenus(newGenus);
        this.species = formatSpecies(newSpecies);
        this.ageInWeeks = formatAgeInWeeks(newAgeInWeeks);
        this.isFemale = newIsFemale;
        this.isAlive = true;
        this.generationNumber = formatGenerationNumber(newGenerationNumber);
        this.healthCoefficient = formatHealthCoefficient(newHealthCoefficient);
        this.identificationNumber = numberOfGuppiesBorn;
    }

    /**
     * Gets genus.
     *
     * @return genus in as a String
     */
    public String getGenus() {
        return this.genus;
    }

    /**
     * Gets species.
     *
     * @return species as a String
     */
    public String getSpecies() {
        return this.species;
    }

    /**
     * Gets age in weeks.
     *
     * @return age in weeks as an int
     */
    public int getAgeInWeeks() {
        return this.ageInWeeks;
    }

    /**
     * Gets true if female, else false.
     *
     * @return true if female, else false
     */
    public boolean getIsFemale() {
        return this.isFemale;
    }

    /**
     * Gets generation number.
     *
     * @return generation number as an int
     */
    public int getGenerationNumber() {
        return this.generationNumber;
    }

    /**
     * Gets true if alive, else false.
     *
     * @return true if alive, else false
     */
    public boolean getIsAlive() {
        return this.isAlive;
    }

    /**
     * Gets health coefficient.
     *
     * @return health coefficient as a double
     */
    public double getHealthCoefficient() {
        return this.healthCoefficient;
    }

    /**
     * Gets identification number.
     *
     * @return identification number as an int
     */
    public int getIdentificationNumber() {
        return this.identificationNumber;
    }

    /**
     * Gets total number of Guppy created.
     *
     * @return total number of Guppy as an int
     */
    public static int getNumberOfGuppiesBorn() {
        return numberOfGuppiesBorn;
    }

    /**
     * Sets ageInWeeks with given value.
     *
     * @param ageInWeeks an int
     */
    public void setAgeInWeeks(int ageInWeeks) {
        if (ageInWeeks >= 0 && ageInWeeks <= MAXIMUM_AGE_IN_WEEKS) {
            this.ageInWeeks = ageInWeeks;
        }
    }

    /**
     * Sets isAlive with given boolean.
     *
     * @param isAlive a boolean
     */
    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    /**
     * Sets healthCoefficient with given double.
     *
     * @param healthCoefficient a double
     */
    public void setHealthCoefficient(double healthCoefficient) {
        if (healthCoefficient >= MINIMUM_HEALTH_COEFFICIENT && healthCoefficient <= MAXIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = healthCoefficient;
        }
    }

    /**
     * Increments ageInWeeks by one week.
     */
    public void incrementAge() {
        this.ageInWeeks ++;
        if (this.ageInWeeks > MAXIMUM_AGE_IN_WEEKS) {
            this.isAlive = false;
        }
    }

    /**
     * Gets volume of water needed in mL for this guppy.
     *
     * @return volume of water needed in mL as double
     */
    public double getVolumeNeeded() {
        if (this.ageInWeeks < 10) {
            return MINIMUM_WATER_VOLUME_ML;
        } else if (this.ageInWeeks <= 30) {
            return MINIMUM_WATER_VOLUME_ML * ageInWeeks / YOUNG_FISH_AGE_IN_WEEKS;
        } else if (this.ageInWeeks <= 50) {
            return MINIMUM_WATER_VOLUME_ML * 1.5;
        } else {
            return 0.0;
        }
    }

    /**
     * Adds given delta to current health coefficient.
     *
     * @param delta a double
     */
    public void changeHealthCoefficient(double delta) {
        this.healthCoefficient = Math.min(this.healthCoefficient += delta, MAXIMUM_HEALTH_COEFFICIENT);
        if (this.healthCoefficient < MINIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = 0.0;
            this.isAlive = false;
        }
    }

    /**
     * Returns a String representation of Guppy.
     *
     * @return representation as a String
     */
    @Override
    public String toString() {
        return "Guppy{" +
                "genus='" + genus + '\'' +
                ", species='" + species + '\'' +
                ", ageInWeeks=" + ageInWeeks +
                ", isFemale=" + isFemale +
                ", generationNumber=" + generationNumber +
                ", isAlive=" + isAlive +
                ", healthCoefficient=" + healthCoefficient +
                ", identificationNumber=" + identificationNumber +
                '}';
    }

    /**
     * Return true if compared object is equal, else false.
     *
     * @param   o an object to compare
     * @return  true if equal, else false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Guppy guppy = (Guppy) o;
        return ageInWeeks == guppy.ageInWeeks &&
                isFemale == guppy.isFemale &&
                generationNumber == guppy.generationNumber &&
                isAlive == guppy.isAlive &&
                Double.compare(guppy.healthCoefficient, healthCoefficient) == 0 &&
                identificationNumber == guppy.identificationNumber &&
                Objects.equals(genus, guppy.genus) &&
                Objects.equals(species, guppy.species);
    }

    private String formatGenus(String genus) {
        if (genus == null) {
            return DEFAULT_GENUS;
        } else {
            genus = genus.trim();
            if (genus.equals("")) {
                return DEFAULT_GENUS;
            } else {
                return genus.substring(0, 1).toUpperCase() + genus.substring(1).toLowerCase();
            }
        }
    }

    private String formatSpecies(String species) {
        if (species == null) {
            return DEFAULT_SPECIES;
        } else {
            species = species.trim().toLowerCase();
            if (species.equals("")) {
                return DEFAULT_SPECIES;
            } else {
                return species;
            }
        }
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
