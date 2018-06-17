package com.example.yuru.baseballscorekeeper;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.baseball.RecordItem;

/**
 * Created by YURU on 2018/6/16.
 */

public class BaseFirstDialog {

    private NewRecordActivity activity;

    //高飛犧牲
    private RadioGroup radioGroup_sacrificeFly_type,radioGroup_sacrificeFly_direction;
    private RadioButton radioButton_sacrificeFly_type_high,radioButton_sacrificeFly_type_line;
    private RadioButton radioButton_sacrificeFly_direction_7,radioButton_sacrificeFly_direction_8,radioButton_sacrificeFly_direction_9;

    //犧牲觸擊
    private Spinner spinner_actionOne,spinner_actionTwo;
    private int actionOne,actionTwo;

    //一般
    private RadioGroup radioGroup_type;
    private RadioButton radioButton_type_high,radioButton_type_line,radioButton_type_ground;
    private Spinner spinner_direction;
    private CheckBox checkBox_elseAc_FC,checkBox_elseAc_u,checkBox_elseAc_E,checkBox_elseAc_T;

    //two
    private Spinner spinner_two_direction;
    private RadioGroup radioGroup_two_Ac;
    private RadioButton radioButton_two_E,radioButton_two_T;

    //three
    private Spinner spinner_three_direction;
    private RadioGroup radioGroup_three_Ac;
    private RadioButton radioButton_three_E,radioButton_three_T;

    private int select_three_direction;
    private String select_threeAc;


    private String[] num = {"1","2","3","4","5","6","7","8","9"};

    public void setActivity(NewRecordActivity activity) {
        this.activity = activity;
    }

