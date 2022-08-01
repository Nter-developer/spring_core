package hello.spring_core.order;

import hello.spring_core.discount.DiscountPolicy;
import hello.spring_core.discount.FIxDiscountPolicy;
import hello.spring_core.member.Member;
import hello.spring_core.member.MemberRepository;
import hello.spring_core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FIxDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}