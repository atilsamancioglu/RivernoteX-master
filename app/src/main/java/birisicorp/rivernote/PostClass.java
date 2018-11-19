package birisicorp.rivernote;

        import android.app.Activity;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;
        import com.squareup.picasso.Picasso;
        import java.util.ArrayList;

public class PostClass extends ArrayAdapter<String> {
    private final ArrayList<String> noteTitle;
    private final ArrayList<String> noteDesc;
    private final ArrayList<String> noteImage;
    private final Activity context;

    public PostClass(ArrayList<String> noteTitle, ArrayList<String> noteDesc, ArrayList<String> noteImage, Activity context) {
        super(context, R.layout.custom_view, noteTitle);
        this.context = context;
        this.noteTitle = noteTitle;
        this.noteDesc = noteDesc;
        this.noteImage = noteImage;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View customView = layoutInflater.inflate(R.layout.custom_view, null, true);
        TextView postClassNoteTitle = customView.findViewById(R.id.customView_title);
        TextView postClassNoteDesc = customView.findViewById(R.id.customView_desc);
        ImageView postClassNoteImage = customView.findViewById(R.id.customView_image);
        postClassNoteTitle.setText(noteTitle.get(position));
        postClassNoteDesc.setText(noteDesc.get(position));
        Picasso.get().load(noteImage.get(position)).into(postClassNoteImage);
        return customView;
    }
}
