package com.konrad.genderdetector.dao;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.springframework.stereotype.Repository;

import java.beans.FeatureDescriptor;
import java.io.*;
import java.util.Scanner;
import java.util.stream.Collectors;

@Repository
public class TokenNameDao implements TokenDao {
    private final String FEMALE_NAME = "/femaleNames.txt";
    private final String MALE_NAME = "/maleNames.txt";
    private InputStream inputStream = null;
    private Scanner scanner = null;

    @Override
    public String getFemaleNames() {
        return getAllNamesFromFile(FEMALE_NAME);
    }

    @Override
    public String getMaleNames() {
        return getAllNamesFromFile(MALE_NAME);
    }

    public Scanner scanThroughFemaleName() {
        return scanThroughFile(FEMALE_NAME);
    }

    public Scanner scanThroughMaleName() {
        return scanThroughFile(MALE_NAME);
    }

    private Scanner scanThroughFile(String pathFile) {
        inputStream = getClass().getResourceAsStream(pathFile);
        scanner = new Scanner(inputStream, "UTF-8");
        return scanner;
    }

    public String getAllNamesFromFile(String pathFile) {
        StringBuilder allNames = new StringBuilder();
        scanner = scanThroughFile(pathFile);
        while (scanner.hasNextLine()) {
            allNames.append(scanner.nextLine()).append("\n");
        }
        return allNames.toString();
    }


//    public String readFromInputStream(String fileName) {
//        String names = "";
//        ClassLoader classLoader = getClass().getClassLoader();
//        File file = new File(classLoader.getResource(fileName).getFile());
//        try {
//            FileReader fileReader = new FileReader(file);
//            BufferedReader br = new BufferedReader(fileReader);
//            names = br.lines().collect(Collectors.joining("\n"));
//            br.close();
//        } catch (FileNotFoundException e) {
//            System.err.println("Files does not exist");
//        } catch (IOException e) {
//            System.err.println("File exists, but there was IOException");
//        }
//        return names;

//    }

    //Use apache commons I/O
//    private LineIterator readThroughFile(File fileName, String encoderType) throws IOException {
//        LineIterator it = FileUtils.lineIterator(fileName, "UTF-8");
//        return it;
//    }

    //Use apache commons I/O
//    private String getAllNamesFromFile2(String pathFile) throws IOException {
//        StringBuilder allNames = new StringBuilder();
//        LineIterator it = readThroughFile(new File(pathFile), "UTF-8");
//
//        while (it.hasNext()) {
//            allNames.append(it.nextLine()).append("\n");
//        }
//        return allNames.toString();
//    }


}
