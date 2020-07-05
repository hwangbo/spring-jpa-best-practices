package com.cheese.springjpa.Account;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "account")
@Getter
// 객체의 직접 생성을 외부에서 못하게 막음
/*
    객체를 유연하게 생성할 수 있음.
        - 객체를 생성할 때 인자 값의 순서가 상관없음
        - 입력되는 값이 정확히 어떤 값인지 알 수 있음
        - 하나의 생성자로 대체가 가능함
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {

    // 칼럼에 대한 제약조건을 db의 스키마와 동일하게 설정
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "first_name", nullable = false)
    private String fistName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "address1", nullable = false)
    private String address1;

    @Column(name = "address2", nullable = false)
    private String address2;

    @Column(name = "zip", nullable = false)
    private String zip;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    // 생성, 수정 날짜를 제외하여 값 설정 못하게 막음
    @Builder
    public Account(String email, String fistName, String lastName, String password, String address1, String address2, String zip) {
        this.email = email;
        this.fistName = fistName;
        this.lastName = lastName;
        this.password = password;
        this.address1 = address1;
        this.address2 = address2;
        this.zip = zip;
    }

    public void updateMyAccount(AccountDto.MyAccountReq dto) {
        this.address1 = dto.getAddress1();
        this.address2 = dto.getAddress2();
        this.zip = dto.getZip();
    }
}
