package cbedoy.circularloader;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Carlos Bedoy on 1/16/15.
 * <p/>
 * Mobile App Developer - Bills Android
 * <p/>
 * Pademobile
 */
public class ViewCell extends AbstractAdapter {


    public ViewCell(ArrayList<HashMap<String, Object>> dataModel) {
        super(dataModel);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder viewHolder;
        if(convertView == null)
        {
            viewHolder = new ViewHolder();
            convertView = ApplicationLoader.mMainLayoutInflater.inflate(R.layout.default_cell, null);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.any_text);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        HashMap<String, Object> information = dataModel.get(position);
        viewHolder.textView.setText(information.get("value").toString());

        return convertView;
    }

    private class ViewHolder{
        TextView textView;
    }
}
