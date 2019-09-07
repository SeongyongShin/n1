package com.zerock.util;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect //aop 클래스로 사용하겠다.
@Component //해당 클래스를 bean 자동생성 명령
public class LogAdvice {
	
	private static final Logger log = LoggerFactory.getLogger(LogAdvice.class);
	//경로에 해당하는 메서드를 실행하기전에 실행하는 메서드 
	//맨 앞 *는 접근 제한을 의미, 맨 뒤 *(..)는 메서드를 의미
//	@Before("execution(* com.zerock.board.service.BoradServiceImpl*.*(..) )")
//	public void beforeLog() {
//		System.out.println("before");
//	}
//	
//
//	@After("execution(* com.zerock.board.service.BoradServiceImpl*.*(..) )")
//	public void afterLog() {
//		System.out.println("after");
//	}
//	
	//스프링 설정파일에 aop 설정
	
	//Around 는 메서드 실행권한을 가지고, 메서드 안으로 들어가서 메서드와 실행 전, 실행 후 처리가 가능 
	@Around("execution(* com.zerock.board.service.BoradServiceImpl*.*(..) )")
	public Object aroundLog(ProceedingJoinPoint jp) {
		Object result = null;
		long start = System.currentTimeMillis();
		try {
			result = jp.proceed(); // proceed()는 타겟이 되는 메서드를 지칭하고 해당 메서드를 실행시켜야 타겟메서드가 실행된다.
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
//		System.out.println("메서드 실행시간: " + (end - start));
//		System.out.println("적용 클래스: " + jp.getTarget());
//		System.out.println("적용 파라미터: " + Arrays.toString(jp.getArgs()));
		
		log.info("메서드 실행시간: " + (end - start));
		log.info("적용 클래스: " + jp.getTarget());
		log.info("적용 파라미터: " + Arrays.toString(jp.getArgs()));
		return result;
	}
}
