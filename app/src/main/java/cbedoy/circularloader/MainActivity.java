package cbedoy.circularloader;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.melnykov.fab.FloatingActionButton;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends ActionBarActivity {

    private ListView listView;
    private ArrayList<HashMap<String, Object>> dataModel;
    private LoaderDialogView loaderDialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buildMockData();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            setTranslucentNavigation(true);

        }

        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintColor(Color.parseColor("#00796B"));

        listView = (ListView) findViewById(R.id.listView);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.attachToListView(listView);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(loaderDialogView == null)
                    loaderDialogView = new LoaderDialogView(MainActivity.this);
                loaderDialogView.show();
                loaderDialogView = null;
            }
        });

        listView.setAdapter(new ViewCell(dataModel));


        View view = new View(getApplicationContext());
        view.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, 80));
        view.setBackgroundColor(Color.WHITE);


        listView.addFooterView(view);

    }


    private void buildMockData()
    {
        dataModel = new ArrayList<>();
        HashMap<String, Object> model;
        model = new HashMap<>();    model.put("value", "Beer");             dataModel.add(model);
        model = new HashMap<>();    model.put("value", "Pokemon");          dataModel.add(model);
        model = new HashMap<>();    model.put("value", "Skate");            dataModel.add(model);
        model = new HashMap<>();    model.put("value", "Coffe");            dataModel.add(model);
        model = new HashMap<>();    model.put("value", "Xbox 360");         dataModel.add(model);
        model = new HashMap<>();    model.put("value", "Montana");          dataModel.add(model);
        model = new HashMap<>();    model.put("value", "GYM");              dataModel.add(model);
        model = new HashMap<>();    model.put("value", "Pointer");          dataModel.add(model);
        model = new HashMap<>();    model.put("value", "Girld friend");     dataModel.add(model);
        model = new HashMap<>();    model.put("value", "Pademobile");       dataModel.add(model);
        model = new HashMap<>();    model.put("value", "Maruchan");         dataModel.add(model);
        model = new HashMap<>();    model.put("value", "Subway");           dataModel.add(model);
        model = new HashMap<>();    model.put("value", "CFE");              dataModel.add(model);
        model = new HashMap<>();    model.put("value", "Bus");              dataModel.add(model);
        model = new HashMap<>();    model.put("value", "Mouse");            dataModel.add(model);
        model = new HashMap<>();    model.put("value", "iMAC");             dataModel.add(model);
        model = new HashMap<>();    model.put("value", "Moto G2");          dataModel.add(model);
        model = new HashMap<>();    model.put("value", "Forever Alone");    dataModel.add(model);
        model = new HashMap<>();    model.put("value", "Pull & Bear");      dataModel.add(model);
        model = new HashMap<>();    model.put("value", "Code && Music");    dataModel.add(model);
        model = new HashMap<>();    model.put("value", "Matematics");       dataModel.add(model);
        model = new HashMap<>();    model.put("value", "Bills");            dataModel.add(model);
        model = new HashMap<>();    model.put("value", "Guitar");           dataModel.add(model);
        model = new HashMap<>();    model.put("value", "Fingerstyle");      dataModel.add(model);
    }

    private void setTranslucentNavigation(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

}
