package com.manvendrask.aop

import com.manvendrask.aop.util.UserAction
import com.manvendrask.domains.UserActionLog
import org.apache.catalina.connector.RequestFacade
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.web.context.request.RequestContextHolder

/**
 * @author Manvendra SK on 9/5/16.
 */
@Aspect
class UserActionLogAspect {

    UserActionLogAspect() {
    }

    @Pointcut("execution(* save*(..)) && within(com.manvendrask.services.*)")
    def adviceServicesSaveMethods() {}

    @Pointcut("execution(* update*(..)) && within(com.manvendrask.services.*)")
    def adviceServicesUpdateMethods() {}

    @After("adviceServicesSaveMethods()")
    def logTheSaveOperation() {
        println ".......calling after advice for saving..."
        RequestFacade request = (RequestFacade) RequestContextHolder.currentRequestAttributes().request

        UserActionLog userActionLog = new UserActionLog(actionName: UserAction.SAVE_RESOURCE, actionDateTime: new Date(), ipAddress: request.getRemoteAddr()).save(flush: true)
        println userActionLog
    }


    @After("adviceServicesUpdateMethods()")
    def logTheUpdateOperation() {
        println ".......calling after advice for updating..."

        RequestFacade request = (RequestFacade) RequestContextHolder.currentRequestAttributes().request

        UserActionLog userActionLog = new UserActionLog(actionName: UserAction.UPDATE_RESOURCE, actionDateTime: new Date(), ipAddress: request.getRemoteAddr()).save(flush: true)
        println userActionLog
    }
}
