package features.in.java9;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Set;

public class Progress {

    public static void main(String[] args) throws Exception {

        Taskbar bar = Taskbar.getTaskbar();
        if (bar.isSupported(Taskbar.Feature.ICON_IMAGE)) {
            Image icon = ImageIO.read(new File("icon.jpg"));
            bar.setIconImage(icon);
        }

        Thread.sleep(1000);
        for (int i = 0; i <= 100; i++) {
            bar.setProgressValue(i);
            Thread.sleep(30);
        }

        bar.setIconBadge("Done!");

        // Only works if application doesn't have focus
        bar.requestUserAttention(true, true);


        Thread.sleep(7000);
    }
}
