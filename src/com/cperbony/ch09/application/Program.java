package com.cperbony.ch09.application;

import com.cperbony.ch09.entities.Circle;
import com.cperbony.ch09.entities.Retangle;
import com.cperbony.ch09.entities.Shape;
import com.cperbony.ch09.enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Shape> list = new ArrayList<>();

        System.out.println("Enter the number of shapes: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Shape #" + i + " data:");
            System.out.println("Rectangle or Circle ? R or C ?");
            char ch = sc.next().charAt(0);

            System.out.println("Choose Color ?");
            Color color = Color.valueOf(sc.next());

            if (ch == 'r') {
                System.out.println("Width: ");
                double width = sc.nextDouble();
                System.out.println("Height: ");
                double heigth = sc.nextDouble();

                list.add(new Retangle(color, width, heigth));
            } else {
                System.out.println("Radius: ");
                double radius = sc.nextDouble();
                list.add(new Circle(color, radius));
            }
        }

        System.out.println();
        System.out.printf("SHAPE AREAS");

        for (Shape shape : list) {
            System.out.println(String.format("%2f", shape.area()));
        }

        sc.close();
    }
}
