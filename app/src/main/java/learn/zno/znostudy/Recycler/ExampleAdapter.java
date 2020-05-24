package learn.zno.znostudy.Recycler;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import learn.zno.znostudy.R;


public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private ArrayList<ExampleItem> mExampleList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);

        void onDeleteClick(int position);
    }


    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {



        private TextView numbQuest;
        private TextView quest;
        private TextView ans1;

        private TextView ans5;


        private ExampleViewHolder(View itemView, final OnItemClickListener listener,List<String> RigAnsw, List<String> answer) {
            super(itemView);
            numbQuest = itemView.findViewById(R.id.numbQuest);
            quest = itemView.findViewById(R.id.quest);
            ans1 = itemView.findViewById(R.id.ans1);
            ans5 = itemView.findViewById(R.id.ans5);


        }
    }

    private List<String> RigAnsw;
    private List<String> answer;
    public ExampleAdapter(ArrayList<ExampleItem> exampleList, List<String> RigAnsw, List<String> answer) {
        mExampleList = exampleList;
        this.RigAnsw = RigAnsw;
        this.answer = answer;
    }


    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_list, parent, false);
        ExampleViewHolder holder = new ExampleViewHolder(v, mListener,RigAnsw,answer);

        return holder;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {

        ExampleItem currentItem = mExampleList.get(position);

        holder.numbQuest.setText(currentItem.getNumbQuest());
        holder.quest.setText(currentItem.getQuest());
        holder.ans1.setText(currentItem.getAns1());
        holder.ans1.setTextColor(Color.parseColor("#008000"));

        holder.ans5.setText(answer.get(position));
        if(answer.get(position).equalsIgnoreCase(RigAnsw.get(position))){
            holder.ans5.setTextColor(Color.parseColor("#008000"));
        }else{
            holder.ans5.setTextColor(Color.parseColor("#ff0000"));
        }



    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }



}
