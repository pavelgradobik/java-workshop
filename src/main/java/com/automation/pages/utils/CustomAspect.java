package com.automation.pages.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.events.StepFailureEvent;
import ru.yandex.qatools.allure.events.StepFinishedEvent;
import ru.yandex.qatools.allure.events.StepStartedEvent;

import static ru.yandex.qatools.allure.aspects.AllureAspectUtils.getName;
import static ru.yandex.qatools.allure.aspects.AllureAspectUtils.getTitle;

/**
 * Created by sergey on 05.06.17.
 */
@SuppressWarnings("unused")
@Aspect
public class CustomAspect {

  private static Allure ALLURE = Allure.LIFECYCLE;

  @Pointcut("execution(* com.automation.remarks.video.service.pages.*.*(..))")
  public void anyMethod() {
    //pointcut body, should be empty
  }

  @Pointcut("execution(* com.codeborne.selenide.SelenideElement.should*(..))")
  public void selenide() {
    //pointcut body, should be empty
  }

  @Before("anyMethod() || selenide()")
  public void stepStart(JoinPoint joinPoint) {
    String stepTitle = createTitle(joinPoint);

    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    StepStartedEvent startedEvent = new StepStartedEvent(
        getName(methodSignature.getName(), joinPoint.getArgs())
    );

    if (!stepTitle.isEmpty()) {
      startedEvent.setTitle(stepTitle);
    }

    ALLURE.fire(startedEvent);
  }

  @AfterThrowing(pointcut = "anyMethod() || selenide()", throwing = "e")
  public void stepFailed(JoinPoint joinPoint, Throwable e) {
    ALLURE.fire(new StepFailureEvent().withThrowable(e));
    ALLURE.fire(new StepFinishedEvent());
  }

  @AfterReturning(pointcut = "anyMethod() || selenide()", returning = "result")
  public void stepStop(JoinPoint joinPoint, Object result) {
    ALLURE.fire(new StepFinishedEvent());
  }

  public String createTitle(JoinPoint joinPoint) {
    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    Step step = methodSignature.getMethod().getAnnotation(Step.class);
    return step == null ? "" : getTitle(step.value(), methodSignature.getName(), joinPoint.getThis(), joinPoint.getArgs());
  }


  /**
   * For tests only
   */
  static void setAllure(Allure allure) {
    CustomAspect.ALLURE = allure;
  }
}
