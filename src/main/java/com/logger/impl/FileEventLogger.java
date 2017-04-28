package com.logger.impl;

import com.event.Event;
import com.logger.EventLogger;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Volodymyr_Kravtsov on 4/28/2017.
 */
public class FileEventLogger implements EventLogger {
    private String filename;
    private File file;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    private void init() throws IOException {
        this.file = new File(filename);
        if (!file.canWrite()) {
            throw new IOException("Cannot write in file");
        }
    }

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString(), "utf-8", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
