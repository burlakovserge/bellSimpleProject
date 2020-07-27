package ru.bellintegrator.practice.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
    private Logger logger = LogManager.getLogger(this.getClass());

    @Pointcut("execution(public * ru.bellintegrator.practice.service.impl.OrganizationServiceImpl.*(..))")
    public void callAtMyServicePublic() {
    }

    @AfterThrowing(pointcut = "callAtMyServicePublic()", throwing = "e")
    public void afterThisCallAt(JoinPoint jp, Exception e) {
        logger.warn("Exception in {}.{}() with cause = {}", jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName(), e.getCause());
    }
}