package com.iadev.mobileilsin;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
public class Arrayadapter extends ArrayAdapter<String> {
	private final Context context;
	private final String[] values;
 
	public Arrayadapter(Context context, String[] values) {
		super(context, R.layout.listrow, values);
		this.context = context;
		this.values = values;
	}
 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View rowView = inflater.inflate(R.layout.listrow, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.label);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
		textView.setText(values[position]);
 
		// Change icon based on name
		String s = values[position];
 
		System.out.println(s);
 
		if (s.equals("공지사항")) {
			imageView.setImageResource(R.drawable.icon_scnoti);
		} else if (s.equals("점심메뉴")) {
			imageView.setImageResource(R.drawable.icon_lunch);
		} else if (s.equals("학교정보")) {
			imageView.setImageResource(R.drawable.icon_scinfo);
		} else {
			imageView.setImageResource(R.drawable.icon_appinfo);
		}
 
		return rowView;
	}
}