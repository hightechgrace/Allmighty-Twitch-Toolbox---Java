package me.ryandowling.twitchnotifier.events;

import me.ryandowling.twitchnotifier.App;
import me.ryandowling.twitchnotifier.data.streamtip.StreamTipTip;
import me.ryandowling.twitchnotifier.data.twitch.TwitchFollower;
import me.ryandowling.twitchnotifier.events.listeners.DonationListener;
import me.ryandowling.twitchnotifier.events.managers.DonationManager;
import me.ryandowling.twitchnotifier.utils.Utils;
import org.apache.commons.io.FileUtils;

import java.io.IOException;

public class DonationFiles implements DonationListener {
    public DonationFiles() {
        DonationManager.addListener(this);
    }

    @Override
    public void onNewDonation(final StreamTipTip tip) {
        writeFiles();
    }

    public void writeFiles() {
        try {
            StreamTipTip tip = App.NOTIFIER.getLatestDonation();

            FileUtils.write(Utils.getLatestDonationFile().toFile(), tip.getUsername() + ": " + tip.getPrintableAmount
                    ());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}