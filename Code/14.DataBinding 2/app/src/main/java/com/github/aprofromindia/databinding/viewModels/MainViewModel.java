package com.github.aprofromindia.databinding.viewModels;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.view.View;
import android.widget.Toast;

import com.android.databinding.library.baseAdapters.BR;

public class MainViewModel extends BaseObservable {
    private Context context;
    private String text;
    private boolean showProgressBar = true;

    public MainViewModel(Context context) {
        this.context = context;
    }

    public void submitBtnClicked(View v) {
        Toast.makeText(context, "Button clicked", Toast.LENGTH_SHORT).show();
        setShowProgressBar(!showProgressBar);
    }

    public void textChanged(Editable s) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }

    @Bindable
    public boolean isShowProgressBar() {
        return showProgressBar;
    }

    public void setShowProgressBar(boolean showProgressBar) {
        this.showProgressBar = showProgressBar;
        notifyPropertyChanged(BR.showProgressBar);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
