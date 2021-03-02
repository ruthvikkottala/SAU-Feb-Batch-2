package auaop;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;

@Aspect
@Component
@EnableAspectJAutoProxy
public class AspectClass {
	@AfterReturning(pointcut="execution(* auaop.Rectangle.get*(..))",
		    returning="retVal")
	  public void doAccessCheck(JoinPoint joinPoint,Object retVal) {
		System.out.println("Inside AfterReturning process "+ joinPoint.getSignature().getName());
		System.out.println("Returns : " + retVal);
	  }
	@AfterThrowing(
		    pointcut="execution(* auaop.Rectangle.set*(..))",
		    throwing="ex")
		  public void doRecoveryActions(JoinPoint joinPoint,Exception ex) {
		System.out.println("Inside AfterThrowing process "+ joinPoint.getSignature().getName());
		System.out.println("Throws exception : " + ex);
		  }
	@After("within(auaop..*)")
	  public void doReleaseLock(JoinPoint joinPoint) {
		System.out.println("Inside After process "+ joinPoint.getSignature().getName());
	  }
		
		 @Around("args(int)") public Object
		  doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		  System.out.println("Before process starts "+ pjp.getSignature().getName()); 
		  Object retVal = pjp.proceed();
		  System.out.println("After process ends "+ pjp.getSignature().getName()); 
		  return retVal; }
		 
}
