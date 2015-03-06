package me.ryandowling.allmightytwitchtoolbox.gui;

import io.github.asyncronous.toast.Toaster;
import me.ryandowling.allmightytwitchtoolbox.App;
import me.ryandowling.allmightytwitchtoolbox.events.managers.SettingsManager;
import me.ryandowling.allmightytwitchtoolbox.utils.SoundPlayer;
import me.ryandowling.allmightytwitchtoolbox.utils.Utils;
import org.apache.commons.io.FileUtils;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SettingsPanel extends JPanel {
    private JPanel mainPane;
    private JPanel buttonPane;

    private JPanel twitchUsernamePanel;
    private JLabel twitchUsernameLabel;
    private JTextField twitchUsernameTextField;

    private JPanel twitchAPITokenPanel;
    private JLabel twitchAPITokenLabel;
    private JTextField twitchAPITokenTextField;
    private JButton twitchAPITokenButton;

    private JPanel twitchAPIClientIDPanel;
    private JLabel twitchAPIClientIDLabel;
    private JTextField twitchAPIClientIDTextField;
    private JButton twitchAPIClientIDButton;

    private JPanel streamTipClientIDPanel;
    private JLabel streamTipClientIDLabel;
    private JTextField streamTipClientIDTextField;

    private JPanel streamTipAccessTokenPanel;
    private JLabel streamTipAccessTokenLabel;
    private JTextField streamTipAccessTokenTextField;

    private JPanel timeBetweenFollowerChecksPanel;
    private JLabel timeBetweenFollowerChecksLabel;
    private JSpinner timeBetweenFollowerChecksSpinner;

    private JPanel timeBetweenDonationChecksPanel;
    private JLabel timeBetweenDonationChecksLabel;
    private JSpinner timeBetweenDonationChecksSpinner;

    private JPanel timeBetweenViewerCountChecksPanel;
    private JLabel timeBetweenViewerCountChecksLabel;
    private JSpinner timeBetweenViewerCountChecksSpinner;

    private JPanel numberOfPointsOnViewerChartPanel;
    private JLabel numberOfPointsOnViewerChartLabel;
    private JSpinner numberOfPointsOnViewerChartSpinner;

    private JPanel serverPortPanel;
    private JLabel serverPortLabel;
    private JTextField serverPortTextField;

    private JPanel newFollowerSoundPanel;
    private JLabel newFollowerSoundLabel;
    private JTextField newFollowerSoundTextField;
    private JFileChooser newFollowerSoundChooser;
    private JButton newFollowerSoundChooserButton;
    private JButton newFollowerSoundTestButton;

    private JPanel newDonationSoundPanel;
    private JLabel newDonationSoundLabel;
    private JTextField newDonationSoundTextField;
    private JFileChooser newDonationSoundChooser;
    private JButton newDonationSoundChooserButton;
    private JButton newDonationSoundTestButton;

    private JPanel foobarLocationPanel;
    private JLabel foobarLocationLabel;
    private JTextField foobarLocationTextField;
    private JFileChooser foobarLocationChooser;
    private JButton foobarLocationChooserButton;

    private JPanel rawNowPlayingFilePanel;
    private JLabel rawNowPlayingFileLabel;
    private JTextField rawNowPlayingFileTextField;
    private JFileChooser rawNowPlayingFileChooser;
    private JButton rawNowPlayingFileChooserButton;

    private JPanel nowPlayingFilePanel;
    private JLabel nowPlayingFileLabel;
    private JTextField nowPlayingFileTextField;
    private JFileChooser nowPlayingFileChooser;
    private JButton nowPlayingFileChooserButton;

    private JPanel nowPlayingFileFilePanel;
    private JLabel nowPlayingFileFileLabel;
    private JTextField nowPlayingFileFileTextField;
    private JFileChooser nowPlayingFileFileChooser;
    private JButton nowPlayingFileFileChooserButton;

    private JPanel autoRunFoobarNowPlayingConverterPanel;
    private JLabel autoRunFoobarNowPlayingConverterLabel;
    private JCheckBox autoRunFoobarNowPlayingConverterCheckbox;

    private JButton openServerButton;
    private JButton saveButton;

    public SettingsPanel() {
        super();
        setLayout(new BorderLayout());

        setupPanes();
        addComponents();
    }

    private void setupPanes() {
        this.mainPane = new JPanel();
        this.mainPane.setLayout(new BoxLayout(this.mainPane, BoxLayout.Y_AXIS));

        this.buttonPane = new JPanel();
        this.buttonPane.setLayout(new FlowLayout());

        setupTwitchUsernamePanel();
        setupTwitchAPITokenPanel();
        setupTwitchAPIClientIDPanel();
        setupStreamTipClientIDPanel();
        setupStreamTipAccessTokenPanel();
        setupTimeBetweenFollowerChecksPanel();
        setupTimeBetweenDonationChecksPanel();
        setupTimeBetweenViewerCountChecksPanel();
        setupNumberOfPointsOnViewerChartPanel();
        setupServerPortPanel();

        setupFollowerSoundPanel();
        setupDonationSoundPanel();

        setupFoobarLocationPanel();

        setupRawNowPlayingFilePanel();
        setupNowPlayingFilePanel();
        setupNowPlayingFileFilePanel();

        setupAutoRunFoobarNowPlayingConverterPanel();

        setupButtonPanel();
    }

    private void setupTwitchUsernamePanel() {
        this.twitchUsernamePanel = new JPanel();
        this.twitchUsernamePanel.setLayout(new FlowLayout());

        this.twitchUsernameLabel = new JLabel("Twitch Username:");
        this.twitchUsernameTextField = new JTextField(App.NOTIFIER.getSettings().getTwitchUsername(), 16);

        this.twitchUsernamePanel.add(this.twitchUsernameLabel);
        this.twitchUsernamePanel.add(this.twitchUsernameTextField);
    }

    private void setupTwitchAPITokenPanel() {
        this.twitchAPITokenPanel = new JPanel();
        this.twitchAPITokenPanel.setLayout(new FlowLayout());

        this.twitchAPITokenLabel = new JLabel("Twitch API Token:");

        this.twitchAPITokenTextField = new JTextField(App.NOTIFIER.getSettings().getTwitchAPIToken(), 16);

        this.twitchAPITokenButton = new JButton("?");
        this.twitchAPITokenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Utils.openLink("http://www.ryandowling.me/twitch-api-token-generator/");
            }
        });

        this.twitchAPITokenPanel.add(this.twitchAPITokenLabel);
        this.twitchAPITokenPanel.add(this.twitchAPITokenTextField);
        this.twitchAPITokenPanel.add(this.twitchAPITokenButton);
    }

    private void setupTwitchAPIClientIDPanel() {
        this.twitchAPIClientIDPanel = new JPanel();
        this.twitchAPIClientIDPanel.setLayout(new FlowLayout());

        this.twitchAPIClientIDLabel = new JLabel("Twitch API ClientID:");

        this.twitchAPIClientIDTextField = new JTextField(App.NOTIFIER.getSettings().getTwitchAPIClientID(), 16);

        this.twitchAPIClientIDButton = new JButton("?");
        this.twitchAPIClientIDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Utils.openLink("http://www.ryandowling.me/twitch-api-token-generator/");
            }
        });

        this.twitchAPIClientIDPanel.add(this.twitchAPIClientIDLabel);
        this.twitchAPIClientIDPanel.add(this.twitchAPIClientIDTextField);
        this.twitchAPIClientIDPanel.add(this.twitchAPIClientIDButton);
    }

    private void setupStreamTipClientIDPanel() {
        this.streamTipClientIDPanel = new JPanel();
        this.streamTipClientIDPanel.setLayout(new FlowLayout());

        this.streamTipClientIDLabel = new JLabel("Stream Tip Client ID:");
        this.streamTipClientIDTextField = new JTextField(App.NOTIFIER.getSettings().getStreamTipClientID(), 16);

        this.streamTipClientIDPanel.add(this.streamTipClientIDLabel);
        this.streamTipClientIDPanel.add(this.streamTipClientIDTextField);
    }

    private void setupStreamTipAccessTokenPanel() {
        this.streamTipAccessTokenPanel = new JPanel();
        this.streamTipAccessTokenPanel.setLayout(new FlowLayout());

        this.streamTipAccessTokenLabel = new JLabel("Stream Tip Access Token:");
        this.streamTipAccessTokenTextField = new JTextField(App.NOTIFIER.getSettings().getStreamTipAccessToken(), 16);

        this.streamTipAccessTokenPanel.add(this.streamTipAccessTokenLabel);
        this.streamTipAccessTokenPanel.add(this.streamTipAccessTokenTextField);
    }

    private void setupTimeBetweenFollowerChecksPanel() {
        this.timeBetweenFollowerChecksPanel = new JPanel();
        this.timeBetweenFollowerChecksPanel.setLayout(new FlowLayout());

        this.timeBetweenFollowerChecksLabel = new JLabel("Seconds Between New Follower Checks:");

        this.timeBetweenFollowerChecksSpinner = new JSpinner();
        this.timeBetweenFollowerChecksSpinner.setModel(new SpinnerNumberModel(App.NOTIFIER.getSettings()
                .getSecondsBetweenFollowerChecks(), 10, 60, 5));

        this.timeBetweenFollowerChecksPanel.add(this.timeBetweenFollowerChecksLabel);
        this.timeBetweenFollowerChecksPanel.add(this.timeBetweenFollowerChecksSpinner);
    }

    private void setupTimeBetweenDonationChecksPanel() {
        this.timeBetweenDonationChecksPanel = new JPanel();
        this.timeBetweenDonationChecksPanel.setLayout(new FlowLayout());

        this.timeBetweenDonationChecksLabel = new JLabel("Seconds Between New Donation Checks:");

        this.timeBetweenDonationChecksSpinner = new JSpinner();
        this.timeBetweenDonationChecksSpinner.setModel(new SpinnerNumberModel(App.NOTIFIER.getSettings()
                .getSecondsBetweenDonationChecks(), 10, 60, 5));

        this.timeBetweenDonationChecksPanel.add(this.timeBetweenDonationChecksLabel);
        this.timeBetweenDonationChecksPanel.add(this.timeBetweenDonationChecksSpinner);
    }

    private void setupTimeBetweenViewerCountChecksPanel() {
        this.timeBetweenViewerCountChecksPanel = new JPanel();
        this.timeBetweenViewerCountChecksPanel.setLayout(new FlowLayout());

        this.timeBetweenViewerCountChecksLabel = new JLabel("Seconds Between Viewer Count Checks:");

        this.timeBetweenViewerCountChecksSpinner = new JSpinner();
        this.timeBetweenViewerCountChecksSpinner.setModel(new SpinnerNumberModel(App.NOTIFIER.getSettings()
                .getSecondsBetweenViewerCountChecks(), 10, 60, 5));

        this.timeBetweenViewerCountChecksPanel.add(this.timeBetweenViewerCountChecksLabel);
        this.timeBetweenViewerCountChecksPanel.add(this.timeBetweenViewerCountChecksSpinner);
    }

    private void setupNumberOfPointsOnViewerChartPanel() {
        this.numberOfPointsOnViewerChartPanel = new JPanel();
        this.numberOfPointsOnViewerChartPanel.setLayout(new FlowLayout());

        this.numberOfPointsOnViewerChartLabel = new JLabel("Number Of Points On Viewer Count Chart:");

        this.numberOfPointsOnViewerChartSpinner = new JSpinner();
        this.numberOfPointsOnViewerChartSpinner.setModel(new SpinnerNumberModel(App.NOTIFIER.getSettings()
                .getNumberOfPointsOnViewerChart(), 5, 100, 1));

        this.numberOfPointsOnViewerChartPanel.add(this.numberOfPointsOnViewerChartLabel);
        this.numberOfPointsOnViewerChartPanel.add(this.numberOfPointsOnViewerChartSpinner);
    }

    private void setupServerPortPanel() {
        this.serverPortPanel = new JPanel();
        this.serverPortPanel.setLayout(new FlowLayout());

        this.serverPortLabel = new JLabel("Server Port:");

        this.serverPortTextField = new JTextField("" + App.NOTIFIER.getSettings().getServerPort(), 16);

        this.serverPortPanel.add(this.serverPortLabel);
        this.serverPortPanel.add(this.serverPortTextField);
    }

    private void setupFollowerSoundPanel() {
        this.newFollowerSoundPanel = new JPanel();
        this.newFollowerSoundPanel.setLayout(new FlowLayout());

        this.newFollowerSoundLabel = new JLabel("New Follower Sound:");

        this.newFollowerSoundTextField = new JTextField(App.NOTIFIER.getSettings().getNewFollowSoundPath(), 16);
        this.newFollowerSoundTextField.setEnabled(false);

        this.newFollowerSoundChooser = new JFileChooser();
        this.newFollowerSoundChooser.setMultiSelectionEnabled(false);
        this.newFollowerSoundChooser.addChoosableFileFilter(Utils.getWavFileFilter());
        this.newFollowerSoundChooser.setFileFilter(Utils.getWavFileFilter());

        this.newFollowerSoundChooserButton = new JButton("Browse");
        this.newFollowerSoundChooserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newFollowerSoundChooser.showOpenDialog(SettingsPanel.this);
                if (newFollowerSoundChooser.getSelectedFile() != null) {
                    newFollowerSoundTextField.setText(newFollowerSoundChooser.getSelectedFile().getAbsolutePath());
                }
            }
        });

        this.newFollowerSoundTestButton = new JButton("Test");
        this.newFollowerSoundTestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!newFollowerSoundTextField.getText().isEmpty()) {
                    Path path = Paths.get(newFollowerSoundTextField.getText());
                    if (Files.exists(path) && Files.isRegularFile(path)) {
                        SoundPlayer.playSound(path);
                    }
                }
            }
        });

        this.newFollowerSoundPanel.add(this.newFollowerSoundLabel);
        this.newFollowerSoundPanel.add(this.newFollowerSoundTextField);
        this.newFollowerSoundPanel.add(this.newFollowerSoundChooserButton);
        this.newFollowerSoundPanel.add(this.newFollowerSoundTestButton);
    }

    private void setupDonationSoundPanel() {
        this.newDonationSoundPanel = new JPanel();
        this.newDonationSoundPanel.setLayout(new FlowLayout());

        this.newDonationSoundLabel = new JLabel("New Donation Sound:");

        this.newDonationSoundTextField = new JTextField(App.NOTIFIER.getSettings().getNewDonationSoundPath(), 16);
        this.newDonationSoundTextField.setEnabled(false);

        this.newDonationSoundChooser = new JFileChooser();
        this.newDonationSoundChooser.setMultiSelectionEnabled(false);
        this.newDonationSoundChooser.addChoosableFileFilter(Utils.getWavFileFilter());
        this.newDonationSoundChooser.setFileFilter(Utils.getWavFileFilter());

        this.newDonationSoundChooserButton = new JButton("Browse");
        this.newDonationSoundChooserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newDonationSoundChooser.showOpenDialog(SettingsPanel.this);
                if (newDonationSoundChooser.getSelectedFile() != null) {
                    newDonationSoundTextField.setText(newDonationSoundChooser.getSelectedFile().getAbsolutePath());
                }
            }
        });

        this.newDonationSoundTestButton = new JButton("Test");
        this.newDonationSoundTestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!newDonationSoundTextField.getText().isEmpty()) {
                    Path path = Paths.get(newDonationSoundTextField.getText());
                    if (Files.exists(path) && Files.isRegularFile(path)) {
                        SoundPlayer.playSound(path);
                    }
                }
            }
        });

        this.newDonationSoundPanel.add(this.newDonationSoundLabel);
        this.newDonationSoundPanel.add(this.newDonationSoundTextField);
        this.newDonationSoundPanel.add(this.newDonationSoundChooserButton);
        this.newDonationSoundPanel.add(this.newDonationSoundTestButton);
    }

    private void setupFoobarLocationPanel() {
        this.foobarLocationPanel = new JPanel();
        this.foobarLocationPanel.setLayout(new FlowLayout());

        this.foobarLocationLabel = new JLabel("foobar2000 Executable File:");

        this.foobarLocationTextField = new JTextField(App.NOTIFIER.getSettings().getFoobarLocation(), 16);
        this.foobarLocationTextField.setEnabled(false);

        this.foobarLocationChooser = new JFileChooser();
        this.foobarLocationChooser.setMultiSelectionEnabled(false);

        this.foobarLocationChooserButton = new JButton("Browse");
        this.foobarLocationChooserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                foobarLocationChooser.showOpenDialog(SettingsPanel.this);
                if (foobarLocationChooser.getSelectedFile() != null) {
                    foobarLocationTextField.setText(foobarLocationChooser.getSelectedFile().getAbsolutePath());
                }
            }
        });

        this.foobarLocationPanel.add(this.foobarLocationLabel);
        this.foobarLocationPanel.add(this.foobarLocationTextField);
        this.foobarLocationPanel.add(this.foobarLocationChooserButton);
    }

    private void setupRawNowPlayingFilePanel() {
        this.rawNowPlayingFilePanel = new JPanel();
        this.rawNowPlayingFilePanel.setLayout(new FlowLayout());

        this.rawNowPlayingFileLabel = new JLabel("Now Playing Raw File:");

        this.rawNowPlayingFileTextField = new JTextField(App.NOTIFIER.getSettings().getRawNowPlayingFilePath(), 16);
        this.rawNowPlayingFileTextField.setEnabled(false);

        this.rawNowPlayingFileChooser = new JFileChooser();
        this.rawNowPlayingFileChooser.setMultiSelectionEnabled(false);

        this.rawNowPlayingFileChooserButton = new JButton("Browse");
        this.rawNowPlayingFileChooserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rawNowPlayingFileChooser.showOpenDialog(SettingsPanel.this);
                if (rawNowPlayingFileChooser.getSelectedFile() != null) {
                    rawNowPlayingFileTextField.setText(rawNowPlayingFileChooser.getSelectedFile().getAbsolutePath());
                }
            }
        });

        this.rawNowPlayingFilePanel.add(this.rawNowPlayingFileLabel);
        this.rawNowPlayingFilePanel.add(this.rawNowPlayingFileTextField);
        this.rawNowPlayingFilePanel.add(this.rawNowPlayingFileChooserButton);
    }

    private void setupNowPlayingFilePanel() {
        this.nowPlayingFilePanel = new JPanel();
        this.nowPlayingFilePanel.setLayout(new FlowLayout());

        this.nowPlayingFileLabel = new JLabel("Now Playing Output File:");

        this.nowPlayingFileTextField = new JTextField(App.NOTIFIER.getSettings().getNowPlayingFilePath(), 16);
        this.nowPlayingFileTextField.setEnabled(false);

        this.nowPlayingFileChooser = new JFileChooser();
        this.nowPlayingFileChooser.setMultiSelectionEnabled(false);

        this.nowPlayingFileChooserButton = new JButton("Browse");
        this.nowPlayingFileChooserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nowPlayingFileChooser.showOpenDialog(SettingsPanel.this);
                if (nowPlayingFileChooser.getSelectedFile() != null) {
                    nowPlayingFileTextField.setText(nowPlayingFileChooser.getSelectedFile().getAbsolutePath());
                }
            }
        });

        this.nowPlayingFilePanel.add(this.nowPlayingFileLabel);
        this.nowPlayingFilePanel.add(this.nowPlayingFileTextField);
        this.nowPlayingFilePanel.add(this.nowPlayingFileChooserButton);
    }

    private void setupNowPlayingFileFilePanel() {
        this.nowPlayingFileFilePanel = new JPanel();
        this.nowPlayingFileFilePanel.setLayout(new FlowLayout());

        this.nowPlayingFileFileLabel = new JLabel("Now Playing File Output File:");

        this.nowPlayingFileFileTextField = new JTextField(App.NOTIFIER.getSettings().getNowPlayingFileFilePath(), 16);
        this.nowPlayingFileFileTextField.setEnabled(false);

        this.nowPlayingFileFileChooser = new JFileChooser();
        this.nowPlayingFileFileChooser.setMultiSelectionEnabled(false);

        this.nowPlayingFileFileChooserButton = new JButton("Browse");
        this.nowPlayingFileFileChooserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nowPlayingFileFileChooser.showOpenDialog(SettingsPanel.this);
                if (nowPlayingFileFileChooser.getSelectedFile() != null) {
                    nowPlayingFileFileTextField.setText(nowPlayingFileFileChooser.getSelectedFile().getAbsolutePath());
                }
            }
        });

        this.nowPlayingFileFilePanel.add(this.nowPlayingFileFileLabel);
        this.nowPlayingFileFilePanel.add(this.nowPlayingFileFileTextField);
        this.nowPlayingFileFilePanel.add(this.nowPlayingFileFileChooserButton);
    }

    private void setupAutoRunFoobarNowPlayingConverterPanel() {
        this.autoRunFoobarNowPlayingConverterPanel = new JPanel();
        this.autoRunFoobarNowPlayingConverterPanel.setLayout(new FlowLayout());

        this.autoRunFoobarNowPlayingConverterLabel = new JLabel("Auto Run Foobar Now Playing Converter?");

        this.autoRunFoobarNowPlayingConverterCheckbox = new JCheckBox();
        this.autoRunFoobarNowPlayingConverterCheckbox.setSelected(App.NOTIFIER.getSettings().autoRunFoobarNowPlayingConverter());

        this.autoRunFoobarNowPlayingConverterPanel.add(this.autoRunFoobarNowPlayingConverterLabel);
        this.autoRunFoobarNowPlayingConverterPanel.add(this.autoRunFoobarNowPlayingConverterCheckbox);
    }

    private void setupButtonPanel() {
        this.saveButton = new JButton("Save");
        this.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveSettings();
            }
        });

        this.openServerButton = new JButton("Open Server");
        this.openServerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Utils.openLink("http://localhost:" + serverPortTextField.getText());
            }
        });
    }

    private void addComponents() {
        this.mainPane.add(this.twitchUsernamePanel);
        this.mainPane.add(this.twitchAPITokenPanel);
        this.mainPane.add(this.twitchAPIClientIDPanel);
        this.mainPane.add(this.streamTipClientIDPanel);
        this.mainPane.add(this.streamTipAccessTokenPanel);
        this.mainPane.add(this.timeBetweenFollowerChecksPanel);
        this.mainPane.add(this.timeBetweenDonationChecksPanel);
        this.mainPane.add(this.timeBetweenViewerCountChecksPanel);
        this.mainPane.add(this.numberOfPointsOnViewerChartPanel);
        this.mainPane.add(this.serverPortPanel);

        this.mainPane.add(this.newFollowerSoundPanel);
        this.mainPane.add(this.newDonationSoundPanel);

        this.mainPane.add(this.foobarLocationPanel);

        this.mainPane.add(this.rawNowPlayingFilePanel);
        this.mainPane.add(this.nowPlayingFilePanel);
        this.mainPane.add(this.nowPlayingFileFilePanel);

        this.mainPane.add(this.autoRunFoobarNowPlayingConverterPanel);

        this.buttonPane.add(this.saveButton);
        this.buttonPane.add(this.openServerButton);

        add(this.mainPane, BorderLayout.CENTER);
        add(this.buttonPane, BorderLayout.SOUTH);
    }

    private void saveSettings() {
        boolean restartApp = false;

        if (this.twitchUsernameTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Twitch username cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (this.twitchAPITokenTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Twitch API Token cannot be empty!", "Error", JOptionPane
                    .ERROR_MESSAGE);
            return;
        }

        if (!Utils.isTwitchAPITokenValid(this.twitchAPITokenTextField.getText())) {
            JOptionPane.showMessageDialog(this, "Twitch API Token is invalid!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (this.streamTipClientIDTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Stream Tip client ID cannot be empty!", "Error", JOptionPane
                    .ERROR_MESSAGE);
            return;
        }

        if (this.streamTipAccessTokenTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Stream Tip access token cannot be empty!", "Error", JOptionPane
                    .ERROR_MESSAGE);
            return;
        }

        if ((int) this.timeBetweenFollowerChecksSpinner.getValue() < 10 || (int) this
                .timeBetweenFollowerChecksSpinner.getValue() > 60) {
            JOptionPane.showMessageDialog(this, "Time between follower checks must be between 10 and 60 seconds!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if ((int) this.timeBetweenDonationChecksSpinner.getValue() < 10 || (int) this
                .timeBetweenDonationChecksSpinner.getValue() > 60) {
            JOptionPane.showMessageDialog(this, "Time between donation checks must be between 10 and 60 seconds!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if ((int) this.timeBetweenViewerCountChecksSpinner.getValue() < 10 || (int) this
                .timeBetweenViewerCountChecksSpinner.getValue() > 60) {
            JOptionPane.showMessageDialog(this, "Time between viewer count checks must be between 10 and 60 " +
                    "seconds!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if ((int) this.numberOfPointsOnViewerChartSpinner.getValue() < 5 || (int) this
                .numberOfPointsOnViewerChartSpinner.getValue() > 100) {
            JOptionPane.showMessageDialog(this, "Number of points on viewer count chart must be between 5 and 100!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (this.newFollowerSoundTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "New follower sound must be set!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (this.newDonationSoundTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "New donation sound must be set!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!App.NOTIFIER.getSettings().getTwitchUsername().equalsIgnoreCase(this.twitchUsernameTextField.getText())) {
            try {
                FileUtils.forceDeleteOnExit(Utils.getFollowersFile().toFile());
                FileUtils.forceDeleteOnExit(Utils.getDonationsFile().toFile());
                FileUtils.forceDeleteOnExit(Utils.getTxtDir().toFile());
            } catch (IOException e) {
                e.printStackTrace();
            }

            restartApp = true;
        }

        if (App.NOTIFIER.getSettings().getServerPort() != Integer.parseInt(this.serverPortTextField.getText())) {
            restartApp = true;
        }

        App.NOTIFIER.getSettings().setTwitchUsername(this.twitchUsernameTextField.getText());
        App.NOTIFIER.getSettings().setTwitchAPIToken(this.twitchAPITokenTextField.getText());
        App.NOTIFIER.getSettings().setTwitchAPIClientID(this.twitchAPIClientIDTextField.getText());
        App.NOTIFIER.getSettings().setStreamTipClientID(this.streamTipClientIDTextField.getText());
        App.NOTIFIER.getSettings().setStreamTipAccessToken(this.streamTipAccessTokenTextField.getText());
        App.NOTIFIER.getSettings().setSecondsBetweenFollowerChecks((int) this.timeBetweenFollowerChecksSpinner
                .getValue());
        App.NOTIFIER.getSettings().setSecondsBetweenDonationChecks((int) this.timeBetweenDonationChecksSpinner
                .getValue());
        App.NOTIFIER.getSettings().setSecondsBetweenViewerCountChecks((int) this.timeBetweenViewerCountChecksSpinner
                .getValue());
        App.NOTIFIER.getSettings().setNumberOfPointsOnViewerChart((int) this.numberOfPointsOnViewerChartSpinner
                .getValue());
        App.NOTIFIER.getSettings().setServerPort(Integer.parseInt(this.serverPortTextField.getText().replaceAll
                ("[^0-9]", "")));

        if (this.newFollowerSoundChooser.getSelectedFile() != null) {
            App.NOTIFIER.getSettings().setNewFollowSound(this.newFollowerSoundChooser.getSelectedFile()
                    .getAbsolutePath());
        }

        if (this.newDonationSoundChooser.getSelectedFile() != null) {
            App.NOTIFIER.getSettings().setNewDonationSound(this.newDonationSoundChooser.getSelectedFile()
                    .getAbsolutePath());
        }

        if (this.foobarLocationChooser.getSelectedFile() != null) {
            App.NOTIFIER.getSettings().setFoobarLocation(this.foobarLocationChooser.getSelectedFile()
                    .getAbsolutePath());
        }

        if (this.rawNowPlayingFileChooser.getSelectedFile() != null) {
            App.NOTIFIER.getSettings().setRawNowPlayingFile(this.rawNowPlayingFileChooser.getSelectedFile()
                    .getAbsolutePath());
        }

        if (this.nowPlayingFileChooser.getSelectedFile() != null) {
            App.NOTIFIER.getSettings().setNowPlayingFile(this.nowPlayingFileChooser.getSelectedFile()
                    .getAbsolutePath());
        }

        if (this.nowPlayingFileFileChooser.getSelectedFile() != null) {
            App.NOTIFIER.getSettings().setNowPlayingFileFile(this.nowPlayingFileFileChooser.getSelectedFile()
                    .getAbsolutePath());
        }

        App.NOTIFIER.getSettings().setAutoRunFoobarNowPlayingConverter(this.autoRunFoobarNowPlayingConverterCheckbox.isSelected());

        App.NOTIFIER.getSettings().setupFinished();
        App.NOTIFIER.saveSettings();
        SettingsManager.setupComplete();
        Toaster.instance().pop("Settings saved!");

        if (restartApp) {
            JOptionPane.showMessageDialog(this, "The app must be restarted! Please rerun the application after " +
                    "clicking OK!", "Restart Required", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
}
