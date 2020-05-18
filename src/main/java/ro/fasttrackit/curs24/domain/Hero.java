package ro.fasttrackit.curs24.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Hero {
    private final String name;
    private final int skill;

    public Hero(@JsonProperty("name") String name,
                @JsonProperty("skill") int skill) {
        this.name = name;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public int getSkill() {
        return skill;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Hero hero = (Hero) o;
        return skill == hero.skill &&
                Objects.equals(name, hero.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, skill);
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", skill=" + skill +
                '}';
    }
}
