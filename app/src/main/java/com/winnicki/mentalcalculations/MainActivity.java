package com.winnicki.mentalcalculations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.winnicki.mentalcalculations.model.FileOperationManagement;
import com.winnicki.mentalcalculations.model.Operation;
import com.winnicki.mentalcalculations.model.OperationAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GridView.OnItemClickListener {

    GridView gridViewOperations;
    EditText editTextResult;
    TextView textViewScore;

    ArrayList<Operation> listOfOperations;
    OperationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        gridViewOperations = (GridView)findViewById(R.id.gridViewOperations);
        editTextResult = (EditText)findViewById(R.id.editTextResult);
        textViewScore = (TextView)findViewById(R.id.textViewScore);

        listOfOperations = FileOperationManagement.readFile(this, "operations.txt");
        adapter = new OperationAdapter(this, listOfOperations);
        gridViewOperations.setAdapter(adapter);
        gridViewOperations.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int columnNumber = (position%6)+1;
        int rowNumber=(position/6);

        String userResult = editTextResult.getText().toString();

        Operation operation = listOfOperations.get(rowNumber);

        if(columnNumber == 5) {
            if (!userResult.isEmpty()) {
                operation.setResult(userResult);
                if (operation.checkResult(userResult)) {
                    operation.setMark(EnumMark.CORRECT);
                } else {
                    operation.setMark(EnumMark.WRONG);
                }
                adapter.notifyDataSetChanged();
            } else if (userResult.isEmpty()) {
                Toast.makeText(this, "Please enter a result.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void calculateScore(View view) {
        double numberOfGoodAnswers = 0;
        for (int i=0; i<listOfOperations.size(); i++) {
            if(listOfOperations.get(i).getMark() == EnumMark.CORRECT) {
                numberOfGoodAnswers++;
            }
        }
        textViewScore.setText(String.format("%s%%", String.valueOf((numberOfGoodAnswers / 5.0f) * 100.0f)));
    }
}
