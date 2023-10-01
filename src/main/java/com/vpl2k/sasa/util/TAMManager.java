package com.vpl2k.sasa.util;

import com.vpl2k.sasa.SASAApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TAMManager
{
    private SASAApplication sasaApplication;
    private File file;
    private final BufferedReader reader;

    public TAMManager(File file) throws IOException
    {
        this.sasaApplication = SASAApplication.getApplicationInstance();
        this.file = file;
        this.reader = new BufferedReader(new FileReader(file));
    }

    public void readFile() throws IOException
    {

    }

}
