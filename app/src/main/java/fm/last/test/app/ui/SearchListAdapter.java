package fm.last.test.app.ui;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fm.last.test.app.R;
import fm.last.test.app.model.vo.SearchItem;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 16/12/2018
 */
public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.ItemViewHolder> {

    private final List<SearchItem> mItems = new ArrayList<>();
    private final LayoutInflater mInflater;

    SearchListAdapter(LayoutInflater inflater) {
        mInflater = inflater;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new ItemViewHolder(mInflater.inflate(R.layout.search_item_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder albumViewHolder, int position) {
        albumViewHolder.bind(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    void clear() {
        mItems.clear();
        notifyDataSetChanged();
    }

    void addItems(SearchItem[] searchItems) {
        mItems.addAll(Arrays.asList(searchItems));
        notifyDataSetChanged();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        final ImageView icon;
        final TextView name;
        final TextView description;
        private String url;

        ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            this.icon = itemView.findViewById(R.id.image_item);
            this.name = itemView.findViewById(R.id.text_item_name);
            this.description = itemView.findViewById(R.id.text_item_description);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_ITEM_LINK, url);
            context.startActivity(intent);
        }

        void bind(SearchItem searchItem) {
            this.url = searchItem.getUrl();
            name.setText(searchItem.getName());
            description.setText(searchItem.getDescription());
            Glide.with(icon.getContext().getApplicationContext())
                    .load(searchItem.getImageURL())
                    .into(icon);
        }
    }
}
