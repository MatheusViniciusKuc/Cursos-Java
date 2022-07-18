package br.com.bytebank.banco.teste;

import java.util.ArrayList;
import java.util.List;

public class TesteArrayListEquals {

    public static void main(String[] args) {

        List<Number> nums = new ArrayList<>();

        nums.add(59);
        nums.add(69.9);
        nums.add(79.69);

        for (Number f : nums) {
            System.out.println(f);
        }
    }
}