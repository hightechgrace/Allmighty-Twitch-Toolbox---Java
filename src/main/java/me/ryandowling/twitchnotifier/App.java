package me.ryandowling.twitchnotifier;

import me.ryandowling.twitchnotifier.gui.MainFrame;

import javax.swing.SwingUtilities;

public class App {
    public static final TwitchNotifier NOTIFIER = new TwitchNotifier();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                NOTIFIER.setup();
                new MainFrame();
            }
        });
    }
}
