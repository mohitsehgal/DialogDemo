package com.example.dialogdemo;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity implements OnTimeSetListener, OnDateSetListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	private void makeToast(String string) {
		// TODO Auto-generated method stub
		Toast.makeText(this, string, Toast.LENGTH_LONG).show();
		
	}
	
	public void createAlert(View view)
	{
		showDialog(0);		
	}
	
	public void createCustom(View view)
	{
		showDialog(4);
	}
	
	public void createDatePicker(View view)
	{
		showDialog(3);
	}
	public void createTimePicker(View view)
	{
		showDialog(2);
	}
	public void createProgress(View view)
	{
		showDialog(1);
	}
	public void cAlertDialog()
	{
		AlertDialog.Builder builder=new  AlertDialog.Builder(this);
		builder.setTitle("Hello").setIcon(R.drawable.ic_launcher)
		.setMessage("How Are You?")
		.setCancelable(true)
		.setPositiveButton("Yes I am Fine", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
					makeToast("Thats Great! You are Fine!");

			}

			
		})
		.setNegativeButton("Not Well", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
					makeToast("Get Well Soon!!");
			}

			
		}).setNeutralButton("So So", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
					makeToast("Take a Chill Pill!");
			}

			
		}).show();
		

	}
	
	@Override
	@Deprecated
	protected Dialog onCreateDialog(int id) {
	
		switch(id)
		{
		case 0:
			cAlertDialog();
		break;
		case 1:
			cProgressDialog();
		break;
		case 2:
			cTimePicker();
		break;
		case 3:
			cDatePicker();
		break;
		case 4:
			cCustomDialog();
		break;
		
		}
		return super.onCreateDialog(id);
	}

	private void cCustomDialog() {
		LayoutInflater inf=getLayoutInflater();
		View v=inf.inflate(R.layout.abc, null);
		AlertDialog.Builder b=new Builder(this);
		b.setTitle("Custom Title Goes Here").setView(v)
		.show();
	}

	private void cTimePicker() {
		// TODO Auto-generated method stub
		Calendar c=Calendar.getInstance();
		TimePickerDialog tp=new TimePickerDialog(this, this, c.getTime().getHours(),c.getTime().getMinutes()	 , 	true);
		tp.setTitle("Title Goes Here!");
		tp.setMessage("Choose Time ");
		tp.show();
	}
	private void cDatePicker() {
		// TODO Auto-generated method stub
		Calendar c=Calendar.getInstance();
		DatePickerDialog tp=new DatePickerDialog(this, this, c.getTime().getYear(),c.getTime().getMonth(),c.getTime().getDate());
		tp.setTitle("Title Goes Here!");
		tp.setMessage("Choose Date ");
		tp.show();
	}

	private void cProgressDialog() {
		// TODO Auto-generated method stub
		ProgressDialog p;
		p=new ProgressDialog(this);
		p.setIndeterminate(true);
	//	p.setMax(100);
		p.setMessage("Doing Some Task");
		p.show();
		/*for(int i=0;i<100;i++)
		{
			try{
			Thread.sleep(10);
			}catch(Exception e)
			{
				
			}
			p.setProgress(i/10);
		}
		*/

	}

	@Override
	public void onTimeSet(TimePicker arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		makeToast(" Time Selected "+arg1+" : "+arg2);
		
	}

	@Override
	public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		makeToast("Date Selected  "+arg3+"-"+(arg2+1)+"-"+arg1);
		
	}
}
