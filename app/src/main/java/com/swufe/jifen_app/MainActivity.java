package com.swufe.jifen_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void bnt3A(View v){
        int score =3;
        teamA_Scores(score);

    }
    public void bnt2A(View v){
        int score =2;
        teamA_Scores(score);

    }
    public void bnt1A(View v){
        int score =1;
        teamA_Scores(score);

    }
    public void bnt3B(View v){
        int score =3;
        teamB_Scores(score);

    }
    public void bnt2B(View v){
        int score =2;
        teamB_Scores(score);

    }
    public void bnt1B(View v){
        int score =1;
        teamB_Scores(score);

    }
    public void btn4(View v){
        reset();
    }
    public void reset(){
        /*
         * 重置比分
         * */
        TextView teamAScore = findViewById(R.id.teamAScore);
        TextView teamBScore = findViewById(R.id.teamBScore);
        teamAScore.setText("0");
        teamBScore.setText("0");
        //提示
        Toast.makeText(this,"重置成功！",Toast.LENGTH_SHORT).show();

    }
    public void teamA_Scores(Integer add_score){
        /*
         * Team A加score分
         * @Param oldScore 原成绩
         * @Param score  要加的成绩
         * */

        //获取分数
        TextView teamAScore = findViewById(R.id.teamAScore);
        int oldScore = Integer.parseInt(teamAScore.getText().toString());
        // int score = Integer.parseInt(view.getTag().toString());//注，这个位置的getTag是为了调用此函数时传参数值
        int score = add_score;
        teamAScore.setText(""+(oldScore+score));
    }
    public void teamB_Scores(Integer add_score){
        /*
         * Team B加score分
         * @Param oldScore 原成绩
         * @Param score  要加的成绩
         * */

        //获取分数
        TextView teamBScore = findViewById(R.id.teamBScore);
        int oldScore = Integer.parseInt(teamBScore.getText().toString());
        // int score = Integer.parseInt(view.getTag().toString());//注，这个位置的getTag是为了调用此函数时传参数值
        int score = add_score;
        teamBScore.setText(""+(oldScore+score));
    }


    /*
     *保存方向改变时的数据
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String scorea = ((TextView)findViewById(R.id.teamAScore)).getText().toString();
        String scoreb = ((TextView)findViewById(R.id.teamBScore)).getText().toString();
        Log.i("tag","onSaveInstanceState:");
        outState.putString("teama_score",scorea);
        outState.putString("teamb_score",scoreb);
    }
    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);
        String scorea = saveInstanceState.getString("teama_score");
        String scoreb = saveInstanceState.getString("teamb_score");
        Log.i("tag","saveInstanceState:");
        ((TextView)findViewById(R.id.teamAScore)).setText(scorea);
        ((TextView)findViewById(R.id.teamBScore)).setText(scoreb);
    }
}
