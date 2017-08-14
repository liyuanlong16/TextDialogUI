package jp.co.resonabank.textdialogui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

//import butterknife.OnClick;
import jp.co.resonabank.textdialogui.adapter.TieAdapter;
import jp.co.resonabank.textdialogui.bean.BuildBean;
import jp.co.resonabank.textdialogui.bean.PopuBean;
import jp.co.resonabank.textdialogui.bean.TieBean;
import jp.co.resonabank.textdialogui.listener.DialogUIDateTimeSaveListener;
import jp.co.resonabank.textdialogui.listener.DialogUIItemListener;
import jp.co.resonabank.textdialogui.listener.DialogUIListener;
import jp.co.resonabank.textdialogui.listener.TdataListener;
import jp.co.resonabank.textdialogui.widget.DateSelectorWheelView;

public class MainActivity extends AppCompatActivity {


    Activity mActivity;
    Context mContext;
    //    @Bind(R.id.ll_main)
    LinearLayout llMain;
    //    @Bind(R.id.btn_popu)
    Button btnPopu;

    Button btn_custom_alert, btn_custom_bottom_alert, btn_system_alert, btn_loading, btn_md_loading, btn_md_alert, btn_tie_alert, btn_bottom_sheet_cancel, btn_center_sheet, btn_alert_input, btn_alert_multichoose, btn_alert_singlechoose, btn_md_bottom_vertical, btn_md_bottom_horizontal, btn_toast_top, btn_toast_center, btn_toast, btn_select_ymd, btn_select_ymdhm,
            btn_select_ymdhms, btn_popu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llMain = (LinearLayout) findViewById(R.id.ll_main);
        btnPopu = (Button) findViewById(R.id.btn_popu);
//        ButterKnife.bind(this);


        btn_custom_alert = (Button) findViewById(R.id.btn_custom_alert);
        btn_custom_alert.setOnClickListener(listener);

        btn_custom_bottom_alert = (Button) findViewById(R.id.btn_custom_bottom_alert);
        btn_custom_bottom_alert.setOnClickListener(listener);

        btn_system_alert = (Button) findViewById(R.id.btn_system_alert);
        btn_system_alert.setOnClickListener(listener);

        btn_loading = (Button) findViewById(R.id.btn_loading);
        btn_loading.setOnClickListener(listener);

        btn_md_loading = (Button) findViewById(R.id.btn_md_loading);
        btn_md_loading.setOnClickListener(listener);

        btn_md_alert = (Button) findViewById(R.id.btn_md_alert);
        btn_md_alert.setOnClickListener(listener);

        btn_tie_alert = (Button) findViewById(R.id.btn_tie_alert);
        btn_tie_alert.setOnClickListener(listener);

        btn_bottom_sheet_cancel = (Button) findViewById(R.id.btn_bottom_sheet_cancel);
        btn_bottom_sheet_cancel.setOnClickListener(listener);

        btn_center_sheet = (Button) findViewById(R.id.btn_center_sheet);
        btn_center_sheet.setOnClickListener(listener);

        btn_alert_input = (Button) findViewById(R.id.btn_alert_input);
        btn_alert_input.setOnClickListener(listener);

        btn_alert_multichoose = (Button) findViewById(R.id.btn_alert_multichoose);
        btn_alert_multichoose.setOnClickListener(listener);

        btn_alert_singlechoose = (Button) findViewById(R.id.btn_alert_singlechoose);
        btn_alert_singlechoose.setOnClickListener(listener);

        btn_md_bottom_vertical = (Button) findViewById(R.id.btn_md_bottom_vertical);
        btn_md_bottom_vertical.setOnClickListener(listener);

        btn_md_bottom_horizontal = (Button) findViewById(R.id.btn_md_bottom_horizontal);
        btn_md_bottom_horizontal.setOnClickListener(listener);

        btn_toast_top = (Button) findViewById(R.id.btn_toast_top);
        btn_toast_top.setOnClickListener(listener);

        btn_toast_center = (Button) findViewById(R.id.btn_toast_center);
        btn_custom_alert.setOnClickListener(listener);

        btn_toast = (Button) findViewById(R.id.btn_toast);
        btn_toast.setOnClickListener(listener);

        btn_select_ymd = (Button) findViewById(R.id.btn_select_ymd);
        btn_select_ymd.setOnClickListener(listener);

        btn_select_ymdhm = (Button) findViewById(R.id.btn_select_ymdhm);
        btn_select_ymdhm.setOnClickListener(listener);

        btn_select_ymdhms = (Button) findViewById(R.id.btn_select_ymdhms);
        btn_select_ymdhms.setOnClickListener(listener);

