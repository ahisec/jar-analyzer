/*
 * GPLv3 License
 *
 * Copyright (c) 2023-2025 4ra1n (Jar Analyzer Team)
 *
 * This project is distributed under the GPLv3 license.
 *
 * https://github.com/jar-analyzer/jar-analyzer/blob/master/LICENSE
 */

package me.n1ar4.jar.analyzer.gui.adapter;

import me.n1ar4.jar.analyzer.gui.MainForm;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FileTreeKeyAdapter extends KeyAdapter {
    private final JPanel fileTreeSearchPanel = MainForm.getInstance().getFileTreeSearchPanel();
    private final JTextField fileTreeSearchTextField = MainForm.getInstance().getFileTreeSearchTextField();

    @Override
    public void keyPressed(KeyEvent e) {
        if ((e.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0 ||
                (e.getModifiersEx() & KeyEvent.META_DOWN_MASK) != 0) {
            if (e.getKeyCode() == KeyEvent.VK_F) {
                fileTreeSearchPanel.setVisible(!fileTreeSearchPanel.isShowing());
                if (fileTreeSearchPanel.isShowing()) {
                    fileTreeSearchTextField.selectAll();
                    fileTreeSearchTextField.requestFocus();
                }
            }
        }
    }
}
