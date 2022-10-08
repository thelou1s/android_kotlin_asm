package com.github.mwping.plugin.utils;

import org.gradle.api.Project;
import org.gradle.api.logging.Logger;

public class MwpLogger {
    private static final char TOP_LEFT_CORNER = '┌';
    private static final char BOTTOM_LEFT_CORNER = '└';
    private static final char HORIZONTAL_LINE = '│';
    private static final String DIVIDER = "─────────────────────────────────────────────────";
    private Project project;
    private Logger logger;

    public MwpLogger(Project project) {
        this.project = project;
        logger = project.getLogger();
    }

    public void error(String s) {
        //String info = String.format("%1$s\n%2$s %3$s\n%4$s", "" + TOP_LEFT_CORNER + DIVIDER, HORIZONTAL_LINE, s, "" + BOTTOM_LEFT_CORNER + DIVIDER);
        //logger.error(info);

        logger.error(s);
    }
}