package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig  appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        Member member = new Member(1L, "홍길동", Grade.VIP);
        memberService.join(member);

        Order order =  orderService.createOrder(member.getId(), "자전거", 20000);

        System.out.println("order ==> " + order.toString());
        System.out.println("order calculatePrice ==> " + order.calculatePrice());
    }
}
