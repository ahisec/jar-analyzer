/*
 * GPLv3 License
 *
 * Copyright (c) 2022-2026 4ra1n (Jar Analyzer Team)
 *
 * This project is distributed under the GPLv3 license.
 *
 * https://github.com/jar-analyzer/jar-analyzer/blob/master/LICENSE
 */

package me.n1ar4.jar.analyzer.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class JarUtilTest {
    @TempDir
    Path tempDir;

    @Test
    public void testResolveArchiveEntryAcceptsPathInsideExtractionRoot() {
        Path target = JarUtil.resolveArchiveEntry(tempDir, "BOOT-INF/classes/application.yml");

        assertEquals(
                tempDir.resolve("BOOT-INF/classes/application.yml").toAbsolutePath().normalize(),
                target);
    }

    @Test
    public void testResolveArchiveEntryRejectsTraversal() {
        assertNull(JarUtil.resolveArchiveEntry(tempDir, "../outside.xml"));
        assertNull(JarUtil.resolveArchiveEntry(tempDir, "nested/../../outside.xml"));
        assertNull(JarUtil.resolveArchiveEntry(tempDir, "..\\outside.xml"));
    }

    @Test
    public void testResolveArchiveEntryRejectsAbsolutePaths() {
        assertNull(JarUtil.resolveArchiveEntry(tempDir, "/absolute/outside.xml"));
        assertNull(JarUtil.resolveArchiveEntry(tempDir, "C:\\absolute\\outside.xml"));
        assertNull(JarUtil.resolveArchiveEntry(tempDir, "\\\\server\\share\\outside.xml"));
    }

    @Test
    public void testResolveArchiveEntryRejectsSharedStringPrefix() {
        Path sibling = tempDir.resolveSibling(tempDir.getFileName() + "-escape")
                .resolve("outside.xml")
                .toAbsolutePath();

        assertNull(JarUtil.resolveArchiveEntry(tempDir, sibling.toString()));
    }
}
