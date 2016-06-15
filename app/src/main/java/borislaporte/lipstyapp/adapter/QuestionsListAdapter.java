package borislaporte.lipstyapp.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import borislaporte.lipstyapp.R;
import borislaporte.lipstyapp.model.Choice;

/**
 * Created by moi on 07/06/16.
 */
public class QuestionsListAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<Choice> choices;

    public QuestionsListAdapter(Context context, List<Choice> choices) {
        this.context = context;
        this.choices = choices;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return choices.size();
    }

    @Override
    public Object getItem(int position) {
        return choices.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View root = layoutInflater.inflate(R.layout.answer_picture, parent, false);

        Choice choice = choices.get(position);

        TextView text_key = (TextView) root.findViewById(R.id.key);
        ImageView image = (ImageView) root.findViewById(R.id.image);


        Typeface lato = Typeface.createFromAsset(parent.getContext().getAssets(), "Lato-BoldItalic.ttf");
        text_key.setTypeface(lato);

        image.setImageResource(choice.getImageId());
        text_key.setText(choice.getKey());

        return root;
    }
}
