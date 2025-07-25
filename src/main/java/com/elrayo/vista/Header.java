package com.elrayo.vista;

import com.elrayo.util.GradientPanelBlueHorizon; // heredas esta
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.geom.Point2D;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import java.util.Locale;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.geom.Point2D;


public class Header extends javax.swing.JPanel {

    public Header() {
        initComponents();
        navText.putClientProperty("FlatLaf.style", "font: bold $h3.regular.font");
        navText.setForeground(Color.white);
        dateText.putClientProperty("FlatLaf.style", "font: 24 $light.font");
        dateText.setForeground(Color.white);
        SetDate();
    }

    private void SetDate() {
        LocalDate now = LocalDate.now();
        Locale spanishLocale = new Locale("es", "ES");
        dateText.setText(now.format(DateTimeFormatter.ofPattern("'Hoy es' EEEE dd 'de' MMMM 'de' yyyy", spanishLocale)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        navText = new javax.swing.JLabel();
        dateText = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setPreferredSize(new java.awt.Dimension(700, 150));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(750, 430));

        header.setBackground(new java.awt.Color(25, 117, 210));
        header.setMinimumSize(new java.awt.Dimension(750, 150));
        header.setPreferredSize(new java.awt.Dimension(744, 150));

        navText.setText("¿Que vamos a hacer hoy? ");

        dateText.setText("Hoy es {dayname} {day} de {month} de {year}");

        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(navText, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(194, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(navText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JLabel dateText;
    private javax.swing.JPanel header;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel navText;
    // End of variables declaration//GEN-END:variables
}
