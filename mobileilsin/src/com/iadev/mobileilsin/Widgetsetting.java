package com.iadev.mobileilsin;

import kr.iadev.bcilsin.R;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.select.Elements;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class Widgetsetting extends Activity implements ViewSwitcher.ViewFactory {
	List<Integer> galleryIda = new ArrayList<Integer>();

	private ImageSwitcher mSwitcher;
	TextView widgetTextView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_widgetsetting);
		widgetTextView = (TextView)findViewById(R.id.widgettext);
		for (int i = 1; i < 8; i++) {
			galleryIda.add(getResources().getIdentifier("widget" + i,
					"drawable", this.getPackageName()));

		}
		Gallery g = (Gallery) findViewById(R.id.gallery1);
		g.setAdapter(new galleryAdapter(this));
		g.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				mSwitcher.setImageResource(galleryIda.get(arg2));
				SharedPreferences pref = getSharedPreferences("pref", Context.MODE_PRIVATE);
				int widgetBackgroungId = galleryIda.get(arg2);
				SharedPreferences.Editor editor = pref.edit(); 
				editor.putInt("widgetBackgroungId", widgetBackgroungId);
				editor.commit();
			}

			public void onNothingSelected(AdapterView<?> arg0) {
			}

		});
		mSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher1);
		mSwitcher.setFactory(this);
		mSwitcher.setImageResource(galleryIda.get(0));
	}

	public View makeView() {
		ImageView iv1 = new ImageView(this);
		iv1.setBackgroundColor(0xFF000000);
		iv1.setScaleType(ImageView.ScaleType.FIT_CENTER);
		iv1.setLayoutParams(new ImageSwitcher.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		return iv1;
	}

	public class galleryAdapter extends BaseAdapter {
		private final Context mContext;
		LayoutInflater inflater;

		public galleryAdapter(Context c) {
			mContext = c;
			inflater = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		public int getCount() {
			return galleryIda.size();
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = inflater.inflate(R.layout.gallery_item, parent,
						false);
			}
			ImageView imageView = (ImageView) convertView
					.findViewById(R.id.imageView1);
			imageView.setImageResource(galleryIda.get(position));
			return convertView;
		}
	}
}
