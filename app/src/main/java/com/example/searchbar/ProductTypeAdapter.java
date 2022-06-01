package com.example.searchbar;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductTypeAdapter extends RecyclerView.Adapter<ProductTypeAdapter.ViewHolder> implements Filterable {

    Context context;
    List<ProductTypeModel> list;
    List<ProductTypeModel> listFull;
    List<Horizental_Model> list1 = new ArrayList<>();
    Horizental_Adapter horizental_adapter;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public OnItemClickListener onItemClickListener;


    public ProductTypeAdapter(Context context, List<ProductTypeModel> list) {
        this.context = context;
        this.list = list;
        listFull = new ArrayList<>(list);
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }


    interface OnItemClickListener {
        void OnItem(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View rootView;
        rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_row_layout, null);
        return new ViewHolder(rootView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        ProductTypeModel model = list.get(position);
        viewHolder.title.setText(model.getProduct_type_title());

        if (model.getProduct_type_title().equals("Movies")) {
            horizental_adapter = new Horizental_Adapter(context, getMoviesData());
            horizental_adapter.setOnItemClickListener(new Horizental_Adapter.OnItemClickListener() {
                @Override
                public void OnItem(int position) {
                    String name = getMoviesData().get(position).getTitle();
                    Toast.makeText(context, "" + name, Toast.LENGTH_SHORT).show();
                }
            });
        } else if (model.getProduct_type_title().equals("PC games")) {
            horizental_adapter = new Horizental_Adapter(context, getgameData());
            horizental_adapter.setOnItemClickListener(new Horizental_Adapter.OnItemClickListener() {
                @Override
                public void OnItem(int position) {
                    String name = getgameData().get(position).getTitle();
                    if (name.equals("Black Ops")) {
                        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=call+of+duty+black+ops&sxsrf=ACYBGNRK-OYqmnWODwUhzZLa94U9kpukNQ:1568899075336&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjnjsvA_NzkAhWJTsAKHSlhDuYQ_AUIEigB&biw=1366&bih=625")));
                        Toast.makeText(context, "" + name, Toast.LENGTH_SHORT).show();
                    }
                    else  if (name.equals("FallOut")){
                        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?biw=1366&bih=625&tbm=isch&sxsrf=ACYBGNTW4EzkNLgmVZfwDpR7XxaKq91FXQ%3A1568899464417&sa=1&ei=iIGDXcCDGbGX1fAPrr2a8A4&q=fallout+3+game+&oq=fallout+3+game+&gs_l=img.3..0l7j0i30l2j0i8i30.5649.16432..17101...0.0..0.348.7330.2-16j9......0....1..gws-wiz-img.......35i39j0i67j0i24.jtWEy_HVM1A&ved=0ahUKEwjA5476_dzkAhWxSxUIHa6eBu4Q4dUDCAc&uact=5")));

                    }
                }
            });

        } else if (model.getProduct_type_title().equals("Sports")) {
            horizental_adapter = new Horizental_Adapter(context, getSportData());
            horizental_adapter.setOnItemClickListener(new Horizental_Adapter.OnItemClickListener() {
                @Override
                public void OnItem(int position) {
                    String name = getSportData().get(position).getTitle();
                    Toast.makeText(context, "" + name, Toast.LENGTH_SHORT).show();
                }
            });
        } else if (model.getProduct_type_title().equals("TV Channel")) {
            horizental_adapter = new Horizental_Adapter(context, getTvData());
            horizental_adapter.setOnItemClickListener(new Horizental_Adapter.OnItemClickListener() {
                @Override
                public void OnItem(int position) {
                    String name = getTvData().get(position).getTitle();
                    Toast.makeText(context, "" + name, Toast.LENGTH_SHORT).show();
                }
            });
        }
        viewHolder.rcv.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        viewHolder.rcv.setAdapter(horizental_adapter);
        viewHolder.rcv.setHasFixedSize(true);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, description;
        ImageView iv;
        RecyclerView rcv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //    iv = itemView.findViewById(R.id.imageViewForProductRow);
            title = itemView.findViewById(R.id.tv_rowForProductTitle);
            rcv = itemView.findViewById(R.id.rcv_Horizental);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (onItemClickListener != null) {
                        int position = getAdapterPosition();
                        if (position >= 0) {
                            onItemClickListener.OnItem(position);
                        }
                    }
                }
            });

        }    }

    public List<Horizental_Model> getgameData() {
        List<Horizental_Model> pcgames = new ArrayList<>();
        pcgames.add(new Horizental_Model("Racing Car", R.drawable.need_for_speed_payback_1496408004076));
        pcgames.add(new Horizental_Model("Black Ops", R.drawable.cod_black_ps_cover));
        pcgames.add(new Horizental_Model("FallOut", R.drawable.falloutgame));
        pcgames.add(new Horizental_Model("FallOut", R.drawable.falloutgame));
        pcgames.add(new Horizental_Model("Project IGI", R.drawable.project_igi_video_game));
        return pcgames;
    }

    public List<Horizental_Model> getMoviesData() {
        List<Horizental_Model> movies = new ArrayList<>();
        movies.add(new Horizental_Model("Pirates of caribion", R.drawable.pirates));
        movies.add(new Horizental_Model("Ifinity War", R.drawable.avengersinfinitywar));
        movies.add(new Horizental_Model("batVSsuperman", R.drawable.bat_vs_superman));
        movies.add(new Horizental_Model("BatMan", R.drawable.batman));
        movies.add(new Horizental_Model("Ifinity War", R.drawable.avengersinfinitywar));
        return movies;
    }

    public List<Horizental_Model> getSportData() {
        List<Horizental_Model> Sports = new ArrayList<>();
        Sports.add(new Horizental_Model("Badminton", R.drawable.badmintonicon17));
        Sports.add(new Horizental_Model("FootBall", R.drawable.football));
        Sports.add(new Horizental_Model("Hockey", R.drawable.hockey));
        Sports.add(new Horizental_Model("Cricket", R.drawable.download));
        Sports.add(new Horizental_Model("foot Ball", R.drawable.football));
        return Sports;
    }

    public List<Horizental_Model> getTvData() {
        List<Horizental_Model> tv_channel = new ArrayList<>();
        tv_channel.add(new Horizental_Model("", R.drawable.arydigital));
        tv_channel.add(new Horizental_Model("", R.drawable.geo_news));
        tv_channel.add(new Horizental_Model("", R.drawable.aljezira));
        tv_channel.add(new Horizental_Model("", R.drawable.football));
        return tv_channel;
    }


    private Filter exampleFilter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ProductTypeModel> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(listFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (ProductTypeModel item : listFull) {
                    if (item.getProduct_type_title().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            list.clear();
            list.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };


}
