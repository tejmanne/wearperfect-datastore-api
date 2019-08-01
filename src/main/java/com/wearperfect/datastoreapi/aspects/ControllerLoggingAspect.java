package com.wearperfect.datastoreapi.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerLoggingAspect {
	
	@Before("execution(* com.wearperfect.datastoreapi.controllers.*.*(..))")
	public void requestAdvice() {
		System.out.println("Service Request...");
	}
}
