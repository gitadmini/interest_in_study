package com.linyy.interest.inter;

/**
 * 接口和继承 是不是都可以实现多态
 */
public class InterfaceExtend extends Ex implements Inter{

    public static void main(String[] args) {

        // 验证了接口和继承都可以直接new一个子类
        Inter inter = new InterfaceExtend();
        inter.interFunc();

        Ex ex = new InterfaceExtend();
        ex.exFunc();
    }
}

interface Inter{

    default void interFunc(){
        System.out.println("inter func...");
    };

}

class Ex{

    void exFunc(){
        System.out.println("ex func...");
    }
}
