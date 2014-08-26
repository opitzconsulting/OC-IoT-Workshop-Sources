package com.opitz.iotprototype.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: Pascal Date: 27.03.14 Time: 10:06
 * 
 * ORM class representation of our users.
 *
 *
 */

@Entity
public class User implements Serializable {



    /* UNCOMMENT ONCE COMPLETED

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User){
            User other = (User) obj;
            if (this.getId().equals(other.getId())){
                 return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getId();
    }

    @Override
    public String toString() {
        return new StringBuffer().append("ID: ").append(id).append("\nUsername: ").append(username).toString();
    }*/


}