        btn_popu = (Button) findViewById(R.id.btn_popu);
        btn_popu.setOnClickListener(listener);


        mActivity = this;
        mContext = getApplication();
        DialogUIUtils.init(mContext);
    }

    String msg = "まだねと言ってばかりことをしないで，この世界にはてをふる間に人を離れるお茶が冷やした。";


//    @OnClick({R.id.btn_custom_alert, R.id.btn_custom_bottom_alert, R.id.btn_system_alert, R.id.btn_loading, R.id.btn_md_loading, R.id.btn_md_alert, R.id.btn_tie_alert,
//            R.id.btn_bottom_sheet_cancel, R.id.btn_center_sheet, R.id.btn_alert_input,
//            R.id.btn_alert_multichoose, R.id.btn_alert_singlechoose, R.id.btn_md_bottom_vertical, R.id.btn_md_bottom_horizontal,
//            R.id.btn_toast_top, R.id.btn_toast_center, R.id.btn_toast,
//            R.id.btn_select_ymd, R.id.btn_select_ymdhm, R.id.btn_select_ymdhms, R.id.btn_popu})

    View.OnClickListener listener = new View.OnClickListener() {


        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_popu:
                    DialogUIUtils.showPopuWindow(mContext, LinearLayout.LayoutParams.MATCH_PARENT, 4, btnPopu, new TdataListener() {
                        @Override
                        public void initPupoData(List<PopuBean> lists) {
                            for (int i = 0; i < 5; i++) {
                                PopuBean popu = new PopuBean();
                                popu.setTitle("item" + i);
                                popu.setId(i);
                                lists.add(popu);
                            }
                        }

                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int position) {
                        }
                    });
                    break;
                case R.id.btn_custom_alert:
                    View rootView = View.inflate(mActivity, R.layout.custom_dialog_layout, null);
                    final Dialog dialog = DialogUIUtils.showCustomAlert(MainActivity.this, rootView, Gravity.CENTER, true, false).show();
                    rootView.findViewById(R.id.btn_ok).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            DialogUIUtils.dismiss(dialog);
                        }
                    });
                    break;
                case R.id.btn_custom_bottom_alert:
                    View rootViewB = View.inflate(mActivity, R.layout.custom_dialog_bottom_layout, null);
                    DialogUIUtils.showCustomBottomAlert(MainActivity.this, rootViewB).show();
                    break;
                case R.id.btn_system_alert:
                    new AlertDialog
                            .Builder(mActivity)
                            .setTitle("标题")
                            .setMessage("这是内容")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            })
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            })
                            .create()
                            .show();
                    break;
                case R.id.btn_loading:
                    DialogUIUtils.showLoading(MainActivity.this, "加载中...", false, true, true, true).show();
                    break;
                case R.id.btn_md_loading:
                    DialogUIUtils.showMdLoading(MainActivity.this, "加载中...", true, true, true, true).show();
                    break;

                case R.id.btn_alert_multichoose:
                    String[] words = new String[]{"1", "2", "3"};
                    boolean[] choseDefault = new boolean[]{false, false, false};
                    DialogUIUtils.showMdMultiChoose(mActivity, "标题", words, choseDefault, new DialogUIListener() {
                        @Override
                        public void onPositive() {

                        }

                        @Override
                        public void onNegative() {

                        }
                    }).show();
                    break;
                case R.id.btn_alert_singlechoose:
                    String[] words2 = new String[]{"1", "2", "3"};
                    DialogUIUtils.showSingleChoose(mActivity, "单选", 0, words2, new DialogUIItemListener() {
                        @Override
                        public void onItemClick(CharSequence text, int position) {
                            showToast(text + "--" + position);
                        }
                    }).show();
                    break;
                case R.id.btn_md_alert:
                    DialogUIUtils.showMdAlert(mActivity, "标题", msg, new DialogUIListener() {
                        @Override
                        public void onPositive() {
                            showToast("onPositive");
                        }

                        @Override
                        public void onNegative() {
                            showToast("onNegative");
                        }

                    }).show();
                    break;
                case R.id.btn_tie_alert:
                    DialogUIUtils.showAlert(mActivity, "标题", msg, "", "", "确定", "", true, true, true, new DialogUIListener() {
                        @Override
                        public void onPositive() {
                            showToast("onPositive");
                        }

                        @Override
                        public void onNegative() {
                            showToast("onNegative");
                        }

                    }).show();
                    break;
                case R.id.btn_alert_input:
                    DialogUIUtils.showAlert(mActivity, "登录", "", "请输入用户名", "请输入密码", "登录", "取消", false, true, true, new DialogUIListener() {
                        @Override
                        public void onPositive() {

                        }

                        @Override
                        public void onNegative() {

                        }

                        @Override
                        public void onGetInput(CharSequence input1, CharSequence input2) {
                            super.onGetInput(input1, input2);
                            showToast("input1:" + input1 + "--input2:" + input2);
                        }
                    }).show();
                    break;
                case R.id.btn_center_sheet: {
                    List<TieBean> strings = new ArrayList<TieBean>();
                    strings.add(new TieBean("1"));
                    strings.add(new TieBean("2"));
                    strings.add(new TieBean("3"));
                    DialogUIUtils.showSheet(mActivity, strings, "", Gravity.CENTER, true, true, new DialogUIItemListener() {
                        @Override
                        public void onItemClick(CharSequence text, int position) {
                            showToast(text);
                        }
                    }).show();
                }
                break;
                case R.id.btn_bottom_sheet_cancel: {
                    List<TieBean> strings = new ArrayList<TieBean>();
                    strings.add(new TieBean("1"));
                    strings.add(new TieBean("2"));
                    strings.add(new TieBean("3"));
                    DialogUIUtils.showSheet(mActivity, strings, "取消", Gravity.BOTTOM, true, true, new DialogUIItemListener() {
                        @Override
                        public void onItemClick(CharSequence text, int position) {
                            showToast(text + "---" + position);
                        }

                        @Override
                        public void onBottomBtnClick() {
                            showToast("取消");
                        }
                    }).show();
                }
                break;
                case R.id.btn_md_bottom_vertical:
                    List<TieBean> datas2 = new ArrayList<TieBean>();
                    datas2.add(new TieBean("1"));
                    datas2.add(new TieBean("2"));
                    datas2.add(new TieBean("3"));
                    datas2.add(new TieBean("4"));
                    datas2.add(new TieBean("5"));
                    datas2.add(new TieBean("6"));
                    TieAdapter adapter = new TieAdapter(mContext, datas2, true);
                    BuildBean buildBean = DialogUIUtils.showMdBottomSheet(mActivity, true, "", datas2, 0, new DialogUIItemListener() {
                        @Override
                        public void onItemClick(CharSequence text, int position) {
                            showToast(text + "---" + position);
                        }
                    });
                    buildBean.mAdapter = adapter;
                    buildBean.show();
                    break;
                case R.id.btn_md_bottom_horizontal:
                    List<TieBean> datas3 = new ArrayList<TieBean>();
                    datas3.add(new TieBean("1"));
                    datas3.add(new TieBean("2"));
                    datas3.add(new TieBean("3"));
                    datas3.add(new TieBean("4"));
                    datas3.add(new TieBean("5"));
                    datas3.add(new TieBean("6"));
                    DialogUIUtils.showMdBottomSheet(mActivity, false, "标题", datas3, 4, new DialogUIItemListener() {
                        @Override
                        public void onItemClick(CharSequence text, int position) {
                            showToast(text + "---" + position);
                        }
                    }).show();
                    break;

                case R.id.btn_toast_top:
                    DialogUIUtils.showToastTop("上部的Toast弹出方式");
                    break;
                case R.id.btn_toast_center:
                    DialogUIUtils.showToastCenter("中部的Toast弹出方式");
                    break;
                case R.id.btn_toast:
                    DialogUIUtils.showToast("默认的Toast弹出方式");
                    break;
                case R.id.btn_select_ymd: {
                    DialogUIUtils.showDatePick(mActivity, Gravity.CENTER, "选择日期", System.currentTimeMillis() + 60000, DateSelectorWheelView.TYPE_YYYYMMDD, 0, new DialogUIDateTimeSaveListener() {
                        @Override
                        public void onSaveSelectedDate(int tag, String selectedDate) {

                        }
                    }).show();
                }
                break;
                case R.id.btn_select_ymdhm: {
                    DialogUIUtils.showDatePick(mActivity, Gravity.CENTER, "选择日期", System.currentTimeMillis() + 60000, DateSelectorWheelView.TYPE_YYYYMMDDHHMM, 0, new DialogUIDateTimeSaveListener() {
                        @Override
                        public void onSaveSelectedDate(int tag, String selectedDate) {

                        }
                    }).show();
                }
                break;
                case R.id.btn_select_ymdhms: {
                    DialogUIUtils.showDatePick(mActivity, Gravity.BOTTOM, "选择日期", System.currentTimeMillis() + 60000, DateSelectorWheelView.TYPE_YYYYMMDDHHMMSS, 0, new DialogUIDateTimeSaveListener() {
                        @Override
                        public void onSaveSelectedDate(int tag, String selectedDate) {

                        }
                    }).show();
                }
                break;

            }
        }
    };

    public void showToast(CharSequence msg) {
        DialogUIUtils.showToastLong(msg.toString());
    }
}
