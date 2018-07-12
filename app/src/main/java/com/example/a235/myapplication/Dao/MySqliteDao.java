package com.example.a235.myapplication.Dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.a235.myapplication.Bean.Student;

public class MySqliteDao extends SQLiteOpenHelper {
    public static final String CREATE_BOOK = "create table Book ("
            + "id integer primary key autoincrement," + "name String,"
             + "grade integer," + "detail String)";

    private  Context mContext;
    public MySqliteDao(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super( context, name, null, 1 );
        mContext =context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_BOOK);
        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insert(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL("insert into Book(author,price,pages,name) values(?,?,?,?)",new String[]{"214151","张三","3","android"});
    }
    /* 查询数据库 *//* 返回一个游标对象 */
    public Cursor selectData(SQLiteDatabase sqliteDatabase){
        /* 与数据库获得连接，获得只读属性 */



        /* 使用游标保存得到的结果集 *//* 参1:查询语句  ； 参2：查询条件 */
        //Cursor cursor = sqliteDatabase.rawQuery("select * from student", null);

        /* 使用查询语句：方式二
         * @ distinct 			--是否去除重复行  			例：值为：true/false;
         * @ table				--表名
         * @ columns 			--要查询的列 				例： new String[]{"id","name","age"}
         * @ selection			--查询条件				例："id>?"
         * @ selectionArgs		--查询条件的参数 			例：new String[]{"3"}
         * @ groupBy			--对查询的结果进行分组
         * @ having				--对分组的结果进行限制
         * @ orderby			--对查询的结果进行排序；	 例："age asc"
         * @ limit				--分页查询限制 ；			 例："2,5"	从第2行开始，到第5行结束；注：行数从0 开始；
         *  */
        Cursor cursor = sqliteDatabase.query(true,"student", new String[]{"_id","name","grade","detail"}, "_id>?", new String[]{"1"}, null, null, "age desc", "1,5");

        /* 使用游标---获取游标中的数据 */
        while(cursor.moveToNext()){
            Integer id = cursor.getInt(cursor.getColumnIndex("_id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            Integer age = cursor.getInt(cursor.getColumnIndex("age"));
            String detail = cursor.getString(cursor.getColumnIndex("detail"));
        }

        return cursor;

    }

}
