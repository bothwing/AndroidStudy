package com.bothwing.studyproject;

public class MainAdapterData {
    enum Menu {MENU_RECYCLER}

    public String mTitle, mContents;
    public Menu mMenu;

    public MainAdapterData(Menu number, String title, String contents) {
        mMenu = number;
        mTitle = title;
        mContents = contents;
    }
}