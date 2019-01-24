package com.example.wekk3day3;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wekk3day3.user.Result;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class FragmentUserDetails extends Fragment {
    TextView tvName;
    TextView tvCity;
    TextView tvState;
    TextView tvDob;
    TextView tvAge;
    TextView tvPostCode;
    TextView tvStreet;
    TextView tvUserName;
    TextView tvPassword;
    TextView tvTitle;
    ImageView imageView;

    //private OnFragmentInteractionListener mListener;

    public FragmentUserDetails() {
        // Required empty public constructor
    }



    @Override
    public void onStart() {
        super.onStart();
        Log.d("TAG", "Register ");
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("TAG", "UnRegister ");
        EventBus.getDefault().unregister(this);
    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_user_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = view.findViewById(R.id.selectedUserImgView);
        tvName = view.findViewById(R.id.tvName);
        tvAge = view.findViewById(R.id.tvAge);
        tvCity = view.findViewById(R.id.tvCity);
        tvState = view.findViewById(R.id.tvState);
        tvPassword = view.findViewById(R.id.tvPassword);
        tvPostCode = view.findViewById(R.id.tvPostCode);
        tvStreet = view.findViewById(R.id.tvStreet);
        tvDob = view.findViewById(R.id.tvDob);
        tvTitle = view.findViewById(R.id.tvTitle);
        tvUserName = view.findViewById(R.id.tvUserName);
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    public void setTvName(TextView tvName) {
//        this.tvName = tvName;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//             * >Communicating with Other Fragments</a> for more information.
//            */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
//
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void userEvent(ResultEvent event){
        //System.out.println(event.getResult().getName().getFirst());
        if(event != null){
            Result result = event.getResult();
            Glide.with(getContext()).load(result.getPicture().getLarge()).into(imageView);
            tvName.setText(result.getName().getFirst() + " " + result.getName().getLast());
            tvTitle.setText(result.getName().getTitle());
            tvPostCode.setText(result.getLocation().getPostcode());
            tvUserName.setText(result.getLogin().getUsername());
            tvDob.setText(result.getDob().getDate());
            tvStreet.setText(result.getLocation().getStreet());
            tvPassword.setText(result.getLogin().getPassword());
            tvCity.setText(result.getLocation().getCity());
            tvState.setText(result.getLocation().getState());
            tvAge.setText(result.getDob().getAge());
////            Gli
////
////            UserResponse userResponse = event.getUserResponse();
////            ArrayList<Result> arrayListResults = new ArrayList<>(userResponse.getResults());
////            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
////            recyclerViewAdapter = new RecyclerViewAdapter(arrayListResults);
////            recyclerView.setLayoutManager(layoutManager);
////            recyclerView.setAdapter(recyclerViewAdapter);
        }
    }
}