    public void setBaseFirstDialog(final ScrollablePanelAdapter.OrderViewHolder viewHolder) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setItems(new String[]{"擊出球","未擊出球"}, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog,int which) {
                switch (which) {
                    case 0:
                        AlertDialog.Builder hit_builder = new AlertDialog.Builder(activity);
                        hit_builder.setItems(new String[]{"高飛犧牲打", "觸擊犧牲打", "一般"}, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                switch (i) {
                                    case 0:
                                        viewHolder.recordItem.set_BASE_FIRST_STEP_ONE(RecordItem.BASE_FIRST_STEP_ONE.HIGH);
                                        viewHolder.updateUI(activity);
                                        Toast.makeText(activity, "高飛犧牲打", Toast.LENGTH_SHORT).show();

                                        AlertDialog.Builder scrifice_fly_builder = new AlertDialog.Builder(activity);
                                        @SuppressLint("InflateParams") final View view_scrifice_fly_dialog = LayoutInflater.from(activity).inflate(R.layout.record_sacrifice_fly, null);
                                        radioGroup_sacrificeFly_type = view_scrifice_fly_dialog.findViewById(R.id.radioGroup_sacrificeFly_type);
                                        radioButton_sacrificeFly_type_high = view_scrifice_fly_dialog.findViewById(R.id.radioButton_sacrificeFly_high);
                                        radioButton_sacrificeFly_type_line = view_scrifice_fly_dialog.findViewById(R.id.radioButton_sacrificeFly_line);
                                        radioGroup_sacrificeFly_direction = view_scrifice_fly_dialog.findViewById(R.id.radioGroup_sacrificeFly_direction);
                                        radioButton_sacrificeFly_direction_7 = view_scrifice_fly_dialog.findViewById(R.id.radioButton_sacrificeFly_direction_7);
                                        radioButton_sacrificeFly_direction_8 = view_scrifice_fly_dialog.findViewById(R.id.radioButton_sacrificeFly_direction_8);
                                        radioButton_sacrificeFly_direction_9= view_scrifice_fly_dialog.findViewById(R.id.radioButton_sacrificeFly_direction_9);

                                        view_scrifice_fly_dialog.setPadding(10,10,10,10);
                                        scrifice_fly_builder.setView(view_scrifice_fly_dialog);
                                        scrifice_fly_builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                //TODO ahkui  設定顯示高飛犧牲打格子  recordItemFirstBase.setShowSacrificeFlyVisibility(true);
                                                //TODO  ahkui   recordItemFirstBase.setShowOneViewVisibility(true);

                                                int select_sacrificeFly_typeID = radioGroup_sacrificeFly_type.getCheckedRadioButtonId();
                                                int select_sacrificeFly_directionID = radioGroup_sacrificeFly_direction.getCheckedRadioButtonId();
                                                String select_sacrificeFly_type_str;
                                                String select_sacrificeFly_direction_str;
                                                //TODO ahkui  顯示下面選的圖片  recordItemFirstBase.setFirstViewOneTopValue();
                                                if(radioButton_sacrificeFly_type_high.getId() == select_sacrificeFly_typeID) {
                                                    select_sacrificeFly_type_str = "高飛球";
                                                 //TODO ahkui  存入資料庫， 顯示圖片高飛球  (R.drawable.fly_ball)
                                                    viewHolder.recordItem.setBallType(RecordItem.BALL_TYPE.HIGH);

                                                }
                                                else if(radioButton_sacrificeFly_type_line.getId() == select_sacrificeFly_typeID) {
                                                    select_sacrificeFly_type_str = "平飛球";
                                                    //TODO ahkui  存入資料庫， 顯示圖片平飛球  (R.drawable.line_drive)
                                                    viewHolder.recordItem.setBallType(RecordItem.BALL_TYPE.FLAT);

                                                }
                                                else {
                                                    viewHolder.recordItem.setBallType(RecordItem.BALL_TYPE.__);
                                                    select_sacrificeFly_type_str = "未選擇";
                                                }

                                                //TODO ahkui  顯示下面選的數字圖片  recordItemFirstBase.setFirstViewOneNumValue();
                                                if(radioButton_sacrificeFly_direction_7.getId() == select_sacrificeFly_directionID) {
                                                    select_sacrificeFly_direction_str = "左外野";
                                                    //TODO ahkui  存入資料庫， 顯示圖片 7  (R.drawable.throw7)
                                                    viewHolder.recordItem.setBallDirection(RecordItem.BALL_DIRECTION.LEFT);

                                                }
                                                else if(radioButton_sacrificeFly_direction_8.getId() == select_sacrificeFly_directionID) {
                                                    select_sacrificeFly_direction_str = "中外野";
                                                    //TODO ahkui  存入資料庫， 顯示圖片 8  (R.drawable.throw8)
                                                    viewHolder.recordItem.setBallDirection(RecordItem.BALL_DIRECTION.MIDDLE);
                                                }
                                                else if(radioButton_sacrificeFly_direction_9.getId() == select_sacrificeFly_directionID) {
                                                    select_sacrificeFly_direction_str = "右外野";
                                                    //TODO ahkui  存入資料庫， 顯示圖片 9  (R.drawable.throw9)
                                                    viewHolder.recordItem.setBallDirection(RecordItem.BALL_DIRECTION.RIGHT);
                                                }
                                                else {
                                                    select_sacrificeFly_direction_str = "未選擇";
                                                    viewHolder.recordItem.setBallDirection(RecordItem.BALL_DIRECTION.__);
                                                }
                                                viewHolder.updateUI(activity);
                                                Toast.makeText(activity.getApplicationContext(), "OK "+select_sacrificeFly_type_str + "," + select_sacrificeFly_direction_str, Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                        scrifice_fly_builder.show();
                                        break;
                                    case 1:
                                        viewHolder.recordItem.set_BASE_FIRST_STEP_ONE(RecordItem.BASE_FIRST_STEP_ONE.TOUCH);
                                        Toast.makeText(activity, "觸擊犧牲打", Toast.LENGTH_SHORT).show();

                                        AlertDialog.Builder scrifice_hits_builder = new AlertDialog.Builder(activity);
                                        @SuppressLint("InflateParams") View view_sacrifice_hits_dialog = LayoutInflater.from(activity).inflate(R.layout.record_sacrifice_hiits, null);
                                        spinner_actionOne = view_sacrifice_hits_dialog.findViewById(R.id.spinner_actionOne);
                                        spinner_actionTwo = view_sacrifice_hits_dialog.findViewById(R.id.spinner_actionTwo);

                                        view_sacrifice_hits_dialog.setPadding(10,10,10,10);
                                        scrifice_hits_builder.setView(view_sacrifice_hits_dialog);
                                        ArrayAdapter<String> adapter_actionOne = new ArrayAdapter<>(scrifice_hits_builder.getContext(),android.R.layout.simple_spinner_item, num);
                                        ArrayAdapter<String> adapter_actionTwo = new ArrayAdapter<>(scrifice_hits_builder.getContext(),android.R.layout.simple_spinner_item, num);
                                        adapter_actionOne.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                        adapter_actionTwo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                        spinner_actionOne.setAdapter(adapter_actionOne);
                                        spinner_actionTwo.setAdapter(adapter_actionTwo);

                                        scrifice_hits_builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                actionOne = (int) spinner_actionOne.getSelectedItemId();
                                                viewHolder.recordItem.setBALL_TOUCH_AC1(actionOne+1);
                                                actionTwo = (int) spinner_actionTwo.getSelectedItemId();
                                                viewHolder.recordItem.setBALL_TOUCH_AC2(actionTwo+1);
                                                viewHolder.updateUI(activity);
                                                Toast.makeText(activity, "OK " + (actionOne+1) + "," + (actionTwo+1), Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                        scrifice_hits_builder.show();

                                        break;
                                    case 2:
                                        //一般
                                        viewHolder.recordItem.set_BASE_FIRST_STEP_ONE(RecordItem.BASE_FIRST_STEP_ONE.NORMAL);
                                        Toast.makeText(activity, "一般", Toast.LENGTH_SHORT).show();

                                        AlertDialog.Builder first_one_builder = new AlertDialog.Builder(activity);
                                        @SuppressLint("InflateParams") View view_first_one_dialog = LayoutInflater.from(activity).inflate(R.layout.record_first_one, null);
                                        view_first_one_dialog.setPadding(10,20,10,10);
                                        first_one_builder.setView(view_first_one_dialog);
                                        radioGroup_type = view_first_one_dialog.findViewById(R.id.radioGroup_type);
                                        radioButton_type_high = view_first_one_dialog.findViewById(R.id.radioButton_type_high);
                                        radioButton_type_line = view_first_one_dialog.findViewById(R.id.radioButton_type_line);
                                        radioButton_type_ground = view_first_one_dialog.findViewById(R.id.radioButton_type_ground);
                                        spinner_direction = view_first_one_dialog.findViewById(R.id.spinner_direction);
                                        checkBox_elseAc_FC = view_first_one_dialog.findViewById(R.id.checkBox_elseAc_FC);
                                        checkBox_elseAc_u = view_first_one_dialog.findViewById(R.id.checkBox_elseAc_u);
                                        checkBox_elseAc_E = view_first_one_dialog.findViewById(R.id.checkBox_elseAc_E);
                                        checkBox_elseAc_T = view_first_one_dialog.findViewById(R.id.checkBox_elseAc_T);

                                        ArrayAdapter<String> adapter_direction = new ArrayAdapter<>(first_one_builder.getContext(),android.R.layout.simple_spinner_item, num);
                                        adapter_direction.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                        spinner_direction.setAdapter(adapter_direction);

                                        first_one_builder.setNeutralButton("NEXT", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                set_first_view_one();
                                                first_view_two();
                                                viewHolder.updateUI(activity);
                                            }
                                        });
                                        first_one_builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                set_first_view_one();
                                                viewHolder.updateUI(activity);
                                            }
                                        });
                                        first_one_builder.show();

                                        break;
                                }
                            }
                        });
                        hit_builder.show();
                        break;
                    case 1:
                        AlertDialog.Builder unhit_builder = new AlertDialog.Builder(activity);
                        @SuppressLint("InflateParams") View view_unhit_dialog = LayoutInflater.from(activity).inflate(R.layout.record_unhit_dialog, null);
                        view_unhit_dialog.setPadding(10,10,10,10);
                        unhit_builder.setView(view_unhit_dialog);
                        final AlertDialog unhit_dialog = unhit_builder.create();
                        view_unhit_dialog.findViewById(R.id.click_b).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(activity, "保送", Toast.LENGTH_SHORT).show();
                                unhit_dialog.dismiss();
                                //TODO: ahkui 存入資料庫， 顯示圖片 B   (R.drawable.throw_b)
                                viewHolder.recordItem.set_BASE_FIRST_STEP_ONE(RecordItem.BASE_FIRST_STEP_ONE.BADBALL);
                                viewHolder.updateUI(activity);

                            }
                        });
                        view_unhit_dialog.findViewById(R.id.click_db).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(activity, "觸身", Toast.LENGTH_SHORT).show();
                                unhit_dialog.dismiss();
                                //TODO:ahkui 存入資料庫， 顯示圖片 D  (R.drawable.hit_by_pitch)
                                viewHolder.recordItem.set_BASE_FIRST_STEP_ONE(RecordItem.BASE_FIRST_STEP_ONE.HITBYPITCH);
                                viewHolder.updateUI(activity);
                                viewHolder.updateUI(activity);

                            }
                        });
                        view_unhit_dialog.findViewById(R.id.click_k).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(activity, "三振", Toast.LENGTH_SHORT).show();
                                unhit_dialog.dismiss();
                                //TODO:ahkui 存入資料庫， 顯示圖片 K  (R.drawable.killed)
                                viewHolder.recordItem.set_BASE_FIRST_STEP_ONE(RecordItem.BASE_FIRST_STEP_ONE.KILLED);
                                viewHolder.updateUI(activity);
                            }
                        });
                        view_unhit_dialog.findViewById(R.id.click_nok).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(activity, "不死三振", Toast.LENGTH_SHORT).show();
                                unhit_dialog.dismiss();
                                //TODO:ahkui 存入資料庫， 顯示圖片 倒K  (R.drawable.no_killed)
                                viewHolder.recordItem.set_BASE_FIRST_STEP_ONE(RecordItem.BASE_FIRST_STEP_ONE.NOKILLED);
                                viewHolder.updateUI(activity);

                            }
                        });
                        unhit_dialog.show();

                        break;
                }
            }
        });
        builder.show();


    }

    private void set_first_view_one() {
        //TODO ahkui   顯示 recordItemFirstBase.setShowOneViewVisibility(true);

        int select_typeID = radioGroup_type.getCheckedRadioButtonId();
        int select_direction = (int) spinner_direction.getSelectedItemId();
        String select_elseAc = "";

        //TODO ahkui  高飛 平飛  recordItemFirstBase.setFirstViewOneTop(true);
        //TODO ahkui  滾地 recordItemFirstBase.setFirstViewOneBottom(true);
        String select_type_str;
        if(radioButton_type_high.getId() == select_typeID) {
            select_type_str = "高飛球";
            //TODO ahkui  存入資料庫， 顯示圖片高飛球  (R.drawable.fly_ball)
        }
        else if(radioButton_type_line.getId() == select_typeID) {
            select_type_str = "平飛球";
            //TODO ahkui  存入資料庫， 顯示圖片平飛球  (R.drawable.line_drive)
        }
        else if(radioButton_type_ground.getId() == select_typeID) {
            select_type_str = "滾地球";
            //TODO ahkui  存入資料庫， 顯示圖片滾地球  (R.drawable.ground_ball)
        }
        else {
            select_type_str = "未選擇";
        }

        //TODO  ahkui 如果下面有check   recordItemFirstBase.setShowFirstViewOneAc1Visibility(true);
        //TODO  ahkui 設定下方圖片值  recordItemFirstBase.setFirstViewOneAc1Value();
        if(checkBox_elseAc_FC.isChecked()) {
            select_elseAc = select_elseAc + "," + checkBox_elseAc_FC.getText().toString();
            //TODO ahkui  存入資料庫， 顯示圖片FC  (R.drawable.fielder_choice)

        }
        if(checkBox_elseAc_u.isChecked()) {
            select_elseAc = select_elseAc + "," + checkBox_elseAc_u.getText().toString();
            //TODO ahkui  存入資料庫， 顯示圖片u  (R.drawable.u)
        }
        if(checkBox_elseAc_E.isChecked()) {
            select_elseAc = select_elseAc + "," + checkBox_elseAc_E.getText().toString();
            //TODO ahkui  存入資料庫， 顯示圖片E  (R.drawable.error)
        }
        if(checkBox_elseAc_T.isChecked()) {
            select_elseAc = select_elseAc + "," + checkBox_elseAc_T.getText().toString();
            //TODO ahkui  存入資料庫， 顯示圖片T  (R.drawable.tag)
        }
        Toast.makeText(activity, "OK "+ select_type_str +","+(select_direction +1) + select_elseAc, Toast.LENGTH_SHORT).show();
    }

    private void first_view_two() {
        AlertDialog.Builder first_two_builder = new AlertDialog.Builder(activity);
        @SuppressLint("InflateParams") View view_first_two_dialog = LayoutInflater.from(activity).inflate(R.layout.record_first_two, null);
        view_first_two_dialog.setPadding(10,20,10,10);
        first_two_builder.setView(view_first_two_dialog);

        spinner_two_direction = view_first_two_dialog.findViewById(R.id.spinner_two_direction);
        radioGroup_two_Ac = view_first_two_dialog.findViewById(R.id.radioGroup_two_Ac);
        radioButton_two_E = view_first_two_dialog.findViewById(R.id.radioButton_two_E);
        radioButton_two_T = view_first_two_dialog.findViewById(R.id.radioButton_two_T);

        ArrayAdapter<String> adapter_direction_two = new ArrayAdapter<>(first_two_builder.getContext(),android.R.layout.simple_spinner_item, num);
        adapter_direction_two.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_two_direction.setAdapter(adapter_direction_two);

        first_two_builder.setNeutralButton("NEXT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                set_first_view_two();
                first_view_three();
            }
        });

        first_two_builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                set_first_view_two();
            }
        });
        first_two_builder.show();
    }

    private void set_first_view_two() {
        //TODO ahkui   顯示 recordItemFirstBase.setShowTwoViewVisibility(true);

        int select_two_direction = (int) spinner_two_direction.getSelectedItemId();
        String select_twoAc;
        if(radioGroup_two_Ac.getCheckedRadioButtonId() == radioButton_two_E.getId()) {
            //TODO ahkui  recordItemFirstBase.setShowFirstViewTwoAcVisibility(true);
            //TODO ahkui   圖片  (R.drawable.error)
            select_twoAc = "失誤 E";
        }
        else if(radioGroup_two_Ac.getCheckedRadioButtonId() == radioButton_two_T.getId()) {
            //TODO ahkui  recordItemFirstBase.setShowFirstViewTwoAcVisibility(true);
            //TODO ahkui   圖片  (R.drawable.tag)
            select_twoAc = "觸殺 T";
        }
        else {
            select_twoAc = "未選擇";
        }

        Toast.makeText(activity, "OK ," + (select_two_direction +1) + "," + select_twoAc, Toast.LENGTH_SHORT).show();

    }

    private void first_view_three() {
        AlertDialog.Builder first_three_builder = new AlertDialog.Builder(activity);
        @SuppressLint("InflateParams") View view_first_three_dialog = LayoutInflater.from(activity).inflate(R.layout.record_first_two, null);
        view_first_three_dialog.setPadding(10,20,10,10);
        first_three_builder.setView(view_first_three_dialog);

        spinner_three_direction = view_first_three_dialog.findViewById(R.id.spinner_two_direction);
        radioGroup_three_Ac = view_first_three_dialog.findViewById(R.id.radioGroup_two_Ac);
        radioButton_three_E = view_first_three_dialog.findViewById(R.id.radioButton_two_E);
        radioButton_three_T = view_first_three_dialog.findViewById(R.id.radioButton_two_T);

        ArrayAdapter<String> adapter_direction_two = new ArrayAdapter<>(first_three_builder.getContext(),android.R.layout.simple_spinner_item, num);
        adapter_direction_two.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_three_direction.setAdapter(adapter_direction_two);

        first_three_builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //TODO ahkui   顯示 recordItemFirstBase.setShowThreeViewVisibility(true);

                select_three_direction = (int) spinner_three_direction.getSelectedItemId();  //TODO ahkui  存入資料庫， 顯示圖片 1~9
                if(radioGroup_three_Ac.getCheckedRadioButtonId() == radioButton_three_E.getId()) {
                    //TODO ahkui  recordItemFirstBase.setShowFirstViewThreeAcVisibility(true);
                    //TODO ahkui   圖片  (R.drawable.error)  recordItemFirstBase.setFirstViewThreeAcValue();

                    select_threeAc = "失誤 E";
                }
                else if(radioGroup_three_Ac.getCheckedRadioButtonId() == radioButton_three_T.getId()) {
                    //TODO ahkui  recordItemFirstBase.setShowFirstViewThreeAcVisibility(true);
                    //TODO ahkui   圖片  (R.drawable.tag)   recordItemFirstBase.setFirstViewThreeAcValue();
                    select_threeAc = "觸殺 T";
                }
                else {
                    select_threeAc = "未選擇";
                }

                Toast.makeText(activity, "OK ," + (select_three_direction+1) + "," + select_threeAc, Toast.LENGTH_SHORT).show();
            }
        });
        first_three_builder.show();
    }



}
