
package com.elrayo.vista;

import com.elrayo.controlador.ControladorMotorizado;
import com.elrayo.entidad.Motorizado;

import java.util.Scanner;

public class VistaRegistroMotorizado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ControladorMotorizado controlador = new ControladorMotorizado();

        System.out.println("=== REGISTRO DE MOTORIZADO ===");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Teléfono (9 dígitos): ");
        String telefono = scanner.nextLine();
        if (!telefono.matches("\\d{9}")) {
            System.out.println("❌ Teléfono inválido.");
            return;
        }

        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("DNI (8 dígitos): ");
        String dni = scanner.nextLine();
        if (!dni.matches("\\d{8}")) {
            System.out.println("❌ DNI inválido.");
            return;
        }

        Motorizado m = new Motorizado(nombre, telefono, direccion, dni, true);
        controlador.registrarMotorizado(m);

        System.out.println("✅ Motorizado registrado exitosamente.");
    }
}
