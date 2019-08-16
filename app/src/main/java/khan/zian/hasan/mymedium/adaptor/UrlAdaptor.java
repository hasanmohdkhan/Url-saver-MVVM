package khan.zian.hasan.mymedium.adaptor;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import khan.zian.hasan.mymedium.R;
import khan.zian.hasan.mymedium.model.UrlModel;

public class UrlAdaptor extends RecyclerView.Adapter<UrlAdaptor.ViewHolder> {

    private List<UrlModel> mList = new ArrayList<>();
    private Context mContext;

    public UrlAdaptor() { }

//    public UrlAdaptor(List<UrlModel> mList) {
//        this.mList = mList;
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.url_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       if(mList == null){
           Log.d("onBindViewHolder" , "Null ");
       }
       else {
           UrlModel urlModel = mList.get(position);
           holder.text.setText(urlModel.getUrl());
       }



    }

    public void setList(List<UrlModel> mList){
        this.mList = mList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text)
        TextView text;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}
