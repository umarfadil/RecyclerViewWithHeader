package com.umarfadil.recyclerviewwithheader.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.umarfadil.recyclerviewwithheader.adapter.MemberListAdapter;
import com.umarfadil.recyclerviewwithheader.R;
import com.umarfadil.recyclerviewwithheader.model.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemberFragment extends Fragment {

    private RecyclerView listMember;
    private LinearLayoutManager linearLayoutManager;
    private MemberListAdapter memberListAdapter;
    protected Context context;
    SliderLayout sliderLayout;
    HashMap<String, Integer> Hash_file_maps ;
    private RecyclerView recyclerView;

    public static MemberFragment newInstance(){
        return new MemberFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_member, container, false);
        listMember = (RecyclerView) rootView.findViewById(R.id.listMember);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        linearLayoutManager = new LinearLayoutManager(context);
        memberListAdapter = new MemberListAdapter();
        listMember.setLayoutManager(linearLayoutManager);
        listMember.setAdapter(memberListAdapter);
        loadData();
    }

    private void loadData(){
        List<Member> memberList = new ArrayList<>();
        Member member;
        int thumb[] = {
                R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
        String name[] = {"Alicia Chanzia", "Cindy Yuvia", "Della Delila", "Devi Kinal Putri",
                "Dwi Putri Bonita", "Fakhriyani Shafariyanti", "Jennifer Hanna", "Lidya Maulida Djuhandar",
                "Nadila Cindi Wantari", "Natalia", "Priscillia Sari Dewi", "Ratu Vienny Fitrilya",
                "Rina Chikano", "Riskha Fairunissa", "Rona Anggreani", "Saktia Oktapyani",
                "Sinka Juliani", "Viviyona Apriani"};
        String motto[] = {"Hap!Tangkap Aku!", "Mau Kemana Kita?", "Future Processor", "K3bahagiaan Depi",
                "Different", "Shafa Disana?", "Target", "Banyak Mau", "Yossha Ikuzo!", "Spicy Hot",
                "Yuk Isi Batre Senter", "#KitaBisa", "Yuk.. Kita Dangdutan!", "Nothing Gonna Stop Us Now",
                "Stand Up!", "Saktia Dalam Jiwa", "Berarti Dalam Hidup", "Life In Technicolor"};
        for(int i=0; i < thumb.length; i++){
            member = new Member();
            member.setId(i+1);
            member.setName(name[i]);
            member.setTeam(motto[i]);
            member.setThumb(thumb[i]);
            memberList.add(member);
        }
        memberListAdapter.addAll(memberList);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
