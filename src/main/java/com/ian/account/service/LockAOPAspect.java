package com.ian.account.service;

import com.ian.account.aop.AccountLockIdInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class LockAOPAspect {
    private final LockService lockService;

    @Around("@annotation(com.ian.account.aop.AccountLock) && args(request)")
    public Object around(ProceedingJoinPoint joinPoint, AccountLockIdInterface request) throws Throwable {
        // lock 취득 시도
        lockService.lock(request.getAccountNumber());
        try {
            return joinPoint.proceed();
        } finally {
            // lock 해제
            lockService.unlock(request.getAccountNumber());
        }
    }
}
