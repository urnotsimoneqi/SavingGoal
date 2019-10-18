package com.example.demotest.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.demotest.Entity.GroupEntity;
import com.example.demotest.sqlite.SQLiteHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qxm on 2019/10/18.
 */
public class GroupDao {
    private SQLiteHelper sqLiteHelper;
    private SQLiteDatabase db;

    public GroupDao(Context context) {
        sqLiteHelper = new SQLiteHelper(context);
    }

    private ArrayList<GroupEntity> groupList;

    // Add Group Function
    public boolean addGroup(String groupName, int groupTarget) {
        db = sqLiteHelper.getWritableDatabase();
        // Judge if the database is available
        if (db.isOpen()) {
            // execute insert operation
            db.execSQL("insert into group_goal (group_name, target_amount) values(?,?)", new Object[]{groupName, groupTarget});
            db.close();
            return true;
        } else {
            return false;
        }
    }

    // List Group Function
    public List<GroupEntity> listGroup() {
        db = sqLiteHelper.getReadableDatabase();
        groupList = new ArrayList<>();
//        db.execSQL("select * from group_goal");
        Cursor cursor = db.rawQuery("select * from group_goal", null);

        while (cursor.moveToNext()) {
            int groupId = Integer.parseInt(cursor.getString(cursor.getColumnIndex("group_id")));
            String groupName = cursor.getString(cursor.getColumnIndex("group_name"));
            int targetAmount = Integer.parseInt(cursor.getString(cursor.getColumnIndex("target_amount")));

            GroupEntity groupEntity = new GroupEntity(groupId, groupName, targetAmount);
            groupList.add(groupEntity);
        }
        cursor.close();
        db.close();
        return groupList;
    }
}



