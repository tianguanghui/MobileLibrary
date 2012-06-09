package com.mobilelibrary.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.mobilelibrary.R;
import com.mobilelibrary.adapter.PersonInformationAdapter;
import com.mobilelibrary.dao.StoredBookDAO;
import com.mobilelibrary.entity.BookBorrowedEntity;
import com.mobilelibrary.entity.BookStoredEntity;

public class BookInfoActivity extends BaseActivity{
	
    private ListView personInformationListView;
    private ImageButton btn_store;
    private ImageView bookImageView;
    int bookBorrowedEntity;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_info_layout);      
        setTopTitle(this, R.string.book_info);
        
        
        setBackButton(this, new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				BookInfoActivity.this.finish();
			}
		});
        
        bookImageView = (ImageView) this.findViewById(R.id.viewBook_cover);
        bookBorrowedEntity = (Integer)getIntent().getSerializableExtra("bookinfo");
        
        if (bookBorrowedEntity==1 ) {
        	Bitmap bmp=BitmapFactory.decodeResource(getResources(), R.drawable.book_recommend_default);
        	bookImageView.setImageBitmap(bmp);
		}
        if (bookBorrowedEntity==2) {
        	Bitmap bmp=BitmapFactory.decodeResource(getResources(), R.drawable.book6);
        	bookImageView.setImageBitmap(bmp);
		}
        if (bookBorrowedEntity==3) {
        	Bitmap bmp=BitmapFactory.decodeResource(getResources(), R.drawable.book2);
        	bookImageView.setImageBitmap(bmp);
		}
        btn_store = (ImageButton)findViewById(R.id.btn_status_bar_store);
        
        btn_store.setOnClickListener(mStoreClickListener);
   
    }
	
	private OnClickListener mStoreClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub]
			
			StoredBookDAO storeBookDAO = new StoredBookDAO(BookInfoActivity.this);
			
			if (bookBorrowedEntity == 1) {
				BookStoredEntity testBookBorrowedEntity1 = new BookStoredEntity();
				testBookBorrowedEntity1.setBookId("1");
				testBookBorrowedEntity1.setBookText("Android入门与提高");
				testBookBorrowedEntity1.setBookImageUrl("android");
				testBookBorrowedEntity1.setBookPress("android");
				testBookBorrowedEntity1.setBookPressTime("android");
				storeBookDAO.insert(testBookBorrowedEntity1);
			}
			if (bookBorrowedEntity == 2) {
				BookStoredEntity testBookBorrowedEntity1 = new BookStoredEntity();
				testBookBorrowedEntity1.setBookId("2");
				testBookBorrowedEntity1.setBookText("IOS开发实战宝典");
				testBookBorrowedEntity1.setBookImageUrl("android");
				testBookBorrowedEntity1.setBookPress("android");
				testBookBorrowedEntity1.setBookPressTime("android");
				storeBookDAO.insert(testBookBorrowedEntity1);
			}
			if (bookBorrowedEntity == 3) {
				BookStoredEntity testBookBorrowedEntity1 = new BookStoredEntity();
				testBookBorrowedEntity1.setBookId("3");
				testBookBorrowedEntity1.setBookText("JavaEE入门到精通");
				testBookBorrowedEntity1.setBookImageUrl("android");
				testBookBorrowedEntity1.setBookPress("android");
				testBookBorrowedEntity1.setBookPressTime("android");
				storeBookDAO.insert(testBookBorrowedEntity1);
			}
			
			
			Toast.makeText(BookInfoActivity.this, R.string.storesuccess, Toast.LENGTH_SHORT).show();
		}
	};

}

