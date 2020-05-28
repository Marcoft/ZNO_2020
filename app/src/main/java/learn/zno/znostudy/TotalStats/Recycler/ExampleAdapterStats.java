package learn.zno.znostudy.TotalStats.Recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import learn.zno.znostudy.R;


public class ExampleAdapterStats extends RecyclerView.Adapter<ExampleAdapterStats.ExampleViewHolder> implements Filterable {
    private ArrayList<ExampleItemStats> mExampleList;
    private ArrayList<ExampleItemStats> mExampleListForSearchView;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }


    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {



        public TextView idText;
        public TextView typeTest;
        public TextView statsTest;
        public TextView dateTest;


        public ExampleViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            idText = itemView.findViewById(R.id.idText);
            typeTest = itemView.findViewById(R.id.typeTest);
            statsTest = itemView.findViewById(R.id.statsTest);
            dateTest = itemView.findViewById(R.id.dateTest);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });


        }
    }

    public ExampleAdapterStats(ArrayList<ExampleItemStats> exampleList) {
        mExampleList = exampleList;
        mExampleListForSearchView = new ArrayList<>(exampleList);
    }


    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.total_stats_list, parent, false);
        ExampleViewHolder holder = new ExampleViewHolder(v, mListener);

        return holder;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {

        ExampleItemStats currentItem = mExampleList.get(position);

        holder.idText.setText(currentItem.getIdText());
        holder.typeTest.setText(currentItem.getTypeTest());
        holder.statsTest.setText(currentItem.getStatsTest());
        holder.dateTest.setText(currentItem.getDateTest());


    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ExampleItemStats> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mExampleListForSearchView);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (ExampleItemStats item : mExampleListForSearchView) {
                    if (item.getIdText().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mExampleList.clear();
            mExampleList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };


}
