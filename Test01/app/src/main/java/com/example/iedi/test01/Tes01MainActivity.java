package com.example.iedi.test01;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;


public class Tes01MainActivity extends ActionBarActivity {

    protected EditText edit1, edit2;
    protected Button button, button2, button3;
    protected GridLayout grid;
    protected int toggle;
    protected EditTextWatcher watcher = new EditTextWatcher();

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements Button.OnClickListener{


        @Override
        public void onClick(View v) {
            int right, left;
            left = Integer.parseInt(edit1.getText().toString());
            right = Integer.parseInt(edit2.getText().toString());



            switch (v.getId()){
                case R.id.button:
                    toggle = toggle * (-1) + 1;
                    if(toggle==0)
                        grid.setVisibility(View.GONE);
                    else
                        grid.setVisibility(View.VISIBLE);
                    break;
                case R.id.button2:
                    left++;
                    edit1.setText(String.valueOf(left));
                    break;
                case R.id.button3:
                    right++;
                    edit2.setText(String.valueOf(right));
                    break;
            }
        }
    }

    private class EditTextWatcher implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            
           /* if(Integer.parseInt(edit1.getText().toString())%2==0){
                toggle = toggle * (-1) + 1;
                if(toggle==0)
                    grid.setVisibility(View.GONE);
                else
                    grid.setVisibility(View.VISIBLE);
            }*/
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes01_main);

        grid = (GridLayout)findViewById(R.id.grid);

        edit1 = (EditText)findViewById(R.id.editText);
        edit2 = (EditText)findViewById(R.id.editText2);

        edit1.setText(String.valueOf(0));
        edit2.setText(String.valueOf(0));

        edit1.addTextChangedListener(watcher);

        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);

        toggle = 1;

        button.setOnClickListener(buttonClickListener);
        button2.setOnClickListener(buttonClickListener);
        button3.setOnClickListener(buttonClickListener);


        if (savedInstanceState != null) {
            String leftCount = savedInstanceState.getString("leftCount");
            if (leftCount != null) {
                edit1.setText(leftCount);
            } else {
                edit1.setText(String.valueOf(0));
            }
            String rightCount = savedInstanceState.getString("rightCount");
            if (rightCount != null) {
                edit2.setText(rightCount);
            } else {
                edit2.setText(String.valueOf(0));
            }
        } else {
            edit1.setText(String.valueOf(0));
            edit2.setText(String.valueOf(0));
        }


    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("leftCount", edit1.getText().toString());
        savedInstanceState.putString("rightCount", edit2.getText().toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tes01_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
