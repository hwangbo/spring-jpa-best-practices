package com.cheese.springjpa.Account;

import lombok.*;

// DTO 클래스의 필요성

/**
 * 데이터 안정성
 *   - 원치 않는 데이터 변경을 방지
 *   - 불필요한 값들이 넘어오면 잘못된 입력값이므로 Bad_Request 로 처리
 *   - Response 타입이 객체이면 모든 정보를 노출시킬 수 있음.
 * 명확한 요구사항
 *   - 필요한 것들만을 요구할 수 있음
 */
public class AccountDto {


    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class SignUpReq {
        private String email;
        private String fistName;
        private String lastName;
        private String password;
        private String address1;
        private String address2;
        private String zip;

        @Builder
        public SignUpReq(String email, String fistName, String lastName, String password, String address1, String address2, String zip) {
            this.email = email;
            this.fistName = fistName;
            this.lastName = lastName;
            this.password = password;
            this.address1 = address1;
            this.address2 = address2;
            this.zip = zip;
        }

        public Account toEntity() {
            return Account.builder()
                    .email(this.email)
                    .fistName(this.fistName)
                    .lastName(this.lastName)
                    .password(this.password)
                    .address1(this.address1)
                    .address2(this.address2)
                    .zip(this.zip)
                    .build();
        }

    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class MyAccountReq {
        private String address1;
        private String address2;
        private String zip;

        @Builder
        public MyAccountReq(String address1, String address2, String zip) {
            this.address1 = address1;
            this.address2 = address2;
            this.zip = zip;
        }

    }

    @Getter
    public static class Res {
        private String email;
        private String fistName;
        private String lastName;
        private String address1;
        private String address2;
        private String zip;

        public Res(Account account) {
            this.email = account.getEmail();
            this.fistName = account.getFistName();
            this.lastName = account.getLastName();
            this.address1 = account.getAddress1();
            this.address2 = account.getAddress2();
            this.zip = account.getZip();
        }
    }
}
