/*
 * GPLv3 License
 *
 * Copyright (c) 2023-2025 4ra1n (Jar Analyzer Team)
 *
 * This project is distributed under the GPLv3 license.
 *
 * https://github.com/jar-analyzer/jar-analyzer/blob/master/LICENSE
 */

package me.n1ar4.jar.analyzer.taint;

import me.n1ar4.jar.analyzer.dfs.DFSResult;

import java.util.concurrent.ConcurrentLinkedQueue;

public class TaintCache {
    public static ConcurrentLinkedQueue<DFSResult> dfsCache = new ConcurrentLinkedQueue<>();
    public static ConcurrentLinkedQueue<TaintResult> cache = new ConcurrentLinkedQueue<>();
}
