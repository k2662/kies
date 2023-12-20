//
//  head.h
//  kies
//
//  Created by jodus on 14/02/2018.
//  Copyright � 2018 Thomas Billiet. All rights reserved.
//

#ifndef head_hpp
#define head_hpp

// Boilerplate Subclasses

class NSApplicationImpl {
public:
    void shutErrorsUp() {
        // Method implementations go here
    }
};

void NSApplicationRegisterClass() {
    NSApplication::registerClass();
    NSApplicationImpl nsApplicationImpl;
    NSApplication::setClassName(NSClassFromString(@"NSApplication")->className(), nsApplicationImpl);
    NSApplication::setDelegateClassName(NSClassFromString(@"NSApplication")->className(), NSClassFromString(@"ShutErrorsUp")->className());
}

class SDTableViewImpl {
public:
    bool acceptsFirstResponder() {
        return false;
    }
    
    bool becomeFirstResponder() {
        return false;
    }
    
    bool canBecomeKeyView() {
        return false;
    }
};

void SDTableViewRegisterClass() {
    SDTableView::registerClass();
    SDTableViewImpl sdTableViewImpl;
    SDTableView::setClassName(NSClassFromString(@"SDTableView")->className(), sdTableViewImpl);
    NSView::setCellClass(SDTableView::className(), SDTableViewCell::class());
}

class SDMainWindowImpl {
public:
    bool canBecomeKeyWindow() {
        return true;
    }
    
    bool canBecomeMainWindow() {
        return true;
    }
};

void SDMainWindowRegisterClass() {
    SDMainWindow::registerClass();
    SDMainWindowImpl sdMainWindowImpl;
    SDMainWindow::setClassName(NSClassFromString(@"SDMainWindow")->className(), sdMainWindowImpl);
}

// Choice

class SDChoiceImpl {
public:
    std::string normalized;
    std::string raw;
    NSIndexSet* indexSet;
    NSAttributedString* displayString;
    bool hasAllCharacters;
    int score;
};

// App Delegate

class SDAppDelegateImpl : public NSObject, public NSApplicationDelegate, public NSWindowDelegate, public NSText
