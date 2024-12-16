package com.racha.main;

import java.awt.event.ActionEvent;
import java.util.concurrent.TimeUnit;

import org.jdesktop.core.animation.timing.Animator;
import org.jdesktop.core.animation.timing.TimingSource;
import org.jdesktop.core.animation.timing.TimingTarget;
import org.jdesktop.core.animation.timing.TimingTargetAdapter;
import org.jdesktop.core.animation.timing.interpolators.AccelerationInterpolator;
import org.jdesktop.swing.animation.timing.sources.SwingTimerTimingSource;

import com.racha.componets.PanelCover;
import com.racha.componets.PanelLoginAndRegister;

import net.miginfocom.swing.MigLayout;

public class Main extends javax.swing.JFrame {

    private MigLayout layout;
    private PanelCover cover;
    private PanelLoginAndRegister loginAndRegister;
    private boolean isLogin;
    private final double addSize = 30;
    private final double coverSize = 40;
    private final double loginSize = 60;

    public Main() {
        initComponents();
        init();
    }

    private void init() {
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCover();
        loginAndRegister = new PanelLoginAndRegister();

        // Initial layout setup
        bg.setLayout(layout);
        bg.add(cover, "width " + coverSize + "%, pos 0al 0 n 100%");
        bg.add(loginAndRegister, "width " + loginSize + "%, pos 1al 0 n 100%"); // 1al as 100%

        // Create the TimingSource and set it as default
        TimingSource timingSource = new SwingTimerTimingSource();
        Animator.setDefaultTimingSource(timingSource);
        timingSource.init();

        // Define the animation logic
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(Animator source, double fraction) {
                double fractionCover;
                double fractionLogin;

                double size = coverSize;
                if (fraction <= 0.5) {
                    size += fraction * size;
                } else {
                    size += addSize - fraction * addSize;
                }

                if (isLogin) {
                    fractionCover = 1f - fraction;
                    fractionLogin = fraction;
                    if (fraction >= 0.5) {
                        cover.registerRight(fractionCover * 100);
                    } else {
                        cover.loginRight(fractionLogin * 100);
                    }
                } else {
                    fractionCover = fraction;
                    fractionLogin = 1f - fraction;
                    if (fraction <= 0.5) {
                        cover.registerLeft(fraction * 100);
                    } else {
                        cover.loginLeft((1.0 - fraction) * 100);
                    }
                }

                if (fraction >= 0.5) {
                    loginAndRegister.showRegister(!isLogin);
                }
                fractionCover = Math.floor(fractionCover * 100) / 100;
                fractionLogin = Math.floor(fractionLogin * 100) / 100;

                layout.setComponentConstraints(cover, "width " + size + "%, pos " + fractionCover + "al 0 n 100%");
                layout.setComponentConstraints(loginAndRegister, "width " + loginSize + "%, pos " + fractionLogin + "al 0 n 100%");

                bg.revalidate(); // Ensure the layout updates
            }

            @Override
            public void end(Animator source) {
                isLogin = !isLogin; // Toggle state
            }
        };

        // Build the Animator
        Animator animator = new Animator.Builder(timingSource)
                       .setDuration(800, TimeUnit.MILLISECONDS)
                       .addTarget(target)
                       .setInterpolator(new AccelerationInterpolator(0.5, 0.5))
                       .build();

        cover.addEvent((ActionEvent e) -> {
            if (!animator.isRunning()) { // Prevent double triggering
                animator.start();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCover1 = new com.racha.componets.PanelCover();
        bg = new javax.swing.JLayeredPane();

        javax.swing.GroupLayout panelCover1Layout = new javax.swing.GroupLayout(panelCover1);
        panelCover1.setLayout(panelCover1Layout);
        panelCover1Layout.setHorizontalGroup(
            panelCover1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 347, Short.MAX_VALUE)
        );
        panelCover1Layout.setVerticalGroup(
            panelCover1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
        );

        setUndecorated(true);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    private com.racha.componets.PanelCover panelCover1;
    // End of variables declaration//GEN-END:variables
}
