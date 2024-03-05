package com.sin.rickandmorty.response;

import java.util.ArrayList;

public class CharacterDetailResponse {

    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private CharacterOriginResponse characterOrigin;
    private CharacterLocationResponse characterLocation;
    private String image;
    private ArrayList<String> episode;
    private String url;
    private String created;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public CharacterOriginResponse getCharacterOrigin() {
        return characterOrigin;
    }

    public void setCharacterOrigin(CharacterOriginResponse characterOrigin) {
        this.characterOrigin = characterOrigin;
    }

    public CharacterLocationResponse getCharacterLocation() {
        return characterLocation;
    }

    public void setCharacterLocation(CharacterLocationResponse characterLocation) {
        this.characterLocation = characterLocation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<String> getEpisode() {
        return episode;
    }

    public void setEpisode(ArrayList<String> episode) {
        this.episode = episode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
