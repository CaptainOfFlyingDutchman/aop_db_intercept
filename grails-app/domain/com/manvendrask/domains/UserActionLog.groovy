package com.manvendrask.domains

import com.manvendrask.aop.util.UserAction

/**
 * @author Manvendra SK on 9/5/16.
 */
class UserActionLog {

//    String userId
    UserAction actionName
    Date actionDateTime
    String ipAddress
    boolean  isDeleted = false

    static constraints = {
    }


    @Override
    public String toString() {
        return "UserActionLog{" +
                "id=" + id +
                ", actionName=" + actionName +
                ", actionDateTime=" + actionDateTime +
                ", isDeleted=" + isDeleted +
                ", version=" + version +
                '}';
    }
}
