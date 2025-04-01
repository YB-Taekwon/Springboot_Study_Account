package com.ian.account.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND("사용자를 찾을 수 없습니다."),
    ACCOUNT_NOT_FOUND("계좌를 찾을 수 없습니다."),
    ACCOUNT_LIMIT_EXCEEDED("사용자가 생성할 수 있는 최대 계좌 개수를 초과했습니다."),
    ACCOUNT_ALREADY_CLOSED("이미 해지된 계좌입니다."),
    ACCOUNT_HAS_BALANCE("계좌에 잔액이 남아 있어 해지할 수 없습니다."),
    USER_ACCOUNT_UNMATCH("사용자와 계좌 소유주의 정보가 일치하지 않습니다."),
    BALANCE_EXCEEDED("계좌 잔액이 부족합니다.");

    private final String disciption;
}
