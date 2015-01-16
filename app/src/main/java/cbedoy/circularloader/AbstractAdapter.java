package cbedoy.circularloader;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Carlos Bedoy on 1/16/15.
 * <p/>
 * Mobile App Developer - Bills Android
 * <p/>
 * Pademobile
 */
public class AbstractAdapter extends BaseAdapter
{
    protected ArrayList<HashMap<String, Object>> dataModel;

    public AbstractAdapter(ArrayList<HashMap<String, Object>> dataModel){
        this.dataModel = dataModel;
    }

    @Override
    public int getCount() {
        return dataModel.size();
    }

    @Override
    public Object getItem(int position) {
        return dataModel.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}