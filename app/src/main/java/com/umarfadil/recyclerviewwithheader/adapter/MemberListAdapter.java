package com.umarfadil.recyclerviewwithheader.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.umarfadil.recyclerviewwithheader.R;
import com.umarfadil.recyclerviewwithheader.model.Member;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by umarfadil on 11/27/17.
 */

public class MemberListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private List<Member> memberList;

    public MemberListAdapter() {
        memberList = new ArrayList<>();
    }

    private void add(Member item) {
        memberList.add(item);
        notifyItemInserted((memberList.size() + 1) - 1);
    }

    public void addAll(List<Member> memberList) {
        for (Member member : memberList) {
            add(member);
        }
    }

    public void remove(Member item) {
        int position = memberList.indexOf(item);
        if (position > -1) {
            memberList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        while (getItemCount() > 1) {
            remove(getItem(-1));
        }
    }

    public Member getItem(int position){
        return memberList.get(position + 1);
    }

    @Override
    public int getItemViewType (int position) {
        if(isPositionHeader (position)) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }

    public boolean isPositionHeader(int position) {
        return position == 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header, parent, false);
            return new HeaderViewHolder(view);
        } else if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_member, parent, false);
            return new MemberViewHolder(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof HeaderViewHolder) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;

            headerViewHolder.imgHeader.setImageResource(R.mipmap.ic_launcher);
        } else if (holder instanceof MemberViewHolder) {
            MemberViewHolder memberViewHolder = (MemberViewHolder) holder;

            Member member = memberList.get(position - 1);

            memberViewHolder.memberThumb.setImageResource(member.getThumb());
            memberViewHolder.memberName.setText(member.getName());
            memberViewHolder.memberTeam.setText(member.getTeam());
        }

    }

    @Override
    public int getItemCount() {
        return memberList == null ? 0 : memberList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    static class MemberViewHolder extends RecyclerView.ViewHolder {

        ImageView memberThumb;
        TextView memberName;
        TextView memberTeam;

        public MemberViewHolder(View itemView) {
            super(itemView);

            memberThumb = (ImageView) itemView.findViewById(R.id.thumb);
            memberName = (TextView) itemView.findViewById(R.id.name);
            memberTeam = (TextView) itemView.findViewById(R.id.team);
        }
    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder {

        ImageView imgHeader;

        public HeaderViewHolder(View itemView) {
            super(itemView);

            imgHeader = (ImageView) itemView.findViewById(R.id.imgHeader);
        }
    }
}
