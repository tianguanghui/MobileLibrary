package com.mobilelibrary.adapter;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobilelibrary.R;
import com.mobilelibrary.adapter.BookRecommendAdapter.ViewHolder;
import com.mobilelibrary.common.ImageManager;
import com.mobilelibrary.entity.BookBorrowedEntity;
import com.mobilelibrary.entity.BookRecommendEntity;

public class BookBorrowedAdapter extends ArrayListAdapter<BookBorrowedEntity>{

	public BookBorrowedAdapter(Activity context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		View row=convertView;

		ViewHolder holder;

		if (row==null) {
			LayoutInflater inflater = mContext.getLayoutInflater();
			row=inflater.inflate(R.layout.book_borrowed_item, null);

			holder = new ViewHolder();
			holder.bookImage = (ImageView)row.findViewById(R.id.book_borrowed_imageview);
			holder.bookText = (TextView)row.findViewById(R.id.book_borrowed_textview);

			row.setTag(holder);
		}
		else{
			holder = (ViewHolder) row.getTag();
		}
		
		holder.bookText.setText(mList.get(position).getBookText());
		
		System.out.println("text"+mList.get(position).getBookText());
		final String imageUrl = mList.get(position).getBookImageUrl();
		
		holder.bookImage.setTag(imageUrl);
		
		Resources res = mContext.getResources();

		if (position == 0) {
			Bitmap bmp=BitmapFactory.decodeResource(res, R.drawable.book_recommend_default);
			holder.bookImage.setImageBitmap(bmp);
		}
		if (position == 1) {
			Bitmap bmp=BitmapFactory.decodeResource(res, R.drawable.book6);
			holder.bookImage.setImageBitmap(bmp);
		}
		if (position == 2) {
			Bitmap bmp=BitmapFactory.decodeResource(res, R.drawable.book2);
			holder.bookImage.setImageBitmap(bmp);
		}

		return row;
		
	}
	
	static class ViewHolder {
		ImageView bookImage;
		TextView bookText;
	}

}


