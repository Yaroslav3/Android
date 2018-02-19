package model;

import io.realm.RealmObject;

/**
 * Created by Ярик on 09.01.2018.
 */

public class User extends RealmObject{
    private Long id;
    private String name;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String alex) {
        this.password = alex;
    }

    @Override
    public String toString() {
        return id +"" + name + "" + password ;
    }

}
