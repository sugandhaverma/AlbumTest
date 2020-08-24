package com.test.albumtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomeAdapter extends BaseAdapter implements Filterable {



private List<ItemModel> itemModelList;
private List<ItemModel> itemModelListFilter;
private Context context;

    public CustomeAdapter(List<ItemModel> itemModelList, Context context) {
        this.itemModelList = itemModelList;
        this.itemModelListFilter = itemModelList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return itemModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return itemModelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View vw = view;

        ItemModel itemModel = itemModelList.get(i);
        if (vw == null) {

            vw = LayoutInflater.from(context).inflate(R.layout.row_item, viewGroup, false);
        }

        ImageView imageName = vw.findViewById(R.id.artistImage);
        TextView name = vw.findViewById(R.id.artistName);
        TextView song = vw.findViewById(R.id.artistSong);
        TextView cost = vw.findViewById(R.id.tvPrice);

        String aName = itemModel.getName();
        String aSong = itemModel.getSongName();
        String aPrice = itemModel.getPrice();
        int aImage = itemModel.getImage();

        imageName.setImageResource(aImage);
        name.setText(aName);
        song.setText(aSong);
        cost.setText(aPrice);

            return vw;
        }

    @Override
    public Filter getFilter() {

        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();

                if(charSequence == null || charSequence.length() == 0) {

                    filterResults.count = itemModelListFilter.size();
                    filterResults.values = itemModelListFilter;

                }else {
                    String searchChr = charSequence.toString().toLowerCase();
                    List<ItemModel> searchResult = new ArrayList<>();

                    for(ItemModel itemModel:itemModelListFilter){
                        if(itemModel.getName().toLowerCase().contains(searchChr)||
                                itemModel.getSongName().toLowerCase().contains(searchChr) ||
                                 itemModel.getPrice().toLowerCase().contains(searchChr)){
                            searchResult.add(itemModel);
                        }
                    }
                    filterResults.count = searchResult.size();
                    filterResults.values = searchResult;
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                itemModelList = (List<ItemModel>) filterResults.values;
                notifyDataSetChanged();

            }
        };
        return filter;
    }
}
