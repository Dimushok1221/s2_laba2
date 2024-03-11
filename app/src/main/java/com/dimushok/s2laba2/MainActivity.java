package com.dimushok.s2laba2;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
        // константы для ID пунктов меню
        final int MENU_ALPHA_ID = 1;
        final int MENU_SCALE_ID = 2;
        final int MENU_TRANSLATE_ID = 3;
        final int MENU_ROTATE_ID = 4;
        final int MENU_COMBO_ID = 5;
        int num = 1;

        TextView tv;

        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            tv = findViewById(R.id.tv);
            // регистрируем контекстное меню для компонента tv
            registerForContextMenu(tv);
        }

    public void startAnim(View v){
        Animation anim = null;
        // определяем какой пункт был нажат
        switch (num) {
            case MENU_ALPHA_ID:
                // создаем объект анимации из файла anim/myalpha
                anim = AnimationUtils.loadAnimation(this, R.anim.myalpha);
                num++;
                break;
            case MENU_SCALE_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.myscale);
                num++;
                break;
            case MENU_TRANSLATE_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.mytrans);
                num++;
                break;
            case MENU_ROTATE_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.myrotate);
                num++;
                break;
            case MENU_COMBO_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.mycombo);
                num = 1;
                break;
        }
        // запускаем анимацию для компонента tv
        tv.startAnimation(anim);
    }
}

