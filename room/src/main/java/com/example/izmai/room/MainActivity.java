package com.example.izmai.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.Update;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static MainActivity instance;
    private AppDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class,
                "database")
                .build();
    }
    public static MainActivity getInstance() {
        return instance;
    }
    public AppDatabase getDatabase() {
        return database;
    }


}

@Entity
class Employee {
    @PrimaryKey
    public long id;
    public String name;
    public int salary;
}
@Dao
interface EmployeeDao {
    @Query("SELECT * FROM employee")
    List<Employee> getAll();
    @Query("SELECT * FROM employee WHERE id = :id")
    Employee getById(long id);
    @Insert
    void insert(Employee employee);
    @Update
    void update(Employee employee);
    @Delete
    void delete(Employee employee);
}
@Database(entities = {Employee.class}, version = 1)
abstract class AppDatabase extends RoomDatabase {
    public abstract EmployeeDao employeeDao();
}