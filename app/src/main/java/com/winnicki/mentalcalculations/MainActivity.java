package com.winnicki.mentalcalculations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

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
    ArrayList<String> characters;

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
        characters = new ArrayList<>();
        for(int i=0;i<listOfOperations.size();i++) {
            Operation operation = listOfOperations.get(i);
            characters.add(operation.getFirstOperand());
            characters.add(operation.getOperator());
            characters.add(operation.getSecondOperand());
            characters.add(operation.getEqualSign());
            characters.add(operation.getResult());
            characters.add(String.valueOf(operation.getMark()));
        }
        adapter = new OperationAdapter(this, characters);
        gridViewOperations.setAdapter(adapter);
        gridViewOperations.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(!editTextResult.getText().toString().isEmpty()) {
            switch (position) {
                case 4:
                case 10:
                case 16:
                case 22:
                case 28:
                    characters.set(position, editTextResult.getText().toString());
                    characters.set(position+1, "good");
                    adapter.notifyDataSetChanged();
            }
        }
    }
}
