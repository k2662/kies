//
// head.h
// kies
//
// Created by jodus on 14/02/2018.
// Copyright 2018 Thomas Billiet. All rights reserved.
//

import java.util.List;

public class Head {
    public static class NSApplicationImpl {
        public void shutErrorsUp() {
            // Method implementations go here
        }
    }

    public static void NSApplicationRegisterClass() {
        NSApplication.registerClass();
        NSApplicationImpl nsApplicationImpl = new NSApplicationImpl();
        NSApplication.setClassName(NSClass.forString("NSApplication").getClassName(), nsApplicationImpl);
        NSApplication.setDelegateClassName(NSClass.forString("NSApplication").getClassName(), NSClass.forString("ShutErrorsUp").getClassName());
    }

    public static class SDTableViewImpl {
        public boolean acceptsFirstResponder() {
            return false;
        }

        public boolean becomeFirstResponder() {
            return false;
        }

        public boolean canBecomeKeyView() {
            return false;
        }
    }

    public static void SDTableViewRegisterClass() {
        SDTableView.registerClass();
        SDTableViewImpl sdTableViewImpl = new SDTableViewImpl();
        SDTableView.setClassName(NSClass.forString("SDTableView").getClassName(), sdTableViewImpl);
        NSView.setCellClass(SDTableView.getClassName(), SDTableViewCell.class);
    }

    public static class SDMainWindowImpl {
        public boolean canBecomeKeyWindow() {
            return true;
        }

        public boolean canBecomeMainWindow() {
            return true;
        }
    }

    public static void SDMainWindowRegisterClass() {
        SDMainWindow.registerClass();
        SDMainWindowImpl sdMainWindowImpl = new SDMainWindowImpl();
        SDMainWindow.setClassName(NSClass.forString("SDMainWindow").getClassName(), sdMainWindowImpl);
    }

    public static class SDChoiceImpl {
        public String normalized;
        public String raw;
        public NSIndexSet indexSet;
        public NSAttributedString displayString;
        public boolean hasAllCharacters;
        public int score;
    }

    public static class SDAppDelegateImpl extends NSObject implements NSApplicationDelegate, NSWindowDelegate, N

