package com.winnicki.mentalcalculations.model;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileOperationManagement {

    public static ArrayList<Operation> readFile(Context context, String fileName) {
        ArrayList<Operation> listOfOperations = new ArrayList<>();

        AssetManager assetManager = context.getResources().getAssets();

        try {
            InputStreamReader isr = new InputStreamReader(assetManager.open(fileName));
            BufferedReader br = new BufferedReader(isr);
            String oneLine;

            while ((oneLine = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(oneLine, ";");
                int firstOperand = Integer.parseInt(st.nextToken());
                String operator = st.nextToken();
                int secondOperand = Integer.parseInt(st.nextToken());
                String equalSign = st.nextToken();
                String questionMark = st.nextToken();
                Operation operation = new Operation(firstOperand,operator,secondOperand,equalSign,questionMark);
                listOfOperations.add(operation);
            }
            br.close();
            isr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfOperations;
    }
}
