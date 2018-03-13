package edu.bk.thesis.biodiary.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import edu.bk.thesis.biodiary.R;
import edu.bk.thesis.biodiary.adapters.DiaryAdapter;


public class BioDiaryMainActivity extends AppCompatActivity implements DiaryAdapter.DiaryAdapterOnClickHandler
{
    private RecyclerView mDiary;
    private DiaryAdapter mDiaryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodiary_main);

        mDiary = findViewById(R.id.rv_diary);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                                                                    LinearLayoutManager.VERTICAL,
                                                                    false);
        mDiary.setLayoutManager(layoutManager);
        mDiary.setHasFixedSize(true);
        mDiaryAdapter = new DiaryAdapter(this);
        mDiary.setAdapter(mDiaryAdapter);

        String[] diaryData = { "Diary 1", "Diary 2", "Diary 3" };
        mDiaryAdapter.setDiaryData(diaryData);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.biodiary_main_activity_actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.action_settings:
                System.out.println("Action: Settings");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(String diary)
    {
        Toast.makeText(this, diary, Toast.LENGTH_SHORT).show();
    }
}
