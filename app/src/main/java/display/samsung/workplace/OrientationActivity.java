package display.samsung.workplace;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OrientationActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout mLayoutBackground;
    private android.app.ActionBar toolbar;
    private String TAG = "MainActivity";
    private View actionbarView;
    private TextView titletv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation);

        mLayoutBackground = findViewById(R.id.layout_background);

        /*toolbar = getActionBar();
        setSupportActionBar(toolbar);*/

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowCustomEnabled(false);

        // 디자인 한대로 나오게 하기 위해서 레이아웃 파람을 설정
        ActionBar.LayoutParams layout = new ActionBar.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        //actionbar_custom.xml 파일에 디자인 된 레이아웃 가져오기
        actionbarView = getLayoutInflater().inflate(R.layout.actionbar_custom, null);

        //setDisplayOptions 설정 안해주면 Activity에서는 보이지 않음. 이것때문에 엄청 헤맴
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(actionbarView, layout);

        //커스팀 액션바 레이아웃에 있는 버튼에 이벤트 걸때는 아래처럼 사용
        ImageButton menu_btn = (ImageButton) actionbarView.findViewById(R.id.menu_btn);
        menu_btn.setOnClickListener(this);

        titletv = (TextView) actionbarView.findViewById(R.id.titletv);
        titletv.setText("Test ActionBar");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            // 세로 전환할 때 이미지 교체
            mLayoutBackground.setBackgroundResource(R.drawable.img_portrait);

        }else if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            // 가로 전환할 때 이미지 교체
            mLayoutBackground.setBackgroundResource(R.drawable.img_landscape);
        }
    }

    @Override
    public void onClick(View v) {

    }
}
