package com.progKiev;

import java.io.File;
import java.io.FileFilter;

public class MyFileFilter implements FileFilter {
    private String extension;

    public MyFileFilter(String extension) {
        this.extension = extension;
    }

    private boolean check(String ext) {
        if (extension.equals(ext)) {
            return true;
        }
        return false;
    }


    @Override
    public boolean accept(File pathname) {
        int pointerIndex = pathname.getName().lastIndexOf(".");
        if (pointerIndex == -1) {
            return false;
        }
        String ext = pathname.getName().substring(pointerIndex + 1);
        return check(ext);
    }
}
