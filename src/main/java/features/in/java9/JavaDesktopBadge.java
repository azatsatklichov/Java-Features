package features.in.java9;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class JavaDesktopBadge {

    public static void main(String[] args) throws Exception {

        Frame frame = new Frame();
        frame.setSize(400, 400);
        frame.setVisible(true);


        if(Taskbar.isTaskbarSupported()) {
            Taskbar taskbar = Taskbar.getTaskbar();
            if(taskbar.isSupported(Taskbar.Feature.ICON_BADGE_TEXT)) {
                Thread.sleep(2000);
                taskbar.setIconBadge("test!");
            }
        }

    }
}
