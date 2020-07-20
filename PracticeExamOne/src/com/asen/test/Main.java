package com.asen.test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int plunderPerDay = Integer.parseInt(scanner.nextLine());
        double PlannedPlunder = Double.parseDouble(scanner.nextLine());
        double aactualplunder = 0;

        for (int i = 1; i <= days; i++) {
            aactualplunder += plunderPerDay;
            if (i % 3 == 0) {
                aactualplunder += 0.5 * plunderPerDay;
            }
            if (i % 5 == 0) {
                aactualplunder -= aactualplunder * 0.3;
            }

        }
        double percent = (aactualplunder / PlannedPlunder * 100);
        if (aactualplunder >= PlannedPlunder) {
            System.out.println(String.format("Ahoy! %.2f plunder gained.", aactualplunder));
        } else {
            System.out.printf("Collected only %.2f%% of the plunder.", percent);
        }
    }
}