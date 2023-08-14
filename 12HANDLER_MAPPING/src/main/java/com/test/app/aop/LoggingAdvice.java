package com.test.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {

	@Before("execution(* com.test.app.domain.service.SimpleService.get1())")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("비포..." + joinPoint);
	}
	@After("execution(* com.test.app.domain.service.SimpleService.get2())")
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("애프터..." + joinPoint.getTarget());
	}
	
	@Around("execution(* com.test.app.domain.service.SimpleService.get3())")
	public void logAround(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		System.out.println("[AOP] 스타트 : " + pjp.getSignature().getName());
		Object result = pjp.proceed();	//대상 타켓 함수(get3())을 실행
		System.out.println("[AOP] 리절트 : " + result);
		long end = System.currentTimeMillis();
		System.out.println("[AOP] 타임 : " + (end - start) + "ms");
		System.out.println("[AOP] 엔드 : " + end);

	}
	@Around("execution(void com.test.app.domain.service.*.*(..))")
	public Object logAroundAll(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		System.out.println("[AOP] 스타트 : " + pjp.getSignature().getName());
		Object result = pjp.proceed();	//대상 타켓 함수(get3())을 실행
		System.out.println("[AOP] 리절트 : " + result);
		long end = System.currentTimeMillis();
		System.out.println("[AOP] 타임 : " + (end - start) + "ms");
		System.out.println("[AOP] 엔드 : " + end);

		return result;
	}
	
	
	
}
