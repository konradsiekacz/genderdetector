package com.konrad.genderdetector.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface TokenDao {
    String getFemaleNames(String fileName) throws IOException;
    String getMaleNames(String fileName);
}
