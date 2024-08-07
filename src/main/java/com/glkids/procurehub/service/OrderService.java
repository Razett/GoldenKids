package com.glkids.procurehub.service;


import com.glkids.procurehub.dto.OrderDTO;
import com.glkids.procurehub.entity.Order;
import java.util.List;

public interface OrderService {

    //1. 발주 현황 목록
    //1-1. 발주 실행 전 대기 현황
    List<OrderDTO> getOrderListBefore();

    //1-2. 발주 실행 후 진행 현황
    List<OrderDTO> getOrderListAfter();

    //1-3. 대기 현황 수정
    List<OrderDTO> update(List<OrderDTO> updateOrderList);

    //2. 발주 수동 추가
    void register(OrderDTO orderDTO);

    //4. 발주 상세 정보
    OrderDTO read(Long orderno);

    //5. 발주 전체 내역 목록
    List<OrderDTO> totalList();

    //6.발주 실행
    List<OrderDTO> orderExecute(List<Long> ordernos);

    default Order orderDtoToEntity(OrderDTO orderDTO) {
        Order order = Order.builder().orderno(orderDTO.getOrderno()).emp(orderDTO.getEmp())
                .orderdate(orderDTO.getOrderdate()).prcr(orderDTO.getPrcr()).material(orderDTO.getMaterial()).quotationmtrl(orderDTO.getQuotationmtrl())
                .quantity(orderDTO.getQuantity()).trackingNo(orderDTO.getTrackingNo()).status(orderDTO.getStatus())
                .build();

        return order;
    }

    default OrderDTO orderEntityToDTO(Order entity) {
        return OrderDTO.builder().orderno(entity.getOrderno()).emp(entity.getEmp()).orderdate(entity.getOrderdate())
                .prcr(entity.getPrcr()).material(entity.getMaterial()).quotationmtrl(entity.getQuotationmtrl()).quantity(entity.getQuantity())
                .trackingNo(entity.getTrackingNo()).status(entity.getStatus()).regdate(entity.getRegdate()).moddate(entity.getModdate()).build();

    }

}
