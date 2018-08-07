package sg.edu.rp.c346.dynamicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1;
    Spinner spn2;
    Button btnUpdate;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnUpdate = findViewById(R.id.buttonUpate);

        //Initialise the ArrayList
        alNumbers = new ArrayList<>();

        //Create a ArrayAdapter using the default Spinner layout and the ArrayList
        aaNumbers = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);

        //Bind the ArrayAdapter to the Spinner
        spn2.setAdapter(aaNumbers);

        /*alNumbers.add("2");
        alNumbers.add("4");
        alNumbers.add("6");*/

        //Implement the button onClick() method
        // to load the correct number list when it is clicked
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = spn1.getSelectedItemPosition();
                alNumbers.clear();
                //Get the string-array and store as an Array
                String[] strNumbers = getResources().getStringArray(R.array.even_numbers);

                //Convert Array to List and add to the ArrayList
                alNumbers.addAll(Arrays.asList(strNumbers));
            }

        });

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        alNumbers.clear();
                        String[] evenNumbers = getResources().getStringArray(R.array.even_numbers);
                        alNumbers.addAll(Arrays.asList(evenNumbers));
                        spn2.setSelection(2);
                        aaNumbers.notifyDataSetChanged();
                        break;
                    case 1:
                        alNumbers.clear();
                        String[] oddNumbers = getResources().getStringArray(R.array.odd_numbers);
                        alNumbers.addAll(Arrays.asList(oddNumbers));
                        spn2.setSelection(1);
                        aaNumbers.notifyDataSetChanged();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });

    }
}
