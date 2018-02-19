package model;

import io.realm.RealmObject;

/**
 * Created by Ярик on 09.01.2018.
 */

public class Todo extends RealmObject {
    private Long id;
    private String name;
    private Long userId;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return  name + " " + userId ;
    }
}
