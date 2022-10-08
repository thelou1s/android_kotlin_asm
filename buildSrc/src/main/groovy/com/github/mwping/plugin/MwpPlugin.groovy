package com.github.mwping.plugin

import com.github.mwping.plugin.utils.MwpLogger
import org.gradle.api.Plugin
import org.gradle.api.Project


class MwpPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        MwpLogger logger = new MwpLogger(project)
        logger.error("apply MwpPlugin #thelou1s")
    }
}