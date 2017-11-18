package com.fundoopay.fundoopay.dashboard.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.fundoopay.fundoopay.R;
import com.fundoopay.fundoopay.base.BaseActivity;
import com.fundoopay.fundoopay.constants.Constants;
import com.fundoopay.fundoopay.dashboard.adapter.BillAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FundooPayActivity extends BaseActivity {

   /* @BindView(R.id.appCompatButton1)
    AppCompatButton appCompatButton1;
    @BindView(R.id.appCompatButton2)
    AppCompatButton appCompatButton2;*/
    @BindView(R.id.recyclerViewDashBoard)
    RecyclerView recyclerViewDashBoard;
    @BindView(R.id.toolbar_update)
    Toolbar toolbarUpdate;
    @BindView(R.id.floatingButtonMenu)
    FloatingActionButton floatingButtonMenu;
    @BindView(R.id.floatingButtonMenuAdd)
    FloatingActionButton floatingButtonMenuAdd;
    @BindView(R.id.floatingButtonMenuSave)
    FloatingActionButton floatingButtonMenuSave;
    @BindView(R.id.layoutMenu)
    LinearLayout layoutMenu;
    Animation animFadein;
    CreateBillFragment createBillFragment;
    @BindView(R.id.buttonOutstandingPaid)
    AppCompatButton buttonOutstandingPaid;
    @BindView(R.id.buttonOutstandingUnPaid)
    AppCompatButton buttonOutstandingUnPaid;
    @BindView(R.id.linearLayoutOutStanding)
    LinearLayout linearLayoutOutStanding;
    int mTabClicked=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fundoo_pay);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        BillAdapter billAdapter = new BillAdapter(this, this);
        toolbarUpdate.setTitle("");
        setSupportActionBar(toolbarUpdate);
        recyclerViewDashBoard.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewDashBoard.setAdapter(billAdapter);

        animFadein = AnimationUtils.loadAnimation(this, R.anim.anim);
    }

    @Override
    public void setClickListener() {

    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() < 1) {
             super.onBackPressed();
        } else if (getFragmentManager().getBackStackEntryCount() == 1) {
            if(mTabClicked==2){
                layoutMenu.setVisibility(View.VISIBLE);
            }
            floatingButtonMenu.setVisibility(View.VISIBLE);
            getFragmentManager().popBackStack();
        } else {
            getFragmentManager().popBackStack();
        }

        if(linearLayoutOutStanding.getVisibility()==View.VISIBLE){
            linearLayoutOutStanding.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.fundoo_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.account:
                Toast.makeText(this, "Bank Accounts", Toast.LENGTH_SHORT).show();
                return (true);
            case R.id.notify:
                floatingButtonMenu.setVisibility(View.GONE);
                getFragmentManager().beginTransaction().replace(R.id.framlayoutsettting, NotificationFragment.newInstance(this)).addToBackStack(null).commit();
                return (true);
            case R.id.setting:
                floatingButtonMenu.setVisibility(View.GONE);
                getFragmentManager().beginTransaction().replace(R.id.framlayoutsettting, SettingFragment.newInstance(this)).addToBackStack(null).commit();
                return (true);
            case R.id.exit:
                Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show();
                return (true);
        }
        return (super.onOptionsItemSelected(item));
    }

    public void getRecieptCall(int adapterPosition) {
        if (mTabClicked==2){
            if (layoutMenu.getVisibility() == View.VISIBLE) {
                layoutMenu.setVisibility(View.GONE);
                floatingButtonMenu.setVisibility(View.GONE);
                linearLayoutOutStanding.setVisibility(View.VISIBLE);
            }
        } else {
            floatingButtonMenu.setVisibility(View.VISIBLE);
            linearLayoutOutStanding.setVisibility(View.GONE);

        }
        BillingFragment billingFragmeznt = new BillingFragment();
        getFragmentManager().beginTransaction().replace(R.id.framlayoutBill, billingFragmeznt).addToBackStack(null).commit();

    }


   /* @OnClick({R.id.appCompatButton1, R.id.appCompatButton2, R.id.floatingButtonMenuAdd, R.id.floatingButtonMenuSave, R.id.floatingButtonMenu,R.id.buttonOutstandingPaid, R.id.buttonOutstandingUnPaid})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.appCompatButton1:
                if(mTabClicked==2){
                    getPopUpFragment();
                *//*    appCompatButton1.setBackgroundDrawable(getDrawable(R.drawable.tab_left_layout));
                    appCompatButton2.setBackgroundDrawable(getDrawable(R.drawable.tab_right_layout));
                 *//*   layoutMenu.setVisibility(View.GONE);
                    if(linearLayoutOutStanding.getVisibility()==View.VISIBLE){
                        linearLayoutOutStanding.setVisibility(View.GONE);
                    }
                }
                mTabClicked=1;
                break;
            case R.id.appCompatButton2:
                if(mTabClicked==1){
                    getPopUpFragment();
                 *//*   appCompatButton1.setBackgroundDrawable(getDrawable(R.drawable.tab_layout_secound));
                    appCompatButton2.setBackgroundDrawable(getDrawable(R.drawable.tab_layout_one));
                 *//*   layoutMenu.setVisibility(View.VISIBLE);
                }
                mTabClicked=2;

                break;
            case R.id.floatingButtonMenuAdd:

                break;
            case R.id.floatingButtonMenuSave:
                floatingButtonMenu.setVisibility(View.GONE);
                //createBillFragment = new CreateBillFragment(this);
                getFragmentManager().beginTransaction().replace(R.id.framlayoutsettting, CreateBillFragment.newInstance(this)).addToBackStack(null).commit();
                break;
            case R.id.floatingButtonMenu:

                break;
            case R.id.buttonOutstandingPaid:

                break;
            case R.id.buttonOutstandingUnPaid:

                break;
        }
    }*/

    private void getPopUpFragment() {
        if (getFragmentManager().getBackStackEntryCount() == 1) {
            getFragmentManager().popBackStack();
        }
        floatingButtonMenu.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            CreateBillFragment.setImageBitmap(imageBitmap);
        }
    }

    public void getBackFloting() {
        floatingButtonMenu.setVisibility(View.VISIBLE);
    }


}
