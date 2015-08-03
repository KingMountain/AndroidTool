package com.caidongrong.updater;

import java.util.ArrayList;
import android.os.Handler;
import android.os.Looper;

/*
 * anthor:caidongrong
 * date:2015-8-4 0:19
 * usage:use for whole-control of your view
 */

public class ViewUpdater implements Runnable{

	public interface IUpdate{
		public void updateView();
	}
	
	private static ViewUpdater mInstance = new ViewUpdater();
	private Handler mHandler;
	private ArrayList<IUpdate> mUpdateLists;
	
	public static ViewUpdater getInstance() {
		return mInstance;
	}
	
	private ViewUpdater() {
		mHandler = new Handler(Looper.getMainLooper());
		mUpdateLists = new ArrayList<ViewUpdater.IUpdate>();
	}
	
	//regist your event
	public void regist(IUpdate mlist) {
		if(mUpdateLists.contains(mlist)) {
			mUpdateLists.remove(mlist);
		}
		mUpdateLists.add(mlist);
	}
	
	//update all your events
	public void update() {
		mHandler.removeCallbacks(this);
		mHandler.post(this);
	}

	@Override
	public void run() {
		for(IUpdate mList : mUpdateLists) {
			mList.updateView();
		}
	}
	
	
}
