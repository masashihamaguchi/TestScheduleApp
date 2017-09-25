package com.lifeistech.android.testschedule.Adapter_ListView;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.lifeistech.android.testschedule.ItemClass.Item;
import com.lifeistech.android.testschedule.R;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmBaseAdapter;
import io.realm.RealmResults;

/**
 * Created by Masashi Hamaguchi on 2017/07/22.
 */

public class ItemListAdapter extends RealmBaseAdapter<Item> {

    RealmResults<Item> resultList;
    private ArrayList<String> categoryList = new ArrayList<String>();

    public ItemListAdapter(Context context, RealmResults<Item> result) {
        super(context, result);

        resultList = result;
    }

    @Override
    public int getCount() {
        return resultList.size();
    }

    @Override
    public Item getItem(int position) {
        return resultList.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder); //ここでtagを設定しておかないと落ちる
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Item item = getItem(position);

        if (item != null) {
            //set data
            viewHolder.iconImage.setImageResource(R.drawable.ic_android_black_24dp);
            viewHolder.itemText.setText(item.getItemName());
            viewHolder.checkBox.setChecked(item.isChecked());

            String catName;
            // カテゴリ検索
//            for (int n = 0; n < categoryList.size(); n++) {
//                catName = categoryList.get(n).getCategoryName();
//
//                // カテゴリ別色分け
//                viewHolder.cardView.setCardBackgroundColor(categoryList.get(n).getColor());
//
//                for (int m = 0; m < categoryList.get(n).getItemList().size(); m++) {
//                    String name = categoryList.get(n).getItemList().get(m).getItemName();
//                    if (item.getItemName() == name) {
//                        viewHolder.categoryText.setText(catName);
//
//                        break;
//                    }
//                }
//=======
            // カテゴリ別に色分け
//            if (item.getCategory() == "勉強") {
//                viewHolder.cardView.setCardBackgroundColor(MATERIAL_COLORS[0]);
//            } else if (item.getCategory() == "文化祭準備") {
//                viewHolder.cardView.setCardBackgroundColor(MATERIAL_COLORS[1]);
//            } else if (item.getCategory() == "遊び") {
//                viewHolder.cardView.setCardBackgroundColor(MATERIAL_COLORS[2]);
//            } else if (item.getCategory() == "買い物") {
//                viewHolder.cardView.setCardBackgroundColor(MATERIAL_COLORS[3]);
//            } else if (item.getCategory() == "家でやること") {
//                viewHolder.cardView.setCardBackgroundColor(MATERIAL_COLORS[4]);
//>>>>>>> dev2
//            }


//            categoryList = loadCategories(getContext());
//            for (int i = 0; i < categoryList.size(); i++) {
//                if (item.getCategory() == categoryList.get(i).getCategoryName()) {
//                    viewHolder.cardView.setCardBackgroundColor(categoryList.get(i).getColor());
//                }
//            }

        }

        return convertView;
    }

    private class ViewHolder {
        ImageView iconImage;
        TextView itemText;
        TextView categoryText;
        CheckBox checkBox;

        CardView cardView;

        public ViewHolder(View view) {
            //get instance
            iconImage = (ImageView) view.findViewById(R.id.iconImage);
            itemText = (TextView) view.findViewById(R.id.itemText);
            categoryText = (TextView) view.findViewById(R.id.categoryText);
            checkBox = (CheckBox) view.findViewById(R.id.checkBox);

            cardView = (CardView) view.findViewById(R.id.itemCardView);
        }
    }

}