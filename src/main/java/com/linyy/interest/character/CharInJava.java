package com.linyy.interest.character;

public class CharInJava {

    public static void main(String[] args) {
        printAllChar();
    }

    /**
     * 打印所有字符
     */
    private static void printAllChar() {
        int max = (1<<16) - 1; // char占2个字节，取值范围0~2^16-1
        char c ;
        for(int i=0;i<=max;i++) {
            c = (char)i;
            System.out.println(i+":"+c);
        }
    }
}
