package py.edu.facitec.simplepokedex.pokemon.modelo;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Arrays;
@DatabaseTable
public class Pokemon implements Serializable{
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String name;
    @DatabaseField
    private String species;
    @DatabaseField(dataType = DataType.SERIALIZABLE)
    private String[] type;

    @DatabaseField
    private String height;
    @DatabaseField
    private String weight;

    @DatabaseField(dataType = DataType.SERIALIZABLE)
    private String[] abilities;
    @DatabaseField(dataType = DataType.SERIALIZABLE)
    private Stats stats;

    @DatabaseField(dataType = DataType.SERIALIZABLE)
    private String[] evolution;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String[] getAbilities() {
        return abilities;
    }

    public void setAbilities(String[] abilities) {
        this.abilities = abilities;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public String[] getEvolution() {
        return evolution;
    }

    public void setEvolution(String[] evolution) {
        this.evolution = evolution;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", type=" + Arrays.toString(type) +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", abilities=" + Arrays.toString(abilities) +
                ", stats=" + stats +
                ", evolution=" + Arrays.toString(evolution) +
                '}';
    }
}
