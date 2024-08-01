package com.glkids.procurehub.dto;

import com.glkids.procurehub.entity.Emp;
import com.glkids.procurehub.entity.Prcr;
import com.glkids.procurehub.entity.Quotation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * <b>발주</b>
 *
 * <p>{@code Long orderno} - 발주 코드 [BIGINT, PK, Not Null]</p>
 * <p>{@code Emp emp} - 발주 실행 사원 [FK, Nullable]</p>
 * <p>{@code LocalDateTime orderdate} - 발주 실행일 [DATETIME, Not Null]</p>
 * <p>{@code Prcr prcr} - 조달 계획 [FK, Nullable]</p>
 * <p>{@code Quotation quotation} - 견적 [FK, Nullable]</p>
 * <p>{@code Long quantity} - 발주 수량 [BIGINT, Not Null]</p>
 * <p>{@code String trackingNo} - 운송장 번호 [Varchar(20), Nullable]</p>
 * <p>{@code Integer status} - 발주 상태 [INT, Not Null]</p>
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OrderDTO {

    private Long orderno; //발주 코드
    private Emp emp; //발주 실행 사원
    private LocalDateTime orderdate; //발주 실행일
    private Prcr prcr; //조달 계획
    private Quotation quotation; //견적
    private Long quantity; //발주 수량
    private String trackingNo; //운송장 번호
    private Integer status; //발주 상태
}