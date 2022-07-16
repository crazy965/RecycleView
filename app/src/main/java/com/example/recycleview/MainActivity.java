package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PoetryAdapter.OnItemIsClickListener{

    private final List<Poetry> mPoetryList = new ArrayList<Poetry>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPoetry();
        RecyclerView mRecycleView = (RecyclerView) findViewById(R.id.recycler_view);

        StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mRecycleView.setLayoutManager(layoutManager);
        PoetryAdapter adapter = new PoetryAdapter(mPoetryList);
        mRecycleView.setAdapter(adapter);
        adapter.setOnItemIsClick(this);
    }

    private void initPoetry() {
        mPoetryList.add(new Poetry("渡江访朱在明", "明代：张元凯"));
        mPoetryList.add(new Poetry("如梦令 其一 秋思", "清代：孙原湘"));
        mPoetryList.add(new Poetry("吴时极菜园", "明代：岳正"));
        mPoetryList.add(new Poetry("点绛唇 竹洲仲诰集同人于涉园", "清代：黄燮清"));
        mPoetryList.add(new Poetry("满江红 邻女归宁未几，别母悲啼，", "清代：熊琏"));
        mPoetryList.add(new Poetry("将进酒", "唐代：李白"));
        mPoetryList.add(new Poetry("蜀道难", "唐代：李白"));
        mPoetryList.add(new Poetry("黄鹤楼送孟浩然之广陵", "唐代：李白"));
        mPoetryList.add(new Poetry("水调歌头·明月几时有", "宋代：苏轼"));
        mPoetryList.add(new Poetry("念奴娇·赤壁怀古", "宋代：苏轼"));
        mPoetryList.add(new Poetry("江城子·密州出猎", "宋代：苏轼"));
        mPoetryList.add(new Poetry("题西林壁", "宋代：苏轼"));
        mPoetryList.add(new Poetry("山居秋暝", "唐代：王维"));
        mPoetryList.add(new Poetry("九月九日忆山东兄弟", "唐代：王维"));
        mPoetryList.add(new Poetry("雨霖铃·寒蝉凄切", "宋代：柳永"));
        mPoetryList.add(new Poetry("望海潮·东南形胜", "宋代：柳永"));
        mPoetryList.add(new Poetry("苦寒行", "唐代：齐己"));
        mPoetryList.add(new Poetry("送人游塞", "唐代：齐己"));
    }

    @Override
    public void onItemNameIsClick(int position) {
        Toast.makeText(this,mPoetryList.get(position).getPoetryName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemAuthorIsClick(int position) {
        Toast.makeText(this,mPoetryList.get(position).getPoetryAuthor(), Toast.LENGTH_SHORT).show();
    }

}