package tn.esprit.spring.autoloc.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @Before("execution(public * tn.esprit.spring.autoloc.service..*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        log.info("Debut methode : " + joinPoint.getSignature().getName() + " : ");
    }
}
